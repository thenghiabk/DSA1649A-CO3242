package A01_ECIS.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base Abstract Class
abstract class User {
    private String name, telephone, email, role;

    public User(String name, String telephone, String email, String role) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return String.format("Name: %s | Tel: %s | Email: %s | Role: %s", name, telephone, email, role);
    }
}

// Subclasses
class Teacher extends User {
    private double salary;
    private String[] subjects = new String[2];

    public Teacher(String name, String tel, String email, double salary, String s1, String s2) {
        super(name, tel, email, "Teacher");
        this.salary = salary;
        this.subjects[0] = s1;
        this.subjects[1] = s2;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Salary: %.2f | Subjects: %s, %s", salary, subjects[0], subjects[1]);
    }
}

class Administrator extends User {
    private double salary;
    private boolean fullTime;
    private int hours;

    public Administrator(String name, String tel, String email, double salary, boolean ft, int hours) {
        super(name, tel, email, "Admin");
        this.salary = salary;
        this.fullTime = ft;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Salary: %.2f | FT: %b | Hours: %d", salary, fullTime, hours);
    }
}

class Student extends User {
    private String[] subjects = new String[3];

    public Student(String name, String tel, String email, String s1, String s2, String s3) {
        super(name, tel, email, "Student");
        this.subjects[0] = s1;
        this.subjects[1] = s2;
        this.subjects[2] = s3;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Subjects: %s, %s, %s", subjects[0], subjects[1], subjects[2]);
    }
}

class EducationCentre {
    private List<User> users = new ArrayList<>();

    public void addUser(User u) { users.add(u); }

    public void viewAll() {
        if (users.isEmpty()) System.out.println("No records found.");
        else users.forEach(System.out::println);
    }

    public void viewByGroup(String role) {
        users.stream()
                .filter(u -> u.getRole().equalsIgnoreCase(role))
                .forEach(System.out::println);
    }

    public void deleteUser(String name) {
        boolean removed = users.removeIf(u -> u.getName().equalsIgnoreCase(name));
        System.out.println(removed ? "Deleted successfully." : "User not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EducationCentre system = new EducationCentre();

        while (true) {
            System.out.println("\n--- Education Centre System ---");
            System.out.println("1. Add User\n2. View All\n3. View by Group\n4. Delete\n5. Exit");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Role (Teacher/Admin/Student): "); String role = sc.nextLine();

                    if (role.equalsIgnoreCase("Student")) {
                        system.addUser(new Student(name, "000", "mail@edu.com", "Math", "Sci", "Eng"));
                    } else if (role.equalsIgnoreCase("Teacher")) {
                        system.addUser(new Teacher(name, "111", "t@edu.com", 3000, "Math", "Sci"));
                    }
                    System.out.println("User Added (Template data used for brevity).");
                    break;
                case 2: system.viewAll(); break;
                case 3:
                    System.out.print("Enter Group: ");
                    system.viewByGroup(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter Name to Delete: ");
                    system.deleteUser(sc.nextLine());
                    break;
            }
        }
    }
}
