package game.creatures.enemies;

import game.creatures.BaseCreature;

/**
 * Created by Lukasz on 2017-05-07.
 */
public class Enemy extends BaseCreature {
    String name;

    public Enemy() {

    }

    public Enemy(String name,int maxDamage, int minDamage, int defence, int healthPoints, int xp, int lvl) {
        super(maxDamage, minDamage, defence, healthPoints, xp, lvl);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
