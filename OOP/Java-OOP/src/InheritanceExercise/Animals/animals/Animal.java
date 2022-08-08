package InheritanceExercise.Animals.animals;

public class Animal {
    private String name;
    private int age;
    private Gender gender;

    public String getGender() {
        return this.gender.getAsString();
    }

    public String produceSound(){
        return "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(name + " " + age + " " + gender.getAsString());
        sb.append(System.lineSeparator());
        sb.append(this.produceSound());
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Animal(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
