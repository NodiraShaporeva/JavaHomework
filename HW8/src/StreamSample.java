import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamSample {
    public static void main(String[] args) {
        List<Projector> projectors = Arrays.asList(
                new Projector("Epson", 2020, 999.99, "Epson"),
                new Projector("BenQ", 2021, 1499.99, "BenQ"),
                new Projector("Sony", 2019, 1999.99, "Sony"),
                new Projector("LG", 2022, 799.99, "LG"),
                new Projector("Optoma", 2023, 1299.99, "Optoma")
        );

        System.out.println("Все проекторы:");
        projectors.forEach(System.out::println);

        String searchManufacturer = "Epson";
        System.out.println("\nПроекторы производителя \"" + searchManufacturer + "\":");
        projectors.stream()
                .filter(p -> p.manufacturer().equalsIgnoreCase(searchManufacturer))
                .forEach(System.out::println);

        int currentYear = 2023;
        System.out.println("\nПроекторы текущего года (" + currentYear + "):");
        projectors.stream()
                .filter(p -> p.year() == currentYear)
                .forEach(System.out::println);

        double searchPrice = 1500.0;
        System.out.println("\nПроекторы дороже " + searchPrice + ":");
        projectors.stream()
                .filter(p -> p.price() > searchPrice)
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по цене по возрастанию:");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::price))
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по цене по убыванию:");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::price).reversed())
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по году выпуска по возрастанию:");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::year))
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по году выпуска по убыванию:");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::year).reversed())
                .forEach(System.out::println);
    }
}
