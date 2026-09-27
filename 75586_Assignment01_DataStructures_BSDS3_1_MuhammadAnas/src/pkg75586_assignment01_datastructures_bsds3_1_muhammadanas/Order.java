package pkg75586_assignment01_datastructures_bsds3_1_muhammadanas;

// Holds details for a pending trade order in the queue
public class Order {
    private int assetId;
    private String operation; // "BUY" or "SELL"
    private int quantity;

    public Order(int assetId, String operation, int quantity) {
        this.assetId = assetId;
        this.operation = operation.toUpperCase();
        this.quantity = quantity;
    }

    public int getAssetId() {
        return assetId;
    }

    public String getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Asset ID: %-4d | Operation: %-4s | Quantity: %-4d", assetId, operation, quantity);
    }
}