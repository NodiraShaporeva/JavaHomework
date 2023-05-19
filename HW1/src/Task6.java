import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество метров: ");
        double meters = scanner.nextDouble();

        System.out.println("Выберите единицу измерения для конвертации:");
        System.out.println("1. Мили");
        System.out.println("2. Дюймы");
        System.out.println("3. Ярды");
        System.out.print("Введите номер: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 3) {
            System.out.println("Ошибка! Неверный выбор единицы измерения.");
            return;
        }

        String[] units = {" миль", " дюймов", " ярдов"};
        double[] scale = {0.000621371, 39.3701, 1.09361};
        System.out.println("Результат: " + (meters * scale[choice - 1]) + units[choice - 1]);
/*
        switch (choice) {
            case 1 -> {
                convertedLength = meters * 0.000621371;
                units =
                System.out.println("Результат: " + convertedLength + " миль");
            }
            case 2 -> {
                convertedLength = meters * 39.3701;
                System.out.println("Результат: " + convertedLength + " дюймов");
            }
            case 3 -> {
                convertedLength = meters * 1.09361;
                System.out.println("Результат: " + convertedLength + " ярдов");
            }
            default -> System.out.println("Ошибка! Неверный выбор единицы измерения.");
        }
 */
    }
}