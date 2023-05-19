import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите шестизначное число: ");
        int number = scanner.nextInt();

        // Проверка на шестизначность числа
        if (number < 100000 || number > 999999) {
            System.out.println("Ошибка! Введено не шестизначное число.");
            return;
        }
        int[] digits = new int[6];
        for (int i=6; i>0;) {
            digits[--i] = number % 10;
            number /= 10;
        }

        int swappedNumber =
                digits[5] * 100000 +
                digits[4] * 10000 +
                digits[2] * 1000 +
                digits[3] * 100 +
                digits[1] * 10 +
                digits[0];

        System.out.println("Результат: " + swappedNumber);
    }
}