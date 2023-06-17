import java.io.Serializable;

public class Employee implements Serializable {
    private String lastName;
    private String firstName;
    private int age;

    public Employee(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastName + ", Имя: " + firstName + ", Возраст: " + age;
    }
}
