package characters;

import items.Item;

public class Enemy extends Character {
    public boolean isAlive = true;
    public Item loot; // optional

    public Enemy() {
        super("Enemy");
    }

    public Enemy(String name) {
        super(name);
    }

    @Override
    public void receiveDamage(int dmg) {
        super.receiveDamage(dmg);
        if (HP <= 0) isAlive = false;
    }

    public boolean isAlive() {
        return isAlive && !isDefeated();
    }
}
