

import characters.Player;
import locations.WorldLoader;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Detektiv Alaric");
        new WorldLoader(player).start();
    }
}
