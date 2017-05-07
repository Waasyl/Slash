package game.creatures.enemies;

import game.creatures.player.Player;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Lukasz on 2017-05-07.
 */
public class EnemiesActions {

    public static void attack(Player player, Enemy enemy) {
        Random random = new Random();
        int damage = player.getDefence()-(random.nextInt(enemy.getMaxDamage())+enemy.getMinDamage());
        if(damage >= 0){
            System.out.println("Enemy missed");
        }else {
            player.setHealthPoints(player.getHealthPoints()+damage);
            System.out.println("You were hit, and get " + damage*-1 + " dmg");
        }
    }
}
