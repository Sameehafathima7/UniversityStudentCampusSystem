package universitysystem;

import java.util.HashMap;

public class StudentHashTable {

    private HashMap<String, Student> studentTable;

    // Constructor
    public StudentHashTable() {
        studentTable = new HashMap<>();
    }

    // Add student
    public boolean addStudent(Student student) {

        String studentId = student.getStudentId();

        // Check duplicate ID
        if (studentTable.containsKey(studentId)) {
            return false;
        }

        studentTable.put(studentId, student);
        return true;
    }

    // Search student using Student ID
    public Student searchStudent(String studentId) {

        return studentTable.get(studentId);
    }

    // Update student
    public boolean updateStudent(String studentId,
                                 String name,
                                 String programme,
                                 double marks) {

        Student student = studentTable.get(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        return true;
    }

    // Delete student
    public boolean deleteStudent(String studentId) {

        if (!studentTable.containsKey(studentId)) {
            return false;
        }

        studentTable.remove(studentId);
        return true;
    }

    // Display all students
    public void displayStudents() {

        if (studentTable.isEmpty()) {
            System.out.println("Hash table is empty.");
            return;
        }

        System.out.println("\n===== STUDENTS USING HASHING =====");

        for (Student student : studentTable.values()) {
            System.out.println(student);
        }
    }
}
