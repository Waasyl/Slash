package game.creatures.player.playerInventory;

import game.creatures.player.Player;
import game.creatures.player.PlayerActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-05.
 */
public class ItemGenerator {


    public Item itemGenerator(){
        Random random = new Random();


        Item item = null;
        int number = random.nextInt(2)+1;
        if(number == 1) {
            item.setInventoryType(InventoryType.WEAPON);
            item.setMaxDamage(random.nextInt(5)+3);
            item.setMinDamage(random.nextInt(3)+0);
            item.setDefence(random.nextInt(2)+0);
            item.setHealthPoints(random.nextInt(5)+0);
        }else if(number == 2){
            item.setInventoryType(InventoryType.ARMOUR);
            item.setMaxDamage(random.nextInt(2)+0);
            item.setMinDamage(random.nextInt(1)+0);
            item.setDefence(random.nextInt(4)+1);
            item.setHealthPoints(random.nextInt(10)+0);
        }

        return item;
    }

    public Item dropItem(Player player){
        Item item = itemGenerator();
        List<Item> inventory = player.getInventory();
        PlayerInventory playerInventory = new PlayerInventory();
        PlayerActions playerActions = new PlayerActions();
        System.out.println("You found item " + item);
        System.out.println("What do you want to do?");
        System.out.println("1. Add to inventory");
        System.out.println("2. Put on");
        System.out.println("3. Forget");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
//        TODO

        switch(choice){
            case "1":
                playerInventory.add(inventory,item);
                break;
            case "2":

                break;
        }


        return item;
    }

}
