package commands;

import game.GameState;

public class RestCommand implements Command {
    private  GameState state;
    public RestCommand(GameState state) {
        this.state = state;
    }

    @Override public boolean execute() {
        if (!state.isInPainting()) {
            System.out.println("You rest, but it doesn't matter outside the painting.");
            return true;
        }
        state.restedToday = true;
        System.out.println("You rest. (rule satisfied for today)");
        return true;
    }

    @Override public int timeCostHours() {
        return 2;
    }
}
