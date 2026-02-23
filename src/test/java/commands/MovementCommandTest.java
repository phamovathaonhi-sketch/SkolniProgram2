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

class MovementCommandTest {

    private Player player;
    private World world;
    private GameState state;
    private Location startLocation;
    private Location nextLocation;

    @BeforeEach
    void setUp() {
        world = new World();
        state = new GameState();
        player = new Player("Alaric");

        startLocation = new Location(new HashMap<>());
        nextLocation  = new Location(new HashMap<>());

        startLocation.name = "Town";
        nextLocation.name = "Chai House";

        startLocation.requirements = new ArrayList<>();
        nextLocation.requirements  = new ArrayList<>();

        startLocation.nextLocation.put(Directions.FRONT.name(), "Chai House");

        world.locations = new ArrayList<>();
        world.locations.add(startLocation);
        world.locations.add(nextLocation);

        player.setCurrentLocation(startLocation);
    }

    @Test
    void execute_success_movesPlayer() {
        MovementCommand movement = new MovementCommand(Directions.FRONT, player, world, state);

        boolean result = movement.execute();

        assertTrue(result, "The move should be successful.");
        assertEquals(nextLocation, player.getCurrentLocation(), "Player should have moved to Chai House.");
        assertEquals("Chai House", player.getCurrentLocation().getName(), "Location name should match.");
    }

    @Test
    void execute_fail_noPath_keepsPlayer() {
        MovementCommand movement = new MovementCommand(Directions.LEFT, player, world, state);

        boolean result = movement.execute();

        assertFalse(result, "Move should fail if no exit exists in that direction.");
        assertEquals(startLocation, player.getCurrentLocation(), "Player should not have moved.");
        assertEquals("Town", player.getCurrentLocation().getName(), "Location name should remain Town.");
    }
}


