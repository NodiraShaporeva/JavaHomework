// Главный класс приложения
public class CurrencyConverter {
    public static void main(String[] args) {
        Currency usd = new Currency("USD", 1.0);
        Currency euro = new Currency("EUR", 0.85);
        Currency gbp = new Currency("GBP", 0.75);
        Currency jpy = new Currency("JPY", 110.12);

        double amountInUSD = 100.0;
        System.out.println(amountInUSD + " USD в EUR: " + usd.convertTo(euro, amountInUSD));
        System.out.println(amountInUSD + " USD в GBP: " + usd.convertTo(gbp, amountInUSD));
        System.out.println(amountInUSD + " USD в JPY: " + usd.convertTo(jpy, amountInUSD));

        double amountInEUR = 85.0;
        System.out.println(amountInEUR + " EUR в USD: " + euro.convertTo(usd, amountInEUR));
        System.out.println(amountInEUR + " EUR в GBP: " + euro.convertTo(gbp, amountInEUR));
        System.out.println(amountInEUR + " EUR в JPY: " + euro.convertTo(jpy, amountInEUR));

        double amountInGBP = 75.0;
        System.out.println(amountInGBP + " GBP в USD: " + gbp.convertTo(usd, amountInGBP));
        System.out.println(amountInGBP + " GBP в EUR: " + gbp.convertTo(euro, amountInGBP));
        System.out.println(amountInGBP + " GBP в JPY: " + gbp.convertTo(jpy, amountInGBP));

        double amountInJPY = 11012.0;
        System.out.println(amountInJPY + " JPY в USD: " + jpy.convertTo(usd, amountInJPY));
        System.out.println(amountInJPY + " JPY в EUR: " + jpy.convertTo(euro, amountInJPY));
        System.out.println(amountInJPY + " JPY в GBP: " + jpy.convertTo(gbp, amountInJPY));
    }
}

// Класс, представляющий валюту
class Currency {
    private final double exchangeRate;

    public Currency(String code, double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double convertTo(Currency targetCurrency, double amount) {
        return amount * (targetCurrency.exchangeRate / this.exchangeRate);
    }
}
