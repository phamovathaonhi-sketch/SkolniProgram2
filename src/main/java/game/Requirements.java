package game;

import characters.Player;

import java.util.List;

public class Requirements {

    public static boolean checkAll(List<String> reqs, Player player, GameState state) {
        if (reqs == null || reqs.isEmpty()) return true;

        for (String r : reqs) {
            if (!checkOne(r, player, state)) return false;
        }
        return true;
    }

    public static String firstFailed(List<String> reqs, Player player, GameState state) {
        if (reqs == null) return null;
        for (String r : reqs) {
            if (!checkOne(r, player, state)) return r;
        }
        return null;
    }

    private static boolean checkOne(String req, Player player, GameState state) {
        if (req == null) return true;

        req = req.trim();

        if (req.startsWith("HAS:")) {
            String item = req.substring("HAS:".length()).trim();
            return player.getBag().has(item);
        }

        if (req.startsWith("FLAG:")) {
            String flag = req.substring("FLAG:".length()).trim();
            return state.hasFlag(flag);
        }

        return true; // unknown req ignored (keeps it beginner-friendly)
    }
}
