import java.util.Scanner;

public class Car {
    private String name;
    private int year;
    private String manufacturer;
    private double engineCapacity;

    public Car() {
        // Конструктор по умолчанию
    }

    public Car(String name, int year, String manufacturer, double engineCapacity) {
        this.name = name;
        this.year = year;
        this.manufacturer = manufacturer;
        this.engineCapacity = engineCapacity;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название автомобиля: ");
        name = scanner.nextLine();

        System.out.print("Введите год выпуска: ");
        year = scanner.nextInt();
        scanner.nextLine(); // Считываем символ новой строки после ввода числа

        System.out.print("Введите название производителя: ");
        manufacturer = scanner.nextLine();

        System.out.print("Введите объем двигателя: ");
        engineCapacity = scanner.nextDouble();
    }

    public void setData(String name, String manufacturer, double engineCapacity, int year) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.engineCapacity = engineCapacity;
        this.year = year;
    }

    public void setData(String name, String manufacturer, double engineCapacity) {
        setData(name, manufacturer, engineCapacity, 2023);
    }

    public void displayData() {
        System.out.println("Название: " + name);
        System.out.println("Год выпуска: " + year);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Объем двигателя: " + engineCapacity);
    }

    // Методы доступа к отдельным полям через перегрузку методов
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.inputData();
        car1.displayData();

        System.out.println();
    }
}
