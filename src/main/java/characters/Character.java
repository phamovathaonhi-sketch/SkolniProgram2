package characters;

import locations.Location;

public abstract class Character {
    protected String name;
    protected String duty;
    protected int damage;
    protected int HP;
    protected int point;
    protected transient Location currentLocation;

    public Character(String name) {
        this.name = name;
    }

    public boolean isDefeated() {
        return HP <= 0;
    }

    public void attackCh(Character target) {
        if (this.HP > 0 && target != null) {
            target.HP -= this.damage;
            System.out.println(this.name + " deals " + this.damage + " damage to " + target.getName());
        }
    }

    public String getName() { return name; }
    public int getHP() { return HP; }
    public int getDamage() { return damage; }
}