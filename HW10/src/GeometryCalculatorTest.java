import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeometryCalculatorTest {
    @Test
    public void testTriangleArea() {
        Triangle triangle = new Triangle(5, 3);
        double expectedArea = 7.5;
        Assertions.assertEquals(expectedArea, triangle.calculateArea());
    }

    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(4, 6);
        double expectedArea = 24.0;
        Assertions.assertEquals(expectedArea, rectangle.calculateArea());
    }

    @Test
    public void testSquareArea() {
        Square square = new Square(5);
        double expectedArea = 25.0;
        Assertions.assertEquals(expectedArea, square.calculateArea());
    }

    @Test
    public void testRhombusArea() {
        Rhombus rhombus = new Rhombus(4, 5);
        double expectedArea = 10.0;
        Assertions.assertEquals(expectedArea, rhombus.calculateArea());
    }
}