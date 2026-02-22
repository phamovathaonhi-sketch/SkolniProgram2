package commands;

import game.GameState;

public class TimeCommand implements Command {
    private  GameState state;
    public TimeCommand(GameState state) { this.state = state; }

    @Override public boolean execute() {
        if (!state.isInPainting()) {
            System.out.println("Time: (real world) points=" + state.points);
        } else {
            System.out.println("Day " + state.day + ", Hour " + state.hour + ":00, points=" + state.points + ", restedToday=" + state.restedToday);
        }
        return true;
    }

    @Override public int timeCostHours() {
        return 0;
    }
}
