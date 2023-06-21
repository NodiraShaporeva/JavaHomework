import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Device> devices = Arrays.asList(
                new Device("Phone", 2020, 999.99, "Black", "Mobile"),
                new Device("Laptop", 2019, 1499.99, "Silver", "Computer"),
                new Device("Tablet", 2021, 799.99, "White", "Mobile"),
                new Device("Smartwatch", 2022, 299.99, "Black", "Wearable"),
                new Device("TV", 2018, 1999.99, "Black", "Appliance")
        );

        System.out.println("Все устройства:");
        devices.forEach(System.out::println);

        String searchColor = "Black";
        System.out.println("\nУстройства цвета \"" + searchColor + "\":");
        devices.stream()
                .filter(d -> d.color().equalsIgnoreCase(searchColor))
                .forEach(System.out::println);

        int searchYear = 2020;
        System.out.println("\nУстройства выпущенные в " + searchYear + " году:");
        devices.stream()
                .filter(d -> d.year() == searchYear)
                .forEach(System.out::println);

        double searchPrice = 1000.0;
        System.out.println("\nУстройства дороже " + searchPrice + ":");
        devices.stream()
                .filter(d -> d.price() > searchPrice)
                .forEach(System.out::println);

        String searchType = "Mobile";
        System.out.println("\nУстройства типа \"" + searchType + "\":");
        devices.stream()
                .filter(d -> d.type().equalsIgnoreCase(searchType))
                .forEach(System.out::println);

        int startYear = 2019;
        int endYear = 2021;
        System.out.println("\nУстройства выпущенные в диапазоне от " + startYear + " до " + endYear + ":");
        devices.stream()
                .filter(d -> d.year() >= startYear && d.year() <= endYear)
                .forEach(System.out::println);
    }
}
