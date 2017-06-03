package game.creatures.player.playerInventory;

import java.util.List;

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
