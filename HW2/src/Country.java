public class Country {
    private String name;
    private long population;
    private double area;

    public Country(String name, long population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public void setData(String name, double area, long population) {
        this.name = name;
        this.area = area;
        this.population = population;
    }

    public void setData(String name, double area) {
        setData(name, area, 1);
    }

    public static void main(String[] args) {
        Country country = new Country("Россия", 144526636, 17098242);

        System.out.println("\nИнформация о стране:");
        System.out.println("Название: " + country.getName());
        System.out.println("Население: " + country.getPopulation());
        System.out.println("Площадь: " + country.getArea());
    }
}