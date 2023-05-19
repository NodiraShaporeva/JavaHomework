import java.util.Random;

public class Task9 {
    public static void main(String[] args) {
        // Создание и заполнение массива случайными числами
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21) - 10; // Генерация случайного числа от -10 до 10
        }

        // Поиск минимального и максимального элементов
        int min = array[0];
        int max = array[0];

        // Подсчет количества отрицательных, положительных и нулевых элементов
        int countNegative = 0;
        int countPositive = 0;
        int countZero = 0;

        for (int i = 0; i < array.length; i++) {
            int element = array[i];

            // Поиск минимального и максимального элементов
            if (element < min) {
                min = element;
            } else if (element > max) {
                max = element;
            }

            // Подсчет количества отрицательных, положительных и нулевых элементов
            if (element < 0) {
                countNegative++;
            } else if (element > 0) {
                countPositive++;
            } else {
                countZero++;
            }
        }

        // Вывод результатов на экран
        System.out.println("Массив случайных чисел:");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Количество отрицательных элементов: " + countNegative);
        System.out.println("Количество положительных элементов: " + countPositive);
        System.out.println("Количество нулевых элементов: " + countZero);
    }
}