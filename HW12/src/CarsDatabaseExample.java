import java.sql.*;

public class CarsDatabaseExample {
    // JDBC URL, username и password для подключения к базе данных
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/cars_database";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found "+ e);
        }
        // Создание соединения с базой данных
        try (
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Создание таблицы "Автомобили", если она не существует
            createCarsTable(connection);

            // Вставка данных об автомобиле
            insertCar(connection, "Toyota", "Camry", 2.5, 2021, "Серебристый", "Седан");
            insertCar(connection, "Honda", "Civic", 1.8, 2022, "Черный", "Седан");
            insertCar(connection, "Volkswagen", "Golf", 1.6, 2020, "Синий", "Хетчбек");

            // Получение и вывод информации об автомобилях
            retrieveCars(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createCarsTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS cars (" +
                    "id SERIAL PRIMARY KEY," +
                    "manufacturer VARCHAR(100) NOT NULL," +
                    "model VARCHAR(100) NOT NULL," +
                    "engine_volume DECIMAL(3, 1) NOT NULL," +
                    "year INT NOT NULL," +
                    "color VARCHAR(50) NOT NULL," +
                    "car_type VARCHAR(50) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
        }
    }

    private static void insertCar(Connection connection, String manufacturer, String model, double engineVolume,
                                  int year, String color, String carType) throws SQLException {
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
        }
    }

    private static void retrieveCars(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM cars";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String manufacturer = resultSet.getString("manufacturer");
                String model = resultSet.getString("model");
                double engineVolume = resultSet.getDouble("engine_volume");
                int year = resultSet.getInt("year");
                String color = resultSet.getString("color");
                String carType = resultSet.getString("car_type");

                System.out.println("Car ID: " + id);
                System.out.println("Manufacturer: " + manufacturer);
                System.out.println("Model: " + model);
                System.out.println("Engine Volume: " + engineVolume);
                System.out.println("Year: " + year);
                System.out.println("Color: " + color);
                System.out.println("Car Type: " + carType);
                System.out.println("--------------------");
            }
        }
    }
}
