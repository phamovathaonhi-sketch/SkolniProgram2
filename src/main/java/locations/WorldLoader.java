package locations;

import characters.NPC;
import characters.Player;
import commands.*;

import java.util.Scanner;

public class WorldLoader {
    private final World world;
    private final Player player;
    private boolean running = true;

    public WorldLoader(Player player) {
        this.world = World.loadWorld("/gworld.json");
        this.player = player;

        Location start = world.findLocation(world.startLocation);
        if (start == null) throw new IllegalStateException("Start location not found: " + world.startLocation);
        player.setCurrentLocation(start);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to: " + world.worldName);
        if (world.introduction != null) System.out.println(world.introduction);
        new HelpCommand().execute();

        while (running && !player.isDefeated()) {
            System.out.println("\nLocation: " + player.getCurrentLocation().getName());
            System.out.print("> ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;

            Command cmd = parse(input);
            if (cmd != null) cmd.execute();
        }
    }

    private Command parse(String input) {
        String[] parts = input.split("\\s+", 2);
        String action = parts[0].toLowerCase();
        String param = (parts.length > 1) ? parts[1].trim() : "";

        Location loc = player.getCurrentLocation();

        return switch (action) {
            case "help" -> new HelpCommand();
            case "look" -> new LookCommand(loc);
            case "go" -> {
                Directions d = parseDirection(param);
                yield (d == null) ? null : new MovementCommand(d, player, world);
            }
            case "speak" -> {
                NPC npc = loc.getNPC(param);
                yield new DialogCommand(npc);
            }
            case "take" -> new TakeCommand(player, loc, param);
            case "bag" -> new BagCommand(player);
            case "attack" -> new AttackCommand(player, loc);
            case "craft" -> new CraftCommand(player, loc);
            case "quit" -> { running = false; yield null; }
            default -> {
                System.out.println("Unknown command. Type 'help'.");
                yield null;
            }
        };
    }

    private Directions parseDirection(String param) {
        if (param == null || param.isBlank()) {
            System.out.println("Usage: go front");
            return null;
        }
        try {
            return Directions.valueOf(param.toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid direction. Use: front");
            return null;
        }
    }
}
