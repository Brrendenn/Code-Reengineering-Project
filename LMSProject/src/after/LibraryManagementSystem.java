package after;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Library library = new Library();

            library.addBook(new Book("Verity", "Colleen Hoover"));
            library.addBook(new Book("The Secret", "Rhonda Byrne"));
            library.addBook(new Book("Grit", "Angela Duckworth"));

            boolean running = true;
            while (running) {
                library.displayAvailableBooks();

                System.out.println("\nMenu:");
                System.out.println("Type 'borrow' to borrow a book.");
                System.out.println("Type 'return' to return a book.");
                System.out.println("Type 'exit' to quit.");
                System.out.print("Enter your choice: ");
                String action = scanner.nextLine().trim().toLowerCase();
                switch (action) {
                    case "borrow":
                        handleBorrowAction(scanner, library);
                        break;
                    case "return":
                        handleReturnAction(scanner, library);
                        break;
                    case "exit":
                        System.out.println("Exiting the system. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please enter 'borrow', 'return', or 'exit'.");
                        break;
                }
            }
        } 
    }

    private static void handleBorrowAction(Scanner scanner, Library library) {
        System.out.print("Enter the title of the book you want to borrow: ");
        String borrowTitle = scanner.nextLine().trim();
        System.out.print("Enter the author of the book you want to borrow: ");
        String borrowAuthor = scanner.nextLine().trim();
        library.borrowBook(borrowTitle, borrowAuthor);
    }

    private static void handleReturnAction(Scanner scanner, Library library) {
        System.out.print("Enter the title of the book you want to return: ");
        String returnTitle = scanner.nextLine().trim();
        System.out.print("Enter the author of the book you want to return: ");
        String returnAuthor = scanner.nextLine().trim();
        library.returnBook(returnTitle, returnAuthor);
    }
}