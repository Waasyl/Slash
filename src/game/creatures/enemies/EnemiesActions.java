package game.creatures.enemies;

import game.creatures.player.Player;

import java.util.Scanner;

/**
 * Created by Lukasz on 2017-05-07.
 */
public class EnemiesActions {

    public static void attack(Enemy enemy, Player player){
        Scanner scanner = new Scanner(System.in);
        int minDmg = enemy.getMinDamage();
        int maxDmg = enemy.getMaxDamage();
        int defence = player.getDefence();
        int damage = defence-(scanner.nextInt(maxDmg)+minDmg);
        if(damage <= 0){
            System.out.println("You made no damage");
        }else {
            int newHp = player.getHealthPoints()+damage;
            player.setHealthPoints(newHp);
            System.out.println("You hit, and cause " + damage*-1 + " dmg");
        }

    }
}
