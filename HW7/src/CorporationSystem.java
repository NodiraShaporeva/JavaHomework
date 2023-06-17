import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorporationSystem {
    private static List<Employee> employees;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Ввод пути к файлу
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        loadEmployeesFromFile(filePath);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Информационная система Корпорация ===");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Редактировать данные сотрудника");
            System.out.println("3. Удалить сотрудника");
            System.out.println("4. Поиск сотрудника по фамилии");
            System.out.println("5. Вывод информации о сотрудниках по критерию");
            System.out.println("6. Сохранить данные в файл");
            System.out.println("7. Выйти из программы");
            System.out.print("Выберите действие (1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee(scanner);
                case 2 -> editEmployee(scanner);
                case 3 -> deleteEmployee(scanner);
                case 4 -> searchEmployeeByLastName(scanner);
                case 5 -> searchEmployeesByCriteria(scanner);
                case 6 -> saveEmployeesToFile(filePath);
                case 7 -> exit = true;
                default -> System.out.println("Некорректный выбор. Повторите попытку.");
            }
        }
        saveEmployeesToFile(filePath);
    }

    private static void loadEmployeesFromFile(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            employees = (List<Employee>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Данные успешно загружены из файла.");
        } catch (FileNotFoundException e) {
            employees = new ArrayList<>();
            System.out.println("Файл данных не найден. Создан новый список сотрудников.");
        } catch (IOException | ClassNotFoundException e) {
            employees = new ArrayList<>();
            System.out.println("Ошибка при загрузке данных из файла. Создан новый список сотрудников.");
        }
    }

    private static void saveEmployeesToFile(String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employees);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в файл.");
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.println("=== Добавление нового сотрудника ===");
        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера после ввода числа

        Employee newEmployee = new Employee(lastName, firstName, age);
        employees.add(newEmployee);

        System.out.println("Сотрудник успешно добавлен.");
    }

    private static void editEmployee(Scanner scanner) {
        System.out.println("=== Редактирование данных сотрудника ===");
        System.out.print("Введите фамилию сотрудника для редактирования: ");
        String lastName = scanner.nextLine();

        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.print("Введите новую фамилию: ");
                String newLastName = scanner.nextLine();
                System.out.print("Введите новое имя: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Введите новый возраст: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после ввода числа

                employee.setLastName(newLastName);
                employee.setFirstName(newFirstName);
                employee.setAge(newAge);

                System.out.println("Данные сотрудника успешно обновлены.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Сотрудник с указанной фамилией не найден.");
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.println("=== Удаление сотрудника ===");
        System.out.print("Введите фамилию сотрудника для удаления: ");
        String lastName = scanner.nextLine();

        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                employees.remove(employee);
                System.out.println("Сотрудник успешно удален.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Сотрудник с указанной фамилией не найден.");
        }
    }

    private static void searchEmployeeByLastName(Scanner scanner) {
        System.out.println("=== Поиск сотрудника по фамилии ===");
        System.out.print("Введите фамилию сотрудника: ");
        String lastName = scanner.nextLine();

        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Результаты поиска:");
                System.out.println(employee);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Сотрудник с указанной фамилией не найден.");
        }
    }

    private static void searchEmployeesByCriteria(Scanner scanner) {
        System.out.println("=== Поиск сотрудников по критерию ===");
        System.out.println("1. Возраст");
        System.out.println("2. Фамилия, начинающаяся на букву");
        System.out.print("Выберите критерий поиска (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> searchEmployeesByAge(scanner);
            case 2 -> searchEmployeesByLastNameInitial(scanner);
            default -> System.out.println("Некорректный выбор критерия.");
        }
    }

    private static void searchEmployeesByAge(Scanner scanner) {
        System.out.print("Введите возраст сотрудников: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера после ввода числа

        boolean found = false;

        System.out.println("Результаты поиска:");

        for (Employee employee : employees) {
            if (employee.getAge() == age) {
                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Сотрудники указанного возраста не найдены.");
        }
    }

    private static void searchEmployeesByLastNameInitial(Scanner scanner) {
        System.out.print("Введите первую букву фамилии сотрудников: ");
        String initial = scanner.nextLine().toUpperCase();

        boolean found = false;

        System.out.println("Результаты поиска:");

        for (Employee employee : employees) {
            if (employee.getLastName().startsWith(initial)) {
                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Сотрудники с фамилией, начинающейся на указанную букву, не найдены.");
        }
    }
}
