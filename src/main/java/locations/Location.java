package locations;

import characters.Enemy;
import characters.NPC;
import items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Location {
    public String name;
    public String theory;

    public List<Item> items = new ArrayList<>();
    public List<NPC> NPC = new ArrayList<>();
    public List<Enemy> enemy = new ArrayList<>();

    public Map<String, String> nextLocation;

    public Recipe craftingRecipe;

    // simple requirement system
    public List<String> requirements;

    // optional rules (we keep them in JSON for story, logic is in RuleEngine)
    public List<Map<String, Object>> rules;

    public String getName() { return name; }

    public NPC getNPC(String npcName) {
        if (NPC == null || npcName == null) return null;
        for (NPC n : NPC) {
            if (n != null && n.getName() != null && n.getName().equalsIgnoreCase(npcName)) return n;
        }
        return null;
    }

    public Enemy getFirstAliveEnemy() {
        if (enemy == null) return null;
        for (Enemy e : enemy) {
            if (e != null && e.isAlive()) return e;
        }
        return null;
    }

    public void removeCharacter(Enemy e) {
        if (enemy == null || e == null) return;
        enemy.remove(e);
    }

    public Item findItem(String itemName) {
        if (items == null || itemName == null) return null;
        for (Item it : items) {
            if (it != null && it.inStock && it.name != null && it.name.equalsIgnoreCase(itemName)) return it;
        }
        return null;
    }

    public boolean takeItem(String itemName) {
        Item it = findItem(itemName);
        if (it == null) return false;
        it.inStock = false;
        return true;
    }

    public String getNext(Directions dir) {
        if (nextLocation == null || dir == null) return null;
        return nextLocation.get(dir.name());
    }
}
