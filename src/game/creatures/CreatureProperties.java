package game.creatures;

/**
 * Created by marta on 06.05.2017.
 */
public class CreatureProperties {
    int damage;
    int defence;
    int healthPoints;
    int xp;
    int lvl;

    public CreatureProperties(int damage, int defence, int healthPoints, int xp, int lvl) {
        this.damage = damage;
        this.defence = defence;
        this.healthPoints = healthPoints;
        this.xp = xp;
        this.lvl = lvl;
    }
}
