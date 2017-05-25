package game.creatures.enemies;

import game.creatures.BaseCreature;

/**
 * Created by Lukasz on 2017-05-07.
 */
public class Enemy extends BaseCreature {
    public Enemy() {

    }

    public Enemy(int maxDamage, int minDamage, int defence, int healthPoints, int xp, int lvl) {
        super(maxDamage, minDamage, defence, healthPoints, xp, lvl);
    }
}
