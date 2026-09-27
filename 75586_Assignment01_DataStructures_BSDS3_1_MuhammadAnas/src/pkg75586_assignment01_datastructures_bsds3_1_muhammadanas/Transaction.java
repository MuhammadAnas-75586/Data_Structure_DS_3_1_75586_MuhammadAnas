package pkg75586_assignment01_datastructures_bsds3_1_muhammadanas;

// Represents a completed trade stored in the transaction stack
public class Transaction {
    private int transactionId;
    private Asset asset;
    private String type; // "BUY" or "SELL"
    private int quantity;
    private double totalValue;

    public Transaction(int transactionId, Asset asset, String type, int quantity) {
        this.transactionId = transactionId;
        this.asset = asset;
        this.type = type;
        this.quantity = quantity;
        this.totalValue = asset.price * quantity;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Asset getAsset() {
        return asset;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    @Override
    public String toString() {
        return String.format("Tx #%-4d | %-4s | %-22s | Qty: %-4d | Price: Rs. %-8.2f | Total: Rs. %.2f",
                transactionId, type, asset.name, quantity, asset.price, totalValue);
    }
}