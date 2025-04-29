import java.util.ArrayList;
import java.util.List;

public class MyNumber {
    private int number;
    private List<NumberConverter> converters;

    public MyNumber(int number) {
        this.number = number;
        this.converters = new ArrayList<>();
    }

    public void addConverter(NumberConverter converter) {
        converters.add(converter);
        converter.update();
    }

    public void removeConverter(NumberConverter converter) {
        converters.remove(converter);
    }

    public void notifyConverters() {
        for (NumberConverter converter : converters) {
            converter.update();
        }
    }

    public void onStateChanged() {
        notifyConverters();
    }

    public void setData(int number) {
        this.number = number;
        onStateChanged();
    }

    public int getData() {
        return number;
    }
}
