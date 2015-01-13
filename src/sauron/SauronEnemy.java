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

    public SauronEnemy(Type type) {
        this.type = type;
    }

    public Type type() {
        return type;
    }

    @Override
    public String toString() {
        return type.name();
    }
}
