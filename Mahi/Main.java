import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
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
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                }
                case 2 -> library.viewBooks();
                case 3 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int id = scanner.nextInt();
                    library.issueBook(id);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to return: ");
                    int id = scanner.nextInt();
                    library.returnBook(id);
                }
                case 5 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        scanner.close();
    }
}
