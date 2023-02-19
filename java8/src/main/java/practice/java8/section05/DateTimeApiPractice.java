package practice.java8.section05;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeApiPractice {
    public static void main(String[] args) {
        // 지금 이 순간을 기계 시간으로 표현
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT : 2023-02-18T02:15:49.144563Z
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 2023-02-18T02:15:49.144563Z[UTC]
        // 현재 위치의 시간을 나타내는 방법
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone); // Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime); // 2023-02-18T11:15:49.144563+09:00[Asia/Seoul]

        // 인류용 일시로 표현
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // 2023-02-18T11:18:30.148366
        // 특정 일시 리턴
        LocalDateTime birthDay = LocalDateTime.of(1998, Month.MARCH, 20, 18, 30, 0);
        System.out.println(birthDay); // 1998-03-20T18:30
        // 특정 존의 현재 시간 출력
        ZonedDateTime nowInUTC = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(nowInUTC); // 2023-02-18T02:23:04.792204Z[UTC]

        // 날짜 비교 - 인류용 시간 비교
        LocalDate today = LocalDate.now();
        LocalDate lastDay = LocalDate.of(2023, Month.FEBRUARY, 28);
        Period period = Period.between(today, lastDay);
        System.out.println(period.getDays()); // 10 -> 2월 마지막날까지 10일 남음
        // 다른 방법
        Period until = today.until(lastDay);
        System.out.println(until.get(ChronoUnit.DAYS)); // 10

        // 시간 비교 - 기계용 시간 비교
        Instant nowInstant = Instant.now();
        Instant plus = nowInstant.plus(10, ChronoUnit.SECONDS); // now에 10 더함
        Duration between = Duration.between(nowInstant, plus);
        System.out.println(between.getSeconds()); // 10

        // Formatting
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // 커스텀 포맷 생성
        System.out.println(nowDateTime.format(MMddyyyy)); // 02/18/2023

        // Parsing
        LocalDate parse = LocalDate.parse("03/20/1998", MMddyyyy);
        System.out.println(parse); // 1998-03-20

        //레거시 API 지원
        Date date = new Date();
        Instant dateInstant = date.toInstant(); // toInstant()로 레거시한 date를 Instant로 변경
        System.out.println(dateInstant); // 2023-02-18T02:46:32.869Z
        Date newDate = Date.from(dateInstant); // 반대로 Instant를 date로 변경할 수도 있음
        System.out.println(newDate); // Sat Feb 18 11:46:32 KST 2023

        // GregorianCalendar를 LocalDateTime으로 변경 (toInstant를 붙일 수 있다면 레거시를 다 변경 가능함!)
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(dateTime); // 2023-02-18T11:46:32.921
        // GregorianCalendar를 ZoneDateTime으로 변경할 수도 있고, 그 반대의 경우도 가능
        ZonedDateTime zonedDT = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(zonedDT);
        System.out.println(from.getTime()); // Sat Feb 18 11:46:32 KST 2023

        // TimeZone과 ZoneId 호환
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        System.out.println(zoneId); // America/Los_Angeles
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        System.out.println(timeZone.getID()); // America/Los_Angeles
    }
}
