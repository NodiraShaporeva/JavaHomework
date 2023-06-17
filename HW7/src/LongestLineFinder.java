import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LongestLineFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод пути к файлу
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        try {
            // Чтение файла и поиск самой длинной строки
            String longestLine = findLongestLine(filePath);

            // Вывод результатов
            System.out.println("Самая длинная строка:");
            System.out.println(longestLine);
            System.out.println("Длина строки: " + longestLine.length());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static String findLongestLine(String filePath) throws IOException {
        String longestLine = "";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.length() > longestLine.length()) {
                longestLine = line;
            }
        }
        reader.close();
        return longestLine;
    }
}
