package practice.java8.section02;

public class DefaultName implements Name{
    String name;

    public DefaultName(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    public String getName() {
        return this.name;
    }
}
