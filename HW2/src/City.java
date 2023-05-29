public class City {
    private String name;
    private long population;
    private double area;

    public City(String name, long population, double area) {
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

    public void setData(String name, double area) {
        this.name = name;
        this.area = area;
        this.population = 1;
    }

    public void setData(String name, long population) {
        this.name = name;
        this.area = 0;
        this.population = population;
    }

    public static void main(String[] args) {
        City city = new City("Москва", 12655050, 2561.5);

        System.out.println("Информация о городе:");
        System.out.println("Название: " + city.getName());
        System.out.println("Население: " + city.getPopulation());
        System.out.println("Площадь: " + city.getArea());
    }
}