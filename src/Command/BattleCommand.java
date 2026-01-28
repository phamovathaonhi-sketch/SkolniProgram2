package Command;

public class BattleCommand  implements Command{


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
