package game;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;
import game.creatures.enemies.EnemiesActions;
import game.creatures.enemies.Enemy;
import game.creatures.enemies.EnemyGenerator;
import game.creatures.player.Player;
import game.creatures.player.PlayerActions;
import game.creatures.player.playerInventory.ItemGenerator;
import game.creatures.player.playerInventory.PlayerInventory;
import game.result.FileResultsRepository;
import game.result.Result;
import game.result.ResultsRepository;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class GameInterface {


    public static void menu() {
        System.out.println("1. Move(1 or 2 fields)");
        System.out.println("2. Stay");
        System.out.println("3. Inventory");
        System.out.println("4. Show stats");
        System.out.println("0. End Game");
    }

    public static int afterMove(int board, Player player, Enemy enemy) {
        PlayerActions playerActions = new PlayerActions();
        enemy = generateEnemy(enemy);
        board = playerActions.move(board);
        System.out.println("You met a strange creature. A " + enemy.getName() + "!");
        if (enemy.getHealthPoints() > 0) {
            return choseToFight(board, player, enemy);
        } else return board;
    }

    public static Enemy generateEnemy(Enemy enemy) {
        Random random = new Random();
        int randomChoice = random.nextInt(3) + 1;
        switch (randomChoice) {
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

    public static void infoBar(int board, Player player, int counter, int boardSize) {
        System.out.println("\nYour position is: " + board + " only " + (boardSize - board) + " field/s. left");
        System.out.println("Your HP is :" + player.getHealthPoints());
        System.out.println("It took you: " + counter + " step/FileResultsRepository");

    }

    private static int choseToFight(int board, Player player, Enemy enemy) {
        PlayerActions playerActions = new PlayerActions();
        if (enemy.getHealthPoints() <= 0) {
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
        switch (choice) {
            case 1:
                board = fight(player, enemy, board);
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


    public static int fight(Player player, Enemy enemy, int board) {
        int tempBoard = board;

        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
        while ((enemiesActions.checkIfAlive(enemy) && playerActions.checkIfAlive(player)) && tempBoard == board) {
            fightModule(player, enemy);
            board = choseToFight(board, player, enemy);

        }
        return board;
    }

    public static void fightModule(Player player, Enemy enemy) {
        PlayerActions playerActions = new PlayerActions();
        EnemiesActions enemiesActions = new EnemiesActions();
        if (player.getHealthPoints() > 0) {
            playerActions.attack(player, enemy);
            if (enemy.getHealthPoints() > 0) {
                enemiesActions.attack(enemy, player);
            }

        }

    }

    public static void inventory(Player player) {
        PlayerActions playerActions = new PlayerActions();
        System.out.println("What do you want to do?");
        System.out.println("1. Show inventory");
        System.out.println("2. Remove from inventory");
        System.out.println("3. Put on item");
        System.out.println("4. Take off item");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
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

    public static void showPlayerStats(Player player) {
        System.out.println(player);
    }

    public static int boardSizeChoose() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("               Select board size:");
        System.out.println("               1. 10 fields");
        System.out.println("               2. 20 fields");
        System.out.println("               3. 40 fields");
        String choice = scanner.nextLine();
        int boardSize = 0;
        switch (choice) {
            case "1":
                boardSize = 10;
                break;
            case "2":
                boardSize = 20;
                break;
            case "3":
                boardSize = 40;
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }
        return boardSize;

    }
    public static void showResults(List<Result> results){
        System.out.println("                Results: ");
        System.out.println("Player                  Score                    Boards Size");
        for (int i = 0; i < results.size(); i++) {
            if(results != null) {
                System.out.println((i+1) + " " + results.get(i).getPlayerName() + "                   " + results.get(i).getResult() + "                          " + results.get(i).getBoardSize());

            }
        }

    }
    public static void intro(){
        try{
            for (int i = 0; i < 15; i++) {
                System.out.print("<");
                Thread.sleep(50);
            }
            System.out.print("                 WELCOME IN SLASH!               ");

            for (int i = 0; i < 15; i++) {
                System.out.print(">");
                Thread.sleep(50);
            }
            Thread.sleep(50);
            System.out.println("\n                                    have fun\n\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void scores(){
        ResultsRepository resultRepository = new FileResultsRepository("C:\\Users\\Lukasz\\Dropbox\\SDA\\MyBetterHomeRepository\\src\\game\\results");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Show all results");
        System.out.println("2. Show top results");
        System.out.println("0. Exit");
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                GameInterface.showResults(FileResultsRepository.getAllResult());
                break;
            case "2":
                GameInterface.showResults(FileResultsRepository.getTopResult());
                break;
            case "0":
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }
    }


}



