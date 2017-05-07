package game;

import game.creatures.BaseCreature;
import game.creatures.player.Player;
import game.creatures.player.PlayerActions;

/**
 * Created by lukasz on 06.05.2017.
 */
public class MainGameClass {
    public static void main(String[] args) {
        System.out.println("Test class");
        int[] tab = new int[20];
        Player player = new Player();
        PlayerActions.stay(player);


    }
}
