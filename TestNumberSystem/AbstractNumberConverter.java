public abstract class AbstractNumberConverter implements NumberConverter {
    protected MyNumber originalNumber;
    protected MyStack convertedNumber;

    public AbstractNumberConverter(MyNumber number) {
        this.originalNumber = number;
        this.convertedNumber = new MyStack();
    }

    public abstract void decimalTo(int num);
}