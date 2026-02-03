import locations.WorldLoader;
import characters.Player;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Detective");

        WorldLoader w = new WorldLoader(player);

        w.start();
    }
}