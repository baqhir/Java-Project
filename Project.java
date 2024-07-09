import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String email;
    private String className;
    private String rollNumber;

    public Student(String name, int age, String email, String className, String rollNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.className = className;
        this.rollNumber = rollNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email + ", Class: " + className + ", Roll Number: " + rollNumber;
    }
}

public class SchoolSystemManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Enter student details:");

                String name;
                while (true) {
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    if (isValidName(name)) {
                        break;
                    } else {
                        System.out.println("Invalid name. Please enter a valid name with alphabetic characters only.");
                    }
                }

                int age;
                while (true) {
                    try {
                        System.out.print("Age: ");
                        age = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age. Please enter a valid number.");
                    }
                }

                String email;
                while (true) {
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    if (isValidEmail(email)) {
                        break;
                    } else {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                }

                System.out.print("Class: ");
                String className = scanner.nextLine();

                System.out.print("Roll Number: ");
                String rollNumber = scanner.nextLine();

                students.add(new Student(name, age, email, className, rollNumber));
                System.out.println("Student details got uploaded successfully.");

                System.out.print("Do you want to add another student? (yes/no): ");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("no")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        try {
            System.out.print("Enter roll number to retrieve student details: ");
            String rollNumber = scanner.nextLine();
            Student student = findStudentByRollNumber(students, rollNumber);

            if (student != null) {
                System.out.println("Student Details: " + student);
            } else {
                System.out.println("No student found with roll number: " + rollNumber);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving student details: " + e.getMessage());
        }

        scanner.close();
    }

    private static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    private static Student findStudentByRollNumber(List<Student> students, String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }
}
