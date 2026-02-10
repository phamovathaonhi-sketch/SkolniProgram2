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

    public ChallengeCommand(List<String> answer, List<Bag> bag) {
        this.answer = answer;
        this.bag = bag;
    }

    //TODO: logic
    public void attack() {
        int PLayerpower = player.getDamage();
        enemy.receiveDamage(PLayerpower);

        if (enemy.getHP() == 0) {
            System.out.println("Enemy is defeated.");
        }
        if (enemy.getHP() > 0) {
            int enemyPower = enemy.getDamage();
            player.receiveDamage(enemyPower);
            System.out.println(enemy.getName() + "has attacked you");
        } else {
            System.out.println("You have successfully defeated your enemy");
            player.getCurrentLocation().removeCharacter(enemy);
        }
        if (player.getHP() == 0) {
            System.out.println("You lost.");
        }



    }

    @Override
    public boolean execute() {
        attack();
        return false;
    }
}

