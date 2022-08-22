package InterfaceAndAbstractionExercise.MilitaryElite.Classes;

import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.LieutenantGeneral;
import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Private;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<Private> subordinates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.subordinates = new TreeSet<>(new Comparator<Private>() {
            @Override
            public int compare(Private first, Private second) {
                return second.getId() - first.getId();
            }
        });
    }

    public void addPrivate(Private priv) {
        this.subordinates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator())
                .append("Privates: ");
        for (Private subordinate : subordinates) {
            sb.append(System.lineSeparator())
                    .append("  ").append(subordinate.toString());

        }
        return sb.toString();
    }
}
