package commands;

public interface Command {
    boolean execute();
    int timeCostHours(); // how much time passes for this command
}
