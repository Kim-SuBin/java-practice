package practice.java8.section07;

import java.util.Arrays;
import java.util.List;

@Pizza // 타입을 선언하는 모든 곳에 사용 가능
public class AnnotationPractice {
    public static void main(String[] args) throws @Pizza RuntimeException{
        List<@Pizza String> name = Arrays.asList("Napoletan", "Margherita");
    }

    // 애노테이션이 TYPE_PARAMETER인 경우
    static class FeelLikeChicken<@Chicken T> {

        // 앞의 C는 타입 파라미터, 뒤의 C는 타입 -> 뒤의 C에는 애노테이션 사용 불가
        public static <@Chicken C>void print(C c) {

        }
    }

    // 애노테이션이 TYPE_USE인 경우
    static class FeelLikePizza<@Pizza T> {

        // 앞의 P는 타입 파라미터, 뒤의 P는 타입 -> 뒤의 P에도 애노테이션 사용 가능
        public static <@Pizza P>void print(@Pizza P p) {

        }
    }
}
