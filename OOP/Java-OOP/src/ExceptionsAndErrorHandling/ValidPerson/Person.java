package ExceptionsAndErrorHandling.ValidPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        if (firstName.isBlank() || firstName == null) {
            throw new IllegalArgumentException("The first name cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (firstName.isBlank() || lastName == null) {
            throw new IllegalArgumentException("The last name cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age not in range 0-120");
        }
    }
}
