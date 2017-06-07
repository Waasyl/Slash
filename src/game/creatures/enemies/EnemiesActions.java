package game.creatures.enemies;

import com.sun.xml.internal.bind.v2.TODO;
import game.creatures.player.Player;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Lukasz on 2017-05-07.
 */
public class EnemiesActions implements IEnemiesActions {

    public void attack(Enemy enemy, Player player) {
        Random random = new Random();

        int crit = random.nextInt(10)+1;
        int damage = player.getDefence()-(random.nextInt(enemy.getMaxDamage())+enemy.getMinDamage());
        if(damage >= 0){
            System.out.println("Enemy missed");
        }else {
            if (crit == 1) {
//                TODO fix, enenmy critical takes more player hp than should
                int critDamage = player.getDefence() - (enemy.getMaxDamage()*2);
                player.setHealthPoints(player.getHealthPoints() + critDamage);
                System.out.println("ENEMY CRITICAL HIT! " + critDamage * -1 + " DMG!! Your HP: " + enemy.getHealthPoints());
            } else {
                player.setHealthPoints(player.getHealthPoints() + damage);
                System.out.println("You were hit, and get " + damage * -1 + " dmg.Your HP: " + player.getHealthPoints());
                enemy.setXp(enemy.getXp() + 1);
            }
        }
    }
    public boolean checkIfAlive(Enemy enemy){
        boolean flag = true;
        if(enemy.getHealthPoints() > 0){
            return flag;
        }else{
            flag = false;
            return flag;
        }
    }
}
