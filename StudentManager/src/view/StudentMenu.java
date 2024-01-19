package view;

import controller.CheckInput;
import controller.Controller;
import model.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentMenu extends Menu {
    static String [] mc =
            {
"Create" , "Find/Sort", "Update/Delete", "Report", "Exit"
            };
    protected Controller controller;
    public StudentMenu(){
        super("STUDENT MANAGE", mc);
        controller = new Controller();
    }
    @Override
    public void execute(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case 1:{
                System.out.print("Enter Student ID: ");
                String id = CheckInput.checkInputString();
                System.out.print("Enter name: ");
                String name = CheckInput.checkInputString();
                System.out.print("Enter semester: ");
                int semester = CheckInput.checkInputLimit(1, 10);
                System.out.print("Enter course: ");
                String course = CheckInput.checkInputString();
                controller.createStudent(id,name,semester,course);
                System.out.println("Successful");
                break;
            }
            case 2:{
                System.out.print("Enter search name: ");
                String keyword = scanner.nextLine();
                List<Student> foundStudents = controller.findStudentsByName(keyword);
                Collections.sort(foundStudents, Comparator.comparing(Student::getStudent_Name));
                controller.printStudentList(foundStudents);
                break;
            }
            case 3:{
                System.out.print("Enter student ID: ");
                String studentId = scanner.nextLine();
                System.out.print("1. Update student name\n2. Delete student\nEnter your choice: ");
                int option = scanner.nextInt();
                scanner.nextLine();
                if (option == 1) {
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    controller.updateStudentName(studentId, newName);
                } else if (option == 2) {
                    controller.deleteStudent(studentId);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
                break;

            }
            case 4:{
                List<String> report = controller.generateReport();
                controller.printReport(report);
                break;
            }
            case 5:{
                System.exit(0);
            }
        }
    }
}
