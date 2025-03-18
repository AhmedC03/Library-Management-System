import java.util.Arrays;
import java.util.Scanner;

class Library {
    private String[] books;
    private int numberOfBooks;
    private static int totalBooksAdded = 0;
    
    public Library() {
        books = new String[3]; // Initial capacity is 3
        numberOfBooks = 0;
    }
    
    public void addBook(String title) {
        if (numberOfBooks == books.length) {
            resizeLibrary();
        }
        books[numberOfBooks++] = title;
        totalBooksAdded++;
    }
    
    private void resizeLibrary() {
        books = Arrays.copyOf(books, books.length * 2);
    }
    
    public String[] getBooks() {
        return Arrays.copyOf(books, numberOfBooks);
    }
    
    public void removeBook(String title) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i].equals(title)) {
                for (int j = i; j < numberOfBooks - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--numberOfBooks] = null;
                return;
            }
        }
    }
    
    public static int getTotalBooksAdded() {
        return totalBooksAdded;
    }
}

public class TestLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add a book");
            System.out.println("2. View books");
            System.out.println("3. Remove a book");
            System.out.println("4. View total books added");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String bookTitle = scanner.nextLine();
                    library.addBook(bookTitle);
                    break;
                case 2:
                    System.out.println("Books: " + Arrays.toString(library.getBooks()));
                    break;
                case 3:
                    System.out.print("Enter book title to remove: ");
                    String bookToRemove = scanner.nextLine();
                    library.removeBook(bookToRemove);
                    break;
                case 4:
                    System.out.println("Total books ever added: " + Library.getTotalBooksAdded());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
