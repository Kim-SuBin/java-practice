package practice.java8.section01;

import java.util.function.*;

/**
 * 자바가 제공하는 주요 함수형 인터페이스
 */
public class FunctionalInterfaces {
    public static void main(String[] args) {
        // 자바에서 제공하는 Function 인터페이스 활용================
        Function<Integer, Integer> plus10 = i -> i + 10; // Foo3의 메서드와 동일한 기능
        System.out.println(plus10.apply(1)); // R apply(T t) : T 타입을 받아서 R 타입으로 반환

        Function<Integer, Integer> multiply2 = i -> i * 2;
        System.out.println(multiply2.apply(2)); // 2

        // compose 내 메서드가 먼저 수행된 결과를 사용해 앞에 있는 메서드가 수행된다.
        // 즉, multiply2 가 먼저 적용되고 plus10이 적용된다.
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2)); // 14

        // 앞에 있는 메서드 결과를 사용해 andThen 내 메서드가 수행된다.
        // 즉, plus10 이 먼저 실행되고 multiply2 가 적용된다.
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMultiply2.apply(2)); // 24

        // 자바에서 제공하는 Consumer 인터페이스 활용================
        Consumer<Integer> printT = i -> System.out.println(i);
        printT.accept(10); // void accept(T t) : T 타입을 받아서 아무 값도 리턴하지 않음

        // 자바에서 제공하는 Supplier 인터페이스 활용================
        Supplier<Integer> get10 = () -> 10; // 전달 받는 인자 값 X
        System.out.println(get10.get()); // 호출 시 T 타입 값을 반환

        // 자바에서 제공하는 Predicate 인터페이스 활용================
        // test 에 T 타입 값을 넣으면 체크 후 boolean 타입으로 반환함
        Predicate<String> startsWithFunc = s -> s.startsWith("func");
        System.out.println(startsWithFunc.test("function")); // true
        System.out.println(startsWithFunc.test("Function")); // false
        Predicate<Integer> isEven = i -> i % 2 == 0;
        System.out.println(isEven.test(2)); // true
        System.out.println(isEven.test(5)); // false

        // 자바에서 제공하는 UnaryOperator 인터페이스 활용================
        // Function<T, R> 의 특수한 형태로, T 타입과 R 타입이 동일
        UnaryOperator<Integer> plus1 = i -> i + 1;
    }
}
