package game.creatures.player.playerInventory;

import java.util.List;

/**
 * Created by Lukasz on 2017-06-05.
 */
public interface IPlayerInventory {
    //not in use

    List<Item> remove(List<Item> inventory);
    void display(List<Item> inventory);
    List<Item> add(List<Item> inventory,Item item);

}
