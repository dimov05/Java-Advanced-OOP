package InheritanceExercise.Animals.animals;

public class Cat extends Animal{
    public Cat(String name, int age, Gender gender){
        super(name, age, gender);
    }
    public String produceSound(){
        return "Meow meow";
    }
}
