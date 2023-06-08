import java.util.function.IntPredicate;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum1 = findSum(numbers, num -> num == 5);
        System.out.println("Sum of elements equal to 5: " + sum1);

        int sum2 = findSum(numbers, num -> num < 3 || num > 7);
        System.out.println("Sum of elements not in the range [3, 7]: " + sum2);

        int sum3 = findSum(numbers, num -> num > 0);
        System.out.println("Sum of positive elements: " + sum3);

        int sum4 = findSum(numbers, num -> num < 0);
        System.out.println("Sum of negative elements: " + sum4);
    }

    public static int findSum(int[] array, IntPredicate condition) {
        int sum = 0;
        for (int num : array) {
            if (condition.test(num)) {
                sum += num;
            }
        }
        return sum;
    }
}
