package commands;

import characters.Enemy;
import characters.Player;
import items.Bag;

import java.util.List;

public class ChallengeCommand implements Command {

    private List<String> answer;
    private List<Bag> bag;
    private Player player;
    private Enemy enemy;

    public ChallengeCommand(List<String> answer, List<Bag> bag, Player player, Enemy enemy) {
        this.answer = answer;
        this.bag = bag;
        this.player = player;
        this.enemy = enemy;
    }

    private void attack() {
        if (player == null || enemy == null) {
            System.out.println("Challenge error: player or enemy missing.");
            return;
        }

        int playerPower = player.getDamage();
        enemy.receiveDamage(playerPower);

        if (!enemy.isAlive()) {
            System.out.println("Enemy defeated!");
            player.getCurrentLocation().removeCharacter(enemy);
            return;
        }

        player.receiveDamage(enemy.getDamage());
        System.out.println(enemy.getName() + " attacked you!");

        if (player.isDefeated()) {
            System.out.println("You lost.");
        }
    }

    @Override
    public boolean execute() {
        attack();
        return true;
    }

    @Override
    public int timeCostHours() {
        return 0;
    }
}
