package L00_BasicJava;

public class Main {
    public static void main(String[] args) throws Exception {

        /*
            Example 1: Basic Java Programming
         */

//        Scanner sc = new Scanner(System.in); // Create a scanner object
//
//        System.out.println("What's your name? ");
//        String name = sc.nextLine();
//
//        System.out.println("What's your birthday? ");
//        int birthYear = Integer.parseInt(sc.nextLine());
//
//        System.out.println("Hello " + name + ". Your age is: " + (2026 - birthYear) + ". ");

        /*
            Example 2: Switch Statement
         */

//        double totalPrice = 5000;
//        double bonus = 0.1;
//        int day = 2;
//
//        switch (day) {
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//            case 5:
//                totalPrice = totalPrice * (1 - bonus);
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            case 7:
//                System.out.println("Sunday");
//                break;
//        }
//
//        System.out.println("Total Price = " + totalPrice);

        /*
            Example 3: Method
         */

//        sayHello("John", 2000);
//        sayHello("David");
//        sayHello("Lucy");
//
//    }
//
//    public static void sayHello(String name, int birthYear){
//        System.out.println("Hello " + name + ".");
//        if (birthYear != 0) {
//            System.out.println("Your age is: " + (2026 - birthYear));
//        }
//    }
//
//    public static void sayHello(String name){
//        System.out.println("Hello " + name + ".");
//    }

        Student student_1 = new Student("John", "john@fpt.edu.vn", 25);
        Student student_2 = new Student("David", "david@fpt.edu.vn");
    }
}

class Student {
    // attributes
    private String name;
    private String email;
    private int age;

    // constructors
    public Student(String name, String email, int age) throws Exception {
        this.name = name;
        this.email = email;
        setAge(age);
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }


    // helpers
    private void setAge(int age) throws Exception {
        if (age > 18) {
            this.age = age;
        } else {
            throw new Exception("Age is not valid.");
        }
    }
}
