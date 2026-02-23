package commands;

import static org.junit.jupiter.api.Assertions.*;

import characters.Player;
import items.Item;
import locations.Location;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TakeCommandTest {

    private static Location loc() {
        return new Location(new HashMap<>());
    }

    private static Item item(String name, String type, Integer ageHours) {
        Item i = new Item();
        i.name = name;
        i.type = type;
        i.ageHours = ageHours;
        i.inStock = true;
        return i;
    }

    @Test
    void execute_returnsFalse_whenItemNameBlank() {
        Player p = new Player("Detektiv");
        Location l = loc();

        assertFalse(new TakeCommand(p, l, "").execute());
        assertFalse(new TakeCommand(p, l, "").execute());
        assertFalse(new TakeCommand(p, l, null).execute());
    }

    @Test
    void executeItemNotFound() {
        Player p = new Player("Detektiv");
        Location l = loc();

        assertFalse(new TakeCommand(p, l, "Painting").execute());
        assertFalse(p.getBag().has("Painting"));
    }

    @Test
    void executeExpiredBloodNotinStock() {
        Player p = new Player("Detektiv");
        Location l = loc();

        Item expired = item("Pure Yin Blood C", "BloodSample", 26);
        l.items.add(expired);

        boolean ok = new TakeCommand(p, l, "Pure Yin Blood C").execute();

        assertFalse(ok);
        assertTrue(expired.inStock, "Expired sample should remain in location (inStock=true).");
        assertFalse(p.getBag().has("Pure Yin Blood C"));
    }

    @Test
    void executepickUpItem_Bag_NotinStock() {
        Player p = new Player("Detektiv");
        Location l = loc();

        Item painting = item("Painting", "Key", null);
        l.items.add(painting);

        boolean ok = new TakeCommand(p, l, "painting").execute();

        assertTrue(ok);
        assertTrue(p.getBag().has("Painting"));
        assertFalse(painting.inStock, "Picked item should be marked not in stock in location.");
    }

    @Test
    void executeBagisfull() {
        Player p = new Player("Detektiv");
        Location l = loc();

        for (int i = 1; i <= 12; i++) {
            Item it = item("Junk" + i, "Any", null);
            assertTrue(p.getBag().add(it));
        }

        Item valuable = item("Ritual Notes", "Document", null);
        l.items.add(valuable);

        boolean ok = new TakeCommand(p, l, "Ritual Notes").execute();

        assertFalse(ok);
        assertFalse(p.getBag().has("Ritual Notes"));
        assertTrue(valuable.inStock, "If bag is full, item must stay in location (inStock=true).");
    }

    @Test
    void executeFreshBlood() {
        Player p = new Player("Detektiv");
        Location l = loc();

        Item fresh = item("Pure Yin Blood A", "BloodSample", 24);
        l.items.add(fresh);

        boolean ok = new TakeCommand(p, l, "Pure Yin Blood A").execute();

        assertTrue(ok);
        assertTrue(p.getBag().has("Pure Yin Blood A"));
        assertFalse(fresh.inStock);
    }
}
