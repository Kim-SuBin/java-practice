package practice.java8.section01;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class VariableCapture {
    public static void main(String[] args) {
        VariableCapture variableCapture = new VariableCapture();
        variableCapture.run();
    }

    private void run() {
        final int baseNumber = 10; // java8 부터는 값이 사실상 final 인 경우 final 생략 가능 => effective final

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = i -> System.out.println(i + baseNumber);

        printInt.accept(10);
    }
}
