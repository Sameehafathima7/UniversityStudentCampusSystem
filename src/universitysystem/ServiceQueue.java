package universitysystem;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {

    private Queue<String> requests;

    public ServiceQueue() {
        requests = new LinkedList<>();
    }

    // Add a service request
    public void addRequest(String request) {
        requests.offer(request);
        System.out.println("Service request added: " + request);
    }

    // Process the first request
    public String processNextRequest() {

        if (requests.isEmpty()) {
            return null;
        }

        return requests.poll();
    }

    // Display all pending requests
    public void displayRequests() {

        if (requests.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }

        System.out.println("\n===== SERVICE REQUEST QUEUE =====");

        for (String request : requests) {
            System.out.println(request);
        }
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return requests.isEmpty();
    }
}
