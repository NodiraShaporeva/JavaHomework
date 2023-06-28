import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LengthConverterApp {

    public static double convertMillimetersToCentimeters(double millimeters) {
        return millimeters / 10.0;
    }

    public static double convertCentimetersToDecimeters(double centimeters) {
        return centimeters / 10.0;
    }

    public static double convertDecimetersToMeters(double decimeters) {
        return decimeters / 10.0;
    }

    public static double convertMetersToKilometers(double meters) {
        return meters / 1000.0;
    }

    @Test
    public void testConvertMillimetersToCentimeters() {
        Assertions.assertEquals(10.0, convertMillimetersToCentimeters(100));
        Assertions.assertEquals(2.5, convertMillimetersToCentimeters(25));
        Assertions.assertEquals(0.0, convertMillimetersToCentimeters(0));
    }

    @Test
    public void testConvertCentimetersToDecimeters() {
        Assertions.assertEquals(10.0, convertCentimetersToDecimeters(100));
        Assertions.assertEquals(2.5, convertCentimetersToDecimeters(25));
        Assertions.assertEquals(0.0, convertCentimetersToDecimeters(0));
    }

    @Test
    public void testConvertDecimetersToMeters() {
        Assertions.assertEquals(10.0, convertDecimetersToMeters(100));
        Assertions.assertEquals(2.5, convertDecimetersToMeters(25));
        Assertions.assertEquals(0.0, convertDecimetersToMeters(0));
    }

    @Test
    public void testConvertMetersToKilometers() {
        Assertions.assertEquals(1.0, convertMetersToKilometers(1000));
        Assertions.assertEquals(0.5, convertMetersToKilometers(500));
        Assertions.assertEquals(0.0, convertMetersToKilometers(0));
    }

}
