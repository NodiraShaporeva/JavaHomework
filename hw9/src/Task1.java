import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        // Создаем объект для генерации случайных чисел
        Random random = new Random();

        // Создаем и запускаем первый поток для заполнения массива
        FillArrayThread fillArrayThread = new FillArrayThread(random);
        fillArrayThread.start();

        // Создаем два потока-наблюдателя, которые ожидают заполнения массива
        WaitThread sumThread = new WaitThread("SumThread", fillArrayThread);
        WaitThread averageThread = new WaitThread("AverageThread", fillArrayThread);
        sumThread.start();
        averageThread.start();

        try {
            // Ожидаем завершения первого потока заполнения массива
            fillArrayThread.join();

            // Получаем результаты из первого потока
            int[] array = fillArrayThread.getArray();
            int sum = fillArrayThread.getSum();
            double average = fillArrayThread.getAverage();

            // Выводим результаты
            System.out.println("Array: " + java.util.Arrays.toString(array));
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FillArrayThread extends Thread {
    private final Random random;
    private int[] array;
    private int sum;
    private double average;

    public FillArrayThread(Random random) {
        this.random = random;
    }

    public int[] getArray() {
        return array;
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public void run() {
        // Заполняем массив случайными числами
        array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        // Находим сумму элементов массива
        sum = 0;
        for (int num : array) {
            sum += num;
        }

        // Находим среднее арифметическое значение в массиве
        average = (double) sum / array.length;
    }
}

class WaitThread extends Thread {
    private final Thread targetThread;

    public WaitThread(String name, Thread targetThread) {
        super(name);
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        try {
            // Ожидаем завершения потока заполнения массива
            targetThread.join();

            // Выводим результаты второго потока
            if (getName().equals("SumThread")) {
                System.out.println("SumThread: Sum is available");
            } else if (getName().equals("AverageThread")) {
                System.out.println("AverageThread: Average is available");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
