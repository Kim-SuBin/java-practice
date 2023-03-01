package practice.java8.section07;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 중복 애노테이션 컨테이너(PizzaContainer)는
 * 중복 애노테이션(PizzaMenu)과 @Retention 및 Target이 같거나 더 넓어야 한다.
 */
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PizzaContainer {
    PizzaMenu[] value();
}
