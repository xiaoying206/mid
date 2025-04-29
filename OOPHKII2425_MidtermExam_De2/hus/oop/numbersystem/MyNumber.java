package hus.oop.numbersystem;

import java.util.List;

public class MyNumber {
    private int number;  // Số ban đầu trong hệ thập phân
    private List<NumberConverter> converters;  // Danh sách các converter theo observer pattern

    public MyNumber(int number) {
        /* TODO */
    }

    /*
     * Thêm vào converter để quan sát số ban đầu.
     * @param converter
     */
    public void addConverter(NumberConverter converter) {
        /* TODO */
    }

    /*
     * Hủy quan sát số ban đầu của converter.
     * @param converter
     */
    public void removeConverter(NumberConverter converter) {
        /* TODO */
    }

    /*
     * Khi có sự thay đổi trạng thái (biểu diễn số hoặc cơ số), thông báo cho tất cả
     * các converter đang ký quan sát để cập nhật lại trạng thái theo dữ liệu mới.
     */
    public void notifyConverters() {
        /* TODO */
    }

    public void setNumber(int number) {
        /* TODO */
    }

    public int getNumber() {
        /* TODO */
    }

    /*
     * Được gọi khi có sự thay đổi về trạng thái (biểu diến số hoặc cơ số),
     * hàm này sẽ gọi hàm để thông báo cho tất cả các observer đang ký quan sát
     * cập nhật lại trạng thái.
     */
    private void onStateChanged() {
        /* TODO */
    }
}