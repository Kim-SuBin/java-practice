package practice.java8.section01.sub01;

public class Foo03 {
    public static void main(String[] args) {
        // 함수형 인터페이스는 항상 같은 값을 반환해야 함
        RunSomething02 runSomething = (number) -> {
            return number + 10;
        };

        // 1을 넣으면 항상 11 반환
        System.out.println(runSomething.doIt(1)); // 11
        System.out.println(runSomething.doIt(1)); // 11
        System.out.println(runSomething.doIt(1)); // 11
    }
}
