package practice.java8.section04;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
                .findFirst();

        // Optional에 값이 있는지 없는지 확인
        System.out.println(spring.isPresent()); // true 출력
        System.out.println(spring.isEmpty()); // false 출력

        // get()을 사용해 Optional에서 값을 꺼낼 수 있음
        // => 비어있는 Optional에서 값을 꺼내려고 하면 runtime exception이 발생하므로 사용 시 주의해야 함
        OnlineClass springClass = spring.get();
        System.out.println(springClass.getTitle()); // spring boot 출력

        // 가끔적이면 get() 을 쓰기보다는 아래 방법을 활용하자!!

        // Optional 값이 존재하면 수행
        spring.ifPresent(oc -> System.out.println(oc.getTitle())); // spring boot 출력

        // Optional 값이 없을 때 특정 값을 반환하고 싶다면, orElse()를 사용하면 됨
        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("jpa"))
                .findFirst();
        OnlineClass jpaClass = jpa.orElse(createNewClass()); // create new online class 출력
        System.out.println(jpaClass.getTitle()); // new class 출력
        // orElse()의 경우, 값이 있더라도 수행은 됨. (반환이 안됨!)
        OnlineClass onlineClass = spring.orElse(createNewClass()); // create new online class 출력
        System.out.println(onlineClass.getTitle()); // spring boot 출력

        // Optional이 없는 경우에만 수행하길 원하면 orElseGet() 사용
        OnlineClass onlineClass1 = spring.orElseGet(OptionalPractice::createNewClass);
        System.out.println(onlineClass1.getTitle()); // spring boot 출력

        // Optional이 없는 경우 에러를 던지려면 orElseThrow() 사용
//        OnlineClass onlineClass2 = jpa.orElseThrow(IllegalArgumentException::new);
//        System.out.println("Exception 발생했나요?"); // Exception이 터져서 수행 X

        // Optional에 들어있는 값을 걸러내려면 filter()를 사용
        Optional<OnlineClass> onlineClass2 = spring.filter(oc -> oc.getId() > 10);
        System.out.println(onlineClass2); // Optional.empty 출력

        // map 타입으로 가져올 수도 있음
        Optional<Optional<Progress>> progress = spring.map(OnlineClass::getProgress);
        // map 내부 값에 Optional이 있는 경우 양파 껍질 까듯이 순서대로 꺼내야 함 -> 많아질수록 복잡해짐
        Optional<Progress> progress1 = progress.orElseThrow();
        // 이런 경우 flatMap을 사용하면 좋음 -> flatMap은 내부 인스턴스가 Optinoal이면, 꺼내서 Map에 저장하기 때문
        Optional<Progress> progress2 = spring.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        System.out.println("create new online class");
        return new OnlineClass(10, "new class", false);
    }
}
