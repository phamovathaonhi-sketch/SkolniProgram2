package commands;

import characters.Player;
import game.GameState;
import locations.Location;
import locations.World;

public class RitualCommand implements Command {
    private  Player player;
    private  World world;
    private  GameState state;

    public RitualCommand(Player player, World world, GameState state) {
        this.player = player;
        this.world = world;
        this.state = state;
    }

    @Override public boolean execute() {
        Location loc = player.getCurrentLocation();
        if (!"Abandon Temple".equalsIgnoreCase(loc.name)) {
            System.out.println("You can do ritual only in Abandon Temple.");
            return false;
        }

        if (loc.getFirstAliveEnemy() != null) {
            System.out.println("You cannot do ritual while an enemy is alive here.");
            return false;
        }

        // minimal ritual requirements (design core)
        String[] needed = {
                "Painting",
                "Cinnabar",
                "Rooster Blood",
                "Pure Yin Blood A",
                "Pure Yin Blood B",
                "Pure Yin Blood C (fresh)"
        };

        for (String n : needed) {
            if (!player.getBag().has(n)) {
                System.out.println("Ritual failed. Missing: " + n);
                return false;
            }
        }

        state.enterPaintingWorld();

        Location painting = world.findLocation("Painting Room");
        if (painting == null) {
            System.out.println("Broken world: Painting Room not found.");
            return false;
        }

        player.setCurrentLocation(painting);
        System.out.println("The ritual succeeds. Your soul enters the painting...");
        System.out.println("You received rules. You must survive 3 days.");
        return true;
    }

    @Override public int timeCostHours() {
        return 2;
    }
}
