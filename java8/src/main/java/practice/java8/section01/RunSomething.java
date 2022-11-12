package practice.java8.section01;

/**
 * 추상 메서드를 하나만 가지는 함수형 인터페이스 <br/>
 * {@code @FunctionalInterface} 어노테이션을 사용하면 추상 메서드가 두 개 이상 존재할 때 컴파일 에러가 발생한다.
 */
@FunctionalInterface
public interface RunSomething {

    /**
     * abstract 가 생략된 추상 메서드
     */
    void doIt();

    /**
     * 추상 메서드 내에 public 이 생략된 static 메서드를 정의할 수 있음
     */
    static void printName() {
        System.out.println("RunSomething");
    }

    /**
     * 추상 메서드 내에 default 메서드를 정의할 수 있음 ⇒ 다른 시간에 더 자세히 다룰 예정
     */
    default void printAge() {
        System.out.println("25");
    }
}
