package plague;


import static mindustry.Vars.netServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import arc.Events;

import arc.util.CommandHandler;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.content.Blocks;

import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.game.EventType.BlockDestroyEvent;
import mindustry.game.EventType.BuildSelectEvent;
import mindustry.game.EventType.ContentInitEvent;
import mindustry.game.EventType.GameOverEvent;
import mindustry.game.EventType.PlayerJoin;
import mindustry.game.EventType.PlayerLeave;
import mindustry.game.EventType.TapEvent;
import mindustry.game.EventType.Trigger;
import mindustry.game.EventType.UnitCreateEvent;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.gen.Call;
import mindustry.gen.Groups;
import mindustry.gen.Player;
import mindustry.gen.Unit;
import mindustry.net.Administration.ActionType;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.mod.*;

public class FPlagueBasic extends Plugin {
	static boolean Have120SecondsPassed = false;
	static long gameTime = System.currentTimeMillis();
	private Rules survivorBanned = new Rules();
	public static Rules plagueBanned = new Rules();
	Map<String, Team> relogTeam = new HashMap<String, Team>();
	HashMap<String, Tile> playerCores = new HashMap<String, Tile>();
	HashMap<Integer, ArrayList<String>> invitedPlayers = new HashMap<Integer, ArrayList<String>>();
	ArrayList<String> gameovervotes = new ArrayList<String>();
	ArrayList<String> leaders = new ArrayList<String>();
	ArrayList<ItemStack> survivorStartingResources = new ArrayList<ItemStack>();
	ArrayList<Tile> plagueCores = new ArrayList<Tile>();

	int totalplayers = 0;

	Player kickedPlayer = null;
	Player invitedPlayer = null;
	Team teamProximityCore = null;
	PlayerList players = new PlayerList();

	@Override
	public void init(){
		// Starts all timers
		new PlagueTime();
		new PlagueTime2();

		// The reason they happen twice is due to funny issues
		blockRules();
		unitChanges();
		blockChanges();
		survivorResources();
		Events.on(ContentInitEvent.class, e -> {
			blockRules();
			gameRules();
			unitChanges();
			blockChanges();
			survivorResources();
		});

		Events.on(Trigger.update.getClass(), e -> {
			gameRules(); // In case fucker refuses to change
		});

		// Prevents destroying of power source
		netServer.admins.addActionFilter((action) ->{
			if(action.block != null && action.block == Blocks.powerSource && action.type == ActionType.breakBlock){
				return false;
			}
			return true;
		});
		// No placing near crux core and banned blocks incase of bug
		netServer.admins.addActionFilter((action) ->{
			ArrayList<Block> boulders = new ArrayList<Block>();
			boulders.add(Blocks.boulder);
			boulders.add(Blocks.daciteBoulder);
			boulders.add(Blocks.basaltBoulder);
			boulders.add(Blocks.sandBoulder);
			boulders.add(Blocks.shaleBoulder);
			boulders.add(Blocks.snowBoulder);
			if(plagueCores.isEmpty() && Vars.state.gameOver == false) {
				for(int x = 0; x < Vars.world.width(); x++) {
					for(int y = 0; y < Vars.world.height(); y++) {
						if(Vars.world.tile(x, y).block() == Blocks.coreFoundation || Vars.world.tile(x, y).block() == Blocks.coreShard || Vars.world.tile(x, y).block() == Blocks.coreNucleus) {
							if(Vars.world.tile(x, y).team() == Team.purple && Vars.world.tile(x, y).isCenter()) {
								plagueCores.add(Vars.world.tile(x, y));
							}
						}
					}
				}
			}

			if(action.block != null && action.type == ActionType.placeBlock && action.tile.block() == Blocks.powerSource) {
				return false;
			}

			if(action.block != null && action.type == ActionType.placeBlock && action.player.team() != Team.purple && survivorBanned.bannedBlocks.contains(action.block)) {
				Call.infoToast(action.player.con, "[red]NO PERMISSION TO PLACE BANNED BLOCKS", 1);
				return false;
			}

			if(action.block != null && action.type == ActionType.placeBlock && action.player.team() == Team.purple && plagueBanned.bannedBlocks.contains(action.block)) {
				Call.infoToast(action.player.con, "[red]NO PERMISSION TO PLACE BANNED BLOCKS", 1);
				return false;
			}

			if(action.block != null && action.type == ActionType.breakBlock && boulders.contains(action.tile.block())) {
				action.tile.setNet(Blocks.air);
				return false;
			}

			if(action.block != null && action.type == ActionType.placeBlock){
				for(Tile b : plagueCores) {
					if(cartesianDistance(action.tile.x, action.tile.y, b.x, b.y) < 90 && action.player.team() != Team.purple) {
						return false;
					}
				}
			}
			return true;
		});

		// No unit control until 20 mins have passed
		netServer.admins.addActionFilter((action) ->{
			if(action.type == ActionType.control && ((System.currentTimeMillis() - gameTime) / 1000) < 1200){
				return false;
			}
			return true;
		});

		// Vault to core
		Events.on(TapEvent.class, event -> {
			if(event.tile.block() == Blocks.vault) {
				if(event.tile.build.items().has(Items.thorium, 1000) && event.tile.build.team() != Team.purple && event.tile.build.team == event.player.team()) {
					Vars.world.tile(event.tile.build.tileX(), event.tile.build.tileY()).setNet(Blocks.coreShard, event.player.team(), 0);
				}
			}
		});

		// Makes you plague if you join too late also if rejoin put back on team
		Events.on(PlayerJoin.class, event -> {
			if(!players.hasPlayer(event.player.uuid())) {
				//System.out.println("player has not joined before");
				event.player.sendMessage("[yellow]Welcome to plague!");
				event.player.sendMessage("[blue]Discord Link: [yellow]https://discord.gg/rfzm5xgJSC");
				event.player.sendMessage("[purple]Plague is an attack like mode where the infected (purple) must build units to take out the survivors");
				event.player.sendMessage("[purple]Survivors can't build units, their focus is surviving purple's units, to become a survivor place a block on the outside of the map");
				event.player.sendMessage("[purple]Plague has infinite power and must attack and kill survivors (20 minutes for unit control)");
				//event.player.sendMessage("For more information, use /info");
			}

			if(relogTeam.containsKey(event.player.uuid())) {
				event.player.team(relogTeam.get(event.player.uuid()));
				Call.setRules(event.player.con, survivorBanned);
			} else if (Have120SecondsPassed == true) {
				event.player.team(Team.purple);
				Call.setRules(event.player.con, plagueBanned);
			}
		});

		Events.on(PlayerLeave.class, event -> {
			if(event.player.team() != Team.purple && event.player.team() != Team.sharded) {
				relogTeam.put(event.player.uuid(), event.player.team());
			}

			if(!event.player.unit().isNull()) {
				if(event.player.unit().type == UnitTypes.gamma) {
					event.player.unit().kill();
				}
			}

			if(gameovervotes.contains(event.player.name)) {
				gameovervotes.remove(event.player.name);
			}
		});

		// Create core with block placement
		Events.on(BuildSelectEvent.class, event -> {
			if(event.builder.team == Team.sharded && !Have120SecondsPassed) {
				int randomTeamNumber = (int) Math.floor((Math.random() * 200) + 6);
				Team chosenteam = Team.all[randomTeamNumber];
				playerCores.forEach((p, core) -> {
					if(cartesianDistance(event.tile.x, event.tile.y, core.x, core.y) < 160) {
						teamProximityCore = Vars.world.tile(core.x, core.y).build.team;
					}
				});

				if(teamProximityCore != null) {
					event.builder.getPlayer().team(teamProximityCore);
					Call.setRules(event.builder.getPlayer().con, survivorBanned);
					event.tile.setNet(Blocks.coreFoundation, Team.all[teamProximityCore.id], 0);
					for(ItemStack stack : survivorStartingResources) {
						Call.setItem(event.tile.build, stack.item, stack.amount);
					}
					playerCores.put(event.builder.getPlayer().uuid(), event.tile);

				} else {
					event.builder.getPlayer().team(chosenteam);
					Call.setRules(event.builder.getPlayer().con, survivorBanned);
					event.tile.setNet(Blocks.coreFoundation, Team.all[randomTeamNumber], 0);
					for(ItemStack stack : survivorStartingResources) {
						Call.setItem(event.tile.build, stack.item, stack.amount);
					}
					playerCores.put(event.builder.getPlayer().uuid(), event.tile);
					leaders.add(event.builder.getPlayer().uuid());
				}

				teamProximityCore = null;
			}
		});

		// Some maps have power infs outside of no build oh well invincibility time
		Events.on(BlockDestroyEvent.class, event -> {
			if(event.tile.block() == Blocks.powerSource) {
				event.tile.setNet(Blocks.powerSource, event.tile.team(), 0);
			}
		});

		// Hell no no ono
		Events.on(GameOverEvent.class, event -> {
			gameTime = System.currentTimeMillis();
			relogTeam.clear();
			gameovervotes.clear();
			plagueCores.clear();
			playerCores.clear();
			leaders.clear();
			PlagueTime.timer.cancel();
			PlagueTime.unitmultiplier.cancel();
			PlagueTime.gameover.cancel();
			PlagueTime.resetToDefaults();
			Have120SecondsPassed = false;
			new PlagueTime();
		});

		Events.on(UnitCreateEvent.class, event -> {
			if(event.unit.type == UnitTypes.mono) {
				event.unit.team.items().add(Items.lead, 800);
				event.unit.team.items().add(Items.copper, 750);
				event.unit.kill();
			}
		});
	}

	// Turns you infected
	@Override
	public void registerClientCommands(CommandHandler handler){
		handler.<Player>register("infect", "You become [purple]INFECTED", (args, player) -> {
			Call.setRules(player.con, plagueBanned);
			player.team(Team.purple);
		});

		handler.<Player>register("rules", "All the rules on the server", (args, player) -> {
			player.sendMessage("1. Don't grief");
			player.sendMessage("2. Griefing includes wasting resources, you know who you are.");
			player.sendMessage("3. Shooting someone's core with a core unit is punishable by a kick, as it blocks visibility of resource display with a warning message.");
			player.sendMessage("4. Don't be toxic.");
			player.sendMessage("5. No blast bombing");
			player.sendMessage("6. Surv vs surv combat is a kickable offense");
			player.sendMessage("7. Don't build within a survivor's territory as plague. You know what they have conquered, use your head.");
		});

		handler.<Player>register("info" ,"provides information about the plague game mode", (args, player) -> {
			player.sendMessage("Plague is an attack like mode where the infected (purple) must build units to take out the survivors");
			player.sendMessage("Survivors can't build units, their focus is surviving purple's units, to become a survivor place a block on the outside of the map");
			player.sendMessage("Plague has infinite power and must attack and kill survivors (20 minutes for unit control)");
		});

		// Kick a player from the team
		handler.<Player>register("teamkick", "<player>", "Kick a player from your team", (args, player) -> {

			Groups.player.each(p ->{
				if(Strings.stripColors(p.name).equalsIgnoreCase(args[0])) {
					kickedPlayer = p;
				}
			});
			if(kickedPlayer == null) {
				player.sendMessage("No player with such name");
			} else {
				if(leaders.contains(player.uuid()) && player.team() == kickedPlayer.team() && player != kickedPlayer) {
					if(Have120SecondsPassed == true){
						kickedPlayer.team(Team.purple);
					} else {
						kickedPlayer.team(Team.sharded);
					}
					Tile playerCore = playerCores.get(kickedPlayer.uuid());
					playerCore.setNet(Blocks.air);
					playerCores.remove(kickedPlayer.uuid());

				} else {
					player.sendMessage("[red]You aren't a leader/team creator or target player is in another team");
				}

			}
			kickedPlayer = null;
		});

		// Invites a player to a team
		handler.<Player>register("teaminvite", "<Player>", "Invite a player to your team", (args, player) -> {
			if(leaders.contains(player.uuid())) {
				if(player.team() != Team.sharded && player.team() != Team.purple) {
					ArrayList<String> emptylist = new ArrayList<String>();
					Groups.player.each(p ->{
						if(Strings.stripColors(p.name).equalsIgnoreCase(args[0])) {
							invitedPlayer = p;
						}
					});

					if(invitedPlayer != null) {
						if(!invitedPlayers.containsKey(player.team().id)) {
							emptylist.add(invitedPlayer.name);
							invitedPlayers.put(player.team().id, emptylist);
							invitedPlayer.sendMessage("[yellow]You have been invited to team " + player.team().id);
						} else {
							emptylist = invitedPlayers.get(player.team().id);
							emptylist.add(invitedPlayer.name);
							invitedPlayers.put(player.team().id, emptylist);
							invitedPlayer.sendMessage("[yellow]You have been invited to team " + player.team().id);
						}

					} else {
						player.sendMessage("Player not found");
					}


					invitedPlayer = null;
				}
			}
		});

		// Join a team that you have been invited to
		handler.<Player>register("teamjoin", "<TeamID>", "Join a team you've been invited to", (args, player) -> {
			if(args[0].matches("[0-9]+")) {
				int teamid = Integer.parseInt(args[0]);
				if(invitedPlayers.containsKey(teamid)) {
					if(invitedPlayers.get(teamid).contains(player.name)) {
						player.team(Team.all[teamid]);
						player.sendMessage("[green]You have successfully joined a team");
					}
				} else {
					player.sendMessage("[yellow]You haven't been invited to that team");
				}
			} else {
				player.sendMessage("[crimson]Input wasn't a number");
			}
		});

		// It shows how long a round has lasted duh
		handler.<Player>register("time", "Check how long game has lasted", (args, player) -> {
			player.sendMessage("[purple]Game has lasted [green]" + ((System.currentTimeMillis() - gameTime) / 60000) + " [purple]minutes");

		});

		// Kills currently controlled unit
		handler.<Player>register("kill", "Kills currently controlled unit", (args, player) -> {

			player.unit().kill();
		});

		// Respawns unit
		handler.<Player>register("respawn", "Respawn your gamma if bugged as sharded", (args, player) -> {
			if(player.team() == Team.sharded) {
				if(!player.unit().isNull()) {
					player.unit().kill();
				}
				Unit spawnunit = UnitTypes.gamma.spawn(Team.purple, Vars.world.width() * 4, Vars.world.height() * 4);
				player.unit(spawnunit);
			}
		});

		// How do I explain.. if 4/5th of players voted then game ends
		handler.<Player>register("endgame", "[purple] Vote for the game to end", (args, player) -> {
			if(Have120SecondsPassed) {
				if(gameovervotes.contains(player.name)) {
					gameovervotes.remove(player.name);
				} else {
					gameovervotes.add(player.name);
				}
				totalplayers = 0;
				Groups.player.each(p -> {
					totalplayers++;
				});

				Groups.player.each(p -> {
					if(totalplayers <= 5) {
						p.sendMessage("[yellow] There are currently [purple]" + gameovervotes.size() + "[yellow] of [purple]" + 2 + "[yellow] votes to end the game. Vote with /endgame");
					} else {
						p.sendMessage("[yellow] There are currently [purple]" + gameovervotes.size() + "[yellow] of [purple]" + (totalplayers / 5 * 4) + "[yellow] votes to end the game. Vote with /endgame");
					}
				});

				if(totalplayers <= 5) {
					if(gameovervotes.size() >= 2) {
						Events.fire(new GameOverEvent(Team.purple));
					}
				} else if((totalplayers / 5 * 4) <= gameovervotes.size()) {
					Events.fire(new GameOverEvent(Team.purple));
				}
			}
		});

		// Gameover command for admins
		handler.<Player>register("gameover", "Ends round,Admin only", (args, player) -> {
			if(player.admin() == true) {
				Events.fire(new GameOverEvent(Team.purple));
			}
		});

		handler.<Player>register("gameover2", "Ends round,only used if game didn't end", (args, player) -> {
			ArrayList<String> cores = new ArrayList<String>();
			for(int x = 0; x < Vars.world.width(); x++) {
				for(int y = 0; y < Vars.world.height(); y++) {
					if(Vars.world.tile(x, y).block() == Blocks.coreShard || Vars.world.tile(x, y).block() == Blocks.coreFoundation || Vars.world.tile(x, y).block() == Blocks.coreNucleus) {
						if(Vars.world.tile(x, y).build.team != Team.purple) {
							cores.add("There is a surv core");
						}
					}
				}
			}

			if(cores.isEmpty() && !Vars.state.gameOver && Have120SecondsPassed) {
				Events.fire(new GameOverEvent(Team.purple));
			}

			cores.clear();
		});

		handler.<Player>register("playerlist", "Shows all players and their team", (args, player) -> {
			Groups.player.each(p -> {
				if(p.team() != Team.crux) {
					if(leaders.contains(p.uuid())) {
						player.sendMessage("[red]" + p.name + "(Leader)" + " [yellow]Team ID:" + p.team().id);
					} else {
						player.sendMessage("[red]" + p.name + " [yellow]Team ID:" + p.team().id);
					}
				}
			});
		});
	}

	public float cartesianDistance(float x, float y, float cx, float cy){
		return (float) Math.sqrt(Math.pow(x - cx, 2) + Math.pow(y - cy, 2) );
	}

	// Banned blocks for survs and infected
	public void blockRules (){
		survivorBanned.bannedBlocks.addAll(Blocks.groundFactory, Blocks.navalFactory, Blocks.commandCenter, Blocks.multiplicativeReconstructor);
		plagueBanned.bannedBlocks.addAll(Blocks.battery, Blocks.batteryLarge, Blocks.steamGenerator, Blocks.combustionGenerator, Blocks.differentialGenerator, Blocks.rtgGenerator, Blocks.thermalGenerator, Blocks.impactReactor, Blocks.duo, Blocks.scatter, Blocks.scorch, Blocks.hail, Blocks.lancer, Blocks.arc, Blocks.parallax, Blocks.swarmer, Blocks.salvo, Blocks.segment, Blocks.tsunami, Blocks.fuse, Blocks.ripple, Blocks.cyclone, Blocks.foreshadow, Blocks.spectre, Blocks.meltdown, Blocks.navalFactory, Blocks.copperWall, Blocks.copperWallLarge, Blocks.titaniumWall, Blocks.titaniumWallLarge, Blocks.plastaniumWall, Blocks.plastaniumWallLarge, Blocks.thoriumWall, Blocks.thoriumWallLarge, Blocks.phaseWall, Blocks.phaseWallLarge, Blocks.surgeWall, Blocks.surgeWallLarge, Blocks.door, Blocks.doorLarge, Blocks.thoriumReactor, Blocks.solarPanel, Blocks.largeSolarPanel);
	}

	// All the game rules
	public void gameRules () {
		Vars.state.rules.canGameOver = false;
		Vars.state.rules.reactorExplosions = false;
		Vars.state.rules.buildSpeedMultiplier = 5;
		Vars.state.rules.fire = false;
		Vars.state.rules.logicUnitBuild = false;
		Vars.state.rules.damageExplosions = false;
		Vars.state.rules.unitCap = 100;
		Vars.state.rules.unitCapVariable = false;
	}

	// Anything related to unit changes unless specifically put somewhere else
	public void unitChanges () {

		UnitTypes.alpha.health = 1F;
		UnitTypes.beta.health = 1F;
		UnitTypes.gamma.health = 1F;

		// Default Units
		UnitTypes.alpha.weapons.clear();
		UnitTypes.beta.weapons.clear();
		UnitTypes.gamma.weapons.clear();

		// Flare tree
		UnitTypes.flare.weapons.clear();
		UnitTypes.horizon.weapons.clear();
		UnitTypes.zenith.weapons.clear();
		UnitTypes.antumbra.weapons.clear();
		UnitTypes.eclipse.weapons.clear();

		// Mono Tree
		// mono is weaponless
		UnitTypes.poly.weapons.clear();
		UnitTypes.mega.weapons.clear();
		UnitTypes.quad.weapons.clear();
		//oct is weaponless

		// Payload(Picking up Units and Blocks)
		UnitTypes.oct.payloadCapacity = 0F;
		UnitTypes.mega.payloadCapacity = 0F;
		UnitTypes.quad.payloadCapacity = 0F;

	}

	public void blockChanges() {
		((ItemTurret) Blocks.foreshadow).ammoTypes.get(Items.surgeAlloy).buildingDamageMultiplier = 0;
		Blocks.powerSource.health = Integer.MAX_VALUE;
	}

	// Adds all starting survivor resources to an ItemStack Sequence
	public void survivorResources () {
		survivorStartingResources.clear();
		survivorStartingResources.add(new ItemStack(Items.copper, 4000));
		survivorStartingResources.add(new ItemStack(Items.lead, 4000));
		survivorStartingResources.add(new ItemStack(Items.graphite, 2000));
		survivorStartingResources.add(new ItemStack(Items.silicon, 1000));
		survivorStartingResources.add(new ItemStack(Items.titanium, 2000));
		survivorStartingResources.add(new ItemStack(Items.metaglass, 1000));
	}
}
