class Animal {
    protected String name;
    protected int age;
    protected String habitat;

    public Animal(String name, int age, String habitat) {
        this.name = name;
        this.age = age;
        this.habitat = habitat;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public void move() {
        System.out.println(name + " is moving.");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger("Siberian Tiger", 5, "Forest", "Striped");
        tiger.eat();
        tiger.sleep();
        tiger.move();
        tiger.roar();

        Crocodile crocodile = new Crocodile("Nile Crocodile", 10, "River", 4.5);
        crocodile.eat();
        crocodile.sleep();
        crocodile.move();
        crocodile.snapJaws();

        Kangaroo kangaroo = new Kangaroo("Red Kangaroo", 3, "Grassland", 2.5);
        kangaroo.eat();
        kangaroo.sleep();
        kangaroo.move();
        kangaroo.jump();
    }
}

class Tiger extends Animal {
    private String pattern;

    public Tiger(String name, int age, String habitat, String pattern) {
        super(name, age, habitat);
        this.pattern = pattern;
    }

    public void roar() {
        System.out.println(name + " is roaring.");
    }

    @Override
    public void move() {
        System.out.println(name + " is running.");
    }
}

class Crocodile extends Animal {
    private double length;

    public Crocodile(String name, int age, String habitat, double length) {
        super(name, age, habitat);
        this.length = length;
    }

    public void snapJaws() {
        System.out.println(name + " is snapping its jaws.");
    }

    @Override
    public void move() {
        System.out.println(name + " is swimming.");
    }
}

class Kangaroo extends Animal {
    private double jumpHeight;

    public Kangaroo(String name, int age, String habitat, double jumpHeight) {
        super(name, age, habitat);
        this.jumpHeight = jumpHeight;
    }

    public void jump() {
        System.out.println(name + " is jumping.");
    }

    @Override
    public void move() {
        System.out.println(name + " is hopping.");
    }
}