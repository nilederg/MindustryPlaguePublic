package plague;


import static mindustry.Vars.netServer;


import java.util.ArrayList;

import arc.Events;



import arc.util.CommandHandler;

import mindustry.Vars;
import mindustry.content.Blocks;

import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.game.EventType;
import mindustry.game.EventType.BlockBuildBeginEvent;
import mindustry.game.EventType.DepositEvent;
import mindustry.game.EventType.GameOverEvent;
import mindustry.game.EventType.PlayerJoin;

import mindustry.game.EventType.UnitCreateEvent;


import mindustry.game.Rules;
import mindustry.game.Team;

import mindustry.gen.Call;

import mindustry.gen.Player;

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
	    
	    
	   
	
	@Override
    public void init(){
		// Start all plague unit multipliers in x seconds and time before all teamless are turned to plague
		new PlagueTime(120);
		
        
		
		   
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
		
		
		// Makes you plague if you join too late 
		Events.on(PlayerJoin.class, event -> {
	          if(Have120SecondsPassed == true) {
	        	 event.player.team(Team.purple); 	  
	        	 Call.setRules(event.player.con, plagueBanned);
	          }
	        }); 

		
	
		
		// Flare becomes mono duh but only for plague cus surv flares have damage disabled
		Events.on(UnitCreateEvent.class, event -> {
	          if(event.unit.type == UnitTypes.flare && event.unit.team == Team.purple) {
	        	 
	        	  event.unit.setType(UnitTypes.mono);
	        	  
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
        handler.<Player>register("infect", "You become [red]INFECTED", (args, player) -> {
        	Call.setRules(player.con, plagueBanned);
        	player.team(Team.purple);  	
        	
        	
        	
        	
        	
        });
        
        
        // Makes you join blue duh 
        handler.<Player>register("blue", "You become [blue]BLUE", (args, player) -> {
        	
        	if(blueJoinable == true && player.team() != Team.purple) {
        	player.team(Team.blue);  
        	Call.setRules(player.con, survivorBanned);
        	
        	if(blueItemsAdded == false) {
        		CoreBlock.CoreBuild nearestCoreTeamBlue = Vars.state.teams.closestCore(player.getX() / 8, player.getY() / 8, Team.blue);
        		for(ItemStack stack : rules.loadout) {
    				Call.setItem(nearestCoreTeamBlue, stack.item, stack.amount);  
    				blueItemsAdded = true;
    			}
        	}
        	
        	} else {
        		player.sendMessage("Team is locked or you are infected");
        	}
        });
        
        
        // green
        handler.<Player>register("green", "You become [green]GREEN", (args, player) -> {
        	
        	if(greenJoinable == true && player.team() != Team.purple) {
        	player.team(Team.green);
        	Call.setRules(player.con, survivorBanned);
        	
        	
        	if(greenItemsAdded == false) {
        		CoreBlock.CoreBuild nearestCoreTeamGreen = Vars.state.teams.closestCore(player.getX() / 8, player.getY() / 8, Team.green);
        		for(ItemStack stack : rules.loadout) {
    				Call.setItem(nearestCoreTeamGreen, stack.item, stack.amount);  
    				greenItemsAdded = true;
    			}
        	}
        	
        	
        	} else {
        		player.sendMessage("Team is locked or you are infected");
        	}
        });
        
       
        
        
        // Locks a team
        handler.<Player>register("lockteam", "Lock current team", (args, player) -> {
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
        
        

        // duh
        handler.<Player>register("time", "Check how long game has lasted", (args, player) -> {
        	player.sendMessage("[purple]Game has lasted [green]" + ((System.currentTimeMillis() - gameTime) / 60000) + " [purple]minutes");
        });
        
        
        //Peak of unefficient after all the timers god help
        handler.<Player>register("newcustomteam", "<number(1-200)>", "You can choose a team number between 1 and 200 idk", (args, player) -> {
        	if(args.length == 1 && args[0].matches("[0-9]+") && Have120SecondsPassed == false) {
        	ArrayList<Float> closestcores = new ArrayList<Float>();
        	int chosenteamnumber = Integer.parseInt(args[0]) + 5;
        	Team chosenteam = Team.all[chosenteamnumber];
        	ArrayList<String> teamcores = new ArrayList<String>();
        	
        	
        	// adds all team cores to teamcores to check if there is cores since mindustry hascore is broken
        	for(int x = 0; x < Vars.world.width(); x++){
                for(int y = 0; y < Vars.world.height(); y++){
                    
                    if(Vars.world.tile(x, y).block() == Blocks.coreFoundation && Vars.world.tile(x, y).isCenter() && Vars.world.tile(x, y).build.team == chosenteam){
                        teamcores.add("hascorelol");
                        System.out.println("teamcore added");
                    }
                }
            }
        	
        	
        	// cus these are here anyway the reason for chosenteamnumber being increased by 5 is because recessive and me following wtf he did for some reason
        	float distanceaway = 80;
        	if((chosenteamnumber - 5) >= 1 && (chosenteamnumber - 5) <= 8) {
        	
        	if(player.team() != Team.purple) {
        	
        		
        		
        	if(teamcores.isEmpty() == true) {
        	for(Team t : Team.all) {
        		if (t != chosenteam) {
        			CoreBlock.CoreBuild nearestEnemyCore = Vars.state.teams.closestCore(player.x / 8, player.y / 8, t);
        			
        			if(nearestEnemyCore != null) {
        				System.out.println(cartesianDistance(player.x / 8, player.y / 8, nearestEnemyCore.tileX(), nearestEnemyCore.tileY()));
        				if(cartesianDistance(player.x / 8, player.y / 8, nearestEnemyCore.tileX(), nearestEnemyCore.tileY()) < distanceaway) {
        			closestcores.add(cartesianDistance(player.x, player.y, nearestEnemyCore.tileX(), nearestEnemyCore.tileY()));
        			System.out.println("bruh");
        				}
        				}
        		}
        	}
        	
        	
        	if(closestcores.isEmpty() == true) {
        		player.team(chosenteam);
        		Call.setRules(player.con, survivorBanned);
        		Vars.world.tile(Math.round(player.getX()) / 8, Math.round(player.getY()) / 8).setNet(Blocks.coreFoundation, Team.all[chosenteamnumber], 0);
    			
        		for(ItemStack stack : rules.loadout) {
    				Call.setItem(Vars.world.tile(Math.round(player.getX()) / 8, Math.round(player.getY()) / 8).build, stack.item, stack.amount);    			
    			}
        		
        		
        		
        	}
        	}
        	}
        	}
        	teamcores.clear();
        	closestcores.clear();
        	}
        	
        });
        
        handler.<Player>register("setteampass", "<Password>", "Put a team password and allows people to join using it -[red]Custom Teams Only", (args, player) -> {
        	if(args.length == 1 && player.team() != Team.blue && player.team() != Team.green && player.team() != Team.purple && player.team() != Team.sharded && player.team() != Team.purple) {
        	
        	TeamNPass teampass = new TeamNPass(player.team().id, args[0]);
        	
        	lockedCustomTeams.add(teampass);
        	
        	}
        	   	
        });
        
        handler.<Player>register("joincustomteam", "<Password> <TeamNumber>", "Join a custom team -[red] Custom Teams Only", (args, player) -> {
        	if(args.length == 2 && args[1].matches("[0-9]+") && player.team() != Team.purple) {
        		int chosenteamnumber = Integer.parseInt(args[1]) + 5;
            	
     	
        	
        	
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
		rules.canGameOver = true; // MAPS NEED TO HAVE AT LEAST 1 CORE OTHER THAN RED
		rules.reactorExplosions = false;
		rules.buildSpeedMultiplier = 2;
		rules.fire = false;
		rules.logicUnitBuild = false;
		rules.damageExplosions = false;
		
				
        survivorBanned = rules.copy();
        survivorBanned.bannedBlocks.addAll(Blocks.groundFactory, Blocks.navalFactory);

        plagueBanned = rules.copy();
        plagueBanned.bannedBlocks.addAll(Blocks.battery, Blocks.batteryLarge, Blocks.steamGenerator, Blocks.combustionGenerator, Blocks.differentialGenerator, Blocks.rtgGenerator, Blocks.thermalGenerator, Blocks.impactReactor, Blocks.duo, Blocks.scatter, Blocks.scorch, Blocks.hail, Blocks.wave, Blocks.lancer, Blocks.arc, Blocks.parallax, Blocks.swarmer, Blocks.salvo, Blocks.segment, Blocks.tsunami, Blocks.fuse, Blocks.ripple, Blocks.cyclone, Blocks.foreshadow, Blocks.spectre, Blocks.meltdown, Blocks.navalFactory); // Can't be trusted
        
       
        
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
	
	
	
	// Incomplete generation will fix later unused
	public static void randomGen(int width,int height) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < width; y++) {
				double randOre = Math.floor(Math.random() * 6);
				double oreLuck = Math.random();
				if(Vars.world.tile(x, y).floor() == Blocks.sand || Vars.world.tile(x, y).floor() == Blocks.darksand){
				if (oreLuck < 0.001) {
					
					Vars.world.tile(x, y).setFloorNet(Vars.world.tile(x, y).floor(), Blocks.oreCoal);
					
					
					
					
					
				}
				}
				
				
			}
		}
		
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
