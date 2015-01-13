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
        SauronEnemy[] enemies = (SauronEnemy[])o;

        StringBuilder enemiesObserved = new StringBuilder();
        int totalCount = 0;

        for (SauronEnemy enemy : enemies) {
            if (enemiesObserved.length() > 0) {
                enemiesObserved.append(", ");
            }
            enemiesObserved.append(enemy);

            totalCount += enemy.count();
        }

        System.out.printf("%s has spotted %d enemies! %s\n", name(), totalCount, enemiesObserved);
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
