package Command;

import java.io.File;
import Character.NPC;
import Character.Player;

public class DialogCommand implements Command {
    File dialogue1 = new File("dialogue.txt");
    public NPC npc;


    public DialogCommand(Player player, NPC npc) {
        this.npc = npc;
    }

    //TODO: logic
    public void speak(){
    }


    @Override
    public boolean execute() {
        speak();

        return true;


    }
}
