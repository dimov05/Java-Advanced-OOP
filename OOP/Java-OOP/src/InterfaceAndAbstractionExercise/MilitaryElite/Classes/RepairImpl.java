package InterfaceAndAbstractionExercise.MilitaryElite.Classes;

import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Repair;

public class RepairImpl implements Repair {
    private String name;
    private int hoursWorked;

    public RepairImpl(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",
                this.name, this.hoursWorked);
    }
}
