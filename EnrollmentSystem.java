import java.util.Scanner;

class Course {
    private int courseID;
    private String courseName;
    private int credits;

    public Course(int courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID + ", Course Name: " + courseName + ", Credits: " + credits;
    }
}

class Enrollment {
    private int[][] studentCourses;
    private int[] count;

    public Enrollment(int numStudents, int maxCoursesPerStudent) {
        studentCourses = new int[numStudents][maxCoursesPerStudent];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseID) {
        if (count[studentID] < studentCourses[studentID].length) {
            studentCourses[studentID][count[studentID]] = courseID;
            count[studentID]++;
            System.out.println("Student " + studentID + " enrolled in course " + courseID);
        } else {
            System.out.println("Student " + studentID + " can't enroll in more courses.");
        }
    }

    public void drop(int studentID, int courseID) {
        boolean found = false;
        for (int i = 0; i < count[studentID]; i++) {
            if (studentCourses[studentID][i] == courseID) {
                studentCourses[studentID][i] = studentCourses[studentID][count[studentID] - 1];
                count[studentID]--;
                found = true;
                System.out.println("Student " + studentID + " dropped course " + courseID);
                break;
            }
        }
        if (!found) {
            System.out.println("Student " + studentID + " is not enrolled in course " + courseID);
        }
    }

    public void getEnrolledCourses(int studentID, Course[] courseCatalog) {
        System.out.println("Courses enrolled by student " + studentID + ":");
        for (int i = 0; i < count[studentID]; i++) {
            for (Course course : courseCatalog) {
                if (course.getCourseID() == studentCourses[studentID][i]) {
                    System.out.println(course);
                    break;
                }
            }
        }
    }
}

public class EnrollmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Course[] courseCatalog = {
                new Course(1, "Maths", 3),
                new Course(2, "Phy", 4),
                new Course(3, "Chem", 4),
                new Course(4, "CS", 3)
        };

        Enrollment e = new Enrollment(100, 10);

        while (true) {
            System.out.println("Enter 1 to Enroll Student");
            System.out.println("Enter 2 to Drop Course");
            System.out.println("Enter 3 to View Enrolled Courses");
            System.out.println("Enter 4 to Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseID = sc.nextInt();
                    e.enroll(studentID, courseID);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    courseID = sc.nextInt();
                    e.drop(studentID, courseID);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    e.getEnrolledCourses(studentID, courseCatalog);
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
