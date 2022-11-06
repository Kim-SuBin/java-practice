package practice.java8.section01.sub01;

public class Foo01 {
    public static void main(String[] args) {
        // 익명 내부 클래스 annonymouse inner class
        RunSomething01 runSomething01 = new RunSomething01() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };
    }
}
