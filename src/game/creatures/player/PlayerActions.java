package game.creatures.player;

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


    public int attack(int maxDamage, int minDamage, int opponentDef,int opponentHp) {
        Scanner scanner = new Scanner(System.in);
        int damage = opponentDef-(scanner.nextInt(minDamage)+maxDamage);
        if(damage >= 0){
            System.out.println("You made no damage");
        }else {
            opponentHp = opponentHp+damage;
            System.out.println("You hit, and cause " + damage*-1 + " dmg");
        }
        return opponentDef-damage;
    }


}
