package Command;


import Character.Player;
import Location.Directions;
import Location.Location;
import Location.World;

public class MovementCommand implements Command{
    private Directions direction;
    private Player player;
    private World world;

    public MovementCommand(Directions direction, Player player, World world) {
        this.direction = direction;
        this.player = player;
        this.world = world;
    }

    @Override
    public boolean execute() {
       Location currentLoc= player.getCurrentLocation();
       String targetLoc=  currentLoc.getExitTarget(direction);

       if (targetLoc== null){
           System.out.println("Error");
           return false;
       }
       Location next = world.findLocation(targetLoc);
       if (next!=null){
           player.setCurrentLocation(next);
           return true;
       }
        return false;
    }
}
