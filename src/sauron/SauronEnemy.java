package sauron;

/**
 * Created by Lander Brandt on 1/13/15.
 */
public class SauronEnemy {
    public static enum Type {
        Elf,
        Hobbit,
        Dwarf,
        Man,
    }

    private Type type;
    private int count;

    public SauronEnemy(Type type, int count) {
        this.type = type;
        this.count = count;
    }

    public Type type() {
        return type;
    }

    public int count() {
        return count;
    }

    @Override
    public String toString() {
        String pluralEnemies = count > 1 ? "enemies" : "enemy";
        return String.format("%d %s of type %s", count(), pluralEnemies, type.name());
    }
}
