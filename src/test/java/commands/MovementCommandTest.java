
import characters.Player;
import commands.MovementCommand;
import game.GameState;
import locations.Directions;
import locations.Location;
import locations.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


private Directions dir;
private Player player;
private World world;
private GameState state;
private Location StartLocation;
private Location NextLocation;


@BeforeEach
void setUp() {

    world = new World();
    state = new GameState();
    player = new Player("Alaric");

    StartLocation.name = "Town";
    NextLocation.name = "Chai House";


    StartLocation.requirements = new ArrayList<>();
    NextLocation.requirements = new ArrayList<>();


    StartLocation.getNext(Directions.FRONT);


    world.findLocation("Town");


    player.setCurrentLocation(StartLocation);
}

@Test
public void executeTest() {
    MovementCommand movement = new MovementCommand(Directions.FRONT, player, world, state);
    boolean result = movement.execute();
    assertTrue(result, "The move should be successful.");
    assertEquals(NextLocation, player.getCurrentLocation(), "Player should have moved to Town.");
    assertEquals("Town", player.getCurrentLocation().getName(), "Location name should match.");
}

@Test
public void testFailedMoveNoPath() {
    MovementCommand movement = new MovementCommand(Directions.FRONT, player, world, state);
    boolean result = movement.execute();
    assertFalse(result, "Move should fail if no exit exists in that direction.");
    assertEquals(StartLocation, player.getCurrentLocation(), "Player should not have moved.");
}

void main() {
}














