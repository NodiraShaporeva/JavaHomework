import java.util.Random;
import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
        // Создание и заполнение массива случайными числами
        int[] array = generateRandomArray(10, -100, 100);

        // Вывод исходного массива на экран
        System.out.println("Исходный массив: " + Arrays.toString(array));

        // Фильтрация массива и создание новых массивов
        int[] evenArray = filterEvenNumbers(array);
        int[] oddArray = filterOddNumbers(array);
        int[] negativeArray = filterNegativeNumbers(array);
        int[] positiveArray = filterPositiveNumbers(array);

        // Вывод результатов на экран
        System.out.println("Массив четных чисел: " + Arrays.toString(evenArray));
        System.out.println("Массив нечетных чисел: " + Arrays.toString(oddArray));
        System.out.println("Массив отрицательных чисел: " + Arrays.toString(negativeArray));
        System.out.println("Массив положительных чисел: " + Arrays.toString(positiveArray));
    }

    // Метод для генерации массива случайных чисел
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }

    // Метод для фильтрации четных чисел
    public static int[] filterEvenNumbers(int[] array) {
        int count = 0;

        // Подсчет количества четных чисел
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }

        // Создание нового массива для четных чисел
        int[] resultArray = new int[count];
        int index = 0;

        // Заполнение нового массива четными числами
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                resultArray[index] = array[i];
                index++;
            }
        }

        return resultArray;
    }

    // Метод для фильтрации нечетных чисел
    public static int[] filterOddNumbers(int[] array) {
        int count = 0;

        // Подсчет количества нечетных чисел
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                count++;
            }
        }

        // Создание нового массива для нечетных чисел
        int[] resultArray = new int[count];
        int index = 0;

        // Заполнение нового массива нечетными числами
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                resultArray[index] = array[i];
                index++;
            }
        }

        return resultArray;
    }

    // Метод для создания массива с отрицательными числами
    public static int[] filterNegativeNumbers(int[] array) {
        int count = 0;

        // Подсчет количества отрицательных чисел
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
            }
        }

        // Создание нового массива с отрицательными числами
        int[] negativeArray = new int[count];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negativeArray[index] = array[i];
                index++;
            }
        }

        return negativeArray;
    }

    // Метод для создания массива с положительными числами
    public static int[] filterPositiveNumbers(int[] array) {
        int count = 0;

        // Подсчет количества положительных чисел
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }

        // Создание нового массива с положительными числами
        int[] positiveArray = new int[count];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positiveArray[index] = array[i];
                index++;
            }
        }

        return positiveArray;
    }
}