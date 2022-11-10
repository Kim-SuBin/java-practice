package practice.java8.section01;

/**
 * 자바 8 이후 방식 - 람다 표현식 (Lambda Expression) 사용
 */
public class Foo2 {
    public static void main(String[] args) {
        RunSomething runSomething = () -> System.out.println("Hello");

        // 두 줄인 경우
        RunSomething runSomething2 = () -> {
            System.out.println("Lambda");
            System.out.println("Expression");
        };

        runSomething.doIt();
        runSomething2.doIt();
    }
}
