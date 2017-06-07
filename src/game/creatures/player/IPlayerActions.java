package game.creatures.player;

import game.creatures.enemies.Enemy;
import game.creatures.player.playerInventory.Item;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Lukasz on 2017-05-21.
 */
public interface IPlayerActions {

    int move(int board);

    void stay(Player player);

    void attack(Player player, Enemy enemy);

    boolean checkIfAlive(Player player);

    int runAway(int board);

    Player playerName(Player player);

    Player putOn(Player player,Item item);

    Player putOnItemFromInventory(Player player);

    Player takeOff(Player player);

}
