import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeightConverterApp {

    public static double convertMilligramsToGrams(double milligrams) {
        return milligrams / 1000.0;
    }

    public static double convertGramsToKilograms(double grams) {
        return grams / 1000.0;
    }

    public static double convertKilogramsToCentners(double kilograms) {
        return kilograms / 100.0;
    }

    public static double convertCentnersToTonnes(double centners) {
        return centners / 10.0;
    }

    @Test
    public void testConvertMilligramsToGrams() {
        Assertions.assertEquals(0.1, convertMilligramsToGrams(100));
        Assertions.assertEquals(2.5, convertMilligramsToGrams(2500));
        Assertions.assertEquals(0.0, convertMilligramsToGrams(0));
    }

    @Test
    public void testConvertGramsToKilograms() {
        Assertions.assertEquals(1.0, convertGramsToKilograms(1000));
        Assertions.assertEquals(0.5, convertGramsToKilograms(500));
        Assertions.assertEquals(0.0, convertGramsToKilograms(0));
    }

    @Test
    public void testConvertKilogramsToCentners() {
        Assertions.assertEquals(1.0, convertKilogramsToCentners(100));
        Assertions.assertEquals(2.5, convertKilogramsToCentners(250));
        Assertions.assertEquals(0.0, convertKilogramsToCentners(0));
    }

    @Test
    public void testConvertCentnersToTonnes() {
        Assertions.assertEquals(1.0, convertCentnersToTonnes(10));
        Assertions.assertEquals(2.5, convertCentnersToTonnes(25));
        Assertions.assertEquals(0.0, convertCentnersToTonnes(0));
    }
}
