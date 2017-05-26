package game.creatures.player;

import game.creatures.BaseCreature;
import game.creatures.enemies.Enemy;

/**
 * Created by Lukasz on 2017-05-07.
 */
public class Player extends BaseCreature {
    String name;

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
}
