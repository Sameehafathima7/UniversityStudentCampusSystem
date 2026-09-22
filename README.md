# University Student & Campus Route System

## 1. Project Overview

The **University Student & Campus Route System** is a Java console-based application developed for the Data Structures and Algorithms practical assignment.

The system manages student records and campus services using different data structures. It also represents campus locations and their connections as a graph and provides BFS traversal.

The main purpose of this project is to demonstrate the practical use of data structures such as:

* Linked List
* Stack
* Queue
* Binary Search Tree (BST)
* Hash Table
* Graph using Adjacency List
* Breadth-First Search (BFS)

---

## 2. Technologies Used

* **Programming Language:** Java
* **IDE:** Eclipse
* **Application Type:** Console-based Java Application
* **Data Structures:** Linked List, Stack, Queue, BST, Hash Table, Graph
* **Graph Traversal:** BFS
* **Version Control:** Git and GitHub

---

## 3. Main Features

### Student Management

The system provides the following student record operations:

* Add student record
* Update student record
* Delete student record
* Display all student records
* Search student by Student ID

Each student record contains:

* Student ID
* Name
* Programme
* Marks

The system validates student marks between **0 and 100** and prevents duplicate Student IDs.

### Linked List

A Linked List is used to store and manage student records.

Operations include:

* Add student
* Search student
* Update student
* Delete student
* Display all students

### Stack

A Stack is used to record recent system actions.

The Stack follows the **LIFO (Last In, First Out)** principle.

Examples of recorded actions include:

* Adding a student
* Updating a student
* Deleting a student
* Adding a service request
* Processing a service request
* Adding or removing campus locations
* Adding or removing campus connections

### Queue

A Queue is used to manage service requests.

The Queue follows the **FIFO (First In, First Out)** principle.

Operations include:

* Add service request
* Process the next service request
* Display pending requests

### Binary Search Tree (BST)

A Binary Search Tree is used to organize student records according to Student ID.

Operations include:

* Add student
* Search student
* Delete student
* Display students using inorder traversal

### Hash Table

Hashing is used for efficient student searching using Student ID.

Operations include:

* Add student
* Search student
* Update student
* Delete student

### Campus Graph

A Graph using an **Adjacency List** represents campus locations and their connections.

The system supports:

* Add campus location
* Remove campus location
* Add campus connection
* Remove campus connection
* Display campus connections
* Display neighbouring locations
* BFS traversal

### BFS Traversal

**Breadth-First Search (BFS)** is used to traverse connected campus locations starting from a selected location.

---

## 4. System Menu

The application provides the following menu:

```text
1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions using Stack
8. Display Students using BST/AVL
9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS
16. Exit
```

---

## 5. Input Validation

The system includes input validation to improve reliability.

Examples:

* Empty text input is not accepted.
* Marks below 0 are rejected.
* Marks above 100 are rejected.
* Non-numeric marks are rejected.
* Non-numeric menu input is handled.
* Invalid menu choices are rejected.
* Duplicate Student IDs are prevented.
* Invalid or missing campus locations are handled.

---

## 6. Project Structure

```text
UniversityStudentCampusSystem
│
├── src
│   └── universitysystem
│       ├── Student.java
│       ├── StudentLinkedList.java
│       ├── ActionStack.java
│       ├── ServiceQueue.java
│       ├── StudentBST.java
│       ├── StudentHashTable.java
│       ├── CampusGraph.java
│       └── Main.java
│
└── README.md
```

---

## 7. Team Members and Responsibilities

| Member   | Name             | Student ID | Responsibility                   |
| -------- | ---------------- | ---------- | -------------------------------- |
| Member 1 | ARF.SAMEEHA      | 23DA2-0943 | Linked List + Student Management |
| Member 2 | JF.SUHA          | 23DA2-0944 | Stack + Queue                    |
| Member 3 | AM.RAHNA FARWEEN | 23DA2-0564 | BST + Hashing                    |
| Member 4 | AS.ASFA          | 23DA2-0525 | Graph + BFS/DFS                  |

### Individual Contributions

#### Member 1 – ARF.SAMEEHA

**Student ID:** 23DA2-0943

* Implemented the Student class.
* Implemented Linked List operations.
* Implemented add, search, update, delete and display operations.
* Assisted with system integration and testing.

#### Member 2 – JF.SUHA

**Student ID:** 23DA2-0944

* Implemented Stack for recording recent actions.
* Implemented Queue for managing service requests.
* Tested LIFO and FIFO behaviour.
* Assisted with system integration and testing.

#### Member 3 – AM.RAHNA FARWEEN

**Student ID:** 23DA2-0564

* Implemented Binary Search Tree operations.
* Implemented BST insertion, search, deletion and traversal.
* Implemented Hash Table operations.
* Assisted with system integration and testing.

#### Member 4 – AS.ASFA

**Student ID:** 23DA2-0525

* Implemented the campus Graph using an Adjacency List.
* Implemented adding and removing campus locations.
* Implemented adding and removing campus connections.
* Implemented BFS traversal.
* Assisted with system integration and testing.

### Team Contribution

All members contributed to:

* Integration of the individual components.
* Testing the complete application.
* Identifying and fixing integration issues.
* Documentation.
* Demonstration preparation.

---

## 8. Testing

The application was tested using different scenarios.

### Student Testing

* Student creation tested successfully.
* Student update tested successfully.
* Student deletion tested successfully.
* Duplicate Student ID validation tested successfully.
* Linked List display tested successfully.
* BST display tested successfully.
* BST deletion tested successfully.
* Hashing search tested successfully.

### Stack and Queue Testing

* Service request addition tested successfully.
* Service request processing tested successfully.
* FIFO Queue behaviour verified.
* Recent actions displayed in LIFO order.

### Graph Testing

* Campus locations added successfully.
* Campus locations removed successfully.
* Campus connections added successfully.
* Campus connections removed successfully.
* Campus connections displayed successfully.
* BFS traversal tested successfully.

### Input Validation Testing

* Marks value `120` was rejected.
* Valid marks value `85` was accepted.
* Duplicate Student ID was rejected.
* Invalid menu input `99` was rejected.
* Non-numeric menu input `abc` was rejected.
* Exit option `16` worked correctly.

---

## 9. Sample Student Record

```text
Student ID: 23DA2-003
Name: Test Student
Programme: BAIT
Marks: 85.0
```

---

## 10. Sample Campus Network

Example campus locations used during testing:

```text
Main Building
Library
Cafeteria
```

Example connections:

```text
Main Building <-> Library
Library <-> Cafeteria
```

BFS traversal from **Main Building** produced:

```text
Main Building
Library
Cafeteria
```

---

## 11. How to Run the Project

1. Open **Eclipse**.
2. Import or open the `UniversityStudentCampusSystem` project.
3. Make sure the package is:

```text
universitysystem
```

4. Open:

```text
Main.java
```

5. Run `Main.java` as a Java Application.
6. Select an option from the displayed menu.
7. Follow the instructions shown in the console.

---

## 12. Conclusion

The University Student & Campus Route System demonstrates the practical implementation of several important data structures in Java.

The application combines student management, service request processing, recent action tracking, student searching and campus route management into one menu-driven system.

The completed system was tested for its main operations, data structure behaviour and input validation.
