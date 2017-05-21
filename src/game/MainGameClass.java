package game;

import game.creatures.BaseCreature;
import game.creatures.enemies.EnemiesActions;
import game.creatures.enemies.Enemy;
import game.creatures.player.Player;
import game.creatures.player.PlayerActions;

import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class MainGameClass {
    public static void main(String[] args) {
        System.out.println("Test class");
        int[] tab = new int[20];
        Player player = new Player(5,0,2,10,0,1);
        Enemy zombie = new Enemy(6,0,2,5,0,1);
        int board = 0;
        int counter = 0;
        int choice = -1;
        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
//        playerActions.stay(player);
//
//        enemiesActions.attack(zombie,player);
//        playerActions.attack(player,zombie);
//        playerActions.move(board);
        Scanner scanner = new Scanner(System.in);
        while(board <10 && choice != 0) {
            GameInterface.infoBar(board,player,counter);
            zombie.setHealthPoints(5);
            System.out.println("What do you want to do?");
            GameInterface.menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    GameInterface.afterMove(board, player, zombie);
                    counter++;
                    break;
                case 2:
                    playerActions.stay(player);
                    counter++;
                   break;
                case 0:
                    System.out.println("Game ended");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }

    }
}
