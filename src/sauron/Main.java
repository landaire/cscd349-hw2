package sauron;

public class Main {

    public static void main(String[] args) {
        EyeOfSauron eye = new EyeOfSauron();
        SauronAlly saruman = new SauronAlly(eye, "Saruman");
        SauronAlly angmar = new SauronAlly(eye, "Angmar");

        eye.setEnemies(new SauronEnemy[] {
            new SauronEnemy(SauronEnemy.Type.Hobbit, 1),
            new SauronEnemy(SauronEnemy.Type.Elf, 1),
            new SauronEnemy(SauronEnemy.Type.Dwarf, 2),
        });

        System.out.println("Saruman has been defeated!\n");
        saruman.defeated();

        eye.setEnemies(new SauronEnemy[] {
            new SauronEnemy(SauronEnemy.Type.Hobbit, 4),
            new SauronEnemy(SauronEnemy.Type.Elf, 2),
            new SauronEnemy(SauronEnemy.Type.Dwarf, 2),
            new SauronEnemy(SauronEnemy.Type.Man, 100),
        });
    }
}
