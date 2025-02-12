import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public void borrowBook(Borrower borrower, Book book) {
        if (books.contains(book)) {
            books.remove(book);
            borrower.borrowBook(book);
            System.out.println(borrower.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is not available.");
        }
    }

    public void returnBook(Borrower borrower, Book book) {
        if (borrower.returnBook(book)) {
            books.add(book);
            System.out.println(borrower.getName() + " returned: " + book.getTitle());
        }
    }

    public void displayLibraryBooks() {
        System.out.println("Books available in the library:");
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }
    
}
