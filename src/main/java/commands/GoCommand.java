package commands;

import characters.Player;
import locations.Directions;
import locations.Location;
import locations.World;

public class GoCommand implements Command {
    private final Player player;
    private final World world;
    private final Directions direction;

    public GoCommand(Player player, World world, Directions direction) {
        this.player = player;
        this.world = world;
        this.direction = direction;
    }

    @Override public boolean execute() {
        Location current = player.getCurrentLocation();

        // basic gate: cannot leave if enemy alive
        if (current.getFirstAliveEnemy() != null) {
            System.out.println("You cannot leave — an enemy blocks your path. (use: attack)");
            return false;
        }

        String nextName = current.getNext(direction);
        if (nextName == null) {
            System.out.println("No path that way.");
            return false;
        }
        Location next = world.findLocation(nextName);
        if (next == null) {
            System.out.println("Next location not found: " + nextName);
            return false;
        }
        player.setCurrentLocation(next);
        System.out.println("You travel to: " + next.getName());
        return true;
    }
}
