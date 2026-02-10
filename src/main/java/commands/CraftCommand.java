package commands;

import characters.Player;
import items.Item;
import locations.Location;

public class CraftCommand implements Command {
    private final Player player;
    private final Location location;

    public CraftCommand(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    @Override
    public boolean execute() {
        if (location.craftingRecipe == null) {
            System.out.println("Nothing to craft here.");
            return false;
        }

        var req = location.craftingRecipe.requiredItems;
        if (req == null || req.isEmpty()) {
            System.out.println("Recipe invalid.");
            return false;
        }

        for (String r : req) {
            if (!player.getBag().has(r)) {
                System.out.println("Missing: " + r);
                return false;
            }
        }

        for (String r : req) player.getBag().remove(r);

        Item result = location.craftingRecipe.resultItem;
        if (result == null) {
            System.out.println("Recipe result missing.");
            return false;
        }

        player.getBag().add(result);
        System.out.println("Crafted: " + result.pretty());
        return true;
    }
}
