package InheritanceExercise.Animals.animals;

public class Tomcat extends Cat {
    public Tomcat(String name, int age){
        super(name, age, Gender.MALE);
    }

    public String produceSound(){
        return "MEOW";
    }
}
