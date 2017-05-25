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
    public static Player classChoice(Player player){
        System.out.println("Please choose your class: ");
        System.out.println("1. Thief");
        System.out.println("2. Knight");
        System.out.println("3. Berserk");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                player = new Player(5,2,2,20,1,1);
                break;
            case 2:
                player = new Player(7,0,3,15,1,1);
                break;
            case 3:
                player = new Player(5,1,4,10,1,1);
                break;
            default:
                System.out.println("Wrong choice");
        }

        return player;
    }


    public static void menu(){
        System.out.println("1. Move(1 or 2 fields)");
        System.out.println("2. Stay");
        System.out.println("0. End Game");
    }
    public static int afterMove(int board,Player player,Enemy enemy){
        PlayerActions playerActions = new PlayerActions();
        board = playerActions.move(board);
        System.out.println("You met a strange creature");
        return choseToFight(board, player, enemy);

    }
    public static void infoBar(int board,Player player,int counter){
        System.out.println("Your position is: " + board + " only " + (10-board) +" fields left.");
        System.out.println("Yourh HP is :" + player.getHealthPoints());
        System.out.println("It took you: " + counter + " step/s");

    }

    private static int choseToFight(int board, Player player, Enemy enemy) {
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
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong choice");

        }
        return board;
    }

    public static void fight(Player player, Enemy enemy,int board){
        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
        while((playerActions.checkIfAlive(player) && enemiesActions.checkIfAlive(enemy)) ) {
            temp(player,enemy,board);
            choseToFight(board, player, enemy);

        }
    }
    public static void temp(Player player, Enemy enemy,int board){
        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
        enemiesActions.attack(enemy,player);
        playerActions.attack(player,enemy);

    }


}
