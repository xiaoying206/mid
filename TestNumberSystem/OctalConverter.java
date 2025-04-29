public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(MyNumber number) {
        super(number);
    }

    @Override
    public void decimalTo(int num) {
        convertedNumber = new MyStack();
        if (num == 0) convertedNumber.push(0);
        while (num > 0) {
            convertedNumber.push(num % 8);
            num /= 8;
        }
    }

    @Override
    public void display() {
        System.out.println("Octal: " + convertedNumber.toString());
    }

    @Override
    public void update() {
        decimalTo(originalNumber.getData());
    }
}