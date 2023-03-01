package practice.java8.section07;

import java.lang.annotation.*;

@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(PizzaContainer.class) // 중복으로 사용하기 위해 Repeatable 추가 필요
public @interface PizzaMenu {
    String value();
}
