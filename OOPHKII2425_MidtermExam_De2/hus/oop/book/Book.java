package hus.oop.book;

public class Book implements MyBookComparable {
    private String title;
    private String author;
    private String genre;
    private int pages;
    private double price;
    private String publisher;

    private Book() {}

    public static class BookBuilder {
        private String title;
        private String author;
        private String genre;
        private int pages;
        private double price;
        private String publisher;

        public BookBuilder(String title) {
            this.title = title;
        }

        public BookBuilder withAuthor(String author) {
            /* TODO */
        }

        public BookBuilder withGenre(String genre) {
            /* TODO */
        }

        public BookBuilder withPages(int pages) {
            /* TODO */
        }

        public BookBuilder withPrice(double price) {
            /* TODO */
        }

        public BookBuilder withPublisher(String publisher) {
            /* TODO */
        }

        public Book build() {
            Book book = new Book();
            book.title = this.title;
            book.author = this.author;
            book.genre = this.genre;
            book.pages = this.pages;
            book.price = this.price;
            book.publisher = this.publisher;
            return book;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    /**
     * Mô tả book theo định dạng sau: [Title, publisher, author, genre, pages, price]
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
    }

    /**
     * Phương thức đưa ra tiêu chí so sánh 2 Book sao cho thứ tự tăng dần theo title.
     * @param another
     * @return
     */
    @Override
    public int compareTo(Book another) {
        /* TODO */
    }
}
