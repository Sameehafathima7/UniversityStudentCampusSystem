package universitysystem;

// Verified BST insertion, search and delete operations - Rahna
public class StudentBST {

    private class Node {

        Student student;
        Node left;
        Node right;

        Node(Student student) {

            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // =========================
    // ADD STUDENT TO BST
    // =========================

    public boolean addStudent(Student student) {

        if (root == null) {

            root = new Node(student);
            return true;
        }

        return insert(root, student);
    }

    private boolean insert(Node current, Student student) {

        int comparison = student.getStudentId()
                .compareTo(current.student.getStudentId());

        if (comparison == 0) {
            return false;
        }

        if (comparison < 0) {

            if (current.left == null) {

                current.left = new Node(student);
                return true;
            }

            return insert(current.left, student);

        } else {

            if (current.right == null) {

                current.right = new Node(student);
                return true;
            }

            return insert(current.right, student);
        }
    }

    // =========================
    // SEARCH STUDENT BY ID
    // =========================

    public Student searchStudent(String studentId) {

        Node current = root;

        while (current != null) {

            int comparison = studentId
                    .compareTo(current.student.getStudentId());

            if (comparison == 0) {
                return current.student;
            }

            if (comparison < 0) {

                current = current.left;

            } else {

                current = current.right;
            }
        }

        return null;
    }

    // =========================
    // DELETE STUDENT FROM BST
    // =========================

    public boolean deleteStudent(String studentId) {

        if (searchStudent(studentId) == null) {
            return false;
        }

        root = deleteNode(root, studentId);

        return true;
    }

    private Node deleteNode(Node current, String studentId) {

        if (current == null) {
            return null;
        }

        int comparison =
                studentId.compareTo(current.student.getStudentId());

        if (comparison < 0) {

            current.left =
                    deleteNode(current.left, studentId);

        } else if (comparison > 0) {

            current.right =
                    deleteNode(current.right, studentId);

        } else {

            // Case 1: No children
            if (current.left == null
                    && current.right == null) {

                return null;
            }

            // Case 2: Only right child
            if (current.left == null) {

                return current.right;
            }

            // Case 3: Only left child
            if (current.right == null) {

                return current.left;
            }

            // Case 4: Two children
            Node successor = findMinimum(current.right);

            current.student = successor.student;

            current.right =
                    deleteNode(
                            current.right,
                            successor.student.getStudentId());
        }

        return current;
    }

    // Find smallest node in right subtree

    private Node findMinimum(Node current) {

        while (current.left != null) {

            current = current.left;
        }

        return current;
    }

    // =========================
    // DISPLAY STUDENTS
    // =========================

    public void displayStudents() {

        if (root == null) {

            System.out.println("BST is empty.");
            return;
        }

        System.out.println(
                "\n===== STUDENTS USING BST =====");

        inorder(root);
    }

    // Inorder traversal

    private void inorder(Node current) {

        if (current != null) {

            inorder(current.left);

            System.out.println(current.student);

            inorder(current.right);
        }
    }
}