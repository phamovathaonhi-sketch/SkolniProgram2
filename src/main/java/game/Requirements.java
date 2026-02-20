package game;

import characters.Player;

import java.util.List;

public class Requirements {
    /**
     * All or nothing: 1 mistake = all end
     * @param reqs
     * @param player
     * @param state
     * @return
     */

    public static boolean checkAll(List<String> reqs, Player player, GameState state) {
        if (reqs == null || reqs.isEmpty())
            return true;

        for (String r : reqs) {
            if (!checkOne(r, player, state)) return false;
        }
        return true;
    }

    /**
     * check if player had completed the requirement, otherwise it will give a message
     * @param reqs
     * @param player
     * @param state
     * @return
     */

    public static String firstFailed(List<String> reqs, Player player, GameState state) {
        if (reqs == null)
            return null;
        for (String r : reqs) {
            if (!checkOne(r, player, state))
                return r;
        }
        return null;
    }

    /**
     * it is used to check the state and item, if player has successfully completed the required task than it will continue
     * @param req
     * @param player
     * @param state
     * @return
     */


    private static boolean checkOne(String req, Player player, GameState state) {
        if (req == null)
            return true;

        req = req.trim();

        if (req.startsWith("HAS:")) {
            String item = req.substring("HAS:".length()).trim();
            return player.getBag().has(item);
        }

        if (req.startsWith("FLAG:")) {
            String flag = req.substring("FLAG:".length()).trim();
            return state.hasFlag(flag);
        }

        return true; // unknown req ignored
    }
}
