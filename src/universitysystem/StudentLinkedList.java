package universitysystem;

public class StudentLinkedList {

    // Node class
    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;

    // Add student
    public boolean addStudent(Student student) {

        // Check duplicate Student ID
        if (searchStudent(student.getStudentId()) != null) {
            return false;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        return true;
    }

    // Search student by ID
    public Student searchStudent(String studentId) {

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId().equals(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Update student
    public boolean updateStudent(String studentId, String name,
                                 String programme, double marks) {

        Student student = searchStudent(studentId);

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

        if (head == null) {
            return false;
        }

        // If first student needs to be deleted
        if (head.student.getStudentId().equals(studentId)) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId().equals(studentId)) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display all students
    public void displayAllStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Node current = head;

        System.out.println("\n===== ALL STUDENT RECORDS =====");

        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}