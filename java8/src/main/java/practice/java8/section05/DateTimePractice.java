package practice.java8.section05;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimePractice {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        long time = date.getTime(); // date 인데 시간까지 다룸 + 기계용 시간을 가져옴
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000 * 3); // 3초간 재움
        Date after3Seconds = new Date(); // 현재 시간 가져옴
        System.out.println(after3Seconds); // Sat Feb 18 10:32:17 KST 2023
        after3Seconds.setTime(time); // 이전 시간으로 값 변경 가능 => mutable함
        System.out.println(after3Seconds); // Sat Feb 18 10:32:14 KST 2023

        // 1월이 0이므로, 3월은 2라고 써야 함. => Error 발생 가능성 높음. 그래서 숫자 대신 Calendar.MARCH 이렇게 쓰는 게 좋음.
        Calendar myBirthDay = new GregorianCalendar(1998, 2, 20);
        // Date와 다르게 getTime()이 날짜를 가져옴
        System.out.println(myBirthDay.getTime()); // Fri Mar 20 00:00:00 KST 1998
        myBirthDay = new GregorianCalendar(1998, Calendar.MARCH, 20);
        System.out.println(myBirthDay.getTime()); // Fri Mar 20 00:00:00 KST 1998

        /*

        ### 자바 8에서 제공하는 Date-Time API
        - JSR-310 스팩의 구현체를 제공한다.
        - 디자인 철학
            - Clear
              → API를 명확히 구분한다. (getTime() 시 time 정보가 나오고, getDate()  시 date 정보가 나오는 등…)
            - Fluent
              → null 을 리턴하거나 받지 않기 때문에 다양하게 연결하여 쓸 수 있어 유연하다.
            - Immutable
               → 날짜를 변경하면 기존의 인스턴스가 바뀌는 것이 아닌 새로운 인스턴스를 반환한다.
            - Extensible
               → 다양한 커스텀 달력을 만들 수 있는 확장성이 있다.

            ### 주요 API
            - 기계용 시간(machine time)과 인류용 시간(human time)으로 나눌 수 있다.
            - 기계용 시간은 EPOCK부터 현재까지의 타임스탬프를 표현한다.
            - 인류용 시간은 우리가 흔히 사용하는 연,월,일,시,분,초 등을 표현한다.
            - 타임스탬프는 Instant를 사용한다.
            - 특정 날짜(LocalDate), 시간(LocalTime), 일시(LocalDateTime)를 사용할 수 있다.
            - 기간을 표현할 때는 Duration(시간 기반)과 Period(날짜 기반)를 사용할 수 있다.
            - DateTimeFormatter를 사용해서 일시를 특정한 문자열로 포맷팅할 수 있다.

         */

    }
}
