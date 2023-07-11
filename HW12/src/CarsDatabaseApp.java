import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarsDatabaseApp {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/cars_database";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e);
            return;
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            CarsDatabaseApp app = new CarsDatabaseApp(connection);
            app.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private final Connection connection;

    public CarsDatabaseApp(Connection connection) {
        this.connection = connection;
    }

    public void run() throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("1. Отобразить все автомобили");
            System.out.println("2. Показать всех производителей автомобилей");
            System.out.println("3. Показать производителей и количество их автомобилей");
            System.out.println("4. Показать производителя с наибольшим количеством автомобилей");
            System.out.println("5. Показать производителя с наименьшим количеством автомобилей");
            System.out.println("6. Показать все автомобили конкретного года выпуска");
            System.out.println("7. Показать все автомобили с годом выпуска в указанном диапазоне");
            System.out.println("8. Показать все автомобили конкретного производителя");
            System.out.println("9. Создать фильтр для отображения автомобилей по цвету");
            System.out.println("10. Создать фильтр для отображения автомобилей по объему двигателя");
            System.out.println("11. Создать фильтр для отображения автомобилей по типу");
            System.out.println("12. Добавить строку в таблицу");
            System.out.println("13. Удалить строку из таблицы");
            System.out.println("14. Обновить строку в таблице");
            System.out.println("15. Отсоединиться от базы данных");
            System.out.print("Выберите действие (1-15): ");

            int choice = readIntFromConsole();
            switch (choice) {
                case 1 -> displayAllCars();
                case 2 -> displayAllManufacturers();
                case 3 -> displayManufacturersAndCarCounts();
                case 4 -> displayManufacturerWithMostCars();
                case 5 -> displayManufacturerWithFewestCars();
                case 6 -> displayCarsByYear();
                case 7 -> displayCarsByYearRange();
                case 8 -> displayCarsByManufacturer();
                case 9 -> displayCarsByColor();
                case 10 -> displayCarsByEngineVolume();
                case 11 -> displayCarsByType();
                case 12 -> addCar();
                case 13 -> deleteCar();
                case 14 -> updateCar();
                case 15 -> running = false;
                default -> System.out.println("Недопустимый выбор. Пожалуйста, выберите число от 1 до 15.");
            }

            System.out.println();
        }
    }

    private void addCar() throws SQLException {
        System.out.println("Добавление новой строки:");

        System.out.print("Введите производителя: ");
        String manufacturer = readStringFromConsole();

        System.out.print("Введите модель: ");
        String model = readStringFromConsole();

        System.out.print("Введите объем двигателя: ");
        double engineVolume = readDoubleFromConsole();

        System.out.print("Введите год выпуска: ");
        int year = readIntFromConsole();

        System.out.print("Введите цвет: ");
        String color = readStringFromConsole();

        System.out.print("Введите тип автомобиля: ");
        String carType = readStringFromConsole();

        String sql = "INSERT INTO cars (manufacturer, model, engine_volume, year, color, car_type) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, manufacturer);
            preparedStatement.setString(2, model);
            preparedStatement.setDouble(3, engineVolume);
            preparedStatement.setInt(4, year);
            preparedStatement.setString(5, color);
            preparedStatement.setString(6, carType);
            preparedStatement.executeUpdate();
            System.out.println("Новая строка успешно добавлена.");
        }
    }

    private void deleteCar() throws SQLException {
        System.out.print("Введите ID автомобиля для удаления: ");
        int carId = readIntFromConsole();

        String sql = "DELETE FROM cars WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, carId);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Строка успешно удалена.");
            } else {
                System.out.println("Строка с указанным ID не найдена.");
            }
        }
    }

    private void updateCar() throws SQLException {
        System.out.print("Введите ID автомобиля для обновления: ");
        int carId = readIntFromConsole();

        System.out.print("Введите новое название производителя: ");
        String manufacturer = readStringFromConsole();

        System.out.print("Введите новое название модели: ");
        String model = readStringFromConsole();

        System.out.print("Введите новый объем двигателя: ");
        double engineVolume = readDoubleFromConsole();

        System.out.print("Введите новый год выпуска: ");
        int year = readIntFromConsole();

        System.out.print("Введите новый цвет: ");
        String color = readStringFromConsole();

        System.out.print("Введите новый тип автомобиля: ");
        String carType = readStringFromConsole();

        String sql = "UPDATE cars SET manufacturer = ?, model = ?, engine_volume = ?, year = ?, color = ?, car_type = ? " +
                "WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, manufacturer);
            preparedStatement.setString(2, model);
            preparedStatement.setDouble(3, engineVolume);
            preparedStatement.setInt(4, year);
            preparedStatement.setString(5, color);
            preparedStatement.setString(6, carType);
            preparedStatement.setInt(7, carId);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Строка успешно обновлена.");
            } else {
                System.out.println("Строка с указанным ID не найдена.");
            }
        }
    }

    private String readStringFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private double readDoubleFromConsole() {
        double value = 0.0;
        try {
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
        return value;
    }
    private void displayCarsByManufacturer() throws SQLException {
        System.out.print("Введите производителя автомобилей: ");
        String manufacturer = readStringFromConsole();

        System.out.println("Автомобили производителя " + manufacturer + ":");
        String sql = "SELECT * FROM cars WHERE manufacturer = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, manufacturer);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String model = resultSet.getString("model");
                    double engineVolume = resultSet.getDouble("engine_volume");
                    int year = resultSet.getInt("year");
                    String color = resultSet.getString("color");
                    String carType = resultSet.getString("car_type");

                    System.out.println("ID: " + id);
                    System.out.println("Модель: " + model);
                    System.out.println("Объем двигателя: " + engineVolume);
                    System.out.println("Год выпуска: " + year);
                    System.out.println("Цвет: " + color);
                    System.out.println("Тип автомобиля: " + carType);
                    System.out.println("--------------------");
                }
            }
        }
    }

    private void displayCarsByColor() throws SQLException {
        System.out.print("Введите цвет автомобиля: ");
        String color = readStringFromConsole();

        System.out.println("Автомобили цвета " + color + ":");
        String sql = "SELECT * FROM cars WHERE color = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, color);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String manufacturer = resultSet.getString("manufacturer");
                    String model = resultSet.getString("model");
                    double engineVolume = resultSet.getDouble("engine_volume");
                    int year = resultSet.getInt("year");
                    String carType = resultSet.getString("car_type");

                    System.out.println("ID: " + id);
                    System.out.println("Производитель: " + manufacturer);
                    System.out.println("Модель: " + model);
                    System.out.println("Объем двигателя: " + engineVolume);
                    System.out.println("Год выпуска: " + year);
                    System.out.println("Тип автомобиля: " + carType);
                    System.out.println("--------------------");
                }
            }
        }
    }

    private void displayCarsByEngineVolume() throws SQLException {
        System.out.print("Введите минимальный объем двигателя: ");
        double minEngineVolume = readDoubleFromConsole();
        System.out.print("Введите максимальный объем двигателя: ");
        double maxEngineVolume = readDoubleFromConsole();

        System.out.println("Автомобили с объемом двигателя от " + minEngineVolume + " до " + maxEngineVolume + ":");
        String sql = "SELECT * FROM cars WHERE engine_volume BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, minEngineVolume);
            preparedStatement.setDouble(2, maxEngineVolume);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String manufacturer = resultSet.getString("manufacturer");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    String color = resultSet.getString("color");
                    String carType = resultSet.getString("car_type");

                    System.out.println("ID: " + id);
                    System.out.println("Производитель: " + manufacturer);
                    System.out.println("Модель: " + model);
                    System.out.println("Год выпуска: " + year);
                    System.out.println("Цвет: " + color);
                    System.out.println("Тип автомобиля: " + carType);
                    System.out.println("--------------------");
                }
            }
        }
    }

    private void displayCarsByType() throws SQLException {
        System.out.print("Введите тип автомобиля (седан, хетчбек, универсал): ");
        String carType = readStringFromConsole();

        System.out.println("Автомобили типа " + carType + ":");
        String sql = "SELECT * FROM cars WHERE car_type = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, carType);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String manufacturer = resultSet.getString("manufacturer");
                    String model = resultSet.getString("model");
                    double engineVolume = resultSet.getDouble("engine_volume");
                    int year = resultSet.getInt("year");
                    String color = resultSet.getString("color");

                    System.out.println("ID: " + id);
                    System.out.println("Производитель: " + manufacturer);
                    System.out.println("Модель: " + model);
                    System.out.println("Объем двигателя: " + engineVolume);
                    System.out.println("Год выпуска: " + year);
                    System.out.println("Цвет: " + color);
                    System.out.println("--------------------");
                }
            }
        }
    }
    private void displayManufacturerWithMostCars() throws SQLException {
        System.out.println("Производитель с наибольшим количеством автомобилей:");
        String sql = "SELECT manufacturer FROM cars " +
                "GROUP BY manufacturer " +
                "ORDER BY COUNT(*) DESC " +
                "LIMIT 1";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                String manufacturer = resultSet.getString("manufacturer");
                System.out.println(manufacturer);
            } else {
                System.out.println("Нет данных");
            }
        }
    }

    private void displayManufacturerWithFewestCars() throws SQLException {
        System.out.println("Производитель с наименьшим количеством автомобилей:");
        String sql = "SELECT manufacturer FROM cars " +
                "GROUP BY manufacturer " +
                "ORDER BY COUNT(*) ASC " +
                "LIMIT 1";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                String manufacturer = resultSet.getString("manufacturer");
                System.out.println(manufacturer);
            } else {
                System.out.println("Нет данных");
            }
        }
    }

    private void displayCarsByYear() throws SQLException {
        System.out.print("Введите год выпуска: ");
        int year = readIntFromConsole();

        System.out.println("Автомобили " + year + " года выпуска:");
        String sql = "SELECT * FROM cars WHERE year = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, year);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String manufacturer = resultSet.getString("manufacturer");
                    String model = resultSet.getString("model");
                    double engineVolume = resultSet.getDouble("engine_volume");
                    String color = resultSet.getString("color");
                    String carType = resultSet.getString("car_type");

                    System.out.println("ID: " + id);
                    System.out.println("Производитель: " + manufacturer);
                    System.out.println("Модель: " + model);
                    System.out.println("Объем двигателя: " + engineVolume);
                    System.out.println("Цвет: " + color);
                    System.out.println("Тип автомобиля: " + carType);
                    System.out.println("--------------------");
                }
            }
        }
    }

    private void displayCarsByYearRange() throws SQLException {
        System.out.print("Введите начальный год выпуска: ");
        int startYear = readIntFromConsole();
        System.out.print("Введите конечный год выпуска: ");
        int endYear = readIntFromConsole();

        System.out.println("Автомобили с годом выпуска от " + startYear + " до " + endYear + ":");
        String sql = "SELECT * FROM cars WHERE year BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, startYear);
            preparedStatement.setInt(2, endYear);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String manufacturer = resultSet.getString("manufacturer");
                    String model = resultSet.getString("model");
                    double engineVolume = resultSet.getDouble("engine_volume");
                    String color = resultSet.getString("color");
                    String carType = resultSet.getString("car_type");

                    System.out.println("ID: " + id);
                    System.out.println("Производитель: " + manufacturer);
                    System.out.println("Модель: " + model);
                    System.out.println("Объем двигателя: " + engineVolume);
                    System.out.println("Цвет: " + color);
                    System.out.println("Тип автомобиля: " + carType);
                    System.out.println("--------------------");
                }
            }
        }
    }
    private void displayAllCars() throws SQLException {
        System.out.println("Список автомобилей:");
        String sql = "SELECT * FROM cars";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String manufacturer = resultSet.getString("manufacturer");
                String model = resultSet.getString("model");
                double engineVolume = resultSet.getDouble("engine_volume");
                int year = resultSet.getInt("year");
                String color = resultSet.getString("color");
                String carType = resultSet.getString("car_type");

                System.out.println("ID: " + id);
                System.out.println("Производитель: " + manufacturer);
                System.out.println("Модель: " + model);
                System.out.println("Объем двигателя: " + engineVolume);
                System.out.println("Год выпуска: " + year);
                System.out.println("Цвет: " + color);
                System.out.println("Тип автомобиля: " + carType);
                System.out.println("--------------------");
            }
        }
    }

    private void displayAllManufacturers() throws SQLException {
        System.out.println("Список производителей автомобилей:");
        String sql = "SELECT DISTINCT manufacturer FROM cars";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String manufacturer = resultSet.getString("manufacturer");
                System.out.println(manufacturer);
            }
        }
    }

    private void displayManufacturersAndCarCounts() throws SQLException {
        System.out.println("Производители автомобилей и количество автомобилей каждого производителя:");
        String sql = "SELECT manufacturer, COUNT(*) AS car_count FROM cars GROUP BY manufacturer";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String manufacturer = resultSet.getString("manufacturer");
                int carCount = resultSet.getInt("car_count");
                System.out.println(manufacturer + " - " + carCount);
            }
        }
    }

    private int readIntFromConsole() {
        int choice = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            // Очищаем буфер ввода
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
        return choice;
    }
}
