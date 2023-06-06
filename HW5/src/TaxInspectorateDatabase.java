import java.util.ArrayList;
import java.util.List;

class Person {
    private final String id;
    private String name;
    private String city;
    private List<Penalty> penalties;

    public Person(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.penalties = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Penalty> getPenalties() {
        return penalties;
    }

    public void addPenalty(Penalty penalty) {
        penalties.add(penalty);
    }

    public void removePenalty(Penalty penalty) {
        penalties.remove(penalty);
    }

    public void replaceInfo(String newName, String newCity) {
        name = newName;
        city = newCity;
    }
}

class Penalty {
    private String type;
    private int amount;

    public Penalty(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class TaxInspectorateDatabase {
    private List<Person> database;

    public TaxInspectorateDatabase() {
        database = new ArrayList<>();
    }

    public void printDatabase() {
        for (Person person : database) {
            System.out.println("Код: " + person.getId());
            System.out.println("Имя: " + person.getName());
            System.out.println("Город: " + person.getCity());
            System.out.println("Штрафы:");
            for (Penalty penalty : person.getPenalties()) {
                System.out.println("Тип: " + penalty.getType() + ", Сумма: " + penalty.getAmount());
            }
            System.out.println("---------------------------------------------");
        }
    }

    public void printDataByCode(String code) {
        for (Person person : database) {
            if (person.getId().equals(code)) {
                System.out.println("Распечатка данных по идентификационному коду " + code + ":");
                System.out.println("Имя: " + person.getName());
                System.out.println("Город: " + person.getCity());
                System.out.println("Штрафы:");
                for (Penalty penalty : person.getPenalties()) {
                    System.out.println("Тип: " + penalty.getType() + ", Сумма: " + penalty.getAmount());
                }
                System.out.println("---------------------------------------------");
                return;
            }
        }
        System.out.println("Данные по идентификационному коду " + code + " не найдены.");
    }

    public void printDataByPenaltyType(String penaltyType) {
        System.out.println("Распечатка данных по типу штрафа " + penaltyType + ":");
        for (Person person : database) {
            for (Penalty penalty : person.getPenalties()) {
                if (penalty.getType().equals(penaltyType)) {
                    System.out.println("Код: " + person.getId());
                    System.out.println("Имя: " + person.getName());
                    System.out.println("Город: " + person.getCity());
                    System.out.println("Тип: " + penalty.getType() + ", Сумма: " + penalty.getAmount());
                    System.out.println("---------------------------------------------");
                }
            }
        }
    }

    public void printDataByCity(String city) {
        System.out.println("Распечатка данных по городу " + city + ":");
        for (Person person : database) {
            if (person.getCity().equals(city)) {
                System.out.println("Код: " + person.getId());
                System.out.println("Имя: " + person.getName());
                System.out.println("Штрафы:");
                for (Penalty penalty : person.getPenalties()) {
                    System.out.println("Тип: " + penalty.getType() + ", Сумма: " + penalty.getAmount());
                }
                System.out.println("---------------------------------------------");
            }
        }
    }

    public void addPerson(String id, String name, String city) {
        Person person = new Person(id, name, city);
        database.add(person);
    }

    public void addPenalty(String id, String penaltyType, int amount) {
        for (Person person : database) {
            if (person.getId().equals(id)) {
                Penalty penalty = new Penalty(penaltyType, amount);
                person.addPenalty(penalty);
                return;
            }
        }
        System.out.println("Человек с идентификационным кодом " + id + " не найден.");
    }

    public void removePenalty(String id, String penaltyType) {
        for (Person person : database) {
            if (person.getId().equals(id)) {
                List<Penalty> penalties = person.getPenalties();
                Penalty penaltyToRemove = null;
                for (Penalty penalty : penalties) {
                    if (penalty.getType().equals(penaltyType)) {
                        penaltyToRemove = penalty;
                        break;
                    }
                }
                if (penaltyToRemove != null) {
                    person.removePenalty(penaltyToRemove);
                    System.out.println("Штраф удален.");
                } else {
                    System.out.println("Штраф с типом " + penaltyType + " не найден.");
                }
                return;
            }
        }
        System.out.println("Человек с идентификационным кодом " + id + " не найден.");
    }

    public void replacePersonInfo(String id, String newName, String newCity) {
        for (Person person : database) {
            if (person.getId().equals(id)) {
                person.replaceInfo(newName, newCity);
                System.out.println("Информация обновлена.");
                return;
            }
        }
        System.out.println("Человек с идентификационным кодом " + id + " не найден.");
    }

    public static void main(String[] args) {
        TaxInspectorateDatabase database = new TaxInspectorateDatabase();
        database.addPerson("1234567890", "Иванов Иван Иванович", "Москва");
        database.addPerson("0987654321", "Петров Петр Петрович", "Санкт-Петербург");
        database.addPenalty("1234567890", "Нарушение правил дорожного движения", 500);
        database.addPenalty("1234567890", "Несвоевременная оплата налогов", 1000);
        database.addPenalty("0987654321", "Нарушение правил дорожного движения", 300);
        database.addPenalty("0987654321", "Несвоевременная оплата налогов", 1500);

        System.out.println("---------------------------------------------");
        System.out.println("Полная распечатка базы данных:");
        System.out.println("---------------------------------------------");
        database.printDatabase();

        System.out.println("Распечатка данных по идентификационному коду:");
        System.out.println("---------------------------------------------");
        database.printDataByCode("1234567890");

        System.out.println("Распечатка данных по типу штрафа:");
        System.out.println("---------------------------------------------");
        database.printDataByPenaltyType("Нарушение правил дорожного движения");

        System.out.println("Распечатка данных по городу:");
        System.out.println("---------------------------------------------");
        database.printDataByCity("Москва");

        System.out.println("Добавление налогоплательщика:");
        System.out.println("---------------------------------------------");
        database.addPerson("9753197531", "Васильев Василий Висльевич", "Казань");
        database.printDataByCode("9753197531");

        System.out.println("Добавление штрафа:");
        System.out.println("---------------------------------------------");
        database.addPenalty("9753197531", "Нарушение правил дорожного движения", 1300);
        database.printDataByCode("9753197531");

        System.out.println("Удаление штрафа:");
        System.out.println("---------------------------------------------");
        database.removePenalty("9753197531", "Нарушение правил дорожного движения");
        database.printDataByCode("9753197531");

        System.out.println("Обновление данных:");
        System.out.println("---------------------------------------------");
        database.replacePersonInfo("9753197531", "Васильев Василий Висльевич", "Нижний Новгород");
        database.printDataByCode("9753197531");
    }
}