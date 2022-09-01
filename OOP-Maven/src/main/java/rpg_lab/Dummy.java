package rpg_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    private int health;
    private int experience;
    private ItemStorage itemStorage;

    public Dummy(int health, int experience, ItemStorage itemStorage) {
        this.health = health;
        this.experience = experience;
        this.itemStorage = itemStorage;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public Weapon dropWeapon(Random random) {
        List<Weapon> weapons = new ArrayList<>(this.itemStorage.getWeapons());
        int itemIndex = random.nextInt(weapons.size());
        return weapons.get(itemIndex);
    }
}
