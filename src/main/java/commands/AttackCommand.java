package commands;

import characters.Enemy;
import characters.Player;
import locations.Location;

public class AttackCommand implements Command {
    private final Player player;
    private final Location location;

    public AttackCommand(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    @Override
    public boolean execute() {
        Enemy enemy = location.getFirstAliveEnemy();
        if (enemy == null) {
            System.out.println("No enemy here.");
            return false;
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

            if ("Wedding".equalsIgnoreCase(location.name) && location.getFirstAliveEnemy() == null) {
                System.out.println("You stopped the wedding. The painting becomes empty. YOU WIN!");
            }
            return true;
        }

        player.receiveDamage(enemy.getDamage());
        System.out.println(enemy.getName() + " attacks back for " + enemy.getDamage() + ". Your HP: " + player.getHP());
        if (player.isDefeated()) System.out.println("You died. Game over.");

        return true;
    }
}
