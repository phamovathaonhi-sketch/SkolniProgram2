package Mistnost;

import Item.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Character.NPC;
import Character.Enemy;

public class Location {
    private String name;
    private String theory;
    private List<Item> items;
    private Map<String, String> itemPlacement;
    private NPC npc;
    private Enemy enemy;

    public Location(String name, String theory){
        this.name = name;
        this.theory = theory;
        this.items = new ArrayList<>();
        this.itemPlacement = new HashMap<>();
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
