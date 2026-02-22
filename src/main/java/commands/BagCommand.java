package commands;

import characters.Player;

public class BagCommand implements Command {
    private Player player;
    public BagCommand(Player player) { this.player = player; }

    @Override public boolean execute() {
        var items = player.getBag().all();
        if (items.isEmpty()) {
            System.out.println("(bag is empty)");
            return true;
        }
        System.out.println("=== BAG ===");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ") " + items.get(i).pretty());
        }
        return true;
    }

    @Override public int timeCostHours() { return 0; }
}
