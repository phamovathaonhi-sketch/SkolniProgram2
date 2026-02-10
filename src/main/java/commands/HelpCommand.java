package commands;

public class HelpCommand implements Command {
    @Override
    public boolean execute() {
        System.out.println("""
Commands:
  help                 - show this help
  look                 - describe location
  go front             - move forward
  speak <npc>          - talk to NPC (e.g. speak villager)
  take <item>          - take item (e.g. take Painting)
  bag                  - list inventory
  attack               - fight enemy (if present)
  craft                - craft in Forge
  quit                 - exit
""");
        return true;
    }
}
