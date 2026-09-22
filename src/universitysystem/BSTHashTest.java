package universitysystem;

public class BSTHashTest {

    public static void main(String[] args) {

        // Create students
        Student s1 = new Student("23DA2-001", "Kamal", "BAIT", 75);
        Student s2 = new Student("23DA2-002", "Aisha", "BAIT", 82);
        Student s3 = new Student("23DA2-003", "Ahmed", "BSc IT", 68);

        // =========================
        // BST TEST
        // =========================

        StudentBST bst = new StudentBST();

        System.out.println("===== BST TEST =====");

        System.out.println("Student 1 added: " + bst.addStudent(s1));
        System.out.println("Student 2 added: " + bst.addStudent(s2));
        System.out.println("Student 3 added: " + bst.addStudent(s3));

        bst.displayStudents();

        System.out.println("\nSearching BST for 23DA2-002...");

        Student bstFound = bst.searchStudent("23DA2-002");

        if (bstFound != null) {
            System.out.println("Student found:");
            System.out.println(bstFound);
        } else {
            System.out.println("Student not found.");
        }

        // =========================
        // HASHING TEST
        // =========================

        StudentHashTable hashTable = new StudentHashTable();

        System.out.println("\n===== HASHING TEST =====");

        System.out.println("Student 1 added: "
                + hashTable.addStudent(s1));

        System.out.println("Student 2 added: "
                + hashTable.addStudent(s2));

        System.out.println("Student 3 added: "
                + hashTable.addStudent(s3));

        hashTable.displayStudents();

        System.out.println("\nSearching Hash Table for 23DA2-003...");

        Student hashFound = hashTable.searchStudent("23DA2-003");

        if (hashFound != null) {
            System.out.println("Student found:");
            System.out.println(hashFound);
        } else {
            System.out.println("Student not found.");
        }
    }
}
