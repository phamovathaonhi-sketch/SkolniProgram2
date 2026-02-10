package characters;

import items.Bag;
import items.Item;
import locations.Location;

public class Player extends Character {
    private Location currentLocation;
    private Bag bag;


    public Player(String name) {
        super(name);
    }

    public void go(String direction) {

    }
    public void receiveDamage(int damage){
        this.HP= this.HP-damage;
        if (this.HP==0){
            this.HP=0;
        }
    }

    public void pickupItem(Item item) {
        bag.addItem(item);
    }

    public void attack() {
    }
    public void useItem(Item item){

    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
