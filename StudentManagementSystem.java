import java.util.ArrayList;
import java.util.Scanner;

// Abstract Class - Person (Abstraction)
abstract class Person {
    private String name;
    private int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Encapsulation: Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract Method
    public abstract void displayDetails();
}

// Student Class (Inheritance)
class Student extends Person {
    // Constructor
    public Student(String name, int id) {
        super(name, id);
    }

    // Polymorphism: Overriding the displayDetails method
    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + getId() + ", Name: " + getName());
    }
}

// Main Class
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>(); // List to store students

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter Student Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    students.add(new Student(name, id));
                    System.out.println("Student added: " + name);
                    break;

                case 2:
                    // View All Students
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("List of Students:");
                        for (Student student : students) {
                            student.displayDetails(); // Polymorphism in action
                        }
                    }
                    break;

                case 3:
                    // Remove Student
                    System.out.print("Enter Student ID to Remove: ");
                    int removeId = scanner.nextInt();
                    boolean found = false;
                    for (Student student : students) {
                        if (student.getId() == removeId) {
                            students.remove(student);
                            System.out.println("Student removed: " + student.getName());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
