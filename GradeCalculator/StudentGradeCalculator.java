import java.util.*;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String studentId = scanner.nextLine();

            System.out.print("Enter number of grades: ");
            int numGrades = scanner.nextInt();
            scanner.nextLine();

            double[] grades = new double[numGrades];
            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                grades[j] = scanner.nextDouble();
            }
            scanner.nextLine(); // consume newline

            students.add(new Student(name, studentId, grades));
        }

        // Display individual student info
        System.out.println("\n--- Student Grades ---");
        for (Student s : students) {
            s.displayGrades();
            System.out.println("Average: " + s.calculateAverage());
            System.out.println("Status: " + (s.hasPassed() ? "Passed" : "Failed"));
            System.out.println("-----------------------------");
        }

        // Calculate class average
        double total = 0;
        for (Student s : students) {
            total += s.calculateAverage();
        }
        double classAverage = total / students.size();
        System.out.println("Class Average: " + classAverage);

        scanner.close();
    }
}

// ------------------ Student Class ------------------
class Student {
    private String name;
    private String studentId;
    private double[] grades;

    public Student(String name, String studentId, double[] grades) {
        this.name = name;
        this.studentId = studentId;
        this.grades = grades;
    }

    // Calculate average grade
    public double calculateAverage() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return grades.length > 0 ? sum / grades.length : 0;
    }

    // Display individual grades
    public void displayGrades() {
        System.out.println("Student: " + name + " (ID: " + studentId + ")");
        System.out.print("Grades: ");
        for (double g : grades) {
            System.out.print(g + " ");
        }
        System.out.println();
    }

    // Determine pass/fail (pass if average >= 40)
    public boolean hasPassed() {
        return calculateAverage() >= 40;
    }
}
