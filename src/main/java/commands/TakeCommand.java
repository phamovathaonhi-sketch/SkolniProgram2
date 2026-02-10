package commands;

import characters.Player;
import items.Item;
import locations.Location;

public class TakeCommand implements Command {
    private final Player player;
    private final Location location;
    private final String itemName;

    public TakeCommand(Player player, Location location, String itemName) {
        this.player = player;
        this.location = location;
        this.itemName = itemName;
    }

    @Override
    public boolean execute() {
        if (itemName == null || itemName.isBlank()) {
            System.out.println("Usage: take <item>");
            return false;
        }
        Item it = location.findItem(itemName);
        if (it == null) {
            System.out.println("Item not found here: " + itemName);
            return false;
        }
        if (!player.getBag().add(it)) {
            System.out.println("Bag is full.");
            return false;
        }
        location.takeItem(itemName);
        System.out.println("Picked up: " + it.pretty());
        return true;
    }
}
