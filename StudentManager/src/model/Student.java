package model;

public class Student {
    private String student_ID;
    public String student_Name;
    private int semester;
    private String course_name;

    public Student(String student_ID, String student_Name, int semester, String course_name) {
        this.student_ID = student_ID;
        this.student_Name = student_Name;
        this.semester = semester;
        this.course_name = course_name;
    }

    public Student() {
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
