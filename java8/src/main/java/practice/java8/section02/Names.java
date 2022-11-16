package practice.java8.section02;

public interface Names extends Name{
    // 추상 메소드로 다시 선언하면 Names 를 구현하는 구현체에서 직접 구현해야 한다.
    void printNameUpperCase();
}
