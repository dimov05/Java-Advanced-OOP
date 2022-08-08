package InheritanceExercise.Animals.animals;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String asString;

    public String getAsString() {
        return asString;
    }

    private Gender (String asString){
        this.asString = asString;
    }
}
