package game.creatures.enemies;

import game.creatures.player.Player;

import java.util.Scanner;

/**
 * Created by Lukasz on 2017-05-21.
 */
public interface IEnemiesActions {
    void attack(Enemy enemy, Player player);

    boolean checkIfAlive(Enemy enemy);
}
