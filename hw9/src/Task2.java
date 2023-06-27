import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        String filePath = "sourceNums.txt";
        String primeNumsFile = "primeNumsFile.txt";
        String factorialsFile = "factorialsFile.txt";

        var t1 = new Thread(() -> fillFileWithRandomNums(filePath));

        var t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            List<Integer> primeNums = findPrimeNumsInFile(filePath);
            writeNumsToFile(primeNums, primeNumsFile);
        });

        var t3 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            List<Long> factorialsNums = calculateFactorials(filePath);
            writeNumsToFile(factorialsNums, factorialsFile);
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private static List<Integer> findPrimeNumsInFile(String filePath) {
        List<Integer> primeNums = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                if (isPrime(num)) {
                    primeNums.add(num);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return primeNums;
    }



    private static void fillFileWithRandomNums(String filePath){
        try (PrintWriter writer = new PrintWriter(filePath)) {
            Random r = new Random();
            for(int i = 0; i < 10; i++){
                writer.println(r.nextInt(100));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    private static boolean isPrime(int num){
        if (num < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }

    private static List<Long> calculateFactorials(String filePath){
        List<Long> factorials = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null){
                int num = Integer.parseInt(line);
                long factorial = calculateFactorial(num);
                factorials.add(factorial);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return factorials;
    }

    private static long calculateFactorial(int num) {
        if(num == 0 || num == 1){
            return 1;
        }
        long factorial = 1;
        for (int i = 2; i <= num; i++){
            factorial *= i;
        }
        return factorial;
    }

    private static <T extends Number> void writeNumsToFile (List<T> nums, String filePath){
        try (PrintWriter writer = new PrintWriter(filePath)){
            for(T num : nums){
                writer.println(num);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
