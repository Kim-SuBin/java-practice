package practice.java8.section01;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// 메소드 레퍼런스 활용
public class App {
    public static void main(String[] args) {
        // UnaryOperator<String> hi = (s) -> "hi" + s;
        UnaryOperator<String> hi = Greeting::hi; // static 메소드 참조

        // 특정 객체의 인스턴스 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("kim"));

        // 생성자
        Supplier<Greeting> newGreeting = Greeting::new; // 이렇게만 해서는 아무런 일도 벌어지지 않음
        newGreeting.get(); // 이렇게 해야 생성됨

        // 입력 값을 받는 생성자
        Function<String, Greeting> nameGreeting = Greeting::new;
        Greeting name = nameGreeting.apply("name");
        System.out.println(name.getName());

        // 임의 객체의 인스턴스 참조
        String[] names = {"kim", "su", "bin"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
