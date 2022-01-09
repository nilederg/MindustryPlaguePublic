package plague;

import java.util.Timer;
import java.util.TimerTask;
import mindustry.Vars;
import mindustry.content.UnitTypes;
import mindustry.game.Team;
import mindustry.gen.Groups;

public class PlagueTime2 {
    // Here are timers that don't get killed by gameover
    Timer respawnTimer;

    public PlagueTime2() {
        respawnTimer = new Timer();
        respawnTimer.schedule(new respawnTimerTask(), 20000);
    }


    class respawnTimerTask extends TimerTask {
        public void run(){
            Groups.player.each(p -> {
                if(p.team() == Team.sharded && p.unit().isNull()){
                    p.unit(UnitTypes.gamma.spawn(Team.purple, Vars.world.width() * 4, Vars.world.height() * 4));
                }
            });
            respawnTimer.schedule(new respawnTimerTask(), 20000);
            this.cancel();
        }
    }
}
