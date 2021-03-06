package sauron;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Lander Brandt on 1/13/15.
 */
public class EyeOfSauron extends Observable {
    /**
     * Sets the enemies that the eye sees, and notifies its minions
     * @param enemies array of enemy groups
     */
    public void setEnemies(SauronEnemy[] enemies) {
        setChanged();
        notifyObservers(enemies);
    }
}
