package game;

import java.util.HashSet;
import java.util.Set;

/**
 * used for orientating the time inside painting
 */
public class GameState {
    public int day = 0;
    public int hour = 0;
    public int points = 100;

    public boolean restedToday = false; // rule: must rest each day (in painting)
    public  Set<String> flags = new HashSet<>();

    public boolean hasFlag(String flag) {
        return flags.contains(flag);
    }

    /**
     * beginning
     */
    public void enterPaintingWorld() {
        day = 1;
        hour = 8; // morning
        points = 100;
        restedToday = false;
        flags.add("IN_PAINTING");
    }

    /**
     * used to convert from hours to day
     * @param hours
     */
    public void advanceTime(int hours) {
        for (int i = 0; i < hours; i++) {
            hour++;
            if (hour >= 24) {
                hour = 0;
                day++;
                restedToday = false; // new day → must rest again
            }
        }
    }

    public boolean isInPainting() {
        return hasFlag("IN_PAINTING");
    }
}
