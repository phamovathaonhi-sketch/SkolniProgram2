package commands;
import characters.Player;
import characters.Enemy;

public class BattleCommand  implements Command{
    private Player player;
   public Enemy enemy;

    public BattleCommand(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }



    public void attack(){
        int PLayerpower= player.getDamage();
        enemy.receiveDamage(PLayerpower);

        if (enemy.getHP()==0){
            System.out.println("Enemy is defeated.");
        }
        if (enemy.getHP()>0){
            int enemyPower= enemy.getDamage();
            player.receiveDamage(enemyPower);
            System.out.println(enemy.getName()+ "has attacked you");
        }else{
            System.out.println("You have successfully defeated your enemy" );
            player.getCurrentLocation().removeCharacter(enemy);
        }
        if (player.getHP()==0){
            System.out.println("You lost.");
        }
    }
    public void use(){


    }


    @Override
    public boolean execute() {
        attack();
        use();
        return true;
    }

    @Override
    public int timeCostHours() {
        return 0;
    }
}
