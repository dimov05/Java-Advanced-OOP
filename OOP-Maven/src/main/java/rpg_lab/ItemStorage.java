package rpg_lab;

import java.util.Collection;

public interface ItemStorage extends Iterable<Weapon> {
    Collection<Weapon> getWeapons();
}
