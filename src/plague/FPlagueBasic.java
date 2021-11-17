package plague;


import static mindustry.Vars.netServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import arc.Events;
import arc.struct.Seq;

import static mindustry.Vars.maps;

import arc.util.CommandHandler;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.content.Blocks;

import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.game.EventType.BlockDestroyEvent;
import mindustry.game.EventType.BuildSelectEvent;
import mindustry.game.EventType.GameOverEvent;
import mindustry.game.EventType.PlayerJoin;
import mindustry.game.EventType.PlayerLeave;
import mindustry.game.EventType.TapEvent;
import mindustry.game.EventType.UnitCreateEvent;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.gen.Call;
import mindustry.gen.Groups;
import mindustry.gen.Player;
import mindustry.gen.Unit;
import mindustry.mod.Plugin;
import mindustry.net.Administration.ActionType;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.storage.CoreBlock;

public class FPlagueBasic extends Plugin {
	
	
	
	int useless = 0;
	static boolean Have120SecondsPassed = false;
	static long gameTime = System.currentTimeMillis();
	int mapvotes1 = 0;
	int mapvotes2 = 0;
	int mapvotes3 = 0;
	int mapvotes4 = 0;
	int mapvotes5 = 0;
	int mapvotes6 = 0;
	int mapvotes7 = 0;
	int mapvotes8 = 0;
	int mapvotes9 = 0;
	int mapvotes10 = 0;
	
	
	

	public static mindustry.maps.Map selectedMap;
	 private final Rules rules = new Rules();
	    private Rules survivorBanned = new Rules();
	    public static Rules plagueBanned = new Rules();
	    ArrayList<TeamNPass> lockedCustomTeams = new ArrayList<TeamNPass>();
	    Map<String, Team> relogTeam = new HashMap<String, Team>();
	    ArrayList<String> gameovervotes = new ArrayList<String>();
	    int totalplayers = 0; // for some reason i need it here cus java
	    ArrayList<String> playersThatVoted = new ArrayList<String>();
	    ArrayList<Tile> plagueCores = new ArrayList<Tile>();
	    
	   
	
	@Override
    public void init(){
		// Start all plague unit multipliers in x seconds and time before all teamless are turned to plague
		new PlagueTime(120);
		
		rules.canGameOver = false; //I have my own way to game over
		rules.reactorExplosions = false; // I wonder,nah plague op
		rules.buildSpeedMultiplier = 4; // game goes faster brr
		rules.fire = false; // Obvious
		rules.logicUnitBuild = false; // You know why
		rules.damageExplosions = false; // NO NO NO
		
		
		init_rules();
		
		
		
	
		
		
		
		
		
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
				action.player.sendMessage("[red]NO PERMISSION TO PLACE BANNED BLOCKS");
				return false;
			}
			
			if(action.block != null && action.type == ActionType.placeBlock && action.player.team() == Team.purple && plagueBanned.bannedBlocks.contains(action.block)) {
				action.player.sendMessage("[red]NO PERMISSION TO PLACE BANNED BLOCKS");
				return false;
			}
			
			if(action.block != null && action.type == ActionType.breakBlock && boulders.contains(action.tile.block())) {
				action.tile.setNet(Blocks.air);
				return false;
			}
			
			if(action.block != null && action.type == ActionType.placeBlock){
				for(Tile b : plagueCores) {
					if(cartesianDistance(action.tile.x, action.tile.y, b.x, b.y) < 90) {
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
		
		
		
		// Make core from vault using 1k thorium 
		Events.on(TapEvent.class, event -> {
			if(event.tile.block() == Blocks.vault) {
				if(event.tile.build.items().has(Items.thorium, 1000) && event.player.team() != Team.purple) {
					Vars.world.tile(event.tile.build.tileX(), event.tile.build.tileY()).setNet(Blocks.coreShard, event.player.team(), 0);
				}
			}
		});
		
		
		
		// Makes you plague if you join too late also if rejoin put back on team
		Events.on(PlayerJoin.class, event -> {
			
			
			
			if(relogTeam.containsKey(event.player.uuid())) {
	          event.player.team(relogTeam.get(event.player.uuid()));
			  Call.setRules(event.player.con, survivorBanned);
			} else if (Have120SecondsPassed == true) {
	        	 event.player.team(Team.purple); 	  
	        	 Call.setRules(event.player.con, plagueBanned);
	          }	else if (event.player.team() == Team.sharded) {
	        	  Unit spawnunit = UnitTypes.gamma.spawn(Team.purple, Vars.world.width() * 4, Vars.world.height() * 4);
	        	  event.player.unit(spawnunit);
	        	  Call.setRules(event.player.con, survivorBanned);
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
        	ArrayList<String> teamcores = new ArrayList<String>();
        	ArrayList<Float> closestcores = new ArrayList<Float>();
        	float distanceaway = 80;
        	
        	
        	
        	for(int x = 0; x < Vars.world.width(); x++){
                for(int y = 0; y < Vars.world.height(); y++){
                    
                    if(Vars.world.tile(x, y).block() == Blocks.coreFoundation && Vars.world.tile(x, y).isCenter() && Vars.world.tile(x, y).build.team == chosenteam){
                        teamcores.add("hascorelol");
                    }
                }
            }		
        	
        	if(teamcores.isEmpty() == true) {
            	for(Team t : Team.all) {
            		if (t != chosenteam) {
            			CoreBlock.CoreBuild nearestEnemyCore = Vars.state.teams.closestCore(event.builder.getPlayer().x / 8, event.builder.getPlayer().y / 8, t);
            			
            			if(nearestEnemyCore != null) {
            				if(cartesianDistance(event.builder.getPlayer().x / 8, event.builder.getPlayer().y / 8, nearestEnemyCore.tileX(), nearestEnemyCore.tileY()) < distanceaway) {
            			closestcores.add(cartesianDistance(event.builder.getPlayer().x, event.builder.getPlayer().y, nearestEnemyCore.tileX(), nearestEnemyCore.tileY()));
            			
            				}
            				}
            		}
            	}
            	
            	
            	if(closestcores.isEmpty() == true) {
            		event.builder.getPlayer().team(chosenteam);
            		Call.setRules(event.builder.getPlayer().con, survivorBanned);
            		event.tile.setNet(Blocks.coreFoundation, Team.all[randomTeamNumber], 0);
        			event.builder.getPlayer().sendMessage("Your team number is: [green]" + randomTeamNumber);
            		for(ItemStack stack : rules.loadout) {
        				Call.setItem(event.tile.build, stack.item, stack.amount);    			
        			}
            		
            		
            		
            	}
            	}
        	teamcores.clear();
        	closestcores.clear();
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
			lockedCustomTeams.clear();
			relogTeam.clear();
			gameovervotes.clear();	
			plagueCores.clear();
			PlagueTime.timer.cancel();
			PlagueTime.multiplier1.cancel();
			PlagueTime.gameover.cancel();
			PlagueTime.resetToDefaults();
			Have120SecondsPassed = false;
			new PlagueTime(120); // amount of seconds until everything actually starts
			
			// Why,why would you even do more timers Fitmo.. WHY?! Cursed existence
			mostVotedMap();
			
			
			
			if(selectedMap != null) {
			Groups.player.each(p -> {
				p.sendMessage("[yellow]Voted map is: " + selectedMap.name());
			});
			new MapChangerThings();
			}
			
			 
	        });
		
		Events.on(UnitCreateEvent.class, event -> {
			if(event.unit.type == UnitTypes.flare || event.unit.type == UnitTypes.horizon || event.unit.type == UnitTypes.zenith || event.unit.type == UnitTypes.antumbra || event.unit.type == UnitTypes.eclipse) {
				event.unit.kill();
			}
			
			
			
			 
	        });
		
	}
	
	
	
	
	// Turns you infected
	@Override
    public void registerClientCommands(CommandHandler handler){
        handler.<Player>register("infect", "You become [purple]INFECTED", (args, player) -> {
        	if(player.team() != Team.purple) {
        	useless = 0;
        	Team playerteam = player.team();
        	Groups.player.each(p -> {
        	if(p.team() == player.team()){
        	useless++;
        	}
        	});
        	if(useless == 1){
        		for(int x = 0; x < Vars.world.width(); x++) {
        			for(int y = 0; y < Vars.world.height(); y++) {
            			
        				if(Vars.world.tile(x, y).block() == Blocks.coreFoundation && Vars.world.tile(x, y).isCenter() && Vars.world.tile(x, y).build.team == playerteam){
        					Vars.world.tile(x, y).setNet(Blocks.air);
                        }
        				
            		}
        		}
        			
        	}
        	}
        	
        	
        	
        	
        	Call.setRules(player.con, plagueBanned);
        	player.team(Team.purple);  	
        	useless = 0;
        	
        	
        	
        	
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
        
        
        
        
        
        // Start voting to select next map or see all maps
        handler.<Player>register("rtv", "[MapNumber]" ,"Vote for next map or see all maps", (args, player) -> {
        	if(args.length == 1) {
        	
            Seq<mindustry.maps.Map> allcustommaps = mindustry.Vars.maps.customMaps();
        	if(!playersThatVoted.contains(player.name)) {
        	
        	if(args[0].matches("[0-9]+")) {
        		int votednumber = Integer.parseInt(args[0]);
        		if(votednumber == 1) {
        		try {
        			allcustommaps.get(0);
        			mapvotes1++;
        			playersThatVoted.add(player.name);
        			player.sendMessage("You voted for map " + allcustommaps.get(0).name());
        		} catch(Exception e) {
        			player.sendMessage("Vote failed");
        		}
        		} else if(votednumber == 2) {
        			try {
            			allcustommaps.get(1);
            			mapvotes2++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(1).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		} else if(votednumber == 3) {
        			try {
            			allcustommaps.get(2);
            			mapvotes3++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(2).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		} else if(votednumber == 4) {
        			try {
            			allcustommaps.get(3);
            			mapvotes4++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(3).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		} else if(votednumber == 5) {
        			try {
            			allcustommaps.get(4);
            			mapvotes5++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(4).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		} else if(votednumber == 6) {
        			try {
            			allcustommaps.get(5);
            			mapvotes6++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(5).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		} else if(votednumber == 7) {
        			try {
            			allcustommaps.get(6);
            			mapvotes7++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(6).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		} else if(votednumber == 8) {
        			try {
            			allcustommaps.get(7);
            			mapvotes8++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(7).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		} else if(votednumber == 9) {
        			try {
            			allcustommaps.get(8);
            			mapvotes9++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(8).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		} else if(votednumber == 10) {
        			try {
            			allcustommaps.get(9);
            			mapvotes10++;
            			playersThatVoted.add(player.name);
            			player.sendMessage("You voted for map " + allcustommaps.get(9).name());
            		} catch(Exception e) {
            			player.sendMessage("Vote failed");
            		}
        		}	
	
        	}
        	
        	} else {
        		player.sendMessage("You already voted");
        	}
        } else {
        	int mapnumber = 0;
        	player.sendMessage("All maps:");
        	Seq<mindustry.maps.Map> list = mindustry.Vars.maps.customMaps();
        	
        	for(mindustry.maps.Map map : list) {
        		mapnumber++;
        		player.sendMessage(mapnumber + " " + map.name());
        	}
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
        	  			p.sendMessage("[yellow] There is currently [purple]" + gameovervotes.size() + "[yellow] votes out of [purple]" + 2 + "[yellow] required.");
        	  		} else {
        	  		p.sendMessage("[yellow] There is currently [purple]" + gameovervotes.size() + "[yellow] votes out of [purple]" + (totalplayers / 5 * 4) + "[yellow] required.");
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
        
        
        
        
        
        handler.<Player>register("setteampass", "<Password>", "Put a team password and allows people to join using it - [red]Custom Teams Only", (args, player) -> {
        	if(args.length == 1 && player.team() != Team.sharded && player.team() != Team.purple) {
        	
        	TeamNPass teampass = new TeamNPass(player.team().id, args[0]);
        	
        	lockedCustomTeams.add(teampass);
        	
        	}
        	   	
        });
        
        handler.<Player>register("joincustomteam", "<Password> <TeamNumber>", "Join a custom team -[red] Custom Teams Only", (args, player) -> {
        	if(args.length == 2 && args[1].matches("[0-9]+") && player.team() != Team.purple) {
        		int chosenteamnumber = Integer.parseInt(args[1]);
            	
     	
        	
        	
        	for(TeamNPass joining : lockedCustomTeams) {
        		
        		int findingteamid = Math.round(joining.teamid);
        		String findingteampass = joining.password;
        		
        		int tryingtojoinid = Math.round(chosenteamnumber);
        		String tryingtojoinpass = args[0];
        		
        		
        		
        		if(findingteamid == tryingtojoinid && findingteampass.equals(tryingtojoinpass)) {
        		System.out.println("what");
        			player.team(Team.all[chosenteamnumber]);
        		}
        	}
        	
        	}
        	   	
        });
        
        
        
    }
	
	
	
	
	
	
	
	//this thing has more than rules as you can see lmao
	void init_rules(){
		
		rules.canGameOver = false; //I have my own way to game over
		rules.reactorExplosions = false; // I wonder,nah plague op
		rules.buildSpeedMultiplier = 4; // game goes faster brr
		rules.fire = false; // Obvious
		rules.logicUnitBuild = false; // You know why
		rules.damageExplosions = false; // NO NO NO
		
				
        survivorBanned = rules.copy();
        survivorBanned.bannedBlocks.addAll(Blocks.groundFactory, Blocks.navalFactory, Blocks.commandCenter, Blocks.multiplicativeReconstructor);
        survivorBanned.enemyCoreBuildRadius = 700;
        
        plagueBanned = rules.copy();
        plagueBanned.bannedBlocks.addAll(Blocks.battery, Blocks.batteryLarge, Blocks.steamGenerator, Blocks.combustionGenerator, Blocks.differentialGenerator, Blocks.rtgGenerator, Blocks.thermalGenerator, Blocks.impactReactor, Blocks.duo, Blocks.scatter, Blocks.scorch, Blocks.hail, Blocks.lancer, Blocks.arc, Blocks.parallax, Blocks.swarmer, Blocks.salvo, Blocks.segment, Blocks.tsunami, Blocks.fuse, Blocks.ripple, Blocks.cyclone, Blocks.foreshadow, Blocks.spectre, Blocks.meltdown, Blocks.navalFactory, Blocks.copperWall, Blocks.copperWallLarge, Blocks.titaniumWall, Blocks.titaniumWallLarge, Blocks.plastaniumWall, Blocks.plastaniumWallLarge, Blocks.thoriumWall, Blocks.thoriumWallLarge, Blocks.phaseWall, Blocks.phaseWallLarge, Blocks.surgeWall, Blocks.surgeWallLarge, Blocks.door, Blocks.doorLarge, Blocks.thoriumReactor, Blocks.solarPanel, Blocks.largeSolarPanel); // Can't be trusted
        
        Blocks.powerSource.health = Integer.MAX_VALUE;
        
        // Disable default unit damage
        UnitTypes.alpha.weapons.clear();
        UnitTypes.beta.weapons.clear();
        UnitTypes.gamma.weapons.clear();
        UnitTypes.flare.weapons.clear();
        UnitTypes.horizon.abilities.clear();
        UnitTypes.alpha.health = 1;
        UnitTypes.beta.health = 1;
        UnitTypes.gamma.health = 1;
        UnitTypes.flare.health = 1;
        
        //Disable pickup,interesting variable
        UnitTypes.oct.payloadCapacity = 0;
        UnitTypes.mega.payloadCapacity = 0;
        UnitTypes.quad.payloadCapacity = 0;
        
        // Easily changable starting items for survivors
        rules.loadout.clear();
        rules.loadout.add(new ItemStack(Items.copper, 4000));
        rules.loadout.add(new ItemStack(Items.lead, 4000));
        rules.loadout.add(new ItemStack(Items.graphite, 2000));
        rules.loadout.add(new ItemStack(Items.silicon, 1000));
        rules.loadout.add(new ItemStack(Items.titanium, 2000));
        rules.loadout.add(new ItemStack(Items.metaglass, 1000));
        
        //foreshadow build damage removed cus yes
        ((ItemTurret) Blocks.foreshadow).ammoTypes.get(Items.surgeAlloy).buildingDamageMultiplier = 0;
        
        
        	
        
        
       
        

        

        

        

        

        
        


        
    }
	
	
	
	
	
	
	
	
	
	
	
	public mindustry.maps.Map findmap(String mapname) {
		mindustry.maps.Map findMap;
		findMap = maps.all().find(map -> Strings.stripColors(map.name().replace('_', ' ')).equalsIgnoreCase(Strings.stripColors(mapname)));
    	if(findMap != null) {
    		return findMap;
    	}
    	return null;
	}
	
	public mindustry.maps.Map mostVotedMap(){
		playersThatVoted.clear();
		Seq<mindustry.maps.Map> allmaps = mindustry.Vars.maps.customMaps();
		if(mapvotes1 > mapvotes2 && mapvotes1 > mapvotes3 && mapvotes1 > mapvotes4 && mapvotes1 > mapvotes5 && mapvotes1 > mapvotes6 && mapvotes1 > mapvotes7 && mapvotes1 > mapvotes8 && mapvotes1 > mapvotes9 && mapvotes1 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(0);
			return null;	
		}
		
		if(mapvotes2 > mapvotes1 && mapvotes2 > mapvotes3 && mapvotes2 > mapvotes4 && mapvotes2 > mapvotes5 && mapvotes2 > mapvotes6 && mapvotes2 > mapvotes7 && mapvotes2 > mapvotes8 && mapvotes2 > mapvotes9 && mapvotes2 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(1);
			return null;	
		}
		
		if(mapvotes3 > mapvotes2 && mapvotes3 > mapvotes1 && mapvotes3 > mapvotes4 && mapvotes3 > mapvotes5 && mapvotes3 > mapvotes6 && mapvotes3 > mapvotes7 && mapvotes3 > mapvotes8 && mapvotes3 > mapvotes9 && mapvotes3 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(2);
			return null;	
		}
		
		if(mapvotes4 > mapvotes2 && mapvotes4 > mapvotes3 && mapvotes4 > mapvotes1 && mapvotes4 > mapvotes5 && mapvotes4 > mapvotes6 && mapvotes4 > mapvotes7 && mapvotes4 > mapvotes8 && mapvotes4 > mapvotes9 && mapvotes4 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(3);
			return null;	
		}
		
		if(mapvotes5 > mapvotes2 && mapvotes5 > mapvotes3 && mapvotes5 > mapvotes4 && mapvotes5 > mapvotes1 && mapvotes5 > mapvotes6 && mapvotes5 > mapvotes7 && mapvotes5 > mapvotes8 && mapvotes5 > mapvotes9 && mapvotes5 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(4);
			return null;	
		}
		
		if(mapvotes6 > mapvotes2 && mapvotes6 > mapvotes3 && mapvotes6 > mapvotes4 && mapvotes6 > mapvotes5 && mapvotes6 > mapvotes1 && mapvotes6 > mapvotes7 && mapvotes6 > mapvotes8 && mapvotes6 > mapvotes9 && mapvotes6 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(5);
			return null;	
		}
		
		if(mapvotes7 > mapvotes2 && mapvotes7 > mapvotes3 && mapvotes7 > mapvotes4 && mapvotes7 > mapvotes5 && mapvotes7 > mapvotes6 && mapvotes7 > mapvotes1 && mapvotes7 > mapvotes8 && mapvotes7 > mapvotes9 && mapvotes7 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(6);
			return null;	
		}
		
		if(mapvotes8 > mapvotes2 && mapvotes8 > mapvotes3 && mapvotes8 > mapvotes4 && mapvotes8 > mapvotes5 && mapvotes8 > mapvotes6 && mapvotes8 > mapvotes7 && mapvotes8 > mapvotes1 && mapvotes8 > mapvotes9 && mapvotes8 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(7);
			return null;	
		}
		
		if(mapvotes9 > mapvotes2 && mapvotes9 > mapvotes3 && mapvotes9 > mapvotes4 && mapvotes9 > mapvotes5 && mapvotes9 > mapvotes6 && mapvotes9 > mapvotes7 && mapvotes9 > mapvotes8 && mapvotes9 > mapvotes1 && mapvotes9 > mapvotes10) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(8);
			return null;	
		}
		
		if(mapvotes10 > mapvotes2 && mapvotes10 > mapvotes3 && mapvotes10 > mapvotes4 && mapvotes10 > mapvotes5 && mapvotes10 > mapvotes6 && mapvotes10 > mapvotes7 && mapvotes10 > mapvotes8 && mapvotes10 > mapvotes9 && mapvotes10 > mapvotes1) {
			mapvotes1 = 0;
			mapvotes2 = 0;
			mapvotes3 = 0;
			mapvotes4 = 0;
			mapvotes5 = 0;
			mapvotes6 = 0;
			mapvotes7 = 0;
			mapvotes8 = 0;
			mapvotes9 = 0;
			mapvotes10 = 0;
			selectedMap = allmaps.get(9);
			return null;	
		}
		
		return null;
		
		
	}
	
	public float closestCore(int playerx, int playery, Team team) {
		CoreBlock.CoreBuild nearestCoreTeam0 = Vars.state.teams.closestCore(playerx / 8, playery / 8, team);
		if(nearestCoreTeam0 != null){
			
    	float nearestCoreCartTeam0 = cartesianDistance(floatToShort(playerx / 8), floatToShort(playery / 8), nearestCoreTeam0.tileX(), nearestCoreTeam0.tileY());
    	return nearestCoreCartTeam0;
		} else return 1000;
		
	}
	
	public static short floatToShort(float x) {
	    if (x < Short.MIN_VALUE) {
	        return Short.MIN_VALUE;
	    }
	    if (x > Short.MAX_VALUE) {
	        return Short.MAX_VALUE;
	    }
	    return (short) Math.round(x);
	}
	
	public float cartesianDistance(float x, float y, float cx, float cy){
        return (float) Math.sqrt(Math.pow(x - cx, 2) + Math.pow(y - cy, 2) );
    }
	
	
	
}
