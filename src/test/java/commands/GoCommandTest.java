package commands;

import characters.Player;
import game.GameState;
import locations.Directions;
import locations.Location;
import locations.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GoCommandTest {

    private Player player;
    private World world;
    private GameState state;
    private Location startLocation;
    private Location nextLocation;

    @BeforeEach
    public void setUp(){
        world= new World();
        state = new GameState();
        player = new Player("Alaric");

        startLocation = new Location(new HashMap<>());
        nextLocation = new Location(new HashMap<>());

        startLocation.name = "Town";
        nextLocation.name = "Chai House";

        startLocation.requirements = new ArrayList<>();
        nextLocation.requirements = new ArrayList<>();

        String curr= startLocation.nextLocation.put(Directions.FRONT.name(),"Chai House");
        world.locations = new ArrayList<>();
        world.locations.add(startLocation);
        world.locations.add(nextLocation);

        player.setCurrentLocation(startLocation);
    }
    @Test
    public void executeTest(){
            MovementCommand movement = new MovementCommand(Directions.FRONT, player, world, state);

            boolean result = movement.execute();

            assertTrue(result, "The move should be successful.");
            assertEquals(nextLocation, player.getCurrentLocation(), "Player should have moved to Chai House.");
            assertEquals("Chai House", player.getCurrentLocation().getName(), "Location name should match.");

    }
}