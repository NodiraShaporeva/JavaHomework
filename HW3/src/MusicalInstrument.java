class MusicalInstrument {
    protected String name;
    protected String description;

    public MusicalInstrument(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void sound() {
        System.out.println("The instrument is producing sound.");
    }

    public void show() {
        System.out.println("Instrument: " + name);
    }

    public void desc() {
        System.out.println("Description: " + description);
    }

    public void history() {
        System.out.println("This instrument has a rich history.");
    }
    public static void main(String[] args) {
        Violin violin = new Violin("Violin", "A string instrument with four strings.");
        violin.show();
        violin.desc();
        violin.sound();
        violin.history();

        Trombone trombone = new Trombone("Trombone", "A brass instrument with a slide.");
        trombone.show();
        trombone.desc();
        trombone.sound();
        trombone.history();

        Ukulele ukulele = new Ukulele("Ukulele", "A small four-stringed instrument.");
        ukulele.show();
        ukulele.desc();
        ukulele.sound();
        ukulele.history();

        Cello cello = new Cello("Cello", "A large bowed string instrument.");
        cello.show();
        cello.desc();
        cello.sound();
        cello.history();
    }
}

class Violin extends MusicalInstrument {
    public Violin(String name, String description) {
        super(name, description);
    }

    @Override
    public void sound() {
        System.out.println("The violin is playing.");
    }
}

class Trombone extends MusicalInstrument {
    public Trombone(String name, String description) {
        super(name, description);
    }

    @Override
    public void sound() {
        System.out.println("The trombone is playing.");
    }
}

class Ukulele extends MusicalInstrument {
    public Ukulele(String name, String description) {
        super(name, description);
    }

    @Override
    public void sound() {
        System.out.println("The ukulele is playing.");
    }
}

class Cello extends MusicalInstrument {
    public Cello(String name, String description) {
        super(name, description);
    }

    @Override
    public void sound() {
        System.out.println("The cello is playing.");
    }
}