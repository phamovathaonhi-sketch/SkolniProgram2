package items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void isFreshBlood() {
        Item i = new Item();
        i.type = "Key";
        i.ageHours = 999;

        assertTrue(i.isFreshBlood());
    }

    @Test
    void isFreshBloodBloodsampleagemissing() {
        Item i = new Item();
        i.type = "BloodSample";
        i.ageHours = null;

        assertTrue(i.isFreshBlood());
    }

    @Test
    void isFreshBloodtrueWhenAgeAtMost24() {
        Item i = new Item();
        i.type = "BloodSample";
        i.ageHours = 24;

        assertTrue(i.isFreshBlood());

        i.ageHours = 0;
        assertTrue(i.isFreshBlood());
    }

    @Test
    void isFreshBlood_falseWhenAgeOver24() {
        Item i = new Item();
        i.type = "BloodSample";
        i.ageHours = 25;

        assertFalse(i.isFreshBlood());
    }

    @Test
    void prettyItemsinformation() {
        Item i = new Item();
        i.name = "Sword";
        i.type = "Weapon";
        i.damage = 25;
        i.ageHours = null;

        String s = i.pretty();
        assertTrue(s.contains("Sword"));
        assertTrue(s.contains("Weapon"));
        assertTrue(s.contains("dmg=25"));
        assertFalse(s.contains("ageHours="));
    }
}