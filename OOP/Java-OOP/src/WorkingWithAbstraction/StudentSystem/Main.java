package WorkingWithAbstraction.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Exit")) {
                break;
            }

            if (input[0].equals("Create")) {
                String name = input[1];
                int age = Integer.parseInt(input[2]);
                double grade = Double.parseDouble(input[3]);
                Student student = new Student(name, age, grade);
                if (!studentSystem.getRepo().containsKey(name)) {
                    studentSystem.Create(student);
                }
            } else if (input[0].equals("Show")) {
                studentSystem.Show(input[1]);
            }
        }
    }
}
