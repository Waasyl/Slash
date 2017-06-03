package game.creatures.player.playerInventory;

import game.creatures.player.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukasz on 2017-06-02.
 */
public class InventoryTest {


    public static void main(String[] args) {
        List<Item> inventory = new ArrayList<>();
        PlayerInventory playerInventory = new PlayerInventory();
        Item sword = new Item("Sword",5,1,2,0);
        Item crossbow = new Item("Crossbow",4,2,0,0);
        Item crossbow1 = new Item("Crossbow",4,2,0,0);
        Item crossbow2 = new Item("Crossbow",4,2,0,0);
        Item crossbow3 = new Item("Crossbow",4,2,0,0);
        Item crossbow4 = new Item("Crossbow",4,2,0,0);
        playerInventory.add(inventory,sword);
        playerInventory.add(inventory,crossbow);
        playerInventory.add(inventory,crossbow1);
        playerInventory.add(inventory,crossbow2);
        playerInventory.add(inventory,crossbow3);
        playerInventory.add(inventory,crossbow4);
        playerInventory.display(inventory);
    }
}
