import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начало диапазона: ");
        int start = scanner.nextInt();

        System.out.print("Введите конец диапазона: ");
        int end = scanner.nextInt();

        System.out.println("Таблица умножения в диапазоне [" + start + ", " + end + "]:");
        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }
}