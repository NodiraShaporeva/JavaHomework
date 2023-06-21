import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StreamExample2 {
    public static void main(String[] args) {
        List<String> products = Arrays.asList(
                "Apple", "Milk", "Bread", "Butter", "Banana", "Milk", "Cheese");

        System.out.println("Все продукты:");
        products
                .forEach(System.out::println);

        System.out.println("\nПродукты с названием меньше 5 символов:");
        products.stream()
                .filter(p -> p.length() < 5)
                .forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите название продукта для поиска: ");
        String searchProduct = scanner.nextLine();

        long occurrences = products.stream()
                .filter(p -> p.equalsIgnoreCase(searchProduct))
                .count();
        System.out.println("\nПродукт \"" + searchProduct + "\" встречается " + occurrences + " раз(а)");

        System.out.print("\nВведите букву для поиска продуктов, начинающихся на неё: ");
        String searchLetter = scanner.nextLine();
        System.out.println("\nПродукты, начинающиеся на букву \"" + searchLetter + "\":");
        products.stream()
                .filter(p -> p.startsWith(searchLetter))
                .forEach(System.out::println);

        System.out.println("\nПродукты из категории \"Milk\":");
        products.stream()
                .filter(p -> p.equalsIgnoreCase("Milk"))
                .forEach(System.out::println);
    }
}
