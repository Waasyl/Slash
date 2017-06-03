package game.creatures.player.playerInventory;

import jdk.nashorn.internal.runtime.ECMAException;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Lukasz on 2017-06-02.
 */
public class PlayerInventory {


    public List<Item> add(List<Item> inventory,Item item){
        if(inventory.size() < 5){
            inventory.add(item);
        }else{
            System.out.println("Too many items in inventory");
        }
        return inventory;
    }
    public List<Item> remove(List<Item> inventory){
        display(inventory);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Which position do you want to remove from your inventory?");
            int choice = scanner.nextInt();
            inventory.remove(choice);

        }catch(Exception e){
            System.out.println("Wrong choice");
        }
        return inventory;
    }
    public void display(List<Item> inventory){
        int i = 0;
        for (Item item:inventory) {
            System.out.print(i + " ");
            System.out.println(item);
            i++;
        }
    }


}
