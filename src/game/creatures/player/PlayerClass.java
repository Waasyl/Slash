package game.creatures.player;

import game.creatures.player.playerInventory.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Lukasz on 2017-05-25.
 */
public class PlayerClass {
    public static Player classChoice(Player player){
        System.out.println("                Please choose your class: ");
        System.out.println("                  1. Thief");
        System.out.println("                  2. Knight");
        System.out.println("                  3. Berserk");
        Scanner scanner = new Scanner(System.in);
        List<Item> inventory = new ArrayList<>();
        switch (scanner.nextLine()){
            case "1":
                player = new Player(5,2,2,20,1,1);
                break;
            case "2":
                player = new Player(7,0,3,15,1,1);
                break;
            case "3":
                player = new Player(5,1,4,10,1,1);
                break;
            default:
                System.out.println("              Wrong choice.You`re just a weak peasant.");
                player = new Player(3,1,1,5,1,1);
        }
        player.setInventory(inventory);

        return player;
    }
}
