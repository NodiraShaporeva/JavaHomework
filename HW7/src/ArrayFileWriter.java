import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayFileWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод пути к файлу
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        // Ввод массива
        System.out.print("Введите элементы массива через пробел: ");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        int[] array = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }

        try {
            // Запись данных в файл
            writeArrayToFile(filePath, array);

            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private static void writeArrayToFile(String filePath, int[] array) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        // Запись исходного массива
        for (int element : array) {
            writer.write(element + " ");
        }
        writer.newLine();

        // Запись четных значений
        for (int element : array) {
            if (element % 2 == 0) {
                writer.write(element + " ");
            }
        }
        writer.newLine();

        // Запись нечетных значений
        for (int element : array) {
            if (element % 2 != 0) {
                writer.write(element + " ");
            }
        }
        writer.newLine();

        // Запись перевернутого массива
        for (int i = array.length - 1; i >= 0; i--) {
            writer.write(array[i] + " ");
        }

        writer.close();
    }
}
