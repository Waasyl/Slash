package game.creatures.player;

import game.creatures.BaseCreature;
import game.creatures.player.playerInventory.InventoryType;
import game.creatures.player.playerInventory.Item;

import java.util.List;

/**
 * Created by Lukasz on 2017-05-07.
 */
public class Player extends BaseCreature {
    String name;
    List<Item> inventory;
    Item armour;
    Item weapon;


    public Player() {

    }

    public Player(int maxDamage, int minDamage, int defence, int healthPoints, int xp, int lvl) {
        super(maxDamage, minDamage, defence, healthPoints, xp, lvl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public Item getArmour() {
        try{
            return armour;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public void setArmour(Item armour) {
            if (armour.getInventoryType().equals(InventoryType.ARMOUR)) {
                this.armour = armour;
            }
    }

    public Item getWeapon() {
        try{
            return weapon;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public void setWeapon(Item weapon) {

        if(weapon.getInventoryType().equals(InventoryType.WEAPON)){
            this.weapon = weapon;
        }

    }
}
