package Character;
import Location.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NPC extends Character {
    private Map<Location, List<String>> dialogue;


    public NPC(String name) {
        super(name);
        this.dialogue = new HashMap<>();

    }
    public void giveHint(String currentLocationName) {
        List<String> lines = dialogue.get(currentLocationName);
        if (lines != null) {
            System.out.println(lines.get(0)); // Prints first line for this room
        }
    }
}
