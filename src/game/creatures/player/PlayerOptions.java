package game.creatures.player;

import game.creatures.CreatureOptions;

/**
 * Created by lukasz on 06.05.2017.
 */
public class PlayerOptions implements CreatureOptions {

    public static int[] move(int [] array){
        for (int i = 0; i < array.length; i++) {
            i++;
        }

        return array;
    }
    public static int[] stay(int[] array){



        return array;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

}
