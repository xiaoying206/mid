package hus.oop.book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        this.bookList = new ArrayList<>();
    }

    public void append(Book book) {
        bookList.add(book);
    }

    public void insertAtPosition(Book book, int index) {
        bookList.add(index, book);
    }

    public void remove(int index) {
        bookList.remove(index);
    }

    public Book bookAt(int index) {
        return bookList.get(index);
    }

    public int numberOfBooks() {
        return bookList.size();
    }

    public double totalPrice() {
        return bookList.stream().mapToDouble(Book::getPrice).sum();
    }

    public double totalPages() {
        return bookList.stream().mapToDouble(Book::getPages).sum();
    }

    public List<Book> sortIncreasingByTitle() {
        List<Book> result = new ArrayList<>(bookList);
        result.sort(Book::compareTo);
        return result;
    }

    public List<Book> sortByPublisherAndPrice() {
        List<Book> result = new ArrayList<>(bookList);
        result.sort((b1, b2) -> {
            int cmp = b1.getPublisher().compareToIgnoreCase(b2.getPublisher());
            if (cmp == 0) {
                return Double.compare(b2.getPrice(), b1.getPrice()); // giảm dần giá
            }
            return cmp;
        });
        return result;
    }
    public void print(List<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("Danh sách sách rỗng.");
            return;
        }
        // Duyệt qua danh sách và in từng đối tượng Book
        for (Book book : books) {
            System.out.println(book); // Phương thức này gọi book.toString()
        }
    }

    public List<Book> sortIncreasingPrice() {
        List<Book> result = new ArrayList<>(bookList);
        result.sort(Comparator.comparingDouble(Book::getPrice));
        return result;
    }

    public List<Book> sortDecreasingPrice() {
        List<Book> result = new ArrayList<>(bookList);
        result.sort((b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice()));
        return result;
    }

    public List<Book> filterBooksOfGenre(String genre) {
        return bookList.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksOfAuthor(String author) {
        return bookList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksOfPublisher(String publisher) {
        return bookList.stream()
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookList);
    }
}
