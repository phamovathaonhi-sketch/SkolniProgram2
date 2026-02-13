package characters;

import java.util.List;

public class NPC extends Character {
    public List<String> dialogue;
    public boolean met;

    public NPC() {
        super("NPC");
        this.HP = 1;
        this.damage = 0;
    }

    public void speak() {
        if (dialogue == null || dialogue.isEmpty()) {
            System.out.println(name + ": ...");
            return;
        }
        for (String line : dialogue) System.out.println(name + ": " + line);
        met = true;
    }
}
