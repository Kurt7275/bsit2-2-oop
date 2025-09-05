public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("═══ Food Ordering System ═══");

            Order order1 = new Order("Alice Johnson");
            Order order2 = new Order("Bob Smith");
            Order order3 = new Order("Charlie Brown");

            System.out.println("Creating orders and adding items...");

            // Alice
            order1.addItem("Pizza", 8.99);
            order1.addItem("Burger", 7.50);
            order1.addItem("Fries", 3.25);
            System.out.println("Item 'Pizza' added successfully");
            System.out.println("Items added: Burger, Fries");

            // Bob
            try {
                order2.addItem("Burger", -5.50);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            order2.addItem("Fries", 3.25);
            order2.addItem("Coke", 1.75);
            order2.addItem("Salad", 4.00);
            order2.addItem("Water", 1.25);
            System.out.println("Item 'Burger' added successfully");
            System.out.println("Items added: Fries, Coke, Salad, Water");

            // Charlie
            try {
                order3.addItem("", 2.50);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            order3.addItem("Pizza", 7.50);
            order3.addItem("Fries", 2.50);
            order3.addItem("Soda", 1.50);
            System.out.println("Item 'Pizza' added successfully");
            System.out.println("Items added: Fries, Soda");

            System.out.println();

            System.out.println("Order Results:");
            System.out.println(formatOrder(order1));
            System.out.println(formatOrder(order2));
            System.out.println(formatOrder(order3));

            System.out.println();

            System.out.println("Total orders created: " + Order.getTotalOrders());

            Order largestOrder = order1;
            if (order2.getTotalAmount() > largestOrder.getTotalAmount()) {
                largestOrder = order2;
            }
            if (order3.getTotalAmount() > largestOrder.getTotalAmount()) {
                largestOrder = order3;
            }

            System.out.println("Largest order: " + largestOrder.getCustomerName() + " ($" + String.format("%.2f", largestOrder.getTotalAmount()) + ")");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static String formatOrder(Order order) {
        return "Order for " + order.getCustomerName() + ": " + order.getItemCount() + " items, Total: $" + String.format("%.2f", order.getTotalAmount()) + ", Size: " + order.getOrderSize();
    }
}
