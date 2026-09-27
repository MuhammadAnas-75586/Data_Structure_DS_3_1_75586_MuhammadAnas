package pkg75586_assignment01_datastructures_bsds3_1_muhammadanas;

public class Portfolio {
    private Asset[] assets;
    private int[] quantities;
    private int count;

    public Portfolio(Asset[] initialAssets, int[] initialQtys) {
        this.assets = new Asset[20];
        this.quantities = new int[20];
        this.count = 0;

        for (int i = 0; i < initialAssets.length; i++) {
            this.assets[i] = initialAssets[i];
            this.quantities[i] = initialQtys[i];
            this.count++;
        }
    }

    // Updates quantity on BUY/SELL and removes asset if quantity becomes 0
    public boolean updatePortfolio(Asset asset, String operation, int quantity) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (assets[i].id == asset.id) {
                index = i;
                break;
            }
        }

        if (operation.equalsIgnoreCase("BUY")) {
            if (index != -1) {
                quantities[index] += quantity;
            } else {
                if (count >= assets.length) {
                    System.out.println("Portfolio capacity full! Cannot add new asset.");
                    return false;
                }
                assets[count] = asset;
                quantities[count] = quantity;
                count++;
            }
            System.out.println("[PORTFOLIO UPDATE] Added " + quantity + " unit(s) of " + asset.name);
            return true;

        } else if (operation.equalsIgnoreCase("SELL")) {
            if (index == -1) {
                System.out.println("Error: Cannot sell " + asset.name + " (Not in portfolio).");
                return false;
            } else if (quantities[index] < quantity) {
                System.out.println("Error: Insufficient quantity! Owned: " + quantities[index] + ", Requested: " + quantity);
                return false;
            } else {
                quantities[index] -= quantity;
                System.out.println("[PORTFOLIO UPDATE] Subtracted " + quantity + " unit(s) of " + asset.name);

                // Remove asset if fully sold out
                if (quantities[index] == 0) {
                    for (int i = index; i < count - 1; i++) {
                        assets[i] = assets[i + 1];
                        quantities[i] = quantities[i + 1];
                    }
                    assets[count - 1] = null;
                    quantities[count - 1] = 0;
                    count--;
                    System.out.println("[PORTFOLIO UPDATE] " + asset.name + " removed from portfolio.");
                }
                return true;
            }
        }
        return false;
    }

    // Recursively prints portfolio items
    public void displayPortfolioRecursive(int index) {
        // Base Case
        if (index >= count) {
            return;
        }
        // Recursive Case
        double itemVal = assets[index].price * quantities[index];
        System.out.printf(" - %-22s | Quantity: %-4d | Unit Price: Rs. %-8.2f | Item Total: Rs. %.2f\n",
                assets[index].name, quantities[index], assets[index].price, itemVal);

        displayPortfolioRecursive(index + 1);
    }

    // Recursively calculates total portfolio market value
    public double calculateTotalValueRecursive(int index) {
        // Base Case
        if (index >= count) {
            return 0.0;
        }
        // Recursive Case
        return (assets[index].price * quantities[index]) + calculateTotalValueRecursive(index + 1);
    }
}