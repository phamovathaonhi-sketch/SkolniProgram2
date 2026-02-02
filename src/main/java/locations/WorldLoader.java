package locations;

import characters.Player;
import characters.NPC;
import characters.Enemy;
import commands.*;
import java.util.Scanner;

public class WorldLoader {
    private World world;
    private Player player;
    private boolean isRunning;

    public WorldLoader(Player player) {
        this.world = World.loadWorld("/gworld.json");
        this.player = player;

        Location start = world.findLocation(world.startLocation);
        if (start != null) {
            player.setCurrentLocation(start);
        }
    }

    public Command processCommand(String input) {
        String[] parts = input.split(" ", 2); // Split by space
        String action = parts[0].toLowerCase();
        String param = (parts.length > 1) ? parts[1] : "";

        return switch (action) {
            case "go" -> {
                Directions d = parseDirection(param);
                yield (d != null) ? new MovementCommand(d, player, world) : null;
            }
            case "speak" -> {
                NPC target = player.getCurrentLocation().getNPC(param);
                yield (target != null) ? new DialogCommand(player, target) : null;
            }
            case "quit" -> {
                this.isRunning = false;
                yield null;
            }
            default -> null;
        };
    }

    private Directions parseDirection(String dir) {
        try {
            return Directions.valueOf(dir.toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid direction! Try: front, left, or right.");
            return null;
        }
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        isRunning = true;
        System.out.println("Welcome to: " + world.worldName);

        while (isRunning) {
            System.out.println("\nLocation: " + player.getCurrentLocation().getName());
            System.out.print("> ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;

            Command cmd = processCommand(input);
            if (cmd != null) cmd.execute();

            if (player.isDefeated()) isRunning = false;
        }
    }
}