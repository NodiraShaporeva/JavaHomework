class Device {
    protected String name;
    protected String description;

    public Device(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void sound() {
        System.out.println("The device is making a sound.");
    }

    public void show() {
        System.out.println("Device: " + name);
    }

    public void desc() {
        System.out.println("Description: " + description);
    }
    public static void main(String[] args) {
        Kettle kettle = new Kettle("Electric Kettle", "An electric kettle for boiling water.");
        kettle.show();
        kettle.desc();
        kettle.sound();

        Microwave microwave = new Microwave("Microwave Oven", "A kitchen appliance for heating food.");
        microwave.show();
        microwave.desc();
        microwave.sound();

        Car car = new Car("Sedan Car", "A four-wheeled motor vehicle for transportation.");
        car.show();
        car.desc();
        car.sound();

        Steamboat steamboat = new Steamboat("River Steamboat", "A boat powered by steam engines.");
        steamboat.show();
        steamboat.desc();
        steamboat.sound();
    }
}

class Kettle extends Device {
    public Kettle(String name, String description) {
        super(name, description);
    }

    @Override
    public void sound() {
        System.out.println("The kettle is whistling.");
    }
}

class Microwave extends Device {
    public Microwave(String name, String description) {
        super(name, description);
    }

    @Override
    public void sound() {
        System.out.println("The microwave is beeping.");
    }
}

class Car extends Device {
    public Car(String name, String description) {
        super(name, description);
    }

    @Override
    public void sound() {
        System.out.println("The car is honking.");
    }
}

class Steamboat extends Device {
    public Steamboat(String name, String description) {
        super(name, description);
    }

    @Override
    public void sound() {
        System.out.println("The steamboat is whistling.");
    }
}