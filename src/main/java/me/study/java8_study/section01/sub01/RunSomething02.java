package me.study.java8_study.section01.sub01;

// 함수형 인터페이스
// 추상 메소드가 하나만 선언된 인터페이스
@FunctionalInterface // 컴파일 시 함수형 인터페이스를 체크해줘서 더 견고한 관리 가능
public interface RunSomething02 {
    int doIt(int number); // 추상 메소드
}
