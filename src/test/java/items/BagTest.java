package items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    private Item item(String name) {
        Item i = new Item();
        i.name = name;
        i.type = "Any";
        i.inStock = true;
        return i;
    }

    @Test
    void addItem() {
        Bag bag = new Bag(2);

        assertTrue(bag.add(item("A")));
        assertTrue(bag.add(item("B")));
        assertFalse(bag.add(item("C"))); // full

        assertEquals(2, bag.all().size());
    }

    @Test
    void get_isCaseInsensitive() {
        Bag bag = new Bag(5);
        bag.add(item("Sword"));

        assertNotNull(bag.get("sword"));
        assertNotNull(bag.get("SWORD"));
        assertNull(bag.get("Axe"));
    }

    @Test
    void removeItem() {
        Bag bag = new Bag(5);
        bag.add(item("Key"));

        assertTrue(bag.has("key"));
        assertTrue(bag.remove("KEY"));
        assertFalse(bag.has("key"));
        assertFalse(bag.remove("key")); // already removed
    }

    @Test
    void addnullItem() {
        Bag bag = new Bag(5);
        assertFalse(bag.add(null));
    }
}