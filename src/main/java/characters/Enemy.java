package characters;

public class Enemy extends Character {
    private boolean isAlive;

    public Enemy(String name) {
        super(name);
    }

    public boolean isAlive() {
        return isAlive && !isDefeated();
    }
}