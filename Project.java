import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String email;
    private String className;

    public Student(String name, int age, String email, String className) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.className = className;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email + ", Class: " + className;
    }
}

public class SchoolSystemManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Enter student details:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Class: ");
            String className = scanner.nextLine();

            students.add(new Student(name, age, email, className));

            System.out.print("Do you want to add another student? (yes/no): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("\nCollected Student Data:");
        for (Student student : students) {
            System.out.println(student);
        }
        
        scanner.close();
    }
}
