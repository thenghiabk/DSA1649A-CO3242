package A01_ECIS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class User {
    // attributes
    private String name, telephone, email, role;

    // constructors
    public User(String name, String telephone, String email, String role){
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.role = role;
    }

    // helpers
    public String getRole(){
        return role;
    }

    public String displayInfo(){
        return "Name:" + name + ", Telephone: " + telephone + ", Email: " + email + ", Role: " + role;
    }
}

class Teacher extends User {
    // attributes
    private double salary;
    private String[] subjects = new String[2];

    // constructors
    public Teacher(String name, String telephone, String email, double salary, String subject1, String subject2){
        super(name, telephone, email, "Teacher");
        this.salary = salary;
        subjects[0] = subject1;
        subjects[1] = subject2;
    }

    // helpers
    @Override
    public String displayInfo(){
        return super.displayInfo() + ", Salary: " + salary + ", Subject 1: " + subjects[0] + ", Subject 2: " + subjects[1];
    }
}

class Administrator extends User {
    // attributes
    private double salary;
    private boolean isFullTime;
    private int workingHours;

    // constructors
    public Administrator(String name, String telephone, String email, double salary, boolean isFullTime, int workingHours){
        super(name, telephone, email, "Admin");
        this.salary = salary;
        this.isFullTime = isFullTime;
        this.workingHours = workingHours;
    }

    // helpers
    @Override
    public String displayInfo(){
        return super.displayInfo() + ", Salary: " + salary + ", FullTime: " + isFullTime + ", Working Hours: " + workingHours;
    }
}

class Student extends User {
    // attributes
    private String[] subjects = new String[3];

    // constructors
    public Student(String name, String telephone, String email, String subject1, String subject2, String subject3){
        super(name, telephone, email, "Student");
        this.subjects[0] = subject1;
        this.subjects[1] = subject2;
        this.subjects[2] = subject3;
    }

    // helpers
    @Override
    public String displayInfo(){
        return super.displayInfo() +  ", Subject 1: " + subjects[0] + ", Subject 2: " + subjects[1] + ", Subject 3: " + subjects[2];
    }
}

class EducationCentre {
    // attributes
    private List<User> users;

    // constructors
    public EducationCentre(){
        users = new ArrayList<>();
//        users = new LinkedList<>();
    }

    // helpers
    public void addUser(User user){
        users.add(user);
    }

    public void displayAllUsers() {
        for (int i = 0; i < users.size(); i++){
            User user = users.get(i);
            String userInfo = user.displayInfo();
            System.out.println(userInfo);
        }
    }

    public void displayUserByGroup(String role){
        for (int i = 0; i < users.size(); i++){
            User user = users.get(i);
            if (user.getRole().equalsIgnoreCase(role)){
                String userInfo = user.displayInfo();
                System.out.println(userInfo);
            }
        }
    }
}

// Client
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        EducationCentre myCentre = new EducationCentre();

        // create initial users
        User u1 = new Teacher("John", "000", "john@fpt.com", 5000, "Math", "English");
        User u2 = new Administrator("David", "999", "david@fpt.com", 7000, true, 8);
        User u3 = new Student("Lucy", "777", "lucy@fpt.edu.vn", "Math", "English", "Phys");

        // add users to collection
        myCentre.addUser(u1);
        myCentre.addUser(u2);
        myCentre.addUser(u3);

        runMainLoop(myCentre);

        sc.close();
    }

    private static void runMainLoop(EducationCentre myCentre) {
        boolean running = true;

        while (running) {
            showMenu();
            String userChoice = sc.nextLine().trim();

            switch (userChoice) {
                case "1": // add new user
                    handleAddUser(myCentre);
                    break;
                case "2": // view all users
                    myCentre.displayAllUsers();
                    break;
                case "3": // view by group
                    handleViewByGroup(myCentre);
                    break;
                case "4": // edit user
                    System.out.println("Edit user feature not yet implemented.");
                    break;
                case "5": // delete user
                    System.out.println("Delete user feature not yet implemented.");
                    break;
                case "6": // exit
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private static void handleAddUser(EducationCentre myCentre) {
        System.out.println("Enter user's name:");
        String name = sc.nextLine();
        System.out.println("Enter user's telephone:");
        String telephone = sc.nextLine();
        System.out.println("Enter user's email:");
        String email = sc.nextLine();

        System.out.println("Enter user's role (Teacher/Admin/Student):");
        String role = sc.nextLine();

        User newUser = null;

        if (role.equalsIgnoreCase("Teacher")) {
            newUser = createTeacher(name, telephone, email);
        } else if (role.equalsIgnoreCase("Admin")) {
            newUser = createAdministrator(name, telephone, email);
        } else if (role.equalsIgnoreCase("Student")) {
            newUser = createStudent(name, telephone, email);
        } else {
            System.out.println("Invalid role. User not added.");
            return;
        }

        myCentre.addUser(newUser);
        System.out.println("User added successfully!");
    }

    private static Teacher createTeacher(String name, String telephone, String email) {
        System.out.println("Enter user's salary:");
        double salary = Double.parseDouble(sc.nextLine());
        System.out.println("Enter subject 1:");
        String subject1 = sc.nextLine();
        System.out.println("Enter subject 2:");
        String subject2 = sc.nextLine();

        return new Teacher(name, telephone, email, salary, subject1, subject2);
    }

    private static Administrator createAdministrator(String name, String telephone, String email) {
        System.out.println("Enter user's salary:");
        double salary = Double.parseDouble(sc.nextLine());
        System.out.println("Is a fulltime worker? (yes/no):");
        String fulltime = sc.nextLine();
        boolean isFullTime = fulltime.equalsIgnoreCase("yes");

        System.out.println("Enter working hours:");
        int workingHours = Integer.parseInt(sc.nextLine());

        return new Administrator(name, telephone, email, salary, isFullTime, workingHours);
    }

    private static Student createStudent(String name, String telephone, String email) {
        System.out.println("Enter subject 1:");
        String subject1 = sc.nextLine();
        System.out.println("Enter subject 2:");
        String subject2 = sc.nextLine();
        System.out.println("Enter subject 3:");
        String subject3 = sc.nextLine();

        return new Student(name, telephone, email, subject1, subject2, subject3);
    }

    private static void handleViewByGroup(EducationCentre myCentre) {
        System.out.println("Enter role to filter (Teacher/Admin/Student):");
        String userRole = sc.nextLine();
        myCentre.displayUserByGroup(userRole);
    }

    private static void showMenu() {
        System.out.println("=== Education Centre Management System ===");
        System.out.println("1. Add New User");
        System.out.println("2. View All Users");
        System.out.println("3. View Users by Group");
        System.out.println("4. Edit User");
        System.out.println("5. Delete User");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
}
