public class Task1 {
    public static void main(String[] args) {
        String[] arr = {
                "“Your time is limited,",
                "so don’t waste it",
                "living someone else’s life”",
                "Steve Jobs"
        };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            System.out.println(arr[i]);
        }
    }
}