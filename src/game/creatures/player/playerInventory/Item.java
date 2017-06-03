package game.creatures.player.playerInventory;

/**
 * Created by Lukasz on 2017-06-02.
 */
public class Item {
    String name;
    int maxDamage;
    int minDamage;
    int defence;
    int healthPoints;
    InventoryType inventoryType;

    public Item(String name,InventoryType inventoryType, int maxDamage, int minDamage, int defence, int healthPoints) {
        this.name = name;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.defence = defence;
        this.healthPoints = healthPoints;
        this.inventoryType = inventoryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    @Override
    public String toString() {
        return  name  + ", type " + inventoryType +
                ", damage " + minDamage +
                "-" + maxDamage +
                ", def=" + defence +
                ", HP=" + healthPoints;
    }
}
