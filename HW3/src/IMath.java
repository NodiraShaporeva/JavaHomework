interface IMath {
    int Max();
    int Min();
    float Avg();
}

class Array implements IMath {
    private int[] numbers;

    public Array(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int Max() {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    @Override
    public int Min() {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    @Override
    public float Avg() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (float) sum / numbers.length;
    }
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};

        Array array = new Array(numbers);
        System.out.println("Max: " + array.Max());
        System.out.println("Min: " + array.Min());
        System.out.println("Avg: " + array.Avg());
    }
}