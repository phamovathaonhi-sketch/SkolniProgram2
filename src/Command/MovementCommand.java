package Command;

import Location.Location;
import Character.Player;
import Location.World;

public class MovementCommand implements Command{
    private Location loc;
    private Player player;
    private World world;

    public MovementCommand(Location loc, Player player, World world) {
        this.loc = loc;
        this.player = player;
        this.world = world;
    }

    @Override
    public boolean execute() {
       Location currentLoc= player.getCurrentLocation();
       String targetLoc=  currentLoc.getExitTarget(D);
        return true;
    }
}
