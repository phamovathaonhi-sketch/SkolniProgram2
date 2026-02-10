package characters;

import locations.Location;

public class Enemy extends Character {
    private boolean isAlive;
    private Enemy enemy;
    private Player pLayer;

    public Enemy(String name) {
        super(name);
    }
    public void receiveDamage(int Damage) {
        this.HP = this.HP - damage;
        if (this.HP < 0) {
          this.HP =0;
        }
    }
    public boolean isAlive() {
        if (enemy.getHP() == 0){
            return isDefeated;
        }
        return isAlive && !isDefeated();
    }
    public int attackPlayer(){
        int Damage = enemy.getDamage();
        return Damage;
    }

public boolean isDefeated() {
        if (enemy.getHP() == 0){
            System.out.println("You have successfully defeated an enemy!");
            return true;
        }
        return false;
    }
}