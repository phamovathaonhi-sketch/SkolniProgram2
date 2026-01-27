package Command;

import Item.Bag;

import java.util.List;

public class ChallengeCommand implements Command {
    private List<String> answer;
    private List<Bag> bag;

    //TODO: logic
    public void attack(){}
    public void use(List<Bag> bag){}

    @Override
    public boolean execute() {
        attack();
        use(this.bag);

        return false;
    }
}
