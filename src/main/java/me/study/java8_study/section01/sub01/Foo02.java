package me.study.java8_study.section01.sub01;

public class Foo02 {
    public static void main(String[] args) {
        // 람다 표현식
        RunSomething01 runSomething011 = () -> System.out.println("Hello");

        // 내부에 코드가 2줄이라면?
        RunSomething01 runSomething012 = () -> {
            System.out.println("Hello");
            System.out.println("Lambda");
        };

        // 실행
        runSomething011.doIt();
        runSomething012.doIt();
    }
}
