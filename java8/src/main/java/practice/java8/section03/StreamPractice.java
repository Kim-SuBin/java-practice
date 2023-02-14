package practice.java8.section03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("kim");
        names.add("lee");
        names.add("park");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        System.out.println("names = " + names); // 소문자로 출력됨 -> stream 을 사용하는 데이터를 변경하지 않음을 알 수 있음

        // 스트림 파이프라인은 0 또는 다수의 중개 오퍼레이션과 한 개의 종료 오퍼레이션으로 구성
        // 중계 오퍼레이션 -> filter, map, limit, skip, sorted, ...
        // 종료 오퍼레이션 -> collect, allMatch, count, forEach, min, max, ...
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s); // 종료 오퍼레이션이 있어야만 출력됨 -> kim, lee, park 순서대로 출력
            return s.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println("collect = " + collect); // collect = [KIM, LEE, PARK]

        // 스트림을 안쓰고 처리할 때, 루프를 돌면서 병렬로 처리하기가 어려움
        for(String name : names) {
            if (name.startsWith("k")) {
                System.out.println(name.toUpperCase()); // KIM 출력
            }
        }

        // 스트림을 쓰면, 병렬적으로 처리하기 쉬움
        collect = names.parallelStream().filter(name -> name.startsWith("k")).map(String::toUpperCase)
                .collect(Collectors.toList());
        collect.forEach(System.out::println); // KIM 출력
    }
}
