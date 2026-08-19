import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        System.out.println("\n--- Book List ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && book.isAvailable()) {
                book.issue();
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available or invalid ID.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && !book.isAvailable()) {
                book.returnBook();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid ID or book was not issued.");
    }
}
