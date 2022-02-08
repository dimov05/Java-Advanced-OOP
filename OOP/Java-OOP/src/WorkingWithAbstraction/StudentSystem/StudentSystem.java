package WorkingWithAbstraction.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void setRepo(Map<String, Student> repo) {
        this.repo = repo;
    }

    public void Create(Student student) {
        this.repo.put(student.getName(), student);
    }

    public void Show(String name) {
        String typeStudent;
        Student currentStudent = repo.get(name);
        if (currentStudent.getGrade() >= 5.00) {
            typeStudent = "Excellent student.";
        } else if (currentStudent.getGrade() < 5.00 && currentStudent.getGrade() >= 3.50) {
            typeStudent = "Average student.";
        } else {
            typeStudent = "Very nice person.";
        }
        System.out.printf("%s is %d years old. %s%n",
                currentStudent.getName(), currentStudent.getAge(), typeStudent);
    }
}
