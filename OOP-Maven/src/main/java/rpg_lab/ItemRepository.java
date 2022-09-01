package rpg_lab;

import java.util.Collection;
import java.util.Iterator;

public class ItemRepository implements ItemStorage {
    private Collection<Weapon> weapons;
    @Override
    public Collection<Weapon> getWeapons() {
        return weapons;
    }

    public ItemRepository(Collection<Weapon> weapons) {
        this.weapons = weapons;
    }

    @Override
    public Iterator<Weapon> iterator() {
        return weapons.iterator();
    }

}
