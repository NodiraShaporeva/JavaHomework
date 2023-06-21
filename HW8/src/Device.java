record Device(String name, int year, double price, String color, String type) {

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}