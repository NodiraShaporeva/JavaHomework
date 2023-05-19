import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение: ");
        double value = scanner.nextDouble();

        System.out.print("Введите процент: ");
        double percent = scanner.nextDouble();

        double result = (percent * value) / 100;

        System.out.println("Результат: " + result);
    }
}