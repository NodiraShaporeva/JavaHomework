import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        // Нормализация границ диапазона
        int start = Math.min(number1, number2);
        int end = Math.max(number1, number2);

        System.out.println("Нечетные числа в диапазоне [" + start + ", " + end + "]:");
        if (start % 2 == 0) ++start;  // start |= 1;
        for (int i = start; i <= end; i += 2) {
            System.out.println(i);
        }
    }
}