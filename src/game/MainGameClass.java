package game;

import game.creatures.enemies.Enemy;
import game.creatures.player.Player;
import game.creatures.player.PlayerActions;
import game.creatures.player.PlayerClass;
import game.result.FileResultsRepository;
import game.result.Result;
import game.result.ResultsRepository;

import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class MainGameClass {
    public static void main(String[] args) {
        GameInterface.intro();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while(flag) {
            System.out.println("1. Game");
            System.out.println("2. Scores");
            System.out.println("0. End");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    game();
                    flag = false;
                    break;
                case "2":
                    GameInterface.scores();
                    System.out.println();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }

        }
    }

    private static void game() {
        Player playerModel = new Player();
        Enemy enemy = new Enemy();
        ResultsRepository resultRepository = new FileResultsRepository("C:\\Users\\Lukasz\\Dropbox\\SDA\\MyBetterHomeRepository\\src\\game\\results");
//        GameInterface.showResults(FileResultsRepository.getAllResult());
        int board = 0;
        int counter = 0;
        int choice = -1;
        PlayerActions playerActions = new PlayerActions();
        Scanner scanner = new Scanner(System.in);


        Player player = PlayerClass.classChoice(playerModel);
        playerActions.playerName(player);
        int boardSize = GameInterface.boardSizeChoose();
        for (int i = 0; i < 18; i++) {
            System.out.println();
        }
        while((board < boardSize && player.getHealthPoints() > 0) && choice != 0) {
            GameInterface.infoBar(board,player,counter, boardSize);
            System.out.println("What do you want to do?");
            GameInterface.menu();
            choice = scanner.nextInt();
//        TODO handle exception
            switch (choice) {
                case 1:
                    board = GameInterface.afterMove(board, player, enemy);
                    counter++;
                    break;
                case 2:
                    playerActions.stay(player);
                    counter++;
                   break;
                case 3:
                    GameInterface.inventory(player);
                    break;
                case 4:
                    GameInterface.showPlayerStats(player);
                    break;
                case 0:
                    System.out.println("Game ended");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }

        if(board >= 10 && player.getHealthPoints() > 0){
            Result result = new Result(player.getName(),counter,boardSize);
            System.out.println("Congratulations master. You won!");
            resultRepository.add(result);
        }else if(player.getHealthPoints() <= 0){
            System.out.println("You lose");
        }
    }


}
