package commands;

import characters.NPC;

public class SpeakCommand implements Command {
    private final NPC npc;
    public SpeakCommand(NPC npc) { this.npc = npc; }

    @Override public boolean execute() {
        if (npc == null) {
            System.out.println("No such NPC here.");
            return false;
        }
        npc.speak();
        return true;
    }
}
