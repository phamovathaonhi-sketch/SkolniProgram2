package commands;

import characters.Enemy;
import characters.Player;
import game.GameState;
import game.RuleEngine;
import locations.Location;

public class AttackCommand implements Command {
    private final Player player;
    private final Location location;
    private final GameState state;

    public AttackCommand(Player player, Location location, GameState state) {
        this.player = player;
        this.location = location;
        this.state = state;
    }

    @Override public boolean execute() {
        Enemy enemy = location.getFirstAliveEnemy();
        if (enemy == null) {
            System.out.println("No enemy here.");
            return false;
        }

        // Wedding time rule: rooster kill only 19:00–23:00
        if ("Wedding".equalsIgnoreCase(location.name) && "Rooster".equalsIgnoreCase(enemy.getName())) {
            if (!state.isInPainting()) {
                System.out.println("You are not in the painting timeline. (ritual required)");
                return false;
            }
            if (state.hour < 19) {
                throw new RuleEngine.GameOver("Zabil jsi (nebo ses pokusil zabít) kohouta před 19:00. Prohra.");
            }
            if (state.hour >= 24) {
                throw new RuleEngine.GameOver("Je po půlnoci. Prohra.");
            }
        }

        int playerDmg = player.getTotalDamage();
        enemy.receiveDamage(playerDmg);
        System.out.println("You hit " + enemy.getName() + " for " + playerDmg + ". Enemy HP: " + enemy.getHP());

        if (!enemy.isAlive()) {
            System.out.println(enemy.getName() + " defeated!");

            if (enemy.loot != null && enemy.loot.inStock) {
                player.getBag().add(enemy.loot);
                enemy.loot.inStock = false;
                System.out.println("Loot obtained: " + enemy.loot.pretty());
            }

            location.removeCharacter(enemy);

            // WIN condition: Wedding cleared (both defeated)
            if ("Wedding".equalsIgnoreCase(location.name) && location.getFirstAliveEnemy() == null) {
                System.out.println("You stopped the wedding. The painting becomes empty.");
                System.out.println("YOU WIN!");
                throw new RuleEngine.GameOver("END"); // stop game loop cleanly
            }

            return true;
        }

        player.receiveDamage(enemy.getDamage());
        System.out.println(enemy.getName() + " attacks back for " + enemy.getDamage() + ". Your HP: " + player.getHP());
        if (player.isDefeated()) throw new RuleEngine.GameOver("You died. Game over.");

        return true;
    }

    @Override public int timeCostHours() { return 1; }
}
