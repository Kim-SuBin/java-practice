package practice.java8.section01;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

// Shadowing 코드로 보기
public class Shadowing {
    public static void main(String[] args) {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 로컬 클래스 scope 내의 baseNumber 출력 - Shadowing
            }
        }
        new LocalClass().printBaseNumber(); // 11 출력

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // 익명 클래스 scope 내의 baseNumber 출력 - Shadowing
            }
        };
        integerConsumer.accept(11); // 11 출력

        // 람다
        // baseNumber 와 같은 scope 이기 때문에 애초에 인자 값으로 baseNumber 넣을 수 없음
        IntConsumer printInt = i -> System.out.println(i + baseNumber); // 람다는 effective final 값만 참조할 수 있음

        printInt.accept(10);
    }
}
