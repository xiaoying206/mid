public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(MyNumber number) {
        super(number);
    }

    @Override
    public void decimalTo(int num) {
        convertedNumber = new MyStack();
        if (num == 0) convertedNumber.push(0);
        while (num > 0) {
            convertedNumber.push(num % 2);
            num /= 2;
        }
    }

    @Override
    public void display() {
        System.out.println("Binary: " + convertedNumber.toString());
    }

    @Override
    public void update() {
        decimalTo(originalNumber.getData());
    }
}