package practice.java8.section01;

/**
 * 자바 8 이전 방식 - 익명 내부 클래스 (anonymous inner class) 사용
 */
public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };
    }
}
