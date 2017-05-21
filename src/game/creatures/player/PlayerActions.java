package game.creatures.player;

import game.creatures.enemies.Enemy;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class PlayerActions implements IPlayerActions{

//wrong idea

    public int move(int board){
        Random random = new Random();
        int rand = random.nextInt(2)+1;
        return (board + rand);
    }

    public  void stay(Player player){
        int HP = player.getHealthPoints();
        HP++;
        player.setHealthPoints(HP);
    }


    public  void attack(Player player, Enemy enemy) {
        Random random = new Random();
        int damage = enemy.getDefence()-(random.nextInt(player.getMaxDamage())+player.getMinDamage());
        if(damage >= 0){
            System.out.println("You made no damage");
        }else {
            enemy.setHealthPoints(enemy.getHealthPoints()+damage);
            System.out.println("You hit, and cause " + damage*-1 + " dmg. Enemy HP: " + enemy.getHealthPoints());
            player.setXp(enemy.getXp()+1);
        }
    }
    public boolean checkIfAlive(Player player){
        if(player.getHealthPoints() > 0){
            return true;
        }else{
            return false;
        }
    }
    public int runAway(int board) {
        if (board <= 3) {
            board = 0;
            return board;
        } else {
            return board - 3;
        }
    }

}
