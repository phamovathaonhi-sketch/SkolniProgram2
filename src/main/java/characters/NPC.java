package characters;

import java.util.List;

public class NPC extends Character {
    private List<String> dialogue;

    public NPC(String name) {
        super(name);
    }

    public void speak() {
        if (dialogue != null && !dialogue.isEmpty()) {
            for (String line : dialogue) {
                System.out.println(name + ": " + line);
            }
        }
    }
}