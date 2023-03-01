package practice.java8.section07;


import java.util.Arrays;

@PizzaMenu("Napoletan")
@PizzaMenu("Margherita")
public class DuplicateAnnotationPractice {
    public static void main(String[] args) {
        // 컨테이너 애노테이션으로 중복 애노테이션 참조하기
        PizzaContainer pizzaContainer = DuplicateAnnotationPractice.class.getAnnotation(PizzaContainer.class);
        Arrays.stream(pizzaContainer.value()).forEach(pizzaMenu -> {
            System.out.println(pizzaMenu.value());
        });
    }
}
