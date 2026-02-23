package characters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    static class TestCharacter extends Character {
        TestCharacter(String name) {
            super(name);
        }
    }

    @Test
    void receiveDamage() {
        TestCharacter c = new TestCharacter("A");
        assertEquals(100, c.getHP());

        c.receiveDamage(30);
        assertEquals(70, c.getHP());

        c.receiveDamage(1000);
        assertEquals(0, c.getHP());
        assertTrue(c.isDefeated());
    }

    @Test
    void receiveDamagenoHealing() {
        TestCharacter c = new TestCharacter("A");
        c.receiveDamage(-50); // should be treated as 0
        assertEquals(100, c.getHP());
        assertFalse(c.isDefeated());
    }

    @Test
    void isDefeatedTrue() {
        TestCharacter c = new TestCharacter("A");
        c.receiveDamage(100);
        assertTrue(c.isDefeated());
        assertEquals(0, c.getHP());
    }
}