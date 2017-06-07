package game;

import game.creatures.enemies.EnemiesActions;
import game.creatures.enemies.Enemy;
import game.creatures.enemies.EnemyGenerator;
import game.creatures.player.Player;
import game.creatures.player.PlayerActions;
import game.creatures.player.playerInventory.ItemGenerator;
import game.creatures.player.playerInventory.PlayerInventory;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class GameInterface {


    public static void menu(){
        System.out.println("1. Move(1 or 2 fields)");
        System.out.println("2. Stay");
        System.out.println("3. Inventory");
        System.out.println("4. Show stats");
        System.out.println("0. End Game");
    }
    public static int afterMove(int board,Player player,Enemy enemy){
        PlayerActions playerActions = new PlayerActions();
        enemy = generateEnemy(enemy);
        board = playerActions.move(board);
        System.out.println("You met a strange creature. A " + enemy.getName() + "!");
        if(enemy.getHealthPoints() > 0) {
            return choseToFight(board, player, enemy);
        }
        else return board;
    }
    public static Enemy generateEnemy(Enemy enemy){
        Random random = new Random();
        int randomChoice = random.nextInt(3)+1;
        switch (randomChoice){
            case 1:
                enemy = EnemyGenerator.zombie(enemy);
                break;
            case 2:
                enemy = EnemyGenerator.knight(enemy);
                break;
            case 3:
                enemy = EnemyGenerator.goblin(enemy);
                break;
        }


        return enemy;
    }
    public static void infoBar(int board,Player player,int counter){
        System.out.println("\nYour position is: " + board + " only " + (10-board) +" field/s left.");
        System.out.println("Your HP is :" + player.getHealthPoints());
        System.out.println("It took you: " + counter + " step/s");

    }

    private static int choseToFight(int board, Player player, Enemy enemy) {
        PlayerActions playerActions = new PlayerActions();
        if(enemy.getHealthPoints() <= 0){
            System.out.println("You won this fight.\n");
            ItemGenerator itemGenerator = new ItemGenerator();
            itemGenerator.dropItem(player);
            return board;
        }

        System.out.println("\nWhat do you want to do?");
        System.out.println("1.Fight");
        System.out.println("2.Run away(you will be moved back 3 fields)");
        System.out.println("0.Exit game");
        Scanner scanner = new Scanner(System.in);
//        TODO handle exception
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                board = fight(player,enemy,board);
                break;
            case 2:
                board = playerActions.runAway(board);
                break;
            case 0:
                System.exit(1);
                break;
            default:
                System.out.println("Wrong choice");
                break;

        }
        return board;
    }



    public static int fight(Player player, Enemy enemy,int board){
        int tempBoard = board;

        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
        while((enemiesActions.checkIfAlive(enemy) && playerActions.checkIfAlive(player)) && tempBoard == board) {
                fightModule(player, enemy);
                board = choseToFight(board, player, enemy);

        }
        return board;
    }
    public static void fightModule(Player player, Enemy enemy){
        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
        if(player.getHealthPoints() > 0){
            playerActions.attack(player,enemy);
            if(enemy.getHealthPoints() > 0) {
                enemiesActions.attack(enemy, player);
            }

        }

    }

    public static void inventory(Player player){
        PlayerActions playerActions = new PlayerActions();
//        PlayerInventory playerInventory = new PlayerInventory();
        System.out.println("What do you want to do?");
        System.out.println("1. Show inventory");
        System.out.println("2. Remove from inventory");
        System.out.println("3. Put on item");
        System.out.println("4. Take off item");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                PlayerInventory.display(player.getInventory());
                break;
            case "2":
                PlayerInventory.remove(player.getInventory());
                break;
            case "3":
                playerActions.putOnItemFromInventory(player);
                break;
            case "4":
                playerActions.takeOff(player);
                break;
            case "0":
                break;
            default:
                System.out.println("Wrong choice");
        }
    }

    public static void showPlayerStats(Player player){
        System.out.println(player);
    }


}
