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
    public static void afterMove(int board,Player player,Enemy enemy){
        PlayerActions playerActions = new PlayerActions();
        board = playerActions.move(board);
        System.out.println("You moved " + board + " fields");
        System.out.println("You met a strange creature");
        choseToFight(board, player, enemy);

    }
    public static void infoBar(int board,Player player,int counter){
        System.out.println("Your position is: " + board + " only " + (10-board) +" fields left.");
        System.out.println("Yourh HP is :" + player.getHealthPoints());
        System.out.println("It took you: " + counter + " step/s");

    }

    private static boolean choseToFight(int board, Player player, Enemy enemy) {
        PlayerActions playerActions = new PlayerActions();
        System.out.println("What do you want to do?");
        System.out.println("1.Fight");
        System.out.println("2.Run away(you will be moved back 3 fields");
        System.out.println("0.Exit game");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                fight(player,enemy,board);
                break;
            case 2:
                playerActions.runAway(board);
                return false;
            case 0:
                return false;
            default:
                System.out.println("Wrong choice");

        }
        return true;
    }

    public static boolean fight(Player player, Enemy enemy,int board){
        boolean flag = true;
        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
        while(flag && (playerActions.checkIfAlive(player) && enemiesActions.checkIfAlive(enemy)) ) {
            temp(player,enemy,board);
            flag = choseToFight(board, player, enemy);

        }

        return true;
    }
    public static void temp(Player player, Enemy enemy,int board){
        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
        enemiesActions.attack(enemy,player);
        playerActions.attack(player,enemy);

    }


}
