package InterfaceAndAbstractionExercise.MilitaryElite.Classes;

import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }
}
