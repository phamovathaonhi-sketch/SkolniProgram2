package locations;

import items.Item;
import java.util.List;
import java.util.Map;
import characters.NPC;
import characters.Enemy;

public class Location {

    private String name;
    private String theory;
    private List<Item> items;
    private Map<String, String> itemPlacement;


    private List<NPC> NPC;
    private List<Enemy> enemy;


    private Map<String, String> nextLocation;

    public String getName() {
        return name; }
    public String getTheory() {
        return theory; }

    public Enemy getEnemy() {

        if (enemy == null || enemy.isEmpty()) return null;
        return enemy.get(0);
    }

    public NPC getNPC(String name) {
        if (NPC == null) return null;
        for (NPC n : NPC) {
            if (n.getName().equalsIgnoreCase(name)) return n;
        }
        return null;
    }

    public String getNextDIrection(Directions direction) {
        if (nextLocation== null) return null;
        return nextLocation.get(direction.name());
    }

    public List<Item> getItems(Item item) {
        return items; }
    public void removeCharacter(Enemy e){
        this.enemy.remove(e);
    }
}