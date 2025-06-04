package after;
public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    
    public boolean borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            return true; 
        }
        return false; 
    }

    public boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            return true; 
        }
        return false; 
    }

    public boolean isAvailable() {
        return !isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}

   
    