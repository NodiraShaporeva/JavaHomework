import java.util.Scanner;
import java.util.Random;

class Matrix<T extends Number> {
    private T[][] matrix;
    private int rows;
    private int columns;

    @SuppressWarnings("unchecked")
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = (T[][]) new Number[rows][columns];
    }

    public void fillFromKeyboard() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter value for element (" + i + ", " + j + "): ");
                String input = scanner.next();
                matrix[i][j] = parseValue(input);
            }
        }
    }

    public void fillRandomly() {
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Generate random integer between 1 and 100
                matrix[i][j] = parseValue(Integer.toString(random.nextInt(100) + 1));
            }
        }
    }

    public void add(Matrix<T> other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for addition.");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Number a = matrix[i][j];
                Number b = other.matrix[i][j];
                if (a instanceof Double || b instanceof Double) {
                    matrix[i][j] = (T) Double.valueOf(a.doubleValue() + b.doubleValue());
                } else if (a instanceof Float || b instanceof Float) {
                    matrix[i][j] = (T) Float.valueOf(a.floatValue() + b.floatValue());
                } else if (a instanceof Long || b instanceof Long) {
                    matrix[i][j] = (T) Long.valueOf(a.longValue() + b.longValue());
                } else {
                    matrix[i][j] = (T) Integer.valueOf(a.intValue() + b.intValue());
                }
            }
        }
    }

    private T parseValue(String input) {
        Class<?> type = Double.class; // Default element type is Double

        if (type == Integer.class) {
            return (T) Integer.valueOf(input);
        } else if (type == Double.class) {
            return (T) Double.valueOf(input);
        } else if (type == Float.class) {
            return (T) Float.valueOf(input);
        } else if (type == Long.class) {
            return (T) Long.valueOf(input);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type.getSimpleName());
        }
    }
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Matrix<Double> subtract(Matrix<T> other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        Matrix<T> result = new Matrix<>(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = (T) (Double) (matrix[i][j].doubleValue() - other.matrix[i][j].doubleValue());
            }
        }

        return (Matrix<Double>) result;
    }

    public Matrix<Double> multiply(Matrix<T> other) {
        if (columns != other.rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }

        Matrix<T> result = new Matrix<>(rows, other.columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                double sum = 0;

                for (int k = 0; k < columns; k++) {
                    sum += matrix[i][k].doubleValue() * other.matrix[k][j].doubleValue();
                }

                result.matrix[i][j] = (T) (Double) sum;
            }
        }

        return (Matrix<Double>) result;
    }

    public Matrix<Double> divide(Matrix<T> other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        Matrix<T> result = new Matrix<>(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = (T) (Double) (matrix[i][j].doubleValue() / other.matrix[i][j].doubleValue());
            }
        }

        return (Matrix<Double>) result;
    }

    public T findMax() {
        T max = matrix[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j].doubleValue() > max.doubleValue()) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    public T findMin() {
        T min = matrix[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j].doubleValue() < min.doubleValue()) {
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }

    public double calculateAverage() {
        double sum = 0;
        int count = rows * columns;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j].doubleValue();
            }
        }

        return sum / count;
    }

    public static void main(String[] args) {
        Matrix<Double> matrix1 = new Matrix<>(2, 2);
        matrix1.fillFromKeyboard();
        matrix1.display();

        Matrix<Double> matrix2 = new Matrix<>(2, 2);
        matrix2.fillFromKeyboard();
        matrix2.display();

        matrix1.add(matrix2);
        matrix1.display();
        System.out.println("Matrix Sum:");
        System.out.println();

        Matrix<Double> matrixDifference = matrix1.subtract(matrix2);
        System.out.println("Matrix Difference:");
        matrixDifference.display();
        System.out.println();

        Matrix<Double> matrixProduct = matrix1.multiply(matrix2);
        System.out.println("Matrix Product:");
        matrixProduct.display();
        System.out.println();

        Matrix<Double> matrixQuotient = matrix1.divide(matrix2);
        System.out.println("Matrix Quotient:");
        matrixQuotient.display();
        System.out.println();

        System.out.println("Max element in matrix 1: " + matrix1.findMax());
        System.out.println("Min element in matrix 2: " + matrix2.findMin());
        System.out.println("Average value of matrix 1: " + matrix1.calculateAverage());
    }
}

