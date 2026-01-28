package Character;

import Item.Bag;
import Item.Item;
import Mistnost.Location;

public class Player extends Character {
    private Location currentLocation;
    private Bag bag;

    public Player(String name) {
        super(name);
    }

    public void go(String direction) {
        // logic to update currentLocation based on MovementCommand direction
    }

    public void pickupItem(Item item) {
        bag.addItem(item);
    }

    public void attack() {
    }
}
