package practice.java8.section02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class NameApp {
    public static void main(String[] args) {
        DefaultName name = new DefaultName("Kim");
        name.printName(); // Kim
        name.printNameUpperCase(); // KIM
        System.out.println("-----------------");

        List<String> names = new ArrayList<>();
        names.add("kim");
        names.add("Lee");
        names.add("park");
        names.add("bin");

        // forEach 를 사용하면 손쉽게 순회를 할 수 있음
        names.forEach(System.out::println);

        // for loop 를 사용한 방법과 비교해보았을 때 forEach 가 엄청 간편함을 알 수 있음
        for (String n : names) {
            System.out.println(n);
        }
        System.out.println("-----------------");

        // spliterator 는 쪼갤 수 있는 기능을 가진 iterator -> iterator 처럼 순회에 사용할 수 있음
        Spliterator<String> spliterator = names.spliterator();
        // trySplit() 은 spliterator 를 반으로 나눠 앞 부분을 가져옴
        // -> 보통 순서가 중요하지 않고 parallel 하게 처리할 때 활용
        Spliterator<String> spliterator1 = spliterator.trySplit();
        System.out.println("spliterator : ");
        while (spliterator.tryAdvance(System.out::println)); //  다음 값이 존재하는 경우에만 동작
        System.out.println("spliterator1 : ");
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("-----------------");

        // section3에서 자세히 볼 예정
        // 아래와 같이 대문자로 변경해 K로 시작하는 단어 필터하여 set 으로 모아 출력 할 수 있음
        names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("-----------------");

        // 조건에 충족하는 값 제거
        names.removeIf(s -> s.startsWith("k"));
        names.forEach(System.out::println);
        System.out.println("-----------------");

        // 대소문자 구분 없이 역순 정렬
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);
        System.out.println("-----------------");
    }
}
