import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Array<T> {
    private final Object[] array;
    private final int size;
    public Array(int size) {
        this.size = size;
        array = new Object[size];
    }

    public void fillFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите элемент [" + i + "]: ");
            if (array[i] instanceof String) {
                array[i] = (T) scanner.next();
            } else if (array[i] instanceof Integer) {
                array[i] = (T) Integer.valueOf(scanner.nextInt());
            }
        }
    }

    public void fillRandomly() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (T) Integer.valueOf((int) (Math.random() * 100)); // Генерация случайных чисел от 0 до 100
        }
    }

    public void display() {
        System.out.println(Arrays.toString(Arrays.copyOf(array, size)));
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public T findMax(Comparator<T> comparator) {
        if (array.length == 0) {
            return null;
        }

        T max = (T) array[0];
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare((T) array[i], max) > 0) {
                max = (T) array[i];
            }
        }

        return max;
    }

    public T findMin(Comparator<T> comparator) {
        if (array.length == 0) {
            return null;
        }

        T min = (T) array[0];
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare((T) array[i], min) < 0) {
                min = (T) array[i];
            }
        }

        return min;
    }


    public double calculateAverage() {
        double sum = 0.0;
        for (Object o : array) {
            sum += Double.parseDouble(o.toString());
        }
        return sum / array.length;
    }

    public void sortAscending() {
        Arrays.sort(array);
    }

    public void sortDescending(Comparator<T> comparator) {
        Arrays.sort(array, (a, b) -> comparator.compare((T) b, (T) a));
    }

    public int binarySearch(T key, Comparator<T> comparator) {
        int low = 0;
        int high = size;

        while (low < high) {
            int mid = (low + high) / 2;
            T midValue = (T) array[mid];

            int comparison = comparator.compare(midValue, key);

            if (comparison == 0) {
                return mid; // Value found
            } else if (comparison < 0) {
                low = mid + 1; // Value is in the second half
            } else {
                high = mid; // Value is in the first half
            }
        }

        return -1; // Value not found
    }

    public void replaceValue(int index, T newValue) {
        if (index >= 0 && index < array.length) {
            array[index] = newValue;
            System.out.println("Значение в массиве успешно заменено.");
        } else {
            System.out.println("Недопустимый индекс. Замена значения не выполнена.");
        }
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(5);

        array.fillRandomly();
        array.fillFromKeyboard();

        // Вывод массива на экран
        array.display();

        // Поиск максимального значения
        Integer max = array.findMax(Comparator.naturalOrder());
        System.out.println("Максимальное значение: " + max);

        // Поиск минимального значения
        Integer min = array.findMin(Comparator.naturalOrder());
        System.out.println("Минимальное значение: " + min);

        // Вычисление среднего значения
        double average = array.calculateAverage();
        System.out.println("Среднеарифметическое значение: " + average);

        // Сортировка массива по убыванию
        array.sortDescending(Comparator.naturalOrder());
        System.out.print("Массив после сортировки по убыванию: ");
        array.display();

        // Сортировка массива по возрастанию
        array.sortAscending();
        System.out.print("Массив после сортировки по возрастанию: ");
        array.display();

        // Поиск значения
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение для бинарного поиска: ");
        Integer searchKey = scanner.nextInt();
        array.sortAscending(); // Сортировка массива перед поиском
        Comparator<Integer> comparator = Comparator.naturalOrder();
        int searchResult = array.binarySearch(searchKey, comparator);
        if (searchResult >= 0) {
            System.out.println("Значение найдено на позиции " + searchResult);
        } else {
            System.out.println("Значение не найдено");
        }

        // Замена значения в массиве
        System.out.println("Введите индекс элемента для замены:");
        int index = scanner.nextInt();

        System.out.println("Введите новое значение:");
        Integer newValue = scanner.nextInt();

        array.replaceValue(index, newValue);
        array.display();
    }
}
