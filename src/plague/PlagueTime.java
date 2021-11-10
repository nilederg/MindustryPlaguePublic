package plague;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import arc.Events;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.UnitTypes;
import mindustry.game.Team;
import mindustry.game.EventType.GameOverEvent;
import mindustry.gen.Call;
import mindustry.gen.Groups;
import mindustry.type.Weapon;


public class PlagueTime {
	static Timer timer;
	static Timer multiplier1;
	static Timer gameover;
	double modifiermessage = 1.0;
	
	   
	
	public PlagueTime(int seconds) {
		
		
		
		
        timer = new Timer();
        timer.schedule(new PlagueyTime(), 125 * 1000);
        multiplier1 = new Timer();
        multiplier1.schedule(new UnitMultiplier(), 600 * 1000);
        gameover = new Timer();
        gameover.schedule(new gameOvering(), 132 * 1000);
        
        
	}

    class PlagueyTime extends TimerTask {
        public void run() {
        	FPlagueBasic.Have120SecondsPassed = true; 
        	Groups.player.each(p -> {
        		if(p.team() == Team.sharded) {
        			p.team(Team.purple);
        			Call.setRules(p.con, FPlagueBasic.plagueBanned);
        			//FPlagueBasic.randomGen(Vars.world.width(), Vars.world.height());
        		}
        	});
        	
            
            
           
            
           timer.cancel(); 
        }
    }
    
    class gameOvering extends TimerTask {
        public void run() {
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
        	
        	if(cores.isEmpty() && !Vars.state.gameOver) {
				Events.fire(new GameOverEvent(Team.purple));	
				gameover.schedule(new gameOvering(), 130 * 1000);
			} else if (!Vars.state.gameOver){
				gameover.schedule(new gameOvering(), 5 * 1000);		
			} else {
				gameover.schedule(new gameOvering(), 50 * 1000);
			}
			
			cores.clear();
			
			this.cancel();
        }
    }
    
    
    
    
    
    class UnitMultiplier extends TimerTask {
        public void run() {
        	
        	
     	    modifiermessage = Math.round((modifiermessage * 1.1) * 100.0) / 100.0;
     	    
     	   Vars.content.units().each(u ->{
     		   u.health = (float) (u.health * 1.1);
     		   for(Weapon weapon : u.weapons) {
     			   weapon.bullet.damage = (float) (weapon.bullet.damage * 1.1);
     		   }
     	   }); 
     	   
     	  Groups.player.each(p -> {
      		p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifiermessage + "x");
      	});
     	 multiplier1.schedule(new UnitMultiplier(), 600 * 1000);
     	 UnitTypes.poly.weapons.get(0).bullet.damage = 0;
     	 UnitTypes.poly.weapons.get(1).bullet.damage = 0;
            this.cancel();
        }
        
        // Below will be disabled damage but weapons aren't deleted like on other units
        
        
        
    }
    
    
    
    // NIGHTMARES BELOW DO NOT CHECK
    // Resets all damage and health to default
    
   public static void resetToDefaults() {
	   UnitTypes.antumbra.health = defaultantumbrahealth;
	   UnitTypes.arkyid.health = defaultarkyidhealth;
	   UnitTypes.atrax.health = defaultatraxhealth;
	   UnitTypes.bryde.health = defaultbrydehealth;
	   UnitTypes.corvus.health = defaultcorvushealth;
	   UnitTypes.crawler.health = defaultcrawlerhealth;
	   UnitTypes.dagger.health = defaultdaggerhealth;
	   UnitTypes.eclipse.health = defaulteclipsehealth;
	   UnitTypes.fortress.health = defaultfortresshealth;
	   UnitTypes.horizon.health = defaulthorizonhealth;
	   UnitTypes.mace.health = defaultmacehealth;
	   UnitTypes.mega.health = defaultmegahealth;
	   UnitTypes.minke.health = defaultminkehealth;
	   UnitTypes.nova.health = defaultnovahealth;
	   UnitTypes.oct.health = defaultocthealth;
	   UnitTypes.omura.health = defaultomurahealth;
	   UnitTypes.poly.health = defaultpolyhealth;
	   UnitTypes.pulsar.health = defaultpulsarhealth;
	   UnitTypes.quad.health = defaultquadhealth;
	   UnitTypes.quasar.health = defaultquasarhealth;
	   UnitTypes.reign.health = defaultreignhealth;
	   UnitTypes.risso.health = defaultrissohealth;
	   UnitTypes.scepter.health = defaultscepterhealth;
	   UnitTypes.sei.health = defaultseihealth;
	   UnitTypes.spiroct.health = defaultspirocthealth;
	   UnitTypes.toxopid.health = defaulttoxopidhealth;
	   UnitTypes.vela.health = defaultvelahealth;
	   UnitTypes.zenith.health = defaultzenithhealth;
	   
	   UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0;
	   UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbradamage1;
	   UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2;
	   UnitTypes.antumbra.weapons.get(3).bullet.damage = defaultantumbradamage3;
	   UnitTypes.antumbra.weapons.get(4).bullet.damage = defaultantumbradamage4;
	   UnitTypes.antumbra.weapons.get(5).bullet.damage = defaultantumbradamage5;
   
	    UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0;
	    UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1;
	    UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2;
	    UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3;
	    UnitTypes.arkyid.weapons.get(4).bullet.damage = defaultarkyiddamage4;
	    UnitTypes.arkyid.weapons.get(5).bullet.damage = defaultarkyiddamage5;
	    UnitTypes.arkyid.weapons.get(6).bullet.damage = defaultarkyiddamage6;
	    UnitTypes.arkyid.weapons.get(7).bullet.damage = defaultarkyiddamage7;
	    
	    UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0;
	    UnitTypes.atrax.weapons.get(1).bullet.damage = defaultatraxdamage1;
	   
	    UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0;
	    UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1;
	    UnitTypes.bryde.weapons.get(2).bullet.damage = defaultbrydedamage2;
	   
	    UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0;
	   
	   // Crawler has an ability i assume
	   
	    UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0;
	    UnitTypes.dagger.weapons.get(1).bullet.damage = defaultdaggerdamage1;
	   
	    UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0;
	    UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1;
	    UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2;
	    UnitTypes.eclipse.weapons.get(3).bullet.damage = defaulteclipsedamage3;
	    UnitTypes.eclipse.weapons.get(4).bullet.damage = defaulteclipsedamage4;
	    UnitTypes.eclipse.weapons.get(5).bullet.damage = defaulteclipsedamage5;
	   
	    UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0;
	    UnitTypes.fortress.weapons.get(1).bullet.damage = defaultfortressdamage1;
	   
	   // Horizon has an ability i think
	   
	    UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0;
	    UnitTypes.mace.weapons.get(1).bullet.damage = defaultmacedamage1;
	   
	   
	    UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0;
	    UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1;
	    UnitTypes.mega.weapons.get(2).bullet.damage = defaultmegadamage2;
	    UnitTypes.mega.weapons.get(3).bullet.damage = defaultmegadamage3;
	   
	    UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0;
	    UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1;
	    UnitTypes.minke.weapons.get(2).bullet.damage = defaultminkedamage2;
	    UnitTypes.minke.weapons.get(3).bullet.damage = defaultminkedamage3;
	   
	    UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0;
	    UnitTypes.nova.weapons.get(1).bullet.damage = defaultnovadamage1;
	   
	   // Oct is weaponless kekw
	   
	    UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0;

	    UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0;
	    UnitTypes.poly.weapons.get(1).bullet.damage = defaultpolydamage1;
	   
	    UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0;
	    UnitTypes.pulsar.weapons.get(1).bullet.damage = defaultpulsardamage1;
	   
	    UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0;

	    UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0;
	    UnitTypes.quasar.weapons.get(1).bullet.damage = defaultquasardamage1;
	   
	    UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0;
	    UnitTypes.reign.weapons.get(1).bullet.damage = defaultreigndamage1;
	   
	    UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0;
	    UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1;
	    UnitTypes.risso.weapons.get(2).bullet.damage = defaultrissodamage2;
	   
	    UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0;
	    UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1;
	    UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2;
	    UnitTypes.scepter.weapons.get(3).bullet.damage = defaultscepterdamage3;
	    UnitTypes.scepter.weapons.get(4).bullet.damage = defaultscepterdamage4;
	    UnitTypes.scepter.weapons.get(5).bullet.damage = defaultscepterdamage5;
	   
	    UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0;
	    UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1;
	    UnitTypes.sei.weapons.get(2).bullet.damage = defaultseidamage2;
	   
	    UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0;
	    UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1;
	    UnitTypes.spiroct.weapons.get(2).bullet.damage = defaultspiroctdamage2;
	    UnitTypes.spiroct.weapons.get(3).bullet.damage = defaultspiroctdamage3;
	   
	    UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0;
	    UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1;
	    UnitTypes.toxopid.weapons.get(2).bullet.damage = defaulttoxopiddamage2;
	   
	    UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0;
	   
	    UnitTypes.zenith.weapons.get(0).bullet.damage =	defaultzenithdamage0;
	    UnitTypes.zenith.weapons.get(1).bullet.damage = defaultzenithdamage1;
   }
   
   
   
   // All default stats
   public static float defaultantumbrahealth = UnitTypes.antumbra.health;
   public static float defaultarkyidhealth = UnitTypes.arkyid.health;
   public static float defaultatraxhealth = UnitTypes.atrax.health;
   public static float defaultbrydehealth = UnitTypes.bryde.health;
   public static float defaultcorvushealth = UnitTypes.corvus.health;
   public static float defaultcrawlerhealth = UnitTypes.crawler.health;
   public static float defaultdaggerhealth = UnitTypes.dagger.health;
   public static float defaulteclipsehealth = UnitTypes.eclipse.health;
   public static float defaultfortresshealth = UnitTypes.fortress.health;
   public static float defaulthorizonhealth = UnitTypes.horizon.health;
   public static float defaultmacehealth = UnitTypes.mace.health;
   public static float defaultmegahealth = UnitTypes.mega.health;
   public static float defaultminkehealth = UnitTypes.minke.health;
   public static float defaultnovahealth = UnitTypes.nova.health;
   public static float defaultocthealth = UnitTypes.oct.health;
   public static float defaultomurahealth = UnitTypes.omura.health;
   public static float defaultpolyhealth = UnitTypes.poly.health;
   public static float defaultpulsarhealth = UnitTypes.pulsar.health;
   public static float defaultquadhealth = UnitTypes.quad.health;
   public static float defaultquasarhealth = UnitTypes.quasar.health;
   public static float defaultreignhealth = UnitTypes.reign.health;
   public static float defaultrissohealth = UnitTypes.risso.health;
   public static float defaultscepterhealth = UnitTypes.scepter.health;
   public static float defaultseihealth = UnitTypes.sei.health;
   public static float defaultspirocthealth = UnitTypes.spiroct.health;
   public static float defaulttoxopidhealth = UnitTypes.toxopid.health;
   public static float defaultvelahealth = UnitTypes.vela.health;
   public static float defaultzenithhealth = UnitTypes.zenith.health;
   
   public static float defaultantumbradamage0 = UnitTypes.antumbra.weapons.get(0).bullet.damage;
   public static float defaultantumbradamage1 = UnitTypes.antumbra.weapons.get(1).bullet.damage;
   public static float defaultantumbradamage2 = UnitTypes.antumbra.weapons.get(2).bullet.damage;
   public static float defaultantumbradamage3 = UnitTypes.antumbra.weapons.get(3).bullet.damage;
   public static float defaultantumbradamage4 = UnitTypes.antumbra.weapons.get(4).bullet.damage;
   public static float defaultantumbradamage5 = UnitTypes.antumbra.weapons.get(5).bullet.damage;
   
   public static float defaultarkyiddamage0 = UnitTypes.arkyid.weapons.get(0).bullet.damage;
   public static float defaultarkyiddamage1 = UnitTypes.arkyid.weapons.get(1).bullet.damage;
   public static float defaultarkyiddamage2 = UnitTypes.arkyid.weapons.get(2).bullet.damage;
   public static float defaultarkyiddamage3 = UnitTypes.arkyid.weapons.get(3).bullet.damage;
   public static float defaultarkyiddamage4 = UnitTypes.arkyid.weapons.get(4).bullet.damage;
   public static float defaultarkyiddamage5 = UnitTypes.arkyid.weapons.get(5).bullet.damage;
   public static float defaultarkyiddamage6 = UnitTypes.arkyid.weapons.get(6).bullet.damage;
   public static float defaultarkyiddamage7 = UnitTypes.arkyid.weapons.get(7).bullet.damage;
    
   public static float defaultatraxdamage0 = UnitTypes.atrax.weapons.get(0).bullet.damage;
   public static float defaultatraxdamage1 = UnitTypes.atrax.weapons.get(1).bullet.damage;
   
   public static float defaultbrydedamage0 = UnitTypes.bryde.weapons.get(0).bullet.damage;
   public static float defaultbrydedamage1 = UnitTypes.bryde.weapons.get(1).bullet.damage;
   public static float defaultbrydedamage2 = UnitTypes.bryde.weapons.get(2).bullet.damage;
   
   public static float defaultcorvusdamage0 = UnitTypes.corvus.weapons.get(0).bullet.damage;
   
   // Crawler has an ability i assume
   
   public static float defaultdaggerdamage0 = UnitTypes.dagger.weapons.get(0).bullet.damage;
   public static float defaultdaggerdamage1 = UnitTypes.dagger.weapons.get(1).bullet.damage;
   
   public static float defaulteclipsedamage0 = UnitTypes.eclipse.weapons.get(0).bullet.damage;
   public static float defaulteclipsedamage1 = UnitTypes.eclipse.weapons.get(1).bullet.damage;
   public static float defaulteclipsedamage2 = UnitTypes.eclipse.weapons.get(2).bullet.damage;
   public static float defaulteclipsedamage3 = UnitTypes.eclipse.weapons.get(3).bullet.damage;
   public static float defaulteclipsedamage4 = UnitTypes.eclipse.weapons.get(4).bullet.damage;
   public static float defaulteclipsedamage5 = UnitTypes.eclipse.weapons.get(5).bullet.damage;
   
   public static float defaultfortressdamage0 = UnitTypes.fortress.weapons.get(0).bullet.damage;
   public static float defaultfortressdamage1 = UnitTypes.fortress.weapons.get(1).bullet.damage;
   
   // Horizon has an ability i think
   
   public static float defaultmacedamage0 = UnitTypes.mace.weapons.get(0).bullet.damage;
   public static float defaultmacedamage1 = UnitTypes.mace.weapons.get(1).bullet.damage;
   
   
   public static float defaultmegadamage0 = UnitTypes.mega.weapons.get(0).bullet.damage;
   public static float defaultmegadamage1 = UnitTypes.mega.weapons.get(1).bullet.damage;
   public static float defaultmegadamage2 = UnitTypes.mega.weapons.get(2).bullet.damage;
   public static float defaultmegadamage3 = UnitTypes.mega.weapons.get(3).bullet.damage;
   
   public static float defaultminkedamage0 = UnitTypes.minke.weapons.get(0).bullet.damage;
   public static float defaultminkedamage1 = UnitTypes.minke.weapons.get(1).bullet.damage;
   public static float defaultminkedamage2 = UnitTypes.minke.weapons.get(2).bullet.damage;
   public static float defaultminkedamage3 = UnitTypes.minke.weapons.get(3).bullet.damage;
   
   public static float defaultnovadamage0 = UnitTypes.nova.weapons.get(0).bullet.damage;
   public static float defaultnovadamage1 = UnitTypes.nova.weapons.get(1).bullet.damage;
   
   // Oct is weaponless kekw
   
   public static float defaultomuradamage0 = UnitTypes.omura.weapons.get(0).bullet.damage;

   public static float defaultpolydamage0 = UnitTypes.poly.weapons.get(0).bullet.damage;
   public static float defaultpolydamage1 = UnitTypes.poly.weapons.get(1).bullet.damage;
   
   public static float defaultpulsardamage0 = UnitTypes.pulsar.weapons.get(0).bullet.damage;
   public static float defaultpulsardamage1 = UnitTypes.pulsar.weapons.get(1).bullet.damage;
   
   public static float defaultquaddamage0 = UnitTypes.quad.weapons.get(0).bullet.damage;

   public static float defaultquasardamage0 = UnitTypes.quasar.weapons.get(0).bullet.damage;
   public static float defaultquasardamage1 = UnitTypes.quasar.weapons.get(1).bullet.damage;
   
   public static float defaultreigndamage0 = UnitTypes.reign.weapons.get(0).bullet.damage;
   public static float defaultreigndamage1 = UnitTypes.reign.weapons.get(1).bullet.damage;
   
   public static float defaultrissodamage0 = UnitTypes.risso.weapons.get(0).bullet.damage;
   public static float defaultrissodamage1 = UnitTypes.risso.weapons.get(1).bullet.damage;
   public static float defaultrissodamage2 = UnitTypes.risso.weapons.get(2).bullet.damage;
   
   public static float defaultscepterdamage0 = UnitTypes.scepter.weapons.get(0).bullet.damage;
   public static float defaultscepterdamage1 = UnitTypes.scepter.weapons.get(1).bullet.damage;
   public static float defaultscepterdamage2 = UnitTypes.scepter.weapons.get(2).bullet.damage;
   public static float defaultscepterdamage3 = UnitTypes.scepter.weapons.get(3).bullet.damage;
   public static float defaultscepterdamage4 = UnitTypes.scepter.weapons.get(4).bullet.damage;
   public static float defaultscepterdamage5 = UnitTypes.scepter.weapons.get(5).bullet.damage;
   
   public static float defaultseidamage0 = UnitTypes.sei.weapons.get(0).bullet.damage;
   public static float defaultseidamage1 = UnitTypes.sei.weapons.get(1).bullet.damage;
   public static float defaultseidamage2 = UnitTypes.sei.weapons.get(2).bullet.damage;
   
   public static float defaultspiroctdamage0 = UnitTypes.spiroct.weapons.get(0).bullet.damage;
   public static float defaultspiroctdamage1 = UnitTypes.spiroct.weapons.get(1).bullet.damage;
   public static float defaultspiroctdamage2 = UnitTypes.spiroct.weapons.get(2).bullet.damage;
   public static float defaultspiroctdamage3 = UnitTypes.spiroct.weapons.get(3).bullet.damage;
   
   public static float defaulttoxopiddamage0 = UnitTypes.toxopid.weapons.get(0).bullet.damage;
   public static float defaulttoxopiddamage1 = UnitTypes.toxopid.weapons.get(1).bullet.damage;
   public static float defaulttoxopiddamage2 = UnitTypes.toxopid.weapons.get(2).bullet.damage;
   
   public static float defaultveladamage0 = UnitTypes.vela.weapons.get(0).bullet.damage;
   
   public static float defaultzenithdamage0 = UnitTypes.zenith.weapons.get(0).bullet.damage;
   public static float defaultzenithdamage1 = UnitTypes.zenith.weapons.get(1).bullet.damage;
   
}
