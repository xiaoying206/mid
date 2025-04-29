package hus.oop.book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList; // Không sử dụng LinkedList ở đây, có thể bỏ import nếu không dùng
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    // bookManager được khai báo static theo mẫu
    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        init(); // Khởi tạo dữ liệu từ file

        // Thực hiện chạy từng hàm test theo yêu cầu
        System.out.println("--- Bắt đầu chạy các bài kiểm tra ---");

        testOriginalData();
        testSortIncreasingTitle();
        testSortPublisherAndPrice();
        testPriceOfBooksIncreasing();
        testPriceOfBooksDecreasing();

        // Cần cung cấp giá trị cụ thể để lọc
        testFilterBooksOfAuthor("J.R.R. Tolkien");
        testFilterBooksOfPublisher("Penguin");
        testFilterBooksOfGenre("data_science");

        // Các hàm test tính tổng trả về giá trị và in ra
        int totalPages = testTotalPages();
        double totalPrice = testTotalPrice();

        System.out.println("--- Kết thúc chạy các bài kiểm tra ---");

        // Có thể in lại kết quả tổng ở đây nếu cần
        // System.out.println("\nKết quả tổng cuối cùng:");
        // System.out.println("Tổng số trang: " + totalPages);
        // System.out.println("Tổng giá: " + totalPrice);
    }

    public static void init() {
        // Sử dụng đường dẫn tương đối được cung cấp trong mẫu
        String filePath = "data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            System.out.println("--- Đang đọc dữ liệu từ file: " + filePath + " ---");
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            boolean isHeader = true; // Biến để bỏ qua dòng header
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);

                if (isHeader) {
                    isHeader = false;
                    continue; // Bỏ qua dòng header
                }

                // Kiểm tra xem có đúng 6 cột dữ liệu không
                if (dataList.size() != 6) {
                    System.err.println("Dòng dữ liệu không hợp lệ (không đủ 6 phần tử): " + line);
                    continue; // Bỏ qua dòng không hợp lệ
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào bookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */

                try {
                    // Lấy dữ liệu từ List<String>, trim khoảng trắng
                    String title = dataList.get(0).trim();
                    String author = dataList.get(1).trim();
                    String genre = dataList.get(2).trim();
                    // Chuyển đổi sang kiểu số, xử lý lỗi NumberFormatException
                    int pages = Integer.parseInt(dataList.get(3).trim());
                    double price = Double.parseDouble(dataList.get(4).trim());
                    String publisher = dataList.get(5).trim(); // Nhà xuất bản có thể rỗng

                    // Sử dụng Builder Pattern để tạo đối tượng Book
                    Book newBook = new Book.BookBuilder(title)
                            .withAuthor(author)
                            .withGenre(genre)
                            .withPages(pages)
                            .withPrice(price)
                            .withPublisher(publisher)
                            .build();

                    // Thêm sách vào BookManager
                    bookManager.append(newBook);

                } catch (NumberFormatException e) {
                    System.err.println("Lỗi định dạng số khi đọc dòng: " + line + " - " + e.getMessage());
                } catch (Exception e) {
                    // Bắt các ngoại lệ khác có thể xảy ra
                    System.err.println("Lỗi không xác định khi xử lý dòng: " + line + " - " + e.getMessage());
                    e.printStackTrace(); // In stack trace để debug chi tiết hơn
                }
            }
            System.out.println("Đọc dữ liệu hoàn tất. Số lượng sách đã đọc: " + bookManager.numberOfBooks());

        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file " + filePath + ": " + e.getMessage());
            e.printStackTrace(); // In stack trace nếu file không tìm thấy, vv.
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) { // Tên biến crunchifyException theo mẫu
                crunchifyException.printStackTrace();
            }
        }
        System.out.println("----------------------------------------\n");
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            // Sử dụng split với giới hạn -1 để giữ lại cả các trường rỗng cuối dòng nếu có
            String[] splitData = dataLine.split(COMMA_DELIMITER, -1);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    // Hàm này không được sử dụng trong readListData hiện tại, giữ nguyên theo mẫu
    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }
        // Sử dụng split với giới hạn -1 để giữ lại cả các trường rỗng cuối dòng nếu có
        return dataLine.split(COMMA_DELIMITER, -1);
    }

    /*
     * In ra danh sách book theo thứ tự đọc vào ban đầu, mỗi book được in trên 1 dòng theo format book
     * được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testOriginalData() {
        /* TODO */
        System.out.println("Tên test: testOriginalData");
        System.out.println("Kết quả chạy chương trình:");
        bookManager.print(bookManager.getAllBooks()); // Giả định BookManager có method getAllBooks()
        System.out.println(); // Xuống dòng sau mỗi test
    }

    /*
     * In ra danh sách book theo thứ tự tăng dần của title, mỗi book được in trên 1 dòng theo format book
     * được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testSortIncreasingTitle() {
        /* TODO */ // Đã hoàn thành phần TODO bằng cách gọi hàm
        System.out.println("Tên test: testSortIncreasingTitle");
        System.out.println("Kết quả chạy chương trình:");
        // >>> SỬA DÒNG NÀY <<<
        List<Book> sortedBooks = bookManager.sortIncreasingByTitle(); // Sửa tên phương thức ở đây
        bookManager.print(sortedBooks);
        System.out.println();
    }

    /*
     * Test in ra book sắp xếp theo tiêu chí: đầu tiên theo publisher tăng dần, nếu cùng publisher thì theo thứ tự giá giảm dần.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testSortPublisherAndPrice() {
        /* TODO */
        System.out.println("Tên test: testSortPublisherAndPrice");
        System.out.println("Kết quả chạy chương trình:");
        List<Book> sortedBooks = bookManager.sortByPublisherAndPrice();
        bookManager.print(sortedBooks);
        System.out.println();
    }

    /*
     * Test in ra danh sách book theo giá tăng dần.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        System.out.println("Tên test: testPriceOfBooksIncreasing");
        System.out.println("Kết quả chạy chương trình:");
        List<Book> sortedBooks = bookManager.sortIncreasingPrice();
        bookManager.print(sortedBooks);
        System.out.println();
    }

    /*
     * Test in ra danh sách book theo giá giảm dần.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        System.out.println("Tên test: testPriceOfBooksDecreasing");
        System.out.println("Kết quả chạy chương trình:");
        List<Book> sortedBooks = bookManager.sortDecreasingPrice();
        bookManager.print(sortedBooks);
        System.out.println();
    }

    /*
     * Test in ra danh sách book theo tác giả.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfAuthor(String author) {
        /* TODO */
        System.out.println("Tên test: testFilterBooksOfAuthor (author='" + author + "')");
        System.out.println("Kết quả chạy chương trình:");
        List<Book> filteredBooks = bookManager.filterBooksOfAuthor(author);
        bookManager.print(filteredBooks);
        System.out.println();
    }

    /*
     * Test in ra danh sách book theo nhà xuất bản.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfPublisher(String publisher) {
        /* TODO */
        System.out.println("Tên test: testFilterBooksOfPublisher (publisher='" + publisher + "')");
        System.out.println("Kết quả chạy chương trình:");
        List<Book> filteredBooks = bookManager.filterBooksOfPublisher(publisher);
        bookManager.print(filteredBooks);
        System.out.println();
    }

    /*
     * Test in ra danh sách book theo thể loại.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfGenre(String genre) {
        /* TODO */
        System.out.println("Tên test: testFilterBooksOfGenre (genre='" + genre + "')");
        System.out.println("Kết quả chạy chương trình:");
        List<Book> filteredBooks = bookManager.filterBooksOfGenre(genre);
        bookManager.print(filteredBooks);
        System.out.println();
    }

    /*
     * In ra tổng số trang của tất cả các book.
     */
    public static int testTotalPages() {
        /* TODO */
        System.out.println("Tên test: testTotalPages");
        System.out.println("Kết quả chạy chương trình:");
        // bookManager.totalPages() được giả định trả về double,
        // làm tròn và cast về int để khớp với kiểu trả về của App.testTotalPages()
        double total = bookManager.totalPages();
        int totalInt = (int) Math.round(total);
        System.out.println("Tổng số trang: " + totalInt);
        System.out.println();
        return totalInt; // Trả về int theo yêu cầu
    }

    /*
     * In ra tổng giá của tất cả các sách.
     */
    public static double testTotalPrice() {
        /* TODO */
        System.out.println("Tên test: testTotalPrice");
        System.out.println("Kết quả chạy chương trình:");
        double total = bookManager.totalPrice();
        System.out.printf("Tổng giá: %.2f\n", total); // Định dạng 2 chữ số thập phân cho giá
        System.out.println();
        return total; // Trả về double theo yêu cầu
    }
}