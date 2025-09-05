import java.util.ArrayList;

public class FoodOrderingSystem {

    static class Order {
        private String customerName;
        private ArrayList<String> items;
        private ArrayList<Double> prices;
        private static int totalOrders = 0;

        public Order(String customerName) {
            this.customerName = customerName;
            this.items = new ArrayList<>();
            this.prices = new ArrayList<>();
            totalOrders++;
        }

        public void addItem(String item, double price) throws IllegalArgumentException {
            if (price <= 0) {
                throw new IllegalArgumentException("Invalid price: must be greater than 0");
            }
            if (item == null || item.isEmpty()) {
                throw new IllegalArgumentException("Invalid item: cannot be empty");
            }
            items.add(item);
            prices.add(price);
            System.out.println("Item '" + item + "' added successfully");
        }

        public double getTotalAmount() {
            if (items.isEmpty()) {
                return 0.0;
            }
            double total = 0.0;
            for (double price : prices) {
                total += price;
            }
            return total;
        }

        public String getOrderSize() {
            if (items.isEmpty()) return "Empty order";
            if (items.size() <= 3) return "Small";
            if (items.size() <= 6) return "Medium";
            return "Large";
        }

        public void addMultipleItems(String[] items, double... prices) {
            if (items.length != prices.length) {
                throw new IllegalArgumentException("Items and prices count mismatch");
            }
            for (int i = 0; i < items.length; i++) {
                try {
                    addItem(items[i], prices[i]);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    break;
                }
            }
        }

        public static int getTotalOrders() {
            return totalOrders;
        }

        public String getCustomerName() {
            return customerName;
        }

        public int getItemCount() {
            return items.size();
        }

        @Override
        public String toString() {
            return "Order for " + customerName + ": " + getItemCount() + " items, Total: $" + String.format("%.2f", getTotalAmount()) + ", Size: " + getOrderSize();
        }
    }

    public static void main(String[] args) {
        System.out.println("═══ Food Ordering System ═══\n");

        System.out.println("Creating orders and adding items...");
        
        Order order1 = new Order("Alice Johnson");
        Order order2 = new Order("Bob Smith");
        Order order3 = new Order("Charlie Brown");

        try {
            order1.addItem("Pizza", 12.99);
            order2.addMultipleItems(new String[]{"Burger", "Fries"}, 8.50, 3.25);
            order3.addMultipleItems(new String[]{"Taco", "Hotdog", "Soda"}, 5.00, 4.50, 2.00);

            order1.addItem("Pizza", -5.00);
            order2.addItem("", 3.00);
            order3.addMultipleItems(new String[]{"Burger"}, 2.50);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nOrder Results:");
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);

        System.out.println("\nTotal orders created: " + Order.getTotalOrders());

        Order largestOrder = order1;
        if (order2.getTotalAmount() > largestOrder.getTotalAmount()) largestOrder = order2;
        if (order3.getTotalAmount() > largestOrder.getTotalAmount()) largestOrder = order3;

        System.out.println("Largest order: " + largestOrder.getCustomerName() + " ($" + String.format("%.2f", largestOrder.getTotalAmount()) + ")");
    }
}
