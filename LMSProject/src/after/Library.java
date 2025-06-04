package after;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    private Book findBook(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        boolean found = false;
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are currently available in the library.");
        }
    }

    public void borrowBook(String title, String author) {
        Book bookToBorrow = findBook(title, author);

        if (bookToBorrow != null) { 
            if (bookToBorrow.isAvailable()) {
                if (bookToBorrow.borrowBook()) { 
                    System.out.println("You have successfully borrowed '" + title + "' by " + author + ".");
                } else {
                    System.out.println("Failed to borrow '" + title + "' by " + author + ". An unexpected issue occurred.");
                }
            } else { 
                System.out.println("Sorry, '" + title + "' by " + author + " is already borrowed.");
            }
        } else { 
            System.out.println("Sorry, the book '" + title + "' by " + author + " was not found in the library.");
        }
    }

    public void returnBook(String title, String author) {
        Book bookToReturn = findBook(title, author);

        if (bookToReturn != null) { 
            if (bookToReturn.isBorrowed()) {
                if (bookToReturn.returnBook()) { 
                    System.out.println("You have successfully returned '" + title + "' by " + author + ".");
                } else {
                    System.out.println("Failed to return '" + title + "' by " + author + ". An unexpected issue occurred.");
                }
            } else { 
                System.out.println("This book, '" + title + "' by " + author + ", was not borrowed or is already available.");
            }
        } else { 
            System.out.println("Sorry, the book '" + title + "' by " + author + " was not found in the library.");
        }
    }
}
    
        