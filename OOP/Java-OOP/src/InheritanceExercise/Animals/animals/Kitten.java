package InheritanceExercise.Animals.animals;

public class Kitten extends Cat{
    public Kitten(String name, int age){
        super(name, age, Gender.FEMALE);
    }

    public String produceSound(){
        return "Meow";
    }
}
