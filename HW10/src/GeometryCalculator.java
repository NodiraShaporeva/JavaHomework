// Главный класс приложения
public class GeometryCalculator {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5, 3);
        System.out.println("Площадь треугольника: " + triangle.calculateArea());

        Rectangle rectangle = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());

        Square square = new Square(5);
        System.out.println("Площадь квадрата: " + square.calculateArea());

        Rhombus rhombus = new Rhombus(4, 5);
        System.out.println("Площадь ромба: " + rhombus.calculateArea());
    }
}

// Абстрактный класс, представляющий геометрическую фигуру
abstract class Shape {
    public abstract double calculateArea();
}

// Класс треугольника
class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Класс прямоугольника
class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Класс квадрата
class Square extends Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

// Класс ромба
class Rhombus extends Shape {
    private final double diagonal1;
    private final double diagonal2;

    public Rhombus(double diagonal1, double diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public double calculateArea() {
        return 0.5 * diagonal1 * diagonal2;
    }
}
