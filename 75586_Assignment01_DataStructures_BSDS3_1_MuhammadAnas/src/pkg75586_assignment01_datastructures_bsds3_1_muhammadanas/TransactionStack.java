package pkg75586_assignment01_datastructures_bsds3_1_muhammadanas;

public class TransactionStack {
    private Transaction[] stack = new Transaction[20];
    private int top = -1;

    // Push transaction to history
    public void push(Transaction transaction) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow. Transaction stack is full.");
            return;
        }
        top++;
        stack[top] = transaction;
        System.out.println("[STACK PUSH] Recorded: " + transaction);
    }

    // Pop most recent transaction
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! No transactions to pop.");
        } else {
            System.out.println("[STACK POP] Removed Most Recent: " + stack[top]);
            stack[top] = null;
            top--;
        }
    }

    // Peek most recent transaction
    public void peek() {
        if (top == -1) {
            System.out.println("Transaction Stack is empty.");
        } else {
            System.out.println("Top of Stack (Most Recent): " + stack[top]);
        }
    }

    // Print transaction history
    public void display() {
        if (top == -1) {
            System.out.println("No recent transactions.");
        } else {
            System.out.println("\n--- RECENT TRANSACTIONS (LIFO Order) ---");
            int step = 1;
            for (int i = top; i >= 0; i--) {
                System.out.println(step++ + ". " + stack[i]);
            }
        }
    }
}