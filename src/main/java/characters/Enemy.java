package characters;

public class Enemy extends Character {
    private boolean isAlive;



    public Enemy(String name) {

        super(name);
    }
    public void receiveDamage(int Damage ) {
        this.HP = this.HP - damage;
        if (this.HP < 0) {
          this.HP =0;
        }

    }

    public boolean isAlive() {

        return isAlive && !isDefeated();
    }
}