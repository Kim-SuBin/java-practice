package me.study.java8_study.section01.sub01;

public class Foo04 {
    public static void main(String[] args) {
        // 순수 함수가 아닌 경우 1. 외부에 있는 값 참조
        int baseNumber = 10;
        RunSomething02 runSomething01 = (number) -> {
            return number + baseNumber;
        };

        // 순수 함수가 아닌 경우 2. 외부에 있는 값 변경
        RunSomething02 runSomething02 = new RunSomething02() {
            int baseNumber02 = 10;

            @Override
            public int doIt(int number) {
                baseNumber02++;
                return number + baseNumber02;
            }
        };
    }
}
