package pkg75586_assignment01_datastructures_bsds3_1_muhammadanas;

// Linked list for managing watchlisted assets
public class Watchlist {

    private static class WatchlistNode {
        Asset asset;
        WatchlistNode next;

        public WatchlistNode(Asset asset) {
            this.asset = asset;
            this.next = null;
        }
    }

    private WatchlistNode head = null;

    // Add asset to list (ignores duplicates)
    public void add(Asset target) {
        if (head == null) {
            head = new WatchlistNode(target);
            System.out.println("Added to Watchlist: " + target.name);
            return;
        }

        WatchlistNode curr = head;
        boolean duplicate = false;

        while (curr != null) {
            if (curr.asset.id == target.id) {
                duplicate = true;
                break;
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }

        if (duplicate) {
            System.out.println("Asset already in Watchlist!");
        } else {
            curr.next = new WatchlistNode(target);
            System.out.println("Added to Watchlist: " + target.name);
        }
    }

    // Remove asset by ID
    public void remove(int id) {
        if (head == null) {
            System.out.println("Watchlist is empty.");
            return;
        }

        if (head.asset.id == id) {
            System.out.println("Removed: " + head.asset.name);
            head = head.next;
            return;
        }

        WatchlistNode prev = head;
        WatchlistNode curr = head.next;

        while (curr != null && curr.asset.id != id) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
            System.out.println("Removed: " + curr.asset.name);
        } else {
            System.out.println("Asset ID " + id + " not found in Watchlist.");
        }
    }

    // Search asset by ID in watchlist
    public void search(int id) {
        WatchlistNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.asset.id == id) {
                System.out.println("Found in Watchlist: " + temp.asset);
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (found==false) {
            System.out.println("Asset ID " + id + " not found in Watchlist.");
        }
    }

    // Print watchlist
    public void display() {
        if (head == null) {
            System.out.println("Watchlist is currently empty.");
        } else {
            System.out.println("\n--- INVESTOR WATCHLIST ---");
            WatchlistNode temp = head;
            while (temp != null) {
                System.out.println(temp.asset);
                temp = temp.next;
            }
        }
    }
}