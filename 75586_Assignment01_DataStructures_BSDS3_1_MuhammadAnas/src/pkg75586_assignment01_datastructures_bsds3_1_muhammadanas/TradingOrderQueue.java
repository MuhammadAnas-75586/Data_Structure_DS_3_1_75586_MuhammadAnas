package pkg75586_assignment01_datastructures_bsds3_1_muhammadanas;

public class TradingOrderQueue {
    private Order[] queue = new Order[10];
    private int front = 0;
    private int rear = -1;

    // Add new order to queue
    public void enqueue(Order order) {
        if (rear == queue.length - 1) {
            System.out.println("Queue Overflow! Order queue is full.");
        } else {
            rear++;
            queue[rear] = order;
            System.out.println("[QUEUE ENQUEUE] Placed Order: " + order);
        }
    }

    // Process and remove next order
    public Order dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow! No pending orders.");
            return null;
        } else {
            Order order = queue[front];
            queue[front] = null;
            front++;
            return order;
        }
    }

    // View next order in queue
    public void peek() {
        if (front > rear) {
            System.out.println("Trading Order Queue is empty.");
        } else {
            System.out.println("Front of Queue (Next Order): " + queue[front]);
        }
    }

    // Print all active orders
    public void display() {
        if (front > rear) {
            System.out.println("No pending trading orders.");
        } else {
            System.out.println("\n--- TRADING ORDERS QUEUE (FIFO Order) ---");
            int step = 1;
            for (int i = front; i <= rear; i++) {
                System.out.println(step++ + ". " + queue[i]);
            }
        }
    }
}