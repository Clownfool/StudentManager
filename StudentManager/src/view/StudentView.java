package view;
import model.Student;
import java.util.List;

public class StudentView {
    public void printStudentDetails(Student student) {
        System.out.println("Student Details:");
        System.out.println(student);
    }

    public void printStudentList(List<Student> students) {
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void printReport(List<String> report) {
        System.out.println("Student Report:");
        System.out.println("Student name\t\tCourse\t\tTotal of Course");

        for (String line : report) {
            System.out.println(line);
        }
    }
}
