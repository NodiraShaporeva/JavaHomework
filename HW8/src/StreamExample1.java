import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(100);

        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();

        long negativeCount = numbers.stream()
                .filter(n -> n < 0)
                .count();

        long twoDigitCount = numbers.stream()
                .filter(n -> n >= 10 && n <= 99)
                .count();

        long mirrorNumberCount = numbers.stream()
                .filter(StreamExample1::isMirrorNumber)
                .count();

        System.out.println("Количество положительных чисел: " + positiveCount);
        System.out.println("Количество отрицательных чисел: " + negativeCount);
        System.out.println("Количество двухзначных чисел: " + twoDigitCount);
        System.out.println("Количество зеркальных чисел: " + mirrorNumberCount);
    }

    private static List<Integer> generateRandomNumbers(int count) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(201) - 100;  // Генерируем числа от -100 до 100
            numbers.add(number);
        }
        return numbers;
    }

    private static boolean isMirrorNumber(int number) {
        String numberStr = String.valueOf(number);
        String reverseNumberStr = new StringBuilder(numberStr).reverse().toString();
        return numberStr.equals(reverseNumberStr);
    }
}
