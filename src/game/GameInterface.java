package game;

import com.sun.org.apache.xpath.internal.SourceTree;
import game.creatures.enemies.EnemiesActions;
import game.creatures.enemies.Enemy;
import game.creatures.player.Player;
import game.creatures.player.PlayerActions;

import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class GameInterface {
    public static void menu(){
        System.out.println("1. Move(1 or 2 fields)");
        System.out.println("2. Stay");
        System.out.println("0. End Game");
    }
    public static void afterMove(int[] tab,Player player,Enemy enemy){
        PlayerActions.move(tab);
        System.out.println("You met a strange creature.What do you want to do?");
        System.out.println("1.Fight");
        System.out.println("2.Run away(you will be moved back 3 fields");
        System.out.println("0.Exit game");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                fight(player,enemy);
                break;
            case 2:
                PlayerActions.runAway(tab);
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong choice");

        }

    }

    public static boolean fight(Player player, Enemy enemy){
        Scanner scanner = new Scanner(System.in);
        while(PlayerActions.checkIfAlive(player) && EnemiesActions.checkIfAlive(enemy)){


        }

        return true;
    }



}
