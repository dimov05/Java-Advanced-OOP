package rpg_lab;

import org.junit.Test;
import org.mockito.*;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroTest {
    @Test
    public void testItemDropShouldDropCorrectly() {
        Weapon weapon = mock(Weapon.class);
        Target target = mock(Target.class);
        Random random = mock(Random.class);
        Hero hero = new Hero("Test_Hero", weapon);
        when(target.isDead()).thenReturn(true);

        Weapon weapon3 = mock(Weapon.class);
        when(weapon3.getAttack()).thenReturn(73);
        when(target.dropWeapon(any())).thenReturn(weapon3);
        Weapon wep = hero.attack(target, random);

        assertEquals(73, wep.getAttack(), 0);
    }
}
