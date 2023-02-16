package practice.java8.section03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamApiPractice {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream().filter(springClass -> springClass.getTitle().startsWith("spring"))
                .forEach(springClass -> System.out.println(springClass.getId()));

        System.out.println("close 되지 않은 수업");
        // 방법 1. 람다 사용
        springClasses.stream().filter(springClass -> !springClass.isClosed())
                .forEach(springClass -> System.out.println(springClass.getId()));
        // 방법 2. 메서드 레퍼런스와 static 메서드 사용
        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed))
                .forEach(springClass -> System.out.println(springClass.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(OnlineClass::getTitle)
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> onlineClasses = new ArrayList<>();
        onlineClasses.add(springClasses);
        onlineClasses.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // flatMap 을 사용하면 리스트 내부에 있는 리스트들을 순서대로 꺼내서 stream 으로 실행
        onlineClasses.stream().flatMap(Collection::stream)
                .forEach(onlineClass -> System.out.println(onlineClass.getId()));

        System.out.println("10부터 1씩 증가하는 무한 스트림 중 앞 10개 빼고 최대 10개 출력");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println); // 20부터 29까지 출력

        System.out.println("자바 수업 중 Test가 들어있는 수업이 있는지 확인");
        boolean isIncludeTest = javaClasses.stream().anyMatch(javaClass -> javaClass.getTitle().contains("Test"));
        System.out.println(isIncludeTest); // true 출력

    }
}
