package practice.java8.section01;

/**
 * 자바 8 이후 방식 - 람다 표현식 (Lambda Expression) 사용
 */
public class Foo3 {
    public static void main(String[] args) {
        // 함수형 인터페이스는 동일한 입력에 항상 같은 값을 반환해야 함 => 순수 함수
        RunSomething2 runSomething = (number) -> (number + 10);

        // 1을 넣으면 항상 11 반환
        System.out.println("runSomething = " + runSomething.doIt(10)); // 11
        System.out.println("runSomething = " + runSomething.doIt(10)); // 11
        System.out.println("runSomething = " + runSomething.doIt(10)); // 11

    }
}
