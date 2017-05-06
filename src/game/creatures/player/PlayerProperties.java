package game.creatures.player;

import game.creatures.CreatureProperties;

/**
 * Created by marta on 06.05.2017.
 */
public class PlayerProperties extends CreatureProperties {
    public PlayerProperties(int damage, int defence, int healthPoints, int xp, int lvl) {
        super(damage = 10, defence=10, healthPoints=100, xp=0, lvl=1);
    }

}
