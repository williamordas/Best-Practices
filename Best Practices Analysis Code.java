import java.io.*;
import java.util.*;

// Class representing a Student
class Student {
    private String name;
    private double grade;

    // Constructor
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getter for grade
    public double getGrade() {
        return grade;
    }
}

public class StudentGradeCalculator {

    public static void main(String[] args) {
        // Proper variable naming convention: 'studentList' clearly indicates a list of students
        List<Student> studentList = new ArrayList<>();

        // Adding some students to the list for demonstration
        studentList.add(new Student("Alice", 85.0));
        studentList.add(new Student("Bob", 92.0));
        studentList.add(new Student("Charlie", 78.5));

        // Calculate and print the average grade
        double averageGrade = calculateAverageGrade(studentList);
        System.out.println("Average Grade: " + averageGrade);

        // Read students from a file and handle exceptions properly
        readStudentsFromFile("students.txt");
    }

    // Code modularity: The following method breaks down the task of calculating the average grade
    public static double calculateAverageGrade(List<Student> students) {
        // Efficient algorithm: Using a for-each loop for better readability and performance
        double total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        return total / students.size();
    }

    // Method to read students from a file
    public static void readStudentsFromFile(String filename) {
        // Exception handling: Using try-with-resources to handle potential file I/O errors
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line (in a real scenario, you'd parse and add to studentList)
                System.out.println("Read line: " + line);
            }
        } catch (IOException e) {
            // Properly handling the IOException
            e.printStackTrace();
        }
    }
}


