package pkg75586_assignment01_datastructures_bsds3_1_muhammadanas;

import java.util.Scanner;

public class Main {
    private static int transactionIdCounter = 1001; // Auto-increments transaction IDs

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Market data
        Asset[] assets = new Asset[]{
            new Asset(101, "Engro Corporation", "Conglomerate", 345.50, 2.15),
            new Asset(102, "Lucky Cement", "Cement", 810.00, 1.40),
            new Asset(103, "Hub Power Co. (HUBC)", "Power", 125.75, -0.85),
            new Asset(104, "Habib Bank Ltd (HBL)", "Banking", 138.20, 1.10),
            new Asset(105, "Oil & Gas Dev (OGDC)", "Energy", 118.90, -1.50),
            new Asset(106, "Systems Limited", "Technology", 412.30, 3.45),
            new Asset(107, "Pakistan State Oil", "Energy", 195.40, 0.55),
            new Asset(108, "Fauji Fertilizer", "Agriculture", 168.10, 0.90),
            new Asset(109, "MCB Bank Limited", "Banking", 210.60, 1.75),
            new Asset(110, "TRG Pakistan", "Technology", 45.25, -4.20)
        };

        // Initial portfolio state
        Asset[] initialPortfolioAssets = new Asset[]{assets[0], assets[1], assets[4], assets[5]};
        int[] initialPortfolioQty = new int[]{15, 2, 10, 5};

        Portfolio portfolio = new Portfolio(initialPortfolioAssets, initialPortfolioQty);
        Watchlist watchlist = new Watchlist();
        TransactionStack transactionStack = new TransactionStack();
        TradingOrderQueue orderQueue = new TradingOrderQueue();

        int mainChoice = -1;

        while (mainChoice != 0) {
            System.out.println("\n==================================================");
            System.out.println("        FINTECH TRADING MANAGEMENT SYSTEM          ");
            System.out.println("==================================================");
            System.out.println("1. Manage Market Assets");
            System.out.println("2. Search Asset");
            System.out.println("3. Sort Market Assets");
            System.out.println("4. Manage Watchlist");
            System.out.println("5. Calculate Portfolio Value");
            System.out.println("6. Manage Transactions");
            System.out.println("7. Manage Trading Orders");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                mainChoice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                mainChoice = -1;
            }

            switch (mainChoice) {
                case 1: {
                    int subChoice = -1;
                    while (subChoice != 0) {
                        System.out.println("\n--------------------------------------------------");
                        System.out.println("                MARKET ASSETS                     ");
                        System.out.println("--------------------------------------------------");
                        System.out.println("1. Display All Assets");
                        System.out.println("2. Calculate Average Price");
                        System.out.println("3. Find Highest-Priced Asset");
                        System.out.println("4. Find Lowest-Priced Asset");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        try {
                            subChoice = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            subChoice = -1;
                        }

                        if (subChoice == 1) {
                            System.out.println("\n--- MARKET ASSETS ---");
                            for (Asset a : assets) {
                                System.out.println(a);
                            }
                        } else if (subChoice == 2) {
                            double sum = 0;
                            for (Asset a : assets) {
                                sum += a.price;
                            }
                            System.out.printf("Average Asset Price: Rs. %.2f\n", sum / assets.length);
                        } else if (subChoice == 3) {
                            Asset max = assets[0];
                            for (int i = 1; i < assets.length; i++) {
                                if (assets[i].price > max.price) {
                                    max = assets[i];
                                }
                            }
                            System.out.println("Highest-Priced Asset: " + max);
                        } else if (subChoice == 4) {
                            Asset min = assets[0];
                            for (int i = 1; i < assets.length; i++) {
                                if (assets[i].price < min.price) {
                                    min = assets[i];
                                }
                            }
                            System.out.println("Lowest-Priced Asset: " + min);
                        }
                    }
                    break;
                }

                case 2: {
                    int subChoice = -1;
                    while (subChoice != 0) {
                        System.out.println("\n--------------------------------------------------");
                        System.out.println("                SEARCH ASSET                      ");
                        System.out.println("--------------------------------------------------");
                        System.out.println("1. Linear Search");
                        System.out.println("2. Binary Search");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        try {
                            subChoice = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            subChoice = -1;
                        }

                        if (subChoice == 1 || subChoice == 2) {
                            System.out.print("Enter Asset ID to search: ");
                            int targetId = -1;
                            try {
                                targetId = Integer.parseInt(scanner.nextLine());
                            } catch (Exception e) {
                            }

                            if (subChoice == 1) {
                                linearSearch(assets, targetId);
                            } else {
                                binarySearch(assets, targetId);
                            }
                        }
                    }
                    break;
                }

                case 3: {
                    int subChoice = -1;
                    while (subChoice != 0) {
                        System.out.println("\n--------------------------------------------------");
                        System.out.println("               SORT MARKET ASSETS                 ");
                        System.out.println("--------------------------------------------------");
                        System.out.println("1. Bubble Sort (by Price - Ascending)");
                        System.out.println("2. Selection Sort (by Change % - Descending)");
                        System.out.println("3. Insertion Sort (by Asset ID - Ascending)");
                        System.out.println("4. Merge Sort (by Price - Ascending)");
                        System.out.println("5. Quick Sort (by Asset ID - Ascending)");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        try {
                            subChoice = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            subChoice = -1;
                        }

                        if (subChoice == 1) {
                            bubbleSortByPrice(assets);
                            printAssets(assets, "[Bubble Sort] Sorted by Price:");
                        } else if (subChoice == 2) {
                            selectionSortByChangeDesc(assets);
                            printAssets(assets, "[Selection Sort] Sorted by 24h Change % (Desc):");
                        } else if (subChoice == 3) {
                            insertionSortById(assets);
                            printAssets(assets, "[Insertion Sort] Sorted by Asset ID:");
                        } else if (subChoice == 4) {
                            mergeSort(assets, 0, assets.length - 1);
                            printAssets(assets, "[Merge Sort] Sorted by Price:");
                        } else if (subChoice == 5) {
                            quickSort(assets, 0, assets.length - 1);
                            printAssets(assets, "[Quick Sort] Sorted by Asset ID:");
                        }
                    }
                    break;
                }

                case 4: {
                    int subChoice = -1;
                    while (subChoice != 0) {
                        System.out.println("\n--------------------------------------------------");
                        System.out.println("                MANAGE WATCHLIST                  ");
                        System.out.println("--------------------------------------------------");
                        System.out.println("1. Add Asset to Watchlist (Insert)");
                        System.out.println("2. Remove Asset from Watchlist (Delete)");
                        System.out.println("3. Search Asset in Watchlist");
                        System.out.println("4. Display Watchlist");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        try {
                            subChoice = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            subChoice = -1;
                        }

                        if (subChoice == 1) {
                            System.out.print("Enter Asset ID to insert into Watchlist: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            Asset target = findAssetById(assets, id);

                            if (target == null) {
                                System.out.println("Asset ID " + id + " not found in market data.");
                            } else {
                                watchlist.add(target);
                            }
                        } else if (subChoice == 2) {
                            System.out.print("Enter Asset ID to remove: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            watchlist.remove(id);
                        } else if (subChoice == 3) {
                            System.out.print("Enter Asset ID to search in Watchlist: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            watchlist.search(id);
                        } else if (subChoice == 4) {
                            watchlist.display();
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.println("\n--------------------------------------------------");
                    System.out.println("            PORTFOLIO VALUE (RECURSION)           ");
                    System.out.println("--------------------------------------------------");
                    System.out.println("Portfolio Items:");
                    portfolio.displayPortfolioRecursive(0);

                    double total = portfolio.calculateTotalValueRecursive(0);
                    System.out.printf("\n>>> Total Calculated Portfolio Value: Rs. %.2f <<<\n", total);
                    break;
                }

                case 6: {
                    int subChoice = -1;
                    while (subChoice != 0) {
                        System.out.println("\n--------------------------------------------------");
                        System.out.println("             TRANSACTIONS (STACK - LIFO)          ");
                        System.out.println("--------------------------------------------------");
                        System.out.println("1. Pop Recent Transaction");
                        System.out.println("2. Peek Most Recent Transaction");
                        System.out.println("3. Display All Recent Transactions");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        try {
                            subChoice = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            subChoice = -1;
                        }

                        if (subChoice == 1) {
                            transactionStack.pop();
                        } else if (subChoice == 2) {
                            transactionStack.peek();
                        } else if (subChoice == 3) {
                            transactionStack.display();
                        }
                    }
                    break;
                }

                case 7: {
                    int subChoice = -1;
                    while (subChoice != 0) {
                        System.out.println("\n--------------------------------------------------");
                        System.out.println("            TRADING ORDERS (QUEUE - FIFO)         ");
                        System.out.println("--------------------------------------------------");
                        System.out.println("1. Enqueue New Trading Order");
                        System.out.println("2. Dequeue / Process Order");
                        System.out.println("3. Peek Front Order");
                        System.out.println("4. Display All Pending Orders");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        try {
                            subChoice = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            subChoice = -1;
                        }

                        if (subChoice == 1) { // Add order to queue
                            System.out.print("Enter Asset ID: ");
                            int assetId = Integer.parseInt(scanner.nextLine());

                            Asset target = findAssetById(assets, assetId);
                            if (target == null) {
                                System.out.println("Error: Asset ID " + assetId + " does not exist in market data.");
                            } else {
                                System.out.print("Enter Operation (BUY/SELL): ");
                                String op = scanner.nextLine().trim().toUpperCase();

                                if (!op.equals("BUY") && !op.equals("SELL")) {
                                    System.out.println("Invalid operation! Enter either BUY or SELL.");
                                } else {
                                    System.out.print("Enter Quantity: ");
                                    int qty = Integer.parseInt(scanner.nextLine());
                                    if (qty <= 0) {
                                        System.out.println("Quantity must be greater than 0.");
                                    } else {
                                        orderQueue.enqueue(new Order(assetId, op, qty));
                                    }
                                }
                            }
                        } else if (subChoice == 2) { // Process order from queue
                            Order dequeuedOrder = orderQueue.dequeue();
                            if (dequeuedOrder != null) {
                                Asset asset = findAssetById(assets, dequeuedOrder.getAssetId());
                                if (asset != null) {
                                    // Update portfolio first
                                    boolean updateSuccess = portfolio.updatePortfolio(asset, dequeuedOrder.getOperation(), dequeuedOrder.getQuantity());

                                    // Push transaction to stack if portfolio update succeeds
                                    if (updateSuccess) {
                                        Transaction transaction = new Transaction(
                                            transactionIdCounter++,
                                            asset,
                                            dequeuedOrder.getOperation(),
                                            dequeuedOrder.getQuantity()
                                        );
                                        transactionStack.push(transaction);
                                        System.out.println("Order processed and successfully recorded into Transaction Stack!");
                                    } else {
                                        System.out.println("Order processing aborted due to portfolio constraints.");
                                    }
                                }
                            }
                        } else if (subChoice == 3) {
                            orderQueue.peek();
                        } else if (subChoice == 4) {
                            orderQueue.display();
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("Exiting FinTech Trading Management System. Goodbye!");
        scanner.close();
    }

    // Finds an asset in array by ID
    private static Asset findAssetById(Asset[] assets, int id) {
        for (Asset a : assets) {
            if (a.id == id) {
                return a;
            }
        }
        return null;
    }

    // Sorts assets by price ascending
    private static void bubbleSortByPrice(Asset[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].price > arr[j + 1].price) {
                    Asset tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    // Sorts assets by 24h change descending
    private static void selectionSortByChangeDesc(Asset[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].change > arr[maxIdx].change) {
                    maxIdx = j;
                }
            }
            Asset tmp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = tmp;
        }
    }

    // Sorts assets by ID ascending
    private static void insertionSortById(Asset[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Asset key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].id > key.id) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort by price ascending
    private static void mergeSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(Asset[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].price <= R[j].price) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort by ID ascending
    private static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Asset[] arr, int low, int high) {
        int pivot = arr[high].id;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].id < pivot) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static void printAssets(Asset[] arr, String message) {
        System.out.println("\n" + message);
        for (Asset a : arr) {
            System.out.println(a);
        }
    }

    // Linear search by asset ID
    private static void linearSearch(Asset[] assets, int targetId) {
        System.out.println("\n--- Executing Linear Search for ID: " + targetId + " ---");
        boolean found = false;
        for (int i = 0; i < assets.length; i++) {
            System.out.println("Checking index " + i + " [ID: " + assets[i].id + "]...");
            if (assets[i].id == targetId) {
                System.out.println("FOUND: " + assets[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Asset ID " + targetId + " not found.");
        }
    }

    // Binary search by asset ID (sorts array by ID first)
    private static void binarySearch(Asset[] assets, int targetId) {
        System.out.println("\n--- Executing Binary Search for ID: " + targetId + " ---");
        insertionSortById(assets);

        int l = 0, r = assets.length - 1;
        boolean found = false;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (targetId == assets[mid].id) {
                System.out.println("FOUND: " + assets[mid]);
                found = true;
                break;
            } else if (targetId > assets[mid].id) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Asset ID " + targetId + " not found.");
        }
    }
}