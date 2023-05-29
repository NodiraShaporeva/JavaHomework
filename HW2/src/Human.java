public class Human {
    private String name;
    private int age;
    private int stepsCount = 0;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStepsCount(int stepsCount) {
        this.stepsCount = stepsCount;
    }

    public void resetStepsCount() {
        this.stepsCount = 0;
    }

    public void go(int value) {
        if (value < 0) value = 0;
        this.stepsCount += value;
    }

    public void setData(String name, int age) {
        this.name = name;
        this.age = age;
        this.stepsCount = 0;
    }

    public void setData(String name, int age, int stepsCount) {
        this.name = name;
        this.age = age;
        this.stepsCount = stepsCount;
    }

    public static void main(String[] args) {
        Human human = new Human();
        human.setName("Nodira");
        human.setAge(46);
        human.setStepsCount(50);
        human.go(100);

        System.out.println(human.getName()
                + '\n' + human.getAge()
                + '\n' + human.getStepsCount());
    }
}