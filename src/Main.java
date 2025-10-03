public class Main {
    public static void main(String[] args) {
        System.out.println("═══ LIBRARY MANAGEMENT SYSTEM ═══");

        // Create LibraryManager
        LibraryManager manager = new LibraryManager();

        System.out.println("\n═══ Adding Items to Library ═══");
        Book book1 = new Book("B1", "Java Programming", "James Gosling", "123456789", 500, "Programming");
        Book book2 = new Book("B2", "Mystery Novel", "Agatha Christie", "987654321", 300, "Mystery");
        Magazine mag1 = new Magazine("M1", "Tech Today", "Editor Smith", 120, "October", true);
        Magazine mag2 = new Magazine("M2", "Science Weekly", "Editor Doe", 45, "September", false);
        DVD dvd1 = new DVD("D1", "The Matrix", "Wachowski Sisters", 130, "R", "Sci-Fi");
        DVD dvd2 = new DVD("D2", "Frozen", "Disney", 102, "PG", "Animation");

        manager.addItem(book1);
        manager.addItem(mag1);
        manager.addItem(dvd1);

        System.out.println("\n═══ Displaying All Items ═══");
        manager.displayAllItems();

        System.out.println("\n═══ Testing Borrowing ═══");
        Student student = new Student("U1", "John Smith", "john@email.com", "S123", "Computer Science");
        Faculty faculty = new Faculty("U2", "Dr. Smith", "smith@email.com", "Engineering", "Professor");

        book1.borrowItem(student.getName());
        student.addBorrowedItem(book1);
        System.out.println("Student " + student.getName() + " borrowed: " + book1.title);

        dvd1.borrowItem(faculty.getName());
        faculty.addBorrowedItem(dvd1);
        System.out.println("Faculty " + faculty.getName() + " borrowed: " + dvd1.title);

        System.out.println("\n═══ Displaying Available Items ═══");
        manager.displayAvailableItems();

        System.out.println("\n═══ Testing Late Fees ═══");
        System.out.println(book1.title + " - 5 days late: $" + book1.calculateLateFee(5));
        System.out.println(dvd1.title + " - 3 days late: $" + dvd1.calculateLateFee(3));

        System.out.println("\n═══ Testing User Information ═══");
        System.out.println("Student: " + student.getName() + " (" + student.getMajor() + ") - " + student.getBorrowedItemsCount() + " items borrowed");
        System.out.println("Faculty: " + faculty.getName() + " (" + faculty.getDepartment() + ") - " + faculty.getBorrowedItemsCount() + " items borrowed");
    }
}
