interface ISort {
    void SortAsc();
    void SortDesc();
}

class Arr implements ISort {
    private int[] numbers;

    public Arr(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void SortAsc() {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void SortDesc() {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public void displayArray() {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};

        Arr array = new Arr(numbers);
        System.out.println("Original array:");
        array.displayArray();

        System.out.println("Sorted in ascending order:");
        array.SortAsc();
        array.displayArray();

        System.out.println("Sorted in descending order:");
        array.SortDesc();
        array.displayArray();
    }
}