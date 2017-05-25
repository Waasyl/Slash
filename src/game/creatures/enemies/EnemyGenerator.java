package game.creatures.enemies;

import java.util.Random;

/**
 * Created by Lukasz on 2017-05-25.
 */
public class EnemyGenerator {

    public static Enemy zombie(Enemy enemy){
        Random random = new Random();
        int healthPoints = random.nextInt(5)+3;
        enemy = new Enemy("Zombie",3,1,2,healthPoints,1,1);
       return enemy;
    }

    public static Enemy knight(Enemy enemy){
        Random random = new Random();
        int healthPoints = random.nextInt(6)+4;
        enemy = new Enemy("Knight",6,2,2,healthPoints,1,1);
        return enemy;
    }

    public static Enemy goblin(Enemy enemy){
        Random random = new Random();
        int healthPoints = random.nextInt(4)+2;
        enemy = new Enemy("Goblin",4,1,3,healthPoints,1,1);
        return enemy;
    }



}
