package game.creatures.player.playerInventory;

import game.creatures.player.Player;
import game.creatures.player.PlayerActions;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-05.
 */
public class ItemGenerator {


    private Item generateItem(){
        Random random = new Random();


        Item item = new Item();
        int number = random.nextInt(2)+1;
        if(number == 1) {
            item.setName("Sword");
            item.setInventoryType(InventoryType.WEAPON);
            item.setMaxDamage(random.nextInt(5)+3);
            item.setMinDamage(random.nextInt(3)+0);
            item.setDefence(random.nextInt(2)+0);
            item.setHealthPoints(random.nextInt(5)+0);
        }else if(number == 2){
            item.setName("Helmet");
            item.setInventoryType(InventoryType.ARMOUR);
            item.setMaxDamage(random.nextInt(2)+0);
            item.setMinDamage(random.nextInt(1)+0);
            item.setDefence(random.nextInt(4)+1);
            item.setHealthPoints(random.nextInt(10)+0);
        }

        return item;
    }

    public Item dropItem(Player player){
        Item item = generateItem();
        List<Item> inventory = player.getInventory();
        PlayerInventory playerInventory = new PlayerInventory();
        PlayerActions playerActions = new PlayerActions();
        System.out.println("You found item " + item);
        if(player.getWeapon() == null && item.getInventoryType().equals(InventoryType.WEAPON)){
            System.out.println("You have take it to your hands. You have weapon now! Yay!");
            playerActions.putOn(player,item);
        } else if (player.getArmour() == null && item.getInventoryType().equals(InventoryType.ARMOUR)) {
            System.out.println("You have put it on your sexy body. You have armour now! Yay!");
            playerActions.putOn(player,item);
        }else {
            System.out.println("What do you want to do?");
            System.out.println("1. Add to inventory");
            System.out.println("2. Forget");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    playerInventory.add(inventory, item);
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }

        }
        return item;
    }

}
