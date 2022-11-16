package practice.java8.section02;

public class DefaultNames implements Name, Names{
    String name;

    public DefaultNames(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    public String getName() {
        return this.name;
    }

    // 두 인터페이스에서 동일하게 가지고 있는 메소드인 경우, 다이아몬드 문제가 발생하게 된다.
    // 추상 메소드 - 추상 메소드, 추상 메소드 - 기본 메소드, 기본 메소드 - 기본 메소드 관계 없이 모두 문제가 발생한다.
    // 이럴 때에는 재정의하면 문제가 해결된다.
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }
}
