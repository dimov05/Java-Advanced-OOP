package InterfaceAndAbstractionExercise.MilitaryElite.Classes;

import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Private;
import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Soldier;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;


    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Salary: %.2f",
                this.salary);
    }
}
