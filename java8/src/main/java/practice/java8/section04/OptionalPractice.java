package practice.java8.section04;

import java.util.ArrayList;
import java.util.List;

public class OptionalPractice {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass springBoot = new OnlineClass(1, "spring boot", true);
        Progress progress = springBoot.getProgress(); // 현재 설정된 값이 없기 때문에 null

        if (progress != null) {
            System.out.println(progress.getStudyDuration()); // null 처리 없이 출력하면 NPE 발생
        }
    }
}
