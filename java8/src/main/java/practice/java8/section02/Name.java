package practice.java8.section02;

public interface Name {
    void printName();

    String getName();

    // 나중에 공통 기능이 하나 추가된 경우, 특정 기능을 아래와 같이 default 메소드로 제공할 수 있다.
    // 자바 collection 내에도 removeIf 와 같은 default 메소드를 사용한 기능이 존재한다.
    // 그러나, 항상 정상 동작한다고 판단하기는 어렵다. 왜냐하면, 어떻게 구현되어 있는지 모르기 때문이다.
    // 그렇기에 문서화를 아주 잘 해두어야 한다. 아래와 같이 자바독 태그인 @implSpec 과 같은 어노테이션을 활용할 수도 있다.
    // 그리고 만약 문제가 된다면, 구현하는 부분에서 재정의하는 것도 가능하다.

    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져오는 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    // 해당 인터페이스 타입 관련 헬퍼/유틸리티 메소드를 제공할 때는 static 메소드를 제공할 수 있다.
    static void printAnything() {
        System.out.println("Anything");
    }
}
