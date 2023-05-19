public class Task11 {
    public static void main(String[] args) {
        // Примеры использования метода
        printLine(5, Direction.HORIZONTAL, '*');
        printLine(7, Direction.VERTICAL, '#');
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL
    }

    public static void printLine(int length, Direction direction, char symbol) {
        if (direction == Direction.HORIZONTAL) {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol);
            }
        } else if (direction == Direction.VERTICAL) {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        }
    }
}