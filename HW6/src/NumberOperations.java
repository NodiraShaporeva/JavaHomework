import java.util.function.BinaryOperator;

public class NumberOperations {
    public static void main(String[] args) {
        // Maximum of four numbers
        BinaryOperator<Integer> maximum = (a, b) -> a > b ? a : b;
        BinaryOperator<Integer> maximumOfFour = (a, b) -> maximum.apply(maximum.apply(a, b), maximum.apply(b, a));

        // Minimum of four numbers
        BinaryOperator<Integer> minimum = (a, b) -> a < b ? a : b;
        BinaryOperator<Integer> minimumOfFour = (a, b) -> minimum.apply(minimum.apply(a, b), minimum.apply(b, a));

        // Test the lambda expressions
        int number1 = 10;
        int number2 = 5;
        int number3 = 8;
        int number4 = 3;

        int max = maximumOfFour.apply(number1, maximumOfFour.apply(number2, maximumOfFour.apply(number3, number4)));
        int min = minimumOfFour.apply(number1, minimumOfFour.apply(number2, minimumOfFour.apply(number3, number4)));

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
