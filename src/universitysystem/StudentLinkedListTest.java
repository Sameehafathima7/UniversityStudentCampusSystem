package universitysystem;

public class StudentLinkedListTest {

    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        // Add students
        Student s1 = new Student("23DA2-001", "Kamal", "BAIT", 75);
        Student s2 = new Student("23DA2-002", "Aisha", "BAIT", 82);
        Student s3 = new Student("23DA2-003", "Ahmed", "BSc IT", 68);

        System.out.println("Adding students...");

        System.out.println("Student 1 added: "
                + list.addStudent(s1));

        System.out.println("Student 2 added: "
                + list.addStudent(s2));

        System.out.println("Student 3 added: "
                + list.addStudent(s3));

        // Display
        list.displayAllStudents();

        // Search
        System.out.println("\n===== SEARCH STUDENT =====");

        Student found = list.searchStudent("23DA2-002");

        if (found != null) {
            System.out.println("Student found:");
            System.out.println(found);
        } else {
            System.out.println("Student not found.");
        }

        // Update
        System.out.println("\n===== UPDATE STUDENT =====");

        boolean updated = list.updateStudent(
                "23DA2-002",
                "Aisha",
                "BAIT",
                90
        );

        System.out.println("Update successful: " + updated);

        // Display after update
        list.displayAllStudents();

        // Delete
        System.out.println("\n===== DELETE STUDENT =====");

        boolean deleted = list.deleteStudent("23DA2-003");

        System.out.println("Delete successful: " + deleted);

        // Final display
        list.displayAllStudents();
    }
}