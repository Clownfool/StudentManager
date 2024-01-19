package controller;

import model.Student;
import view.StudentView;
import model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.CheckInput;

public class Controller {
    private List<Student> students;
    private StudentView studentView;
    public Controller() {
        students = new ArrayList<>();
        studentView = new StudentView();
    }
    public void createStudent(String id, String name, int semester, String course) {
        Student student = new Student(id, name, semester, course);
        students.add(student);
    }
    public List<Student> findStudentsByName(String searchName) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getStudent_Name().toLowerCase().contains(searchName.toLowerCase())) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }
    public void updateStudentName(String id, String newName) {
        for (Student student : students) {
            if (student.getStudent_ID().equals(id)) {
                student.student_Name = newName;
                break;
            }
        }
    }
    public void deleteStudent(String id) {
        Student foundStudent = null;
        for (Student student : students) {
            if (student.getStudent_ID().equals(id)) {
                foundStudent = student;
                break;
            }
        }
        if (foundStudent != null) {
            students.remove(foundStudent);
        }
    }
    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        List<String> processedStudents = new ArrayList<>();

        for (Student student : students) {
            String studentKey = student.getStudent_Name() + "|" + student.getCourse_name();
            if (!processedStudents.contains(studentKey)) {
                int totalCourses = Collections.frequency(students, student);
                String line = student.getStudent_Name() + "\t\t" + student.getCourse_name() + "\t\t" + totalCourses;
                report.add(line);
                processedStudents.add(studentKey);
            }
        }

        return report;
    }
    public void printStudentList(List<Student> students) {
        studentView.printStudentList(students);
    }

    public void printReport(List<String> report) {
        studentView.printReport(report);
    }
}
