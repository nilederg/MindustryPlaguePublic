package plague;

import java.util.Timer;
import java.util.TimerTask;

import mindustry.Vars;
import mindustry.game.Gamemode;
import mindustry.gen.Groups;
import mindustry.net.WorldReloader;



public class MapChangerThings {

	static Timer mapchangetimer;
	
	
			 
		    		
	
	
	public MapChangerThings() {
		
	
		mapchangetimer = new Timer();
		mapchangetimer.schedule(new MapChange(), 14 * 1000);
		
  
	}
	
	class MapChange extends TimerTask {
		public void run() {
		
			// Why would anyone create this,you may ask? not even i know
			Runnable r = () -> {
	    		WorldReloader reloader = new WorldReloader();
	    		reloader.begin();
	    		Vars.world.loadMap(FPlagueBasic.selectedMap, FPlagueBasic.selectedMap.applyRules(Gamemode.survival));
	    		Vars.state.rules = Vars.state.map.applyRules(Gamemode.survival);
	    		Vars.logic.play();
	    		reloader.end();
	    		};
			
	    		Groups.player.each(p ->{
	    			p.kick("A voted map is being loaded, sorry!", 0);
	    		});
			
			try {r.run(); } catch (mindustry.maps.MapException e) {
	    		}
			
			FPlagueBasic.selectedMap = null;
			mapchangetimer.cancel();
		}
	}
	
	
}
