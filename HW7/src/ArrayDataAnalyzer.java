import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayDataAnalyzer {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\NODIRA\\Downloads\\2.txt"; // Замените на фактический путь к вашему файлу

        try {
            int[][] arrays = readArraysFromFile(filePath);

            // Обработка и отображение данных для каждого массива
            for (int i = 0; i < arrays.length; i++) {
                int[] array = arrays[i];
                System.out.println("Массив #" + (i + 1) + ":");
                displayArray(array);
                int min = findMin(array);
                int max = findMax(array);
                int sum = calculateSum(array);
                System.out.println("Минимальный элемент: " + min);
                System.out.println("Максимальный элемент: " + max);
                System.out.println("Сумма элементов: " + sum);
                System.out.println();
            }

            // Нахождение максимального и минимального элементов среди всех массивов
            int overallMin = Integer.MAX_VALUE;
            int overallMax = Integer.MIN_VALUE;
            int overallSum = 0;
            for (int[] array : arrays) {
                int min = findMin(array);
                int max = findMax(array);
                int sum = calculateSum(array);
                overallMin = Math.min(overallMin, min);
                overallMax = Math.max(overallMax, max);
                overallSum += sum;
            }

            // Вывод общих результатов
            System.out.println("Максимальный элемент среди всех массивов: " + overallMax);
            System.out.println("Минимальный элемент среди всех массивов: " + overallMin);
            System.out.println("Общая сумма всех массивов: " + overallSum);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static int[][] readArraysFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int[][] arrays;
        int arrayCount = 0;
        while (reader.readLine() != null) {
            arrayCount++;
        }
        reader.close();

        reader = new BufferedReader(new FileReader(filePath));
        arrays = new int[arrayCount][];
        int index = 0;
        while ((line = reader.readLine()) != null) {
            String[] elements = line.split(" ");
            int[] array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
            arrays[index] = array;
            index++;
        }
        reader.close();

        return arrays;
    }

    private static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int calculateSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
}
