package rpg_lab;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class DummyTests {

    @Test
    public void dummyLoosesHealthIfAttacked() {
        Target target = mock(Target.class);
        target.takeAttack(5);
        assertEquals(5, target.getHealth(), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttackedAndDead() {
        Target target = mock(Target.class);
        target.takeAttack(11);
        target.takeAttack(10);
    }

    @Test
    public void deadDummyGivesXP() {
        Target target = mock(Target.class);
        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("Petarcho", weapon);
        hero.attack(target);
        assertEquals(10, hero.getExperience(), 0);
    }

    @Test
    public void aliveDummyDoesNotGiveXP() {
        Target target = mock(Target.class);
        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("Petarcho", weapon);
        hero.attack(target);
        assertEquals(0, hero.getExperience(), 0);
    }
}
