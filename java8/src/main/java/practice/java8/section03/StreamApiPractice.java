package practice.java8.section03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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


        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> onlineClasses = new ArrayList<>();
        onlineClasses.add(springClasses);
        onlineClasses.add(javaClasses);
    }
}
