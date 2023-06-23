import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = null;

        try {
            System.out.print("Введите путь к файлу: ");
            filePath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        assert filePath != null;
        File inputFile = new File(filePath);
        File primeOutputFile = new File("prime_numbers.txt");
        File factorialOutputFile = new File("factorials.txt");

        RandomNumberThread randomNumberThread = new RandomNumberThread(inputFile);
        PrimeNumberThread primeNumberThread = new PrimeNumberThread(inputFile, primeOutputFile);
        FactorialThread factorialThread = new FactorialThread(inputFile, factorialOutputFile);

        randomNumberThread.start();
        primeNumberThread.start();
        factorialThread.start();

        try {
            randomNumberThread.join();
            primeNumberThread.join();
            factorialThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Статистика выполненных операций:");
        System.out.println("Сгенерировано случайных чисел: " + randomNumberThread.getNumberCount());
        System.out.println("Найдено простых чисел: " + primeNumberThread.getPrimeCount());
        System.out.println("Вычислено факториалов: " + factorialThread.getFactorialCount());
    }
}

class RandomNumberThread extends Thread {
    private final File inputFile;
    private int numberCount;

    public RandomNumberThread(File inputFile) {
        this.inputFile = inputFile;
    }

    public int getNumberCount() {
        return numberCount;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            Random random = new Random();
            int numberLimit = 100;
            int numbersToGenerate = 1000;

            for (int i = 0; i < numbersToGenerate; i++) {
                int randomNumber = random.nextInt(numberLimit);
                writer.write(String.valueOf(randomNumber));
                writer.newLine();
            }

            numberCount = numbersToGenerate;
            System.out.println("Сгенерировано случайных чисел: " + numberCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PrimeNumberThread extends Thread {
    private final File inputFile;
    private final File outputFile;
    private int primeCount;

    public PrimeNumberThread(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public int getPrimeCount() {
        return primeCount;
    }

    @Override
    public void run() {
        List<Integer> primeNumbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (isPrime(number)) {
                    primeNumbers.add(number);
                    writer.write(String.valueOf(number));
                    writer.newLine();
                }
            }

            primeCount = primeNumbers.size();
            System.out.println("Найдено простых чисел: " + primeCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

class FactorialThread extends Thread {
    private final File inputFile;
    private final File outputFile;
    private int factorialCount;

    public FactorialThread(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public int getFactorialCount() {
        return factorialCount;
    }

    @Override
    public void run() {
        List<Long> factorials = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                long factorial = computeFactorial(number);
                factorials.add(factorial);
                writer.write(String.valueOf(factorial));
                writer.newLine();
            }

            factorialCount = factorials.size();
            System.out.println("Вычислено факториалов: " + factorialCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long computeFactorial(int number) {
        long factorial = 1;

        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
