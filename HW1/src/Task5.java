import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер месяца (от 1 до 12): ");
        int month = scanner.nextInt();

        String season;

        switch (month) {
            case 1, 2, 12 -> season = "Winter";
            case 3, 4, 5 -> season = "Spring";
            case 6, 7, 8 -> season = "Summer";
            case 9, 10, 11 -> season = "Autumn";
            default -> {
                System.out.println("Ошибка! Введен неверный номер месяца.");
                return;
            }
        }
        System.out.println("Сезон: " + season);
   }
}