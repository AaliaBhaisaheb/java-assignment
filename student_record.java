import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int studentID;
    private String name;
    private int age;
    private String department;

    public Student(int studentID, String name, int age, String department) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class StudentRecordSystem {
    private List<Student> students;

    public StudentRecordSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public Student getStudent(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class student_record {
    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to Add student");
            System.out.println("Enter 2 to view student");
            System.out.println("Enter 3 to view all students");
            System.out.println("Enter 4 to exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.println("Enter student id");
                    int studentId = sc.nextInt();
                    sc.nextLine(); // Clear the buffer
                    System.out.println("Enter the name:");
                    String name = sc.nextLine();
                    System.out.println("Enter the age");
                    int age = sc.nextInt();
                    sc.nextLine(); // Clear the buffer
                    System.out.println("Enter the department");
                    String department = sc.nextLine();
                    Student s = new Student(studentId, name, age, department);
                    system.addStudent(s);
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    Student retrievedStudent = system.getStudent(id);
                    if (retrievedStudent != null) {
                        System.out.println(retrievedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    system.displayAllStudents();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
