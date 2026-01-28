package Character;

public abstract class Character {
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
        return HP<=0;
    }

    public void attackCh(Character target){
        target.HP -= this.damage;

    }

}
