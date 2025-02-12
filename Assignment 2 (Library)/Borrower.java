import java.util.ArrayList;
import java.util.List;

class Borrower {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Borrower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }

    public void displayBorrowedBooks() {
        System.out.println(name + " has borrowed the following books:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book);
        }
    }
}