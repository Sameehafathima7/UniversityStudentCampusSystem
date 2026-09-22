package universitysystem;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static StudentLinkedList studentList = new StudentLinkedList();
    static ActionStack actionStack = new ActionStack();
    static ServiceQueue serviceQueue = new ServiceQueue();
    static StudentBST studentBST = new StudentBST();
    static StudentHashTable hashTable = new StudentHashTable();
    static CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {

        int choice;

        do {

            displayMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    addServiceRequest();
                    break;

                case 6:
                    processServiceRequest();
                    break;

                case 7:
                    actionStack.displayActions();
                    break;

                case 8:
                    studentBST.displayStudents();
                    break;

                case 9:
                    searchStudentUsingHashing();
                    break;

                case 10:
                    addCampusLocation();
                    break;

                case 11:
                    removeCampusLocation();
                    break;

                case 12:
                    addCampusConnection();
                    break;

                case 13:
                    removeCampusConnection();
                    break;

                case 14:
                    campusGraph.displayConnections();
                    break;

                case 15:
                    traverseCampus();
                    break;

                case 16:
                    System.out.println("\nThank you for using the system.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please enter 1-16.");
            }

        } while (choice != 16);

        scanner.close();
    }

    // =========================
    // DISPLAY MENU
    // =========================

    public static void displayMenu() {

        System.out.println("\n==============================================");
        System.out.println(" UNIVERSITY STUDENT & CAMPUS ROUTE SYSTEM");
        System.out.println("==============================================");

        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST/AVL");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS");
        System.out.println("16. Exit");

        System.out.println("==============================================");
    }

    // =========================
    // ADD STUDENT
    // =========================

    public static void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        String studentId = readText("Enter Student ID: ");

        if (studentList.searchStudent(studentId) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        String name = readText("Enter Name: ");
        String programme = readText("Enter Programme: ");

        double marks = readMarks();

        Student student =
                new Student(studentId, name, programme, marks);

        studentList.addStudent(student);
        studentBST.addStudent(student);
        hashTable.addStudent(student);

        actionStack.pushAction(
                "Added Student: " + studentId);

        System.out.println("Student added successfully.");
    }

    // =========================
    // UPDATE STUDENT
    // =========================

    public static void updateStudent() {

        System.out.println("\n===== UPDATE STUDENT =====");

        String studentId = readText("Enter Student ID: ");

        Student student = studentList.searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = readText("Enter new Name: ");
        String programme = readText("Enter new Programme: ");

        double marks = readMarks();

        studentList.updateStudent(
                studentId, name, programme, marks);

        hashTable.updateStudent(
                studentId, name, programme, marks);

        actionStack.pushAction(
                "Updated Student: " + studentId);

        System.out.println("Student updated successfully.");
    }

    // =========================
    // DELETE STUDENT
    // =========================

    public static void deleteStudent() {

        System.out.println("\n===== DELETE STUDENT =====");

        String studentId = readText("Enter Student ID: ");

        Student student = studentList.searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        studentList.deleteStudent(studentId);

        // Delete student from BST also
        studentBST.deleteStudent(studentId);

        hashTable.deleteStudent(studentId);

        actionStack.pushAction(
                "Deleted Student: " + studentId);

        System.out.println("Student deleted successfully.");
    }

    // =========================
    // ADD SERVICE REQUEST
    // =========================

    public static void addServiceRequest() {

        System.out.println("\n===== ADD SERVICE REQUEST =====");

        String request =
                readText("Enter service request: ");

        serviceQueue.addRequest(request);

        actionStack.pushAction(
                "Added service request");
    }

    // =========================
    // PROCESS SERVICE REQUEST
    // =========================

    public static void processServiceRequest() {

        System.out.println("\n===== PROCESS SERVICE REQUEST =====");

        String request =
                serviceQueue.processNextRequest();

        if (request == null) {

            System.out.println("No pending service requests.");

        } else {

            System.out.println("Processed request: " + request);

            actionStack.pushAction(
                    "Processed service request");
        }
    }

    // =========================
    // HASHING SEARCH
    // =========================

    public static void searchStudentUsingHashing() {

        System.out.println("\n===== SEARCH USING HASHING =====");

        String studentId =
                readText("Enter Student ID: ");

        Student student =
                hashTable.searchStudent(studentId);

        if (student == null) {

            System.out.println("Student not found.");

        } else {

            System.out.println("Student found:");
            System.out.println(student);
        }
    }

    // =========================
    // ADD CAMPUS LOCATION
    // =========================

    public static void addCampusLocation() {

        System.out.println("\n===== ADD CAMPUS LOCATION =====");

        String location =
                readText("Enter campus location: ");

        boolean added =
                campusGraph.addLocation(location);

        if (added) {

            System.out.println(
                    "Campus location added successfully.");

            actionStack.pushAction(
                    "Added campus location: " + location);

        } else {

            System.out.println(
                    "Error: Location already exists.");
        }
    }

    // =========================
    // REMOVE CAMPUS LOCATION
    // =========================

    public static void removeCampusLocation() {

        System.out.println("\n===== REMOVE CAMPUS LOCATION =====");

        String location =
                readText("Enter campus location: ");

        boolean removed =
                campusGraph.removeLocation(location);

        if (removed) {

            System.out.println(
                    "Campus location removed successfully.");

            actionStack.pushAction(
                    "Removed campus location: " + location);

        } else {

            System.out.println(
                    "Location not found.");
        }
    }

    // =========================
    // ADD CAMPUS CONNECTION
    // =========================

    public static void addCampusConnection() {

        System.out.println("\n===== ADD CAMPUS CONNECTION =====");

        String location1 =
                readText("Enter first location: ");

        String location2 =
                readText("Enter second location: ");

        boolean added =
                campusGraph.addConnection(
                        location1, location2);

        if (added) {

            System.out.println(
                    "Campus connection added successfully.");

            actionStack.pushAction(
                    "Added connection: "
                    + location1 + " - " + location2);

        } else {

            System.out.println(
                    "Unable to add connection.");
        }
    }

    // =========================
    // REMOVE CAMPUS CONNECTION
    // =========================

    public static void removeCampusConnection() {

        System.out.println("\n===== REMOVE CAMPUS CONNECTION =====");

        String location1 =
                readText("Enter first location: ");

        String location2 =
                readText("Enter second location: ");

        boolean removed =
                campusGraph.removeConnection(
                        location1, location2);

        if (removed) {

            System.out.println(
                    "Campus connection removed successfully.");

            actionStack.pushAction(
                    "Removed connection: "
                    + location1 + " - " + location2);

        } else {

            System.out.println(
                    "Connection not found.");
        }
    }

    // =========================
    // BFS TRAVERSAL
    // =========================

    public static void traverseCampus() {

        System.out.println("\n===== BFS CAMPUS TRAVERSAL =====");

        String startLocation =
                readText("Enter starting location: ");

        campusGraph.bfs(startLocation);
    }

    // =========================
    // INPUT VALIDATION
    // =========================

    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(
                        scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number.");
            }
        }
    }

    public static double readMarks() {

        while (true) {

            System.out.print("Enter Marks (0-100): ");

            try {

                double marks =
                        Double.parseDouble(
                                scanner.nextLine());

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println(
                        "Marks must be between 0 and 100.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid marks. Please enter a number.");
            }
        }
    }

    public static String readText(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty.");
        }
    }
}


