class Human {
    protected String name;

    public Human(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("My name is " + name);
    }

    public static void main(String[] args) {
        Builder builder = new Builder("John", "Carpentry");
        builder.introduce();
        builder.build();

        Sailor sailor = new Sailor("Jane", "The Black Pearl");
        sailor.introduce();
        sailor.sail();

        Pilot pilot = new Pilot("Alex", "Boeing 747");
        pilot.introduce();
        pilot.fly();
    }
}

class Builder extends Human {
    private String specialization;

    public Builder(String name, String specialization) {
        super(name);
        this.specialization = specialization;
    }

    public void build() {
        System.out.println(name + " is building");
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I am a builder specializing in " + specialization);
    }
}

class Sailor extends Human {
    private String shipName;

    public Sailor(String name, String shipName) {
        super(name);
        this.shipName = shipName;
    }

    public void sail() {
        System.out.println(name + " is sailing on the ship " + shipName);
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I am a sailor on the ship " + shipName);
    }
}

class Pilot extends Human {
    private String aircraftModel;

    public Pilot(String name, String aircraftModel) {
        super(name);
        this.aircraftModel = aircraftModel;
    }

    public void fly() {
        System.out.println(name + " is flying an aircraft " + aircraftModel);
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I am a pilot flying " + aircraftModel);
    }
}