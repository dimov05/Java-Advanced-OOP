package Encapsulation.SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;
    private final DecimalFormat format = new DecimalFormat("#.0#####");

    public Person(String firstName,String lastName, int age, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return String.format("%s %s gets %s leva",
                this.firstName, this.lastName, this.format.format(this.getSalary()));
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void increaseSalary(double bonus){
        if(this.getAge() < 30){
            bonus = bonus/2;
        }
        this.setSalary(this.getSalary() * ((100+bonus) / 100));
    }
}
