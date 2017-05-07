package game.creatures.player;

import game.creatures.enemies.Enemy;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class PlayerActions {


    public static int[] move(int [] array){
        for (int i = 0; i < array.length; i++) {
            i++;
        }
        return array;
    }

    public static void stay(Player player){
        int HP = player.getHealthPoints();
        HP++;
        player.setHealthPoints(HP);
    }


    public static void attack(Player player, Enemy enemy) {
        Random random = new Random();
        int damage = enemy.getDefence()-(random.nextInt(player.getMaxDamage())+player.getMinDamage());
        if(damage >= 0){
            System.out.println("You made no damage");
        }else {
            enemy.setHealthPoints(enemy.getHealthPoints()+damage);
            System.out.println("You hit, and cause " + damage*-1 + " dmg");
        }
    }
    public static boolean checkIfAlive(Player player){
        if(player.getHealthPoints() > 0){
            return true;
        }else{
            return false;
        }
    }


}
