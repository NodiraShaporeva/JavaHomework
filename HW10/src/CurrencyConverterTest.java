import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {
    @Test
    public void testConversionFromUSD() {
        Currency usd = new Currency("USD", 1.0);
        Currency euro = new Currency("EUR", 0.85);
        Currency gbp = new Currency("GBP", 0.75);
        Currency jpy = new Currency("JPY", 110.12);

        double amount = 100.0;

        Assertions.assertEquals(85.0, usd.convertTo(euro, amount));
        Assertions.assertEquals(75.0, usd.convertTo(gbp, amount));
        Assertions.assertEquals(11012.0, usd.convertTo(jpy, amount));
    }

    @Test
    public void testConversionFromEUR() {
        Currency usd = new Currency("USD", 1.0);
        Currency euro = new Currency("EUR", 0.85);
        Currency gbp = new Currency("GBP", 0.75);
        Currency jpy = new Currency("JPY", 110.12);

        double amount = 85.0;

        Assertions.assertEquals(100.0, euro.convertTo(usd, amount));
        Assertions.assertEquals(63.75, euro.convertTo(gbp, amount));
        Assertions.assertEquals(9220.2, euro.convertTo(jpy, amount));
    }

    @Test
    public void testConversionFromGBP() {
        Currency usd = new Currency("USD", 1.0);
        Currency euro = new Currency("EUR", 0.85);
        Currency gbp = new Currency("GBP", 0.75);
        Currency jpy = new Currency("JPY", 110.12);

        double amount = 75.0;

        Assertions.assertEquals(100.0, gbp.convertTo(usd, amount));
        Assertions.assertEquals(85.0, gbp.convertTo(euro, amount));
        Assertions.assertEquals(12148.0, gbp.convertTo(jpy, amount));
    }

    @Test
    public void testConversionFromJPY() {
        Currency usd = new Currency("USD", 1.0);
        Currency euro = new Currency("EUR", 0.85);
        Currency gbp = new Currency("GBP", 0.75);
        Currency jpy = new Currency("JPY", 110.12);

        double amount = 11012.0;

        Assertions.assertEquals(100.0, jpy.convertTo(usd, amount));
        Assertions.assertEquals(114.73, jpy.convertTo(euro, amount));
        Assertions.assertEquals(82.08, jpy.convertTo(gbp, amount));
    }
}
