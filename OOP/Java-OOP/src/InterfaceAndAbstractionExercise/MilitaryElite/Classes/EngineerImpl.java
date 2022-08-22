package InterfaceAndAbstractionExercise.MilitaryElite.Classes;

import InterfaceAndAbstractionExercise.MilitaryElite.Enums.Corp;
import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Engineer;
import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Repair;

import java.util.ArrayList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator())
                .append(this.getCorps())
                .append(System.lineSeparator())
                .append("Repairs:");
        for (Repair repair : repairs) {
            sb.append(System.lineSeparator())
                    .append("  ")
                    .append(repair.toString());
        }
        return sb.toString();
    }
}
