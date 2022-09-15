package rpg_lab;

import java.util.Random;

public interface Target {
    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();

    Weapon dropWeapon(Random random);

    int getHealth();
}
