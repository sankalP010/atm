import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books
        library.addBook(new Book("Book 1", "Author 1"));
        library.addBook(new Book("Book 2", "Author 2"));
        library.addBook(new Book("Book 3", "Author 1"));

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search by Title");
            System.out.println("4. Search by Author");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    List<Book> removeResults = library.searchByTitle(removeTitle);
                    if (removeResults.isEmpty()) {
                        System.out.println("Book not found!");
                    } else {
                        for (Book book : removeResults) {
                            library.removeBook(book);
                            System.out.println("Book removed: " + book.getTitle());
                        }
                    }
                    break;
                case 3:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> searchResults = library.searchByTitle(searchTitle);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found with that title.");
                    } else {
                        System.out.println("Search Results:");
                        for (Book book : searchResults) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor());
                        }
                    }
                    break;
                case 4:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book author to search: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> searchAuthorResults = library.searchByAuthor(searchAuthor);
                    if (searchAuthorResults.isEmpty()) {
                        System.out.println("No books found with that author.");
                    } else {
                        System.out.println("Search Results:");
                        for (Book book : searchAuthorResults) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

            System.out.println(); // Print a blank line for separation
        } while (choice != 5);

        scanner.close();
    }
}
