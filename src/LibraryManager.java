import java.util.ArrayList;

public class LibraryManager {
    private ArrayList<Borrowable> items;

    public LibraryManager() {
        items = new ArrayList<>();
    }

    public void addItem(Borrowable item) {
        items.add(item);
        if (item instanceof LibraryItem) {
            LibraryItem libItem = (LibraryItem) item;
            System.out.println("Added: " + libItem.getItemType() + " - " + libItem.getItemInfo());
        }
    }

    public void displayAllItems() {
        for (Borrowable item : items) {
            if (item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                if (item instanceof DVD)
                    System.out.println("DVD: " + libItem.getItemInfo() + " (" + item.getBorrowingStatus() + ")");
                else
                    System.out.println(libItem.getItemType() + ": " + libItem.getItemInfo() + " (" + item.getBorrowingStatus() + ")");
            }
        }
    }

    public Borrowable findItemById(String itemId) {
        for (Borrowable item : items) {
            if (item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                if (libItem.itemId.equals(itemId)) return item;
            }
        }
        return null;
    }

    public void borrowItem(String itemId, String borrowerName) {
        Borrowable item = findItemById(itemId);
        if (item != null && item.isAvailable()) {
            item.borrowItem(borrowerName);
        }
    }

    public void returnItem(String itemId) {
        Borrowable item = findItemById(itemId);
        if (item != null && !item.isAvailable()) {
            item.returnItem();
        }
    }

    public void displayAvailableItems() {
        for (Borrowable item : items) {
            if (item.isAvailable() && item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                System.out.println(libItem.getItemType() + ": " + libItem.getItemInfo() + " (" + item.getBorrowingStatus() + ")");
            }
        }
    }

    public double calculateTotalLateFees(int daysLate) {
        double total = 0.0;
        for (Borrowable item : items) {
            if (item instanceof LibraryItem) {
                LibraryItem libItem = (LibraryItem) item;
                total += libItem.calculateLateFee(daysLate);
            }
        }
        return total;
    }
}
