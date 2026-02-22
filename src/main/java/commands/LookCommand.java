package commands;

import locations.Location;

public class LookCommand implements Command {
    private  Location loc;
    public LookCommand(Location loc) { this.loc = loc; }

    @Override public boolean execute() {
        System.out.println(loc.theory);

        if (loc.NPC != null && !loc.NPC.isEmpty()) {
            System.out.print("NPC: ");
            for (var n : loc.NPC) System.out.print(n.getName() + " ");
            System.out.println();
        }

        boolean anyItems = loc.items != null && loc.items.stream().anyMatch(i -> i != null && i.inStock);
        if (anyItems) {
            System.out.println("Items:");
            loc.items.stream().filter(i -> i != null && i.inStock).forEach(i -> System.out.println(" - " + i.pretty()));
        }

        var e = loc.getFirstAliveEnemy();
        if (e != null) System.out.println("Enemy: " + e.getName() + " (HP " + e.getHP() + ", dmg " + e.getDamage() + ")");

        return true;
    }

    @Override public int timeCostHours() { return 0; }
}
