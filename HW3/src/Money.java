class Money {
    protected int dollars;
    protected int cents;

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public void displayAmount() {
        System.out.println("$" + dollars + "." + cents);
    }

    public void setAmount(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public static void main(String[] args) {
        Money amount = new Money(50, 75);
        amount.displayAmount();

        Product product = new Product("Phone", 500, 99);
        product.decreasePrice(100, 50);
    }
}

class Product {
    private String name;
    private Money price;

    public Product(String name, int dollars, int cents) {
        this.name = name;
        this.price = new Money(dollars, cents);
    }

    public void decreasePrice(int dollars, int cents) {
        int remainingDollars = price.dollars - dollars;
        int remainingCents = price.cents - cents;

        if (remainingCents < 0) {
            remainingCents += 100;
            remainingDollars--;
        }

        if (remainingDollars >= 0) {
            price.setAmount(remainingDollars, remainingCents);
            System.out.println("Price decreased. New price: ");
            price.displayAmount();
        } else {
            System.out.println("Price cannot be negative.");
        }
    }
}