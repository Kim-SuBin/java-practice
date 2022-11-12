package practice.java8.section01;

public class Foo4 {
    public static void main(String[] args) {
        // 함수 밖에 존재하는 경우 순수 함수 X
        int baseNumber = 10;

        RunSomething2 runSomething = new RunSomething2() {
            // 함수 밖에 존재하는 경우 순수 함수 X
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
                baseNumber++; // 함수 밖에 있는 값을 변경하면 순수 함수 X
                return number + baseNumber;
            }
        };
    }
}
