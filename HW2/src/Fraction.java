public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction add(Fraction f) {
        int newDenominator = denominator * f.denominator;
        int newNumerator = (numerator * f.denominator) + (f.numerator * denominator);

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction f) {
        int newDenominator = denominator * f.denominator;
        int newNumerator = (numerator * f.denominator) - (f.numerator * denominator);

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction f) {
        int newNumerator = numerator * f.numerator;
        int newDenominator = denominator * f.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction f) {
        int newNumerator = numerator * f.denominator;
        int newDenominator = denominator * f.numerator;

        return new Fraction(newNumerator, newDenominator);
    }

    public void display() {
        System.out.println(numerator + "/" + denominator);
    }

    public static void main(String[] args) {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction1 = new Fraction(3, 4);

        // Сложение
        Fraction sum = fraction.add(fraction1);
        System.out.print("Сумма: ");
        sum.display();

        // Вычитание
        Fraction difference = fraction.subtract(fraction1);
        System.out.print("Разность: ");
        difference.display();

        // Умножение
        Fraction product = fraction.multiply(fraction1);
        System.out.print("Произведение: ");
        product.display();

        // Деление
        Fraction quotient = fraction.divide(fraction1);
        System.out.print("Частное: ");
        quotient.display();
    }
}
