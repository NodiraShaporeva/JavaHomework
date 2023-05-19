import java.util.Scanner;
import java.util.Arrays;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание и заполнение массива
        int[] array = {5, 2, 8, 1, 9, 3};

        // Вывод исходного массива на экран
        System.out.println("Исходный массив: " + Arrays.toString(array));

        // Запрос выбора пользователя
        System.out.print("Выберите тип сортировки (1 - по возрастанию, 2 - по убыванию): ");
        int choice = scanner.nextInt();

        // Сортировка массива в зависимости от выбора пользователя
        if (choice == 1) {
            sortAscending(array);
            System.out.println("Массив, отсортированный по возрастанию: " + Arrays.toString(array));
        } else if (choice == 2) {
            sortDescending(array);
            System.out.println("Массив, отсортированный по убыванию: " + Arrays.toString(array));
        } else {
            System.out.println("Неверный выбор. Пожалуйста, выберите 1 или 2.");
        }
    }

    // Метод для сортировки массива по возрастанию
    public static void sortAscending(int[] array) {
        Arrays.sort(array);
    }

    // Метод для сортировки массива по убыванию
    public static void sortDescending(int[] array) {
        Arrays.sort(array);
        reverseArray(array);
    }

    // Метод для переворота массива
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}