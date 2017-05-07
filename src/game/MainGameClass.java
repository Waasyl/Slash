package game;

import game.creatures.BaseCreature;
import game.creatures.enemies.EnemiesActions;
import game.creatures.enemies.Enemy;
import game.creatures.player.Player;
import game.creatures.player.PlayerActions;

/**
 * Created by lukasz on 06.05.2017.
 */
public class MainGameClass {
    public static void main(String[] args) {
        System.out.println("Test class");
        int[] tab = new int[20];
        Player player = new Player(5,0,2,10,0,1);
        Enemy zombie = new Enemy(6,0,2,5,0,1);

        PlayerActions.stay(player);
        EnemiesActions.attack(player,zombie);
        PlayerActions.attack(player,zombie);


    }
}
