package universitysystem;

public class StackQueueTest {

    public static void main(String[] args) {

        // =========================
        // STACK TEST
        // =========================

        ActionStack actionStack = new ActionStack();

        System.out.println("===== STACK TEST =====");

        actionStack.pushAction("Added Student 23DA2-001");
        actionStack.pushAction("Added Student 23DA2-002");
        actionStack.pushAction("Updated Student 23DA2-001");
        actionStack.pushAction("Deleted Student 23DA2-002");

        actionStack.displayActions();

        // =========================
        // QUEUE TEST
        // =========================

        ServiceQueue serviceQueue = new ServiceQueue();

        System.out.println("\n===== QUEUE TEST =====");

        serviceQueue.addRequest("Student 23DA2-001 - Transcript Request");
        serviceQueue.addRequest("Student 23DA2-002 - ID Card Request");
        serviceQueue.addRequest("Student 23DA2-003 - Registration Request");

        serviceQueue.displayRequests();

        // Process first request
        System.out.println("\nProcessing next request...");

        String processed = serviceQueue.processNextRequest();

        if (processed != null) {
            System.out.println("Processed: " + processed);
        } else {
            System.out.println("No request available.");
        }

        // Display remaining requests
        serviceQueue.displayRequests();
    }
}
