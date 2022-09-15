package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private final static int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void weaponAttacksLosesDurability() {
        axe.attack(dummy);
        assertEquals(EXPECTED_DURABILITY, axe.getDurabilityPoints(), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        Axe axe = new Axe(10, 0);
        axe.attack(dummy);
    }
}
