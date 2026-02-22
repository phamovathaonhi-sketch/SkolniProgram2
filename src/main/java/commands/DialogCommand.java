package commands;

import characters.NPC;

public class DialogCommand implements Command {
    private  NPC npc;
    public DialogCommand(NPC npc) { this.npc = npc; }

    @Override public boolean execute() {
        if (npc == null) {
            System.out.println("No such NPC here.");
            return false;
        }
        npc.speak();
        return true;
    }

    @Override public int timeCostHours() { return 0; }
}
