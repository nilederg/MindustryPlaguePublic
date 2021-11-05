package plague;


import static mindustry.Vars.netServer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import arc.Events;



import arc.util.CommandHandler;

import mindustry.Vars;
import mindustry.content.Blocks;

import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.game.EventType.BlockDestroyEvent;
import mindustry.game.EventType.BlockInfoEvent;
import mindustry.game.EventType.BuildSelectEvent;
import mindustry.game.EventType.DepositEvent;
import mindustry.game.EventType.GameOverEvent;
import mindustry.game.EventType.PlayerJoin;
import mindustry.game.EventType.PlayerLeave;
import mindustry.game.EventType.UnitCreateEvent;


import mindustry.game.Rules;
import mindustry.game.Team;

import mindustry.gen.Call;

import mindustry.gen.Player;
import mindustry.gen.Unit;
import mindustry.mod.Plugin;
import mindustry.net.Administration.ActionType;

import mindustry.type.ItemStack;

import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.storage.CoreBlock;






public class FPlagueBasic extends Plugin {
	boolean blueItemsAdded = false;
	boolean blueJoinable = true;
	boolean greenJoinable = true;
	boolean greenItemsAdded = false;
	
	
	static boolean Have45MinsPassed = false;
	static boolean Have120SecondsPassed = false;
	long gameTime = System.currentTimeMillis();
	
	
	
	
	

	
	 private final Rules rules = new Rules();
	    private Rules survivorBanned = new Rules();
	    public static Rules plagueBanned = new Rules();
	    ArrayList<TeamNPass> lockedCustomTeams = new ArrayList<TeamNPass>();
	    Map<String, Team> relogTeam = new HashMap<String, Team>();
	    
	    
	   
	
	@Override
    public void init(){
		// Start all plague unit multipliers in x seconds and time before all teamless are turned to plague
		new PlagueTime(120);
		
		rules.canGameOver = false; //I have my own way to game over
		rules.reactorExplosions = false; // I wonder,nah plague op
		rules.buildSpeedMultiplier = 2; // game goes faster brr
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
		// No placing near crux core 
		netServer.admins.addActionFilter((action) ->{ 
			int playerx = Math.round(action.player.getX());
			int playery = Math.round(action.player.getY());
			
			if(action.block != null && action.type == ActionType.placeBlock && action.player.team() != Team.purple && closestCore(playerx, playery, Team.purple) < 100){
                return false;
            }
			return true;
		});
		
		// No unit control until 45 mins have passed
		netServer.admins.addActionFilter((action) ->{ 
			if(action.type == ActionType.control && Have45MinsPassed == false){
				
				return false;
                
            }
			return true;
		});
		
		
		
		// Make core from vault using 480 thorium 
		Events.on(DepositEvent.class, event -> {
	          if(event.tile.block == Blocks.vault && event.tile.items().has(Items.thorium, 480) && event.player.team() != Team.purple) {
	        	  Vars.world.tile(event.tile.tileX(), event.tile.tileY()).setNet(Blocks.coreShard, Team.all[event.player.team().id], 0);  
	          }
	        });
		
		
		
		
		// Makes you plague if you join too late also if rejoin put back on team
		Events.on(PlayerJoin.class, event -> {
			Unit spawnunit = UnitTypes.gamma.spawn(Team.purple, Vars.world.width() / 2, Vars.world.height() / 2);
			event.player.unit(spawnunit);
			
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
		
		// Flare becomes mono duh but only for plague cus surv flares have damage disabled
		Events.on(UnitCreateEvent.class, event -> {
	          if(event.unit.type == UnitTypes.flare && event.unit.team == Team.purple) {
	        	 
	        	  event.unit.setType(UnitTypes.mono);
	        	  
	          }
	        }); 
		
		// When a core is destroyed check for all surv cores
		Events.on(BlockDestroyEvent.class, event -> {
			
			if(event.tile.block() != null) {
				ArrayList<String> cores = new ArrayList<String>();
			if(event.tile.block() == Blocks.coreShard || event.tile.block() == Blocks.coreFoundation || event.tile.block() == Blocks.coreNucleus) {
				
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
				} else {
					cores.clear();
				}
				
			}
			
			}
		});
		
		
		// Hell no no ono
		Events.on(GameOverEvent.class, event -> {
			
			blueJoinable = true;
			blueItemsAdded = false;
			greenJoinable = true;
			greenItemsAdded = false;
			Have120SecondsPassed = false;
			Have45MinsPassed = false;
			gameTime = System.currentTimeMillis();
			this.lockedCustomTeams.clear();
			relogTeam.clear();
			PlagueTime.timer.cancel();
			PlagueTime.unitcontroltimer.cancel();
			PlagueTime.multiplier1.cancel();
			PlagueTime.multiplier2.cancel();
			PlagueTime.multiplier3.cancel();
			PlagueTime.multiplier4.cancel();
			PlagueTime.multiplier5.cancel();
			PlagueTime.multiplier6.cancel();
			PlagueTime.multiplier7.cancel();
			PlagueTime.multiplier8.cancel();
			PlagueTime.multiplier9.cancel();
			PlagueTime.multiplier10.cancel();
			PlagueTime.multiplier11.cancel();
			PlagueTime.multiplier12.cancel();
			PlagueTime.multiplier13.cancel();
			PlagueTime.multiplier14.cancel();
			PlagueTime.multiplier15.cancel();
			PlagueTime.multiplier16.cancel();
			PlagueTime.multiplier17.cancel();
			PlagueTime.multiplier18.cancel();
			new PlagueTime(120); // amount of seconds until everything actually starts
			
			
			 
	        });
		
		
	}
	
	
	
	
	// Turns you infected
	@Override
    public void registerClientCommands(CommandHandler handler){
        handler.<Player>register("infect", "You become [purple]INFECTED", (args, player) -> {
        	Call.setRules(player.con, plagueBanned);
        	player.team(Team.purple);  	
        	
        	
        	
        	
        	
        });
        
        
         
        // Locks a default team,sucks,probably broke after removing purple
        handler.<Player>register("lockteam", "Lock current team - [red] Default Teams Only", (args, player) -> {
        	if(player.team() == Team.green) {
        		greenJoinable = false;
        		player.sendMessage("[green]GREEN team was locked");
        	} else if(player.team() == Team.blue) {
        		blueJoinable = false;
        		player.sendMessage("[blue]BLUE team was locked");
        	} else {
        		player.sendMessage("This is not a lockable team");
        	}
        });
        
        

        // It shows how long a round has lasted duh
        handler.<Player>register("time", "Check how long game has lasted", (args, player) -> {
        	player.sendMessage("[purple]Game has lasted [green]" + ((System.currentTimeMillis() - gameTime) / 60000) + " [purple]minutes");
        	
        });
        
        
        handler.<Player>register("kill", "Kills currently controlled unit", (args, player) -> {
        	player.unit().kill();

        });
        
        handler.<Player>register("respawn", "Respawn your alpha if bugged as sharded", (args, player) -> {
        if(player.team() == Team.sharded) {
        Unit spawnunit = UnitTypes.gamma.spawn(Team.purple, Vars.world.width() / 2, Vars.world.height() / 2);
		player.unit(spawnunit);
        }
        });
        
        
        // Gameover command for admins
        handler.<Player>register("gameover", "Ends round,Admin only", (args, player) -> {
        	if(player.admin) {
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
        	if(args.length == 1 && player.team() != Team.blue && player.team() != Team.green && player.team() != Team.purple && player.team() != Team.sharded && player.team() != Team.purple) {
        	
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
		rules.buildSpeedMultiplier = 2; // game goes faster brr
		rules.fire = false; // Obvious
		rules.logicUnitBuild = false; // You know why
		rules.damageExplosions = false; // NO NO NO
		
				
        survivorBanned = rules.copy();
        survivorBanned.bannedBlocks.addAll(Blocks.groundFactory, Blocks.navalFactory, Blocks.commandCenter, Blocks.multiplicativeReconstructor);

        plagueBanned = rules.copy();
        plagueBanned.bannedBlocks.addAll(Blocks.battery, Blocks.batteryLarge, Blocks.steamGenerator, Blocks.combustionGenerator, Blocks.differentialGenerator, Blocks.rtgGenerator, Blocks.thermalGenerator, Blocks.impactReactor, Blocks.duo, Blocks.scatter, Blocks.scorch, Blocks.hail, Blocks.wave, Blocks.lancer, Blocks.arc, Blocks.parallax, Blocks.swarmer, Blocks.salvo, Blocks.segment, Blocks.tsunami, Blocks.fuse, Blocks.ripple, Blocks.cyclone, Blocks.foreshadow, Blocks.spectre, Blocks.meltdown, Blocks.navalFactory, Blocks.copperWall, Blocks.copperWallLarge, Blocks.titaniumWall, Blocks.titaniumWallLarge, Blocks.plastaniumWall, Blocks.plastaniumWallLarge, Blocks.thoriumWall, Blocks.thoriumWallLarge, Blocks.phaseWall, Blocks.phaseWallLarge, Blocks.surgeWall, Blocks.surgeWallLarge, Blocks.door, Blocks.doorLarge, Blocks.thoriumReactor, Blocks.solarPanel, Blocks.largeSolarPanel); // Can't be trusted
        
       
        
        Blocks.powerSource.health = Integer.MAX_VALUE;
        
        // Disable default unit damage
        UnitTypes.alpha.weapons.clear();
        UnitTypes.beta.weapons.clear();
        UnitTypes.gamma.weapons.clear();
        UnitTypes.flare.weapons.clear();
        
        
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
