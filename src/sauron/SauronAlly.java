package sauron;

import java.util.*;

/**
 * Created by Lander Brandt on 1/13/15.
 */
public class SauronAlly implements Observer {
    private boolean defeated = false;
    /**
     * Concrete class here so we know for sure what data we'll be getting in our {@see update()} method
     */
    private EyeOfSauron eye;
    private String name;

    public SauronAlly(EyeOfSauron eye, String name) {
        this.eye = eye;
        this.name = name;

        eye.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        // Count the different types of enemies
        HashMap<SauronEnemy.Type, Integer> enemyCounts = new HashMap<SauronEnemy.Type, Integer>();
        SauronEnemy[] enemies = (SauronEnemy[])o;

        for (SauronEnemy enemy : enemies) {
            if (!enemyCounts.containsKey(enemy.type())) {
                // If the key doesn't exist then we will get null if we try the operation further down
                // so set the count to 1 to set the object
                enemyCounts.put(enemy.type(), 1);
            } else {
                // Increment the existing integer by 1
                enemyCounts.put(enemy.type(), enemyCounts.get(enemy.type()) + 1);
            }
        }

        StringBuilder enemiesObserved = new StringBuilder();

        Iterator it = enemyCounts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();

            String enemyType = ((SauronEnemy.Type)pairs.getKey()).name();
            Integer count = (Integer)pairs.getValue();
            String pluralEnemies = count > 1 ? "enemies" : "enemy";

            enemiesObserved.append(String.format("%d %s of type %s", count, pluralEnemies, enemyType));
        }

        System.out.printf("%s has spotted %d enemies! %s\n", name(), enemies.length, enemiesObserved);
    }

    /**
     * Sets this enemy as defeated and unsubscribes from {@see eye}'s events
     */
    public void defeated() {
        defeated = true;
        eye.deleteObserver(this);
    }

    public boolean isDefeated() {
        return defeated;
    }

    public String name() {
        return name;
    }
}
