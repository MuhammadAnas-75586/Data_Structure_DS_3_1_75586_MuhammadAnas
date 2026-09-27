package pkg75586_assignment01_datastructures_bsds3_1_muhammadanas;

// Represents a stock/market asset
public class Asset {

    public int id;
    public String name;
    public String type;
    public double price;
    public double change;

    public Asset(int id, String name, String type, double price, double change) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.change = change;
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Name: %-22s | Type: %-14s | Price: Rs. %-8.2f | 24h Change: %+.2f%%",
                id, name, type, price, change);
    }
}