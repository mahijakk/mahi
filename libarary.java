import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isAvailable;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + (isAvailable ? "Available" : "Issued");
    }
}

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    private static void viewBooks() {
        System.out.println("\n--- Book List ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id && book.isAvailable) {
                book.isAvailable = false;
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available or invalid ID.");
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id && !book.isAvailable) {
                book.isAvailable = true;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid ID or book was not issued.");
    }
}
