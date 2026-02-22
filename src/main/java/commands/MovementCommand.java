package commands;

import characters.Player;
import game.GameState;
import game.Requirements;
import locations.Directions;
import locations.Location;
import locations.World;

public class MovementCommand implements Command {
    private  Directions dir;
    private Player player;
    private World world;
    private GameState state;

    public MovementCommand(Directions dir, Player player, World world, GameState state) {
        this.dir = dir;
        this.player = player;
        this.world = world;
        this.state = state;
    }

    @Override public boolean execute() {
        Location current = player.getCurrentLocation();

        if (current.getFirstAliveEnemy() != null) {
            System.out.println("You cannot leave — enemy blocks your path. Use: attack");
            return false;
        }

        String nextName = current.getNext(dir);
        if (nextName == null) {
            System.out.println("No path that way.");
            return false;
        }

        Location next = world.findLocation(nextName);
        if (next == null) {
            System.out.println("Broken world: next location not found: " + nextName);
            return false;
        }

        if (!Requirements.checkAll(next.requirements, player, state)) {
            String failed = Requirements.firstFailed(next.requirements, player, state);
            System.out.println("Blocked. Requirement missing: " + failed);
            return false;
        }

        player.setCurrentLocation(next);
        System.out.println("You travel to: " + next.getName());
        return true;
    }

    @Override public int timeCostHours() {
        return 1;
    }
}
