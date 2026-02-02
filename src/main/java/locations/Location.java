package locations;

import items.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import characters.NPC;
import characters.Enemy;
import characters.Character;

public class Location {
    private String name;
    private String theory;
    private List<Item> items;
    private Map<String, String> itemPlacement;


    private List<NPC> NPC;
    private List<Enemy> enemy;


    private Map<String, String> exits;

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

    public String getExitTarget(Directions direction) {
        if (exits == null) return null;
        return exits.get(direction.name());
    }

    public List<Item> getItems() {
        return items; }
}