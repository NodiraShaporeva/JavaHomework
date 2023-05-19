import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую цифру: ");
        int firstDigit = scanner.nextInt();

        System.out.print("Введите вторую цифру: ");
        int secondDigit = scanner.nextInt();

        System.out.print("Введите третью цифру: ");
        int thirdDigit = scanner.nextInt();

        int result = firstDigit * 100 + secondDigit * 10 + thirdDigit;

        System.out.println("Результат: " + result);
    }
}