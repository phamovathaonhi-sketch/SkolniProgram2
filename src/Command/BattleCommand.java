package Command;
import Character.Player;
import Character.Enemy;

public class BattleCommand  implements Command{
    private Player player;
   public Enemy enemy;

    public BattleCommand(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }



    public void attack(){

    }
    public void use(){}


    @Override
    public boolean execute() {
        attack();
        use();
        return true;
    }
}
