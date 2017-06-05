package game.creatures;

/**
 * Created by lukasz on 06.05.2017.
 */
public class BaseCreature {
    private int maxDamage;
    private int minDamage;
    private int defence;
    private int healthPoints;
    private int xp;
    private int lvl;

    public BaseCreature() {

    }

    public BaseCreature(int maxDamage, int minDamage, int defence, int healthPoints, int xp, int lvl) {
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.defence = defence;
        this.healthPoints = healthPoints;
        this.xp = xp;
        this.lvl = lvl;
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

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return "BaseCreature{" +
                "maxDamage=" + maxDamage +
                ", minDamage=" + minDamage +
                ", defence=" + defence +
                ", healthPoints=" + healthPoints +
                ", xp=" + xp +
                ", lvl=" + lvl +
                '}';
    }
}
