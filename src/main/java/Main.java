

import characters.Player;
import locations.WorldLoader;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Detective Alaric");
        WorldLoader loader = new WorldLoader(player);
        loader.start();
    }
}
