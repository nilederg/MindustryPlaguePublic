package plague;

import java.util.Timer;
import java.util.TimerTask;


import mindustry.content.UnitTypes;
import mindustry.game.Team;
import mindustry.gen.Call;
import mindustry.gen.Groups;


public class PlagueTime {
	static Timer timer;
	static Timer unitcontroltimer;
	static Timer multiplier1;
	static Timer multiplier2;
	static Timer multiplier3;
	static Timer multiplier4;
	static Timer multiplier5;
	static Timer multiplier6;
	static Timer multiplier7;
	static Timer multiplier8;
	static Timer multiplier9;
	static Timer multiplier10;
	static Timer multiplier11;
	static Timer multiplier12;
	static Timer multiplier13;
	static Timer multiplier14;
	static Timer multiplier15;
	static Timer multiplier16;
	static Timer multiplier17;
	static Timer multiplier18;
	
	//Alpha
	   public static float defaultalphahealth = 150;
	   public static float defaultalphadamage0 = 11;
	   //Beta
	   public static float defaultbetahealth = 170;
	   public static float defaultbetadamage0 = 11;
	   //Gamma
	   public static float defaultgammahealth = 220;
	   public static float defaultgammadamage0 = 11;
	   //Dagger
	   public static float defaultdaggerhealth = 150;
	   public static float defaultdaggerdamage0 = 9;
	   //Mace
	   public static float defaultmacedamage0 = 35;
	   public static float defaultmacehealth = 640;
	   //Crawler
	   public static float defaultcrawlerdamage0 = 90;
	   public static float defaultcrawlerhealth = 200;
	   //Atrax
	   public static float defaultatraxdamage0 = 11;
	   public static float defaultatraxhealth = 600;
	   //Spiroct
	   public static float defaultspiroctdamage0 = 20;
	   public static float defaultspiroctdamage1 = 16;
	   public static float defaultspirocthealth = 910;
	   //Arkyid
	   public static float defaultarkyiddamage0 = 37;
	   public static float defaultarkyiddamage1 = 37;
	   public static float defaultarkyiddamage2 = 37;
	   public static float defaultarkyiddamage3 = 65;
	   public static float defaultarkyidhealth = 8000;
	   //Toxopid
	   public static float defaulttoxopiddamage0 = 110;
	   public static float defaulttoxopiddamage1 = 50;
	   public static float defaulttoxopidhealth = 22000;
	   //Flare
	   public static float defaultflaredamage0 = 9;
	   public static float defaultflarehealth = 75;
	   //Horizon
	   public static float defaulthorizondamage0 = 27;
	   public static float defaulthorizonhealth = 340;
	   //Zenith
	   public static float defaultzenithdamage0 = 14;
	   public static float defaultzenithhealth = 700;
	   //Antumbra
	   public static float defaultantumbradamage0 = 18;
	   public static float defaultantumbraddamage1 = 18;
	   public static float defaultantumbradamage2 = 55;
	   public static float defaultantumbrahealth = 7200;
	   //Eclipse
	   public static float defaulteclipsedamage0 = 115;
	   public static float defaulteclipsedamage1 = 15;
	   public static float defaulteclipsedamage2 = 15;
	   public static float defaulteclipsehealth = 22000;
	   //Fortress
	   public static float defaultfortressdamage0 = 20;
	   public static float defaultfortresshealth = 900;
	   //MonoIgnored
	   //Poly
	   public static float defaultpolydamage0 = 12;
	   public static float defaultpolyhealth = 400;
	   //Mega
	   public static float defaultmegadamage0 = 10;
	   public static float defaultmegadamage1 = 8;
	   public static float defaultmegahealth = 460;
	   //Quad
	   public static float defaultquaddamage0 = 220;
	   public static float defaultquadhealth = 6000;
	   //Oct
	   public static float defaultocthealth = 24000;
	   //Risso
	   public static float defaultrissodamage0 = 9;
	   public static float defaultrissodamage1 = 12;
	   public static float defaultrissohealth = 280;
	   //Minke
	   public static float defaultminkedamage0 = 40;
	   public static float defaultminkedamage1 = 40;
	   public static float defaultminkehealth = 600;
	   //Bryde
	   public static float defaultbrydedamage0 = 70;
	   public static float defaultbrydedamage1 = 12;
	   public static float defaultbrydehealth = 910;
	   //Sei
	   public static float defaultseidamage0 = 45;
	   public static float defaultseidamage1 = 57;
	   public static float defaultseihealth = 11000;
	   //Omura
	   public static float defaultomuradamage0 = 1250;
	   public static float defaultomurahealth = 22000;
	   //Scepter
	   public static float defaultscepterdamage0 = 50;
	   public static float defaultscepterdamage1 = 9;
	   public static float defaultscepterdamage2 = 9;
	   public static float defaultscepterhealth = 9000;
	   //Retusa not modified,no damage
	   //Oxynoe
	   public static float defaultoxynoedamage0 = 23;
	   public static float defaultoxynoedamage1 = 17;
	   public static float defaultoxynoehealth = 560;
	   //Cyerce
	   public static float defaultcyercedamage0 = 25;
	   public static float defaultcyercedamage1 = 25;
	   public static float defaultcyercehealth = 870;
	   //Aegires
	   public static float defaultaegiresdamage0 = 24;
	   public static float defaultaegiresdamage1 = 24;
	   public static float defaultaegireshealth = 12000;
	   //Navanax
	   public static float defaultnavanaxdamage0 = 324;
	   public static float defaultnavanaxdamage1 = 324;
	   public static float defaultnavanaxdamage2 = 324;
	   public static float defaultnavanaxdamage3 = 324;
	   public static float defaultnavanaxdamage4 = 70;
	   public static float defaultnavanaxhealth = 20000;
	   //Reign
	   public static float defaultreigndamage0 = 70;
	   public static float defaultreignhealth = 24000;
	   //Nova
	   public static float defaultnovadamage0 = 13;
	   public static float defaultnovahealth = 120;
	   //Pulsar
	   public static float defaultpulsardamage0 = 14;
	   public static float defaultpulsarhealth = 320;
	   //Quasar
	   public static float defaultquasardamage0 = 45;
	   public static float defaultquasarhealth = 640;
	   //Vela
	   public static float defaultveladamage0 = 420;
	   public static float defaultveladamage1 = 420;
	   public static float defaultvelahealth = 8200;
	   //Corvus
	   public static float defaultcorvusdamage0 = 560;
	   public static float defaultcorvushealth = 18000;
	
	public PlagueTime(int seconds) {
        timer = new Timer();
        timer.schedule(new PlagueyTime(), seconds * 1000);
        unitcontroltimer = new Timer();
        unitcontroltimer.schedule(new UnitControlTime(), 2700 * 1000);
        multiplier1 = new Timer();
        multiplier1.schedule(new UnitMultiplier1(), 600 * 1000);
        multiplier2 = new Timer();
        multiplier2.schedule(new UnitMultiplier2(), 1200 * 1000);
        multiplier3 = new Timer();
        multiplier3.schedule(new UnitMultiplier3(), 1800 * 1000);
        multiplier4 = new Timer();
        multiplier4.schedule(new UnitMultiplier4(), 2400 * 1000);
        multiplier5 = new Timer();
        multiplier5.schedule(new UnitMultiplier5(), 3000 * 1000);
        multiplier6 = new Timer();
        multiplier6.schedule(new UnitMultiplier6(), 3600 * 1000);
        multiplier7 = new Timer();
        multiplier7.schedule(new UnitMultiplier7(), 4200 * 1000);
        multiplier8 = new Timer();
        multiplier8.schedule(new UnitMultiplier8(), 4800 * 1000);
        multiplier9 = new Timer();
        multiplier9.schedule(new UnitMultiplier9(), 5400 * 1000);
        multiplier10 = new Timer();
        multiplier10.schedule(new UnitMultiplier10(), 6000 * 1000);
        multiplier11 = new Timer();
        multiplier11.schedule(new UnitMultiplier11(), 6600 * 1000);
        multiplier12 = new Timer();
        multiplier12.schedule(new UnitMultiplier12(), 7200 * 1000);
        multiplier13 = new Timer();
        multiplier13.schedule(new UnitMultiplier13(), 7800 * 1000);
        multiplier14 = new Timer();
        multiplier14.schedule(new UnitMultiplier14(), 8400 * 1000);
        multiplier15 = new Timer();
        multiplier15.schedule(new UnitMultiplier15(), 9000 * 1000);
        multiplier16 = new Timer();
        multiplier16.schedule(new UnitMultiplier16(), 9600 * 1000);
        multiplier17 = new Timer();
        multiplier17.schedule(new UnitMultiplier17(), 10200 * 1000);
        multiplier18 = new Timer();
        multiplier18.schedule(new UnitMultiplier18(), 10800 * 1000);
	}

    class PlagueyTime extends TimerTask {
        public void run() {
        	FPlagueBasic.Have120SecondsPassed = true; 
        	Groups.player.each(p -> {
        		if(p.team() == Team.sharded) {
        			p.team(Team.crux);
        			Call.setRules(p.con, FPlagueBasic.plagueBanned);
        			//FPlagueBasic.randomGen(Vars.world.width(), Vars.world.height());
        		}
        	});
        	
            
            
           
            
            
        }
    }
    
    
    class UnitControlTime extends TimerTask {
    	public void run() {
    		FPlagueBasic.Have45MinsPassed = true;
    	}
    }
    
    
    
    
    class UnitMultiplier1 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 1.1;
     	    UnitTypes.alpha.health = defaultalphahealth * modifier;
     	   //Beta
     	   UnitTypes.beta.health = defaultbetahealth * modifier;
     	    
     	   //Gamma
     	  UnitTypes.gamma.health = defaultgammahealth * modifier;
     	    
     	   //Dagger
     	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
     	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
     	   //Mace
     	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
     	   UnitTypes.mace.health = defaultmacehealth * modifier;
     	   //Crawler
     	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
     	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
     	   //Atrax
     	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
     	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
     	   //Spiroct
     	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
     	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
     	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
     	   //Arkyid
     	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
     	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
     	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
     	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
     	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
     	   //Toxopid
     	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
     	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
     	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
     	   //Flare
     	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
     	   UnitTypes.flare.health = defaultflarehealth * modifier;
     	   //Horizon
     	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
     	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
     	   //Zenith
     	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
     	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
     	   //Antumbra
     	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
     	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
     	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
     	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
     	   //Eclipse
     	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
     	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
     	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
     	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
     	   //Fortress
     	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
     	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
     	   //MonoIgnored
     	   //Poly
     	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
     	   UnitTypes.poly.health = defaultpolyhealth * modifier;
     	   //Mega
     	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
     	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
     	   UnitTypes.mega.health = defaultmegahealth * modifier;
     	   //Quad
     	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
     	   UnitTypes.quad.health = defaultquadhealth * modifier;
     	   //Oct
     	  UnitTypes.oct.health = defaultocthealth * modifier;
     	   //Risso
     	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
     	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
     	   UnitTypes.risso.health = defaultrissohealth * modifier;
     	   //Minke
     	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
     	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
     	   UnitTypes.minke.health = defaultminkehealth * modifier;
     	   //Bryde
     	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
     	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
     	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
     	   //Sei
     	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
     	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
     	   UnitTypes.sei.health = defaultseihealth * modifier;
     	   //Omura
     	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
     	   UnitTypes.omura.health = defaultomurahealth * modifier;
     	   //Scepter
     	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
     	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
     	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
     	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
     	   //Retusa not modified,no damage
     	   //Oxynoe can't find in unit types
     	    
     	   //Cyerce can't find in unit types
     	    
     	   //Aegires can't find in unit types
     	    
     	   //Navanax can't find in unit types
     	    
     	   //Reign
     	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
     	   UnitTypes.reign.health = defaultreignhealth * modifier;
     	   //Nova
     	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
     	   UnitTypes.nova.health = defaultnovahealth * modifier;
     	   //Pulsar
     	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
     	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
     	   //Quasar
     	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
     	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
     	   //Vela
     	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
     	   UnitTypes.vela.health = defaultvelahealth * modifier;
     	   //Corvus
     	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
     	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	  Groups.player.each(p -> {
      		p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
      	});
        	
            
        }
    }
    class UnitMultiplier2 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 1.21;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier3 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 1.33;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier4 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 1.46;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier5 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 1.61;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier6 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 1.77;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier7 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 1.94;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier8 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 2.14;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier9 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 2.35;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier10 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 2.59;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier11 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 2.85;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier12 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 3.13;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier13 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 3.45;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier14 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 3.79;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier15 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 4.17;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier16 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 4.59;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier17 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 5.05;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
     		 p.sendMessage("[yellow]Units now deal [red]10% [yellow]more damage and have [red]10% [yellow] more health for a total multiplier of [red]" + modifier + "x");
        	});
            
        }
    }
    class UnitMultiplier18 extends TimerTask {
        public void run() {
        	//Alpha
        	float modifier = (float) 5.55;
        	UnitTypes.alpha.health = defaultalphahealth * modifier;
      	   //Beta
      	   UnitTypes.beta.health = defaultbetahealth * modifier;
      	    
      	   //Gamma
      	  UnitTypes.gamma.health = defaultgammahealth * modifier;
      	    
      	   //Dagger
      	 UnitTypes.dagger.health = defaultdaggerhealth * modifier;
      	UnitTypes.dagger.weapons.get(0).bullet.damage = defaultdaggerdamage0 * modifier;
      	   //Mace
      	UnitTypes.mace.weapons.get(0).bullet.damage = defaultmacedamage0 * modifier;
      	   UnitTypes.mace.health = defaultmacehealth * modifier;
      	   //Crawler
      	  UnitTypes.crawler.weapons.get(0).bullet.damage = defaultcrawlerdamage0 * modifier;
      	   UnitTypes.crawler.health = defaultcrawlerhealth * modifier;
      	   //Atrax
      	  UnitTypes.atrax.weapons.get(0).bullet.damage = defaultatraxdamage0 * modifier;
      	   UnitTypes.atrax.health = defaultatraxhealth * modifier;
      	   //Spiroct
      	  UnitTypes.spiroct.weapons.get(0).bullet.damage = defaultspiroctdamage0 * modifier;
      	 UnitTypes.spiroct.weapons.get(1).bullet.damage = defaultspiroctdamage1 * modifier;
      	   UnitTypes.spiroct.health = defaultspirocthealth * modifier;
      	   //Arkyid
      	  UnitTypes.arkyid.weapons.get(0).bullet.damage = defaultarkyiddamage0 * modifier;
      	 UnitTypes.arkyid.weapons.get(1).bullet.damage = defaultarkyiddamage1 * modifier;
      	UnitTypes.arkyid.weapons.get(2).bullet.damage = defaultarkyiddamage2 * modifier;
      	UnitTypes.arkyid.weapons.get(3).bullet.damage = defaultarkyiddamage3 * modifier;
      	   UnitTypes.arkyid.health = defaultarkyidhealth * modifier;
      	   //Toxopid
      	  UnitTypes.toxopid.weapons.get(0).bullet.damage = defaulttoxopiddamage0 * modifier;
      	 UnitTypes.toxopid.weapons.get(1).bullet.damage = defaulttoxopiddamage1 * modifier;
      	   UnitTypes.toxopid.health = defaulttoxopidhealth * modifier;
      	   //Flare
      	  //UnitTypes.flare.weapons.get(0).bullet.damage = defaultflaredamage0 * modifier;
      	   UnitTypes.flare.health = defaultflarehealth * modifier;
      	   //Horizon
      	  UnitTypes.horizon.weapons.get(0).bullet.damage = defaulthorizondamage0 * modifier;
      	   UnitTypes.horizon.health = defaulthorizonhealth * modifier;
      	   //Zenith
      	  UnitTypes.zenith.weapons.get(0).bullet.damage = defaultzenithdamage0 * modifier;
      	   UnitTypes.zenith.health = defaultzenithhealth * modifier;
      	   //Antumbra
      	  UnitTypes.antumbra.weapons.get(0).bullet.damage = defaultantumbradamage0 * modifier;
      	 UnitTypes.antumbra.weapons.get(1).bullet.damage = defaultantumbraddamage1 * modifier;
      	UnitTypes.antumbra.weapons.get(2).bullet.damage = defaultantumbradamage2 * modifier;
      	   UnitTypes.antumbra.health = defaultantumbrahealth * modifier;
      	   //Eclipse
      	  UnitTypes.eclipse.weapons.get(0).bullet.damage = defaulteclipsedamage0 * modifier;
      	 UnitTypes.eclipse.weapons.get(1).bullet.damage = defaulteclipsedamage1 * modifier;
      	UnitTypes.eclipse.weapons.get(2).bullet.damage = defaulteclipsedamage2 * modifier;
      	   UnitTypes.eclipse.health = defaulteclipsehealth * modifier;
      	   //Fortress
      	  UnitTypes.fortress.weapons.get(0).bullet.damage = defaultfortressdamage0 * modifier;
      	   UnitTypes.fortress.health = defaultfortresshealth * modifier;
      	   //MonoIgnored
      	   //Poly
      	  UnitTypes.poly.weapons.get(0).bullet.damage = defaultpolydamage0 * modifier;
      	   UnitTypes.poly.health = defaultpolyhealth * modifier;
      	   //Mega
      	  UnitTypes.mega.weapons.get(0).bullet.damage = defaultmegadamage0 * modifier;
      	 UnitTypes.mega.weapons.get(1).bullet.damage = defaultmegadamage1 * modifier;
      	   UnitTypes.mega.health = defaultmegahealth * modifier;
      	   //Quad
      	  UnitTypes.quad.weapons.get(0).bullet.damage = defaultquaddamage0 * modifier;
      	   UnitTypes.quad.health = defaultquadhealth * modifier;
      	   //Oct
      	  UnitTypes.oct.health = defaultocthealth * modifier;
      	   //Risso
      	 UnitTypes.risso.weapons.get(0).bullet.damage = defaultrissodamage0 * modifier;
      	UnitTypes.risso.weapons.get(1).bullet.damage = defaultrissodamage1 * modifier;
      	   UnitTypes.risso.health = defaultrissohealth * modifier;
      	   //Minke
      	  UnitTypes.minke.weapons.get(0).bullet.damage = defaultminkedamage0 * modifier;
      	 UnitTypes.minke.weapons.get(1).bullet.damage = defaultminkedamage1 * modifier;
      	   UnitTypes.minke.health = defaultminkehealth * modifier;
      	   //Bryde
      	  UnitTypes.bryde.weapons.get(0).bullet.damage = defaultbrydedamage0 * modifier;
      	 UnitTypes.bryde.weapons.get(1).bullet.damage = defaultbrydedamage1 * modifier;
      	   UnitTypes.bryde.health = defaultbrydehealth * modifier;
      	   //Sei
      	  UnitTypes.sei.weapons.get(0).bullet.damage = defaultseidamage0 * modifier;
      	 UnitTypes.sei.weapons.get(1).bullet.damage = defaultseidamage1 * modifier;
      	   UnitTypes.sei.health = defaultseihealth * modifier;
      	   //Omura
      	  UnitTypes.omura.weapons.get(0).bullet.damage = defaultomuradamage0 * modifier;
      	   UnitTypes.omura.health = defaultomurahealth * modifier;
      	   //Scepter
      	  UnitTypes.scepter.weapons.get(0).bullet.damage = defaultscepterdamage0 * modifier;
      	 UnitTypes.scepter.weapons.get(1).bullet.damage = defaultscepterdamage1 * modifier;
      	UnitTypes.scepter.weapons.get(2).bullet.damage = defaultscepterdamage2 * modifier;
      	   UnitTypes.scepter.health = defaultscepterhealth * modifier;
      	   //Retusa not modified,no damage
      	   //Oxynoe can't find in unit types
      	    
      	   //Cyerce can't find in unit types
      	    
      	   //Aegires can't find in unit types
      	    
      	   //Navanax can't find in unit types
      	    
      	   //Reign
      	  UnitTypes.reign.weapons.get(0).bullet.damage = defaultreigndamage0 * modifier;
      	   UnitTypes.reign.health = defaultreignhealth * modifier;
      	   //Nova
      	  UnitTypes.nova.weapons.get(0).bullet.damage = defaultnovadamage0 * modifier;
      	   UnitTypes.nova.health = defaultnovahealth * modifier;
      	   //Pulsar
      	  UnitTypes.pulsar.weapons.get(0).bullet.damage = defaultpulsardamage0 * modifier;
      	   UnitTypes.pulsar.health = defaultpulsarhealth * modifier;
      	   //Quasar
      	  UnitTypes.quasar.weapons.get(0).bullet.damage = defaultquasardamage0 * modifier;
      	   UnitTypes.quasar.health = defaultquasarhealth * modifier;
      	   //Vela
      	  UnitTypes.vela.weapons.get(0).bullet.damage = defaultveladamage0 * modifier;
      	   UnitTypes.vela.health = defaultvelahealth * modifier;
      	   //Corvus
      	  UnitTypes.corvus.weapons.get(0).bullet.damage = defaultcorvusdamage0 * modifier;
      	   UnitTypes.corvus.health = defaultcorvushealth * modifier;
     	   System.out.println("it worked");
     	  Groups.player.each(p -> {
        		p.sendMessage("[red]Plague multiplier 5.5");
        	});
            
        }
    }
    
}
