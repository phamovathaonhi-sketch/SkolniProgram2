package Location;

import Item.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Character.NPC;
import Character.Enemy;
import Character.Character;

public class Location {
    private String name;
    private String theory;
    private List<Item> items;
    private Map<String, String> itemPlacement;
    private Map<Directions, String> exits;
    public NPC npc;
    public Enemy enemy;
    private ArrayList<Character> charactersInLocation;


    public Location(String name, String theory){
        this.name = name;
        this.theory = theory;
        this.items = new ArrayList<>();
        this.itemPlacement = new HashMap<>();
    }

    public NPC getNpc() {
        return npc;
    }

    public String getName() {
        return name;
    }

    public Enemy getEnemy() {
        return enemy;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public String getExitTarget(Directions directions){
        return exits.get(directions);
    }

    public String getTheory() {
        return theory;
    }

    public List<Item> getItems() {
        return items;
    }

    public Map<String, String> getItemPlacement() {
        return itemPlacement;
    }

    public Map<Directions, String> getExits() {
        return exits;
    }

    public Character getCharacter(String name) {
        for ( Character c : charactersInLocation) {
            if (c.getName().equalsIgnoreCase(name)){


            }
        }
        return null;
}

    public NPC getNPC(String param) {
        return npc;
    }
}
