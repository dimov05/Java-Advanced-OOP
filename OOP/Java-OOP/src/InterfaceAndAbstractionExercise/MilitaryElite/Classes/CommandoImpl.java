package InterfaceAndAbstractionExercise.MilitaryElite.Classes;

import InterfaceAndAbstractionExercise.MilitaryElite.Enums.Corp;
import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Commando;
import InterfaceAndAbstractionExercise.MilitaryElite.Interfaces.Mission;

import java.util.ArrayList;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append(this.getCorps())
                .append(System.lineSeparator()).append("Missions:");
        for (Mission mission: this.missions) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(mission.toString());
        }
        return sb.toString();
    }

    @Override
    public void addMission(Mission mission) {
        missions.add(mission);
    }
}
