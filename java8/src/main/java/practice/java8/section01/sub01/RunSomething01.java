package practice.java8.section01.sub01;

// 함수형 인터페이스
// 추상 메소드가 하나만 선언된 인터페이스
@FunctionalInterface // 컴파일 시 함수형 인터페이스를 체크해줘서 더 견고한 관리 가능
public interface RunSomething01 {
    void doIt(); // 추상 메소드

    // 아래와 같은 다른 메소드가 존재하더라도 추상 메소드는 1개이므로 함수형 인터페이스
    static void printName() {
        System.out.println("subin");
    }

    default void printAge() {
        System.out.println("25");
    }
}
