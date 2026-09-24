package universitysystem;

import java.util.*;

// Verified Graph operations and BFS traversal - Asfa
public class CampusGraph {

    // Adjacency List
    private Map<String, List<String>> adjacencyList;

    // Constructor
    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add campus location
    public boolean addLocation(String location) {

        if (adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.put(location, new ArrayList<>());
        return true;
    }

    // Remove campus location
    public boolean removeLocation(String location) {

        if (!adjacencyList.containsKey(location)) {
            return false;
        }

        // Remove the location
        adjacencyList.remove(location);

        // Remove connections to this location
        for (List<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }

        return true;
    }

    // Add connection between two locations
    public boolean addConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        if (location1.equals(location2)) {
            return false;
        }

        if (adjacencyList.get(location1).contains(location2)) {
            return false;
        }

        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        return true;
    }

    // Remove connection
    public boolean removeConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        boolean removed1 =
                adjacencyList.get(location1).remove(location2);

        boolean removed2 =
                adjacencyList.get(location2).remove(location1);

        return removed1 && removed2;
    }

    // Display campus connections
    public void displayConnections() {

        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("\n===== CAMPUS CONNECTIONS =====");

        for (String location : adjacencyList.keySet()) {

            System.out.print(location + " -> ");

            List<String> neighbours = adjacencyList.get(location);

            if (neighbours.isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", neighbours));
            }
        }
    }

    // Display neighbours of a location
    public void displayNeighbours(String location) {

        if (!adjacencyList.containsKey(location)) {
            System.out.println("Location not found.");
            return;
        }

        System.out.println("\nConnections from " + location + ":");

        List<String> neighbours = adjacencyList.get(location);

        if (neighbours.isEmpty()) {
            System.out.println("No connections.");
        } else {
            for (String neighbour : neighbours) {
                System.out.println(neighbour);
            }
        }
    }

    // BFS traversal
    public void bfs(String startLocation) {

        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Starting location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startLocation);
        queue.offer(startLocation);

        System.out.println("\n===== BFS TRAVERSAL =====");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println(current);

            for (String neighbour : adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
    }
}