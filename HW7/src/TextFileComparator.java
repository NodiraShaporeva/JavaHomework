import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextFileComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод путей к файлам
        System.out.print("Введите путь к первому файлу: ");
        String filePath1 = scanner.nextLine();

        System.out.print("Введите путь ко второму файлу: ");
        String filePath2 = scanner.nextLine();

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
            BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
            for (int i = 1; ; i++) {
                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                if (line2 == null || line1 == null) {
                    if (line2 != null) {
                        System.out.println("Файл 1 короче. Первая пропущенная строка: " + line2);
                    } else if (line1 != null) {
                        System.out.println("Файл 2 короче. Первая пропущенная строка: " + line1);
                    } else {
                        System.out.println("Все строки совпадают!");
                    }
                    break;
                }
                if (!line1.equals(line2)) {
                    System.out.println("Несовпадение в строке " + i + ":");
                    System.out.println("Файл 1: " + line1);
                    System.out.println("Файл 2: " + line2);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("IO ex");
        }
    }
}
