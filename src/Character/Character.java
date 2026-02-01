package Character;

public abstract class Character{
    private String name;
    private String duty;
    private int damage;
    private int HP;
    private int point;

    public Character(String name) {
        this.name = name;
        this.damage = damage;
        this.HP= HP;
        this.duty = duty;
        this.point = point;
    }

    public boolean isDefeated() {
        if (HP<=0){
            return true;
        }
        return false;
    }

    public void attackCh(Character target){
        if (this.HP<0){
            this.HP=0;
        }
        target.HP -= this.damage;

    }

    public String getName() {
        return name;
    }

    public String getDuty() {
        return duty;
    }

    public int getDamage() {
        return damage;
    }

    public int getHP() {
        return HP;
    }

    public int getPoint() {
        return point;
    }
}
