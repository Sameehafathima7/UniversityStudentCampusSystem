package universitysystem;

public class GraphTest {

    public static void main(String[] args) {

        CampusGraph graph = new CampusGraph();

        // =========================
        // ADD CAMPUS LOCATIONS
        // =========================

        System.out.println("===== ADD CAMPUS LOCATIONS =====");

        System.out.println("Main Entrance added: "
                + graph.addLocation("Main Entrance"));

        System.out.println("Main Building added: "
                + graph.addLocation("Main Building"));

        System.out.println("Academic Complex added: "
                + graph.addLocation("Academic Complex"));

        System.out.println("Student Center added: "
                + graph.addLocation("Student Center"));

        System.out.println("Hostel added: "
                + graph.addLocation("Hostel"));

        System.out.println("Playground added: "
                + graph.addLocation("Playground"));

        // =========================
        // ADD CONNECTIONS
        // =========================

        System.out.println("\n===== ADD CAMPUS CONNECTIONS =====");

        System.out.println("Connection added: "
                + graph.addConnection(
                        "Main Entrance",
                        "Main Building"));

        System.out.println("Connection added: "
                + graph.addConnection(
                        "Main Building",
                        "Academic Complex"));

        System.out.println("Connection added: "
                + graph.addConnection(
                        "Academic Complex",
                        "Student Center"));

        System.out.println("Connection added: "
                + graph.addConnection(
                        "Academic Complex",
                        "Hostel"));

        System.out.println("Connection added: "
                + graph.addConnection(
                        "Hostel",
                        "Playground"));

        // =========================
        // DISPLAY CONNECTIONS
        // =========================

        graph.displayConnections();

        // =========================
        // DISPLAY NEIGHBOURS
        // =========================

        graph.displayNeighbours("Academic Complex");

        // =========================
        // BFS
        // =========================

        graph.bfs("Main Entrance");

        // =========================
        // REMOVE CONNECTION
        // =========================

        System.out.println("\n===== REMOVE CONNECTION =====");

        boolean removedConnection =
                graph.removeConnection(
                        "Hostel",
                        "Playground");

        System.out.println("Connection removed: "
                + removedConnection);

        graph.displayConnections();

        // =========================
        // REMOVE LOCATION
        // =========================

        System.out.println("\n===== REMOVE LOCATION =====");

        boolean removedLocation =
                graph.removeLocation("Student Center");

        System.out.println("Student Center removed: "
                + removedLocation);

        graph.displayConnections();
    }
}