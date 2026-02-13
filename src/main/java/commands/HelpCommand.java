package commands;

public class HelpCommand implements Command {
    @Override public boolean execute() {
        System.out.println("""
Commands:
  help                 - show commands
  look                 - describe location
  time                 - show day/hour/points
  go front             - move forward
  speak <npc>          - talk (e.g. speak villager)
  take <item>          - take item
  bag                  - inventory
  rest                 - rest (important in painting rules)
  ritual               - do ritual (in temple)
  craft                - craft sword (in forge)
  attack               - fight (turn-based)
  quit                 - exit
""");
        return true;
    }
    @Override public int timeCostHours() { return 0; }
}
