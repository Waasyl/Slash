package game;

import game.creatures.BaseCreature;
import game.creatures.enemies.EnemiesActions;
import game.creatures.enemies.Enemy;
import game.creatures.player.Player;
import game.creatures.player.PlayerActions;
import game.creatures.player.PlayerClass;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class MainGameClass {
    public static void main(String[] args) {
        Player playerModel = new Player();
        Enemy zombie = new Enemy();
        int board = 0;
        int counter = 0;
        int choice = -1;
        PlayerActions playerActions = new PlayerActions();
        Scanner scanner = new Scanner(System.in);
        System.out.println("                 WELCOME IN SLASH!               ");
        System.out.println("                    have fun\n\n");

        playerActions.playerName(playerModel);
        Player player = PlayerClass.classChoice(playerModel);
        while((board <10 && player.getHealthPoints() > 0) && choice != 0) {
            GameInterface.infoBar(board,player,counter);
            zombie.setHealthPoints(5);
            System.out.println("What do you want to do?");
            GameInterface.menu();
            choice = scanner.nextInt();
//        TODO
//        handle exception
            switch (choice) {
                case 1:
                    board = GameInterface.afterMove(board, player, zombie);
                    counter++;
                    break;
                case 2:
                    playerActions.stay(player);
                    counter++;
                   break;
                case 3:
                    GameInterface.inventory(player);
                    break;
                case 0:
                    System.out.println("Game ended");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
        if(board >= 10 && player.getHealthPoints() > 0){
            System.out.println("Congratulations master. You won!");
        }else if(player.getHealthPoints() <= 0){
            System.out.println("You lose");
        }
    }
}
