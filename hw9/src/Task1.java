import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[10];

        var t1 = new Thread(()-> fillArray(array));

        var t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int sum = calculateSum(array);
            System.out.println("Sum = " + sum);
        });

        var t3 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Average = " + calculateAvg(array));
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private static void fillArray(int[] array) {
        Random r = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = r.nextInt(100);
        }
    }

    private static int calculateSum(int[] array){
        int sum = 0;
        for(int num : array){
            sum += num;
        }
        return sum;
    }

    private static double calculateAvg(int[] array){
        int sum = calculateSum(array);
        return (double) sum / array.length;
    }
}
