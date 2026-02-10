package commands;

import java.io.File;
import characters.NPC;


public class DialogCommand implements Command {
    File dialogue1 = new File("dialogue.txt");
    public NPC npc;


    public DialogCommand(NPC npc) {
        this.npc = npc;
    }

    public File getDialogue1() {
        return dialogue1;
    }



    @Override
    public boolean execute() {
        if (npc != null){
            npc.speak();
        }else{
            System.out.println("No NPC exists.");
        }


        return true;


    }
}
