package locations;

import characters.NPC;
import characters.Player;
import commands.*;
import game.GameState;
import game.RuleEngine;

import java.util.Scanner;

public class WorldLoader {
    private final World world;
    private final Player player;
    private final GameState state = new GameState();
    private boolean running = true;

    public WorldLoader(Player player) {
        this.world = World.loadWorld("/gworld.json");
        this.player = player;

        Location start = world.findLocation(world.startLocation);
        if (start == null) throw new IllegalStateException("Start location not found: " + world.startLocation);
        player.setCurrentLocation(start);
    }

    /**
     * game beginning
     */
    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to: " + world.worldName);
        if (world.introduction != null) System.out.println(world.introduction);
        new HelpCommand().execute();

        while (running) {
            try {
                if (player.isDefeated()) throw new RuleEngine.GameOver("You died. Game over.");

                System.out.println("\nLocation: " + player.getCurrentLocation().getName());
                System.out.print("> ");
                String input = sc.nextLine().trim();
                if (input.isEmpty()) continue;

                Command cmd = parse(input);
                if (cmd == null) continue;

                // rule check before time crosses midnight (daily rest penalty)
                tickBefore(cmd.timeCostHours());

                boolean ok = cmd.execute();
                if (ok) tickAfter(cmd.timeCostHours());

                RuleEngine.afterAction(state, player.getCurrentLocation());

            } catch (RuleEngine.GameOver end) {
                if (!"END".equals(end.getMessage())) System.out.println(end.getMessage());
                running = false;
            }
        }
    }

    /**
     * this void method is used for orientating the time zone in the game
     * @param costHours
     */
    private void tickBefore(int costHours) {
        if (!state.isInPainting() || costHours <= 0) return;
        // If time will cross midnight, check daily rest penalty once
        int futureHour = state.hour + costHours;
        if (futureHour >= 24) RuleEngine.onNewDayCheck(state);
    }

    /**
     *
     * @param costHours
     */
    private void tickAfter(int costHours) {
        if (costHours <= 0) return;
        state.advanceTime(costHours);
    }

    private Command parse(String input) {
        String[] parts = input.split("\\s+", 2);
        String action = parts[0].toLowerCase();
        String param = (parts.length > 1) ? parts[1].trim() : "";

        Location loc = player.getCurrentLocation();

        return switch (action) {
            case "help" -> new HelpCommand();
            case "look" -> new LookCommand(loc);
            case "time" -> new TimeCommand(state);

            case "go" -> {
                Directions d = parseDirection(param);
                yield (d == null) ? null : new MovementCommand(d, player, world, state);
            }

            case "speak" -> {
                NPC npc = loc.getNPC(param);
                yield new DialogCommand(npc);
            }

            case "take" -> new TakeCommand(player, loc, param);
            case "bag" -> new BagCommand(player);

            case "rest" -> new RestCommand(state);
            case "ritual" -> new RitualCommand(player, world, state);

            case "craft" -> new CraftCommand(player, loc);
            case "attack" -> new AttackCommand(player, loc, state);

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
