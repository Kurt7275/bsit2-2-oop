public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("Demon Slayer", "Koyoharu Gotouge", 192);
        Book book2 = new Book("Vagabond", "George Orwell", 328);
        Book book3 = new Book("The Climber", "Shin-ichi Sakamoto", 448);

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();

        book1.borrowBook();
        book1.displayInfo();

        book1.returnBook();
        book1.displayInfo();
    }
}

class Book {
    String title;
    String author;
    int pages;
    boolean isAvailable;

    Book(String t, String a, int p) {
        title = t;
        author = a;
        pages = p;
        isAvailable = true;
        System.out.println("A new book '" + title + "' by " + author + " has been added to the library!");
    }

    void displayInfo() {
        System.out.println("\nTitle: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + isAvailable);
    }

    void borrowBook() {
        isAvailable = false;
        System.out.println("\nYou borrowed '" + title + "'.");
    }

    void returnBook() {
        isAvailable = true;
        System.out.println("\nYou returned '" + title + "'.");
    }
}
