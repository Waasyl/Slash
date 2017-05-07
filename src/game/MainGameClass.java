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

        PlayerActions.stay(player);
        EnemiesActions.attack(player,zombie);
        PlayerActions.attack(player,zombie);
        PlayerActions.move(tab);
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        GameInterface.menu();
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                PlayerActions.move(tab);
                break;
            case 2:
                PlayerActions.stay(player);
                break;
            case 3:
                System.out.println("Game ended");
                break;
            default:
                System.out.println("Wrong choice");
        }


    }
}
