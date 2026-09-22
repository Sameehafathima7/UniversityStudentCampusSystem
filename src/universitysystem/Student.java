package universitysystem;

public class Student {

    private String studentId;
    private String name;
    private String programme;
    private double marks;

    // Constructor
    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    // Get Student ID
    public String getStudentId() {
        return studentId;
    }

    // Get Name
    public String getName() {
        return name;
    }

    // Get Programme
    public String getProgramme() {
        return programme;
    }

    // Get Marks
    public double getMarks() {
        return marks;
    }

    // Set Name
    public void setName(String name) {
        this.name = name;
    }

    // Set Programme
    public void setProgramme(String programme) {
        this.programme = programme;
    }

    // Set Marks
    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display student details
    @Override
    public String toString() {
        return "Student ID: " + studentId
                + ", Name: " + name
                + ", Programme: " + programme
                + ", Marks: " + marks;
    }
}

