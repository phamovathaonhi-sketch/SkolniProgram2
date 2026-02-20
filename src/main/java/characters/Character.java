package characters;

import locations.Location;

public abstract class Character {
    protected String name;
    protected int HP;
    protected int damage;
    protected transient Location currentLocation;

    protected Character(String name) {
        this.name = name;
        this.HP = 100;
        this.damage = 5;
    }

    public String getName() {
        return name;
    }
    public int getHP() {
        return HP;
    }
    public int getDamage() {
        return damage;
    }

    public void receiveDamage(int dmg) {
        HP -= Math.max(0, dmg);
        if (HP < 0) HP = 0;
    }

    public boolean isDefeated() {
        return HP <= 0;
    }

    public Location getCurrentLocation() {
        return currentLocation; }
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation; }
}
