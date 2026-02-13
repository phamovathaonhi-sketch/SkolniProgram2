package game;

import locations.Location;

public class RuleEngine {

    public static void afterAction(GameState state, Location loc) {
        // Only enforce painting survival/rules inside painting world
        if (!state.isInPainting()) return;

        // lose if points <= 0
        if (state.points <= 0) {
            throw new GameOver("Došly ti body. Prohrál jsi.");
        }

        // lose if you exceeded 3 days and still not finished
        if (state.day > 3) {
            throw new GameOver("Nepřežil jsi 3 dny v malbě včas. Prohrál jsi.");
        }
    }

    public static void onNewDayCheck(GameState state) {
        if (!state.isInPainting()) return;

        // if a day just advanced and player did not rest previous day → penalty
        // This check is called before advancing time across midnight in WorldLoader.tick()
        if (!state.restedToday) {
            state.points -= 15;
            System.out.println("Porušil jsi pravidlo: neodpočíval jsi dnes. -15 bodů. Body: " + state.points);
        }
    }

    public static class GameOver extends RuntimeException {
        public GameOver(String msg) { super(msg); }
    }
}
