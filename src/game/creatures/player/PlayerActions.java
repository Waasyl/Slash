package game.creatures.player;

import game.creatures.enemies.Enemy;
import game.creatures.player.playerInventory.InventoryType;
import game.creatures.player.playerInventory.Item;
import game.creatures.player.playerInventory.PlayerInventory;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lukasz on 06.05.2017.
 */
public class PlayerActions implements IPlayerActions{

    public Player playerName(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.print("              Please enter your name: ");
        player.setName(scanner.nextLine());
        return player;
    }


    public int move(int board){
        Random random = new Random();
        int rand = random.nextInt(2)+1;
        System.out.println("You moved " + rand + " fields");
        return  (board+rand);
    }

    public void stay(Player player){
        int HP = player.getHealthPoints();
        HP++;
        player.setHealthPoints(HP);
    }


    public void attack(Player player, Enemy enemy) {
        Random random = new Random();
        int crit = random.nextInt(10)+1;

        int damage = enemy.getDefence()-(random.nextInt(player.getMaxDamage())+player.getMinDamage());
        if(damage >= 0){
            System.out.println("You made no damage");
        }else {
            if(crit == 1){
                int critDamage = enemy.getDefence() - (player.getMaxDamage()*2);
                enemy.setHealthPoints(enemy.getHealthPoints() + critDamage);
                System.out.println("CRITICAL HIT! " + critDamage * -1 + " DMG!! Enemy HP: " + enemy.getHealthPoints());

            }else {
                enemy.setHealthPoints(enemy.getHealthPoints() + damage);
                System.out.println("You hit, and cause " + damage * -1 + " dmg. Enemy HP: " + enemy.getHealthPoints());
                player.setXp(enemy.getXp() + 1);
            }
        }
    }
    public boolean checkIfAlive(Player player){
        if(player.getHealthPoints() > 0){
            return true;
        }else{
            return false;
        }
    }
    public int runAway(int board) {
        if (board <= 3) {
            board = 0;
            return board;
        } else {
            return board - 3;
        }
    }
    public Player putOn(Player player,Item item){
        int playerMaxDmg = player.getMaxDamage();
        int playerMinDmg = player.getMinDamage();
        int playerHp = player.getHealthPoints();
        int playerDefence = player.getDefence();

        int itemMaxDamage = item.getMaxDamage();
        int itemMinDamage = item.getMinDamage();
        int itemHp = item.getHealthPoints();
        int itemDefence = item.getDefence();
// TODO putting on inventory after finding it should first remove stats of previous inventory form player stats
        if(item.getInventoryType().equals(InventoryType.WEAPON)){
            if(player.getWeapon() != null) {
                PlayerActions playerActions = new PlayerActions();
                player = playerActions.takeOffWeapon(player);
            }
            player.setWeapon(item);
            player.setMaxDamage(playerMaxDmg+itemMaxDamage);
            player.setMinDamage(playerMinDmg+itemMinDamage);
            player.setHealthPoints(playerHp+itemHp);
            player.setDefence(playerDefence+itemDefence);
        }else {
            if(player.getArmour() != null) {
                PlayerActions playerActions = new PlayerActions();
                player = playerActions.takeOffArmour(player);
            }
            player.setArmour(item);
            player.setMaxDamage(playerMaxDmg+itemMaxDamage);
            player.setMinDamage(playerMinDmg+itemMinDamage);
            player.setHealthPoints(playerHp+itemHp);
            player.setDefence(playerDefence+itemDefence);
        }


        return player;
    }

    public Player putOnItemFromInventory(Player player){
        PlayerActions playerActions = new PlayerActions();

        if(player.inventory.isEmpty()){
            System.out.println("Inventory empty.Nothing to put on.");
        }else {
            PlayerInventory playerInventory = new PlayerInventory();
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to put on?");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            playerInventory.display(player.getInventory());
            int choice = scanner.nextInt();
            Item item = player.inventory.get(choice);
            player = playerActions.putOn(player, item);
            player.inventory.remove(choice);
        }
        return player;
    }

//TODO handle situation when HP is low, and can fall below 0 after taking off inventory
    public Player takeOff(Player player){
        if(player.getArmour() == null || player.getWeapon() == null ){
            System.out.println("You`r naked, you can`t take off anything.");
        }else {

            System.out.println("What do you want to take off? ");
            System.out.println("1. ARMOUR");
            System.out.println("2. WEAPON");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    player = takeOffArmour(player);
                    break;
                case "2":
                    player = takeOffWeapon(player);
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
        return player;
    }

    public Player takeOffWeapon(Player player){
        Item item = player.getWeapon();
        int playerMaxDmg = player.getMaxDamage();
        int playerMinDmg = player.getMinDamage();
        int playerHp = player.getHealthPoints();
        int playerDefence = player.getDefence();
        int itemMaxDamage = item.getMaxDamage();
        int itemMinDamage = item.getMinDamage();
        int itemHp = item.getHealthPoints();
        int itemDefence = item.getDefence();
        player.setMaxDamage(playerMaxDmg - itemMaxDamage);
        player.setMinDamage(playerMinDmg - itemMinDamage);
        player.setHealthPoints(playerHp - itemHp);
        player.setDefence(playerDefence - itemDefence);
        player.setWeapon(null);
        return player;

    }
    public Player takeOffArmour(Player player){
        Item item = player.getArmour();
        int playerMaxDmg = player.getMaxDamage();
        int playerMinDmg = player.getMinDamage();
        int playerHp = player.getHealthPoints();
        int playerDefence = player.getDefence();
        int itemMaxDamage = item.getMaxDamage();
        int itemMinDamage = item.getMinDamage();
        int itemHp = item.getHealthPoints();
        int itemDefence = item.getDefence();
        player.setMaxDamage(playerMaxDmg - itemMaxDamage);
        player.setMinDamage(playerMinDmg - itemMinDamage);
        player.setHealthPoints(playerHp - itemHp);
        player.setDefence(playerDefence - itemDefence);
        player.setArmour(null);
        return player;
    }

}
