import characters.Player;
import locations.WorldLoader;

/**
 * main console that will start the game
 * @author Thao Nhi Pham
 */
public class Main {
    public static void main(String[] args) {
        Player player = new Player("Detektiv Alaric");
        new WorldLoader(player).start();
    }
}
