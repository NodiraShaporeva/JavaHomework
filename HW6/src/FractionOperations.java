import java.util.function.BiFunction;

public class FractionOperations {
    public static void main(String[] args) {
        // Sum of two fractions
        BiFunction<Pair<Integer, Integer>, Pair<Integer, Integer>, Pair<Integer, Integer>> sum = (fraction1, fraction2) -> {
            int numerator = fraction1.first() * fraction2.second() + fraction2.first() * fraction1.second();
            int denominator = fraction1.second() * fraction2.second();
            return new Pair<>(numerator, denominator);
        };

        // Difference of two fractions
        BiFunction<Pair<Integer, Integer>, Pair<Integer, Integer>, Pair<Integer, Integer>> difference = (fraction1, fraction2) -> {
            int numerator = fraction1.first() * fraction2.second() - fraction2.first() * fraction1.second();
            int denominator = fraction1.second() * fraction2.second();
            return new Pair<>(numerator, denominator);
        };

        // Product of two fractions
        BiFunction<Pair<Integer, Integer>, Pair<Integer, Integer>, Pair<Integer, Integer>> product = (fraction1, fraction2) -> {
            int numerator = fraction1.first() * fraction2.first();
            int denominator = fraction1.second() * fraction2.second();
            return new Pair<>(numerator, denominator);
        };

        // Division of two fractions
        BiFunction<Pair<Integer, Integer>, Pair<Integer, Integer>, Pair<Integer, Integer>> division = (fraction1, fraction2) -> {
            int numerator = fraction1.first() * fraction2.second();
            int denominator = fraction1.second() * fraction2.first();
            return new Pair<>(numerator, denominator);
        };

        // Test the lambda expressions
        Pair<Integer, Integer> fraction1 = new Pair<>(1, 2);
        Pair<Integer, Integer> fraction2 = new Pair<>(3, 4);

        Pair<Integer, Integer> sumResult = sum.apply(fraction1, fraction2);
        Pair<Integer, Integer> differenceResult = difference.apply(fraction1, fraction2);
        Pair<Integer, Integer> productResult = product.apply(fraction1, fraction2);
        Pair<Integer, Integer> divisionResult = division.apply(fraction1, fraction2);

        System.out.println("Sum: " + sumResult.first() + "/" + sumResult.second());
        System.out.println("Difference: " + differenceResult.first() + "/" + differenceResult.second());
        System.out.println("Product: " + productResult.first() + "/" + productResult.second());
        System.out.println("Division: " + divisionResult.first() + "/" + divisionResult.second());
    }
}

record Pair<T, U>(T first, U second) {
}
