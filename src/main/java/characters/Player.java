package characters;

import items.Bag;
import items.Item;

public class Player extends Character {
    private final Bag bag = new Bag(12);

    public Player(String name) {
        super(name);
        this.HP = 100;
        this.damage = 8;
    }

    public Bag getBag() { return bag; }

    public int getTotalDamage() {
        Item sword = bag.get("Sword");
        int bonus = (sword != null && sword.damage != null) ? sword.damage : 0;
        return this.damage + bonus;
    }
}
