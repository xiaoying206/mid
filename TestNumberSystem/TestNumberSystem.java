public class TestNumberSystem {
    public static void main(String[] args) {
        MyNumber number = new MyNumber(10);
        BinaryConverter binary = new BinaryConverter(number);
        OctalConverter octal = new OctalConverter(number);

        number.addConverter(binary);
        number.addConverter(octal);

        binary.display();
        octal.display();

        System.out.println("Changing number to 25...");
        number.setData(25);

        binary.display();
        octal.display();
    }
}