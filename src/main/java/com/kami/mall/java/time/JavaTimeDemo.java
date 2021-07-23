package com.kami.mall.java.time;

import org.junit.Test;
import sun.jvm.hotspot.oops.Instance;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author yangzi
 * @date 2021-07-07 3:11 PM
 */
public class JavaTimeDemo {


    /**
     * LocalDate 、 LocalTime
     */
    @Test
    public void test1() {

        LocalDate localDate = LocalDate.of(2017, 1, 4);     // 初始化一个日期：2017-01-04
        int year = localDate.getYear();                     // 年份：2017
        Month month = localDate.getMonth();                 // 月份：JANUARY
        int dayOfMonth = localDate.getDayOfMonth();         // 月份中的第几天：4
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();     // 一周的第几天：WEDNESDAY
        int length = localDate.lengthOfMonth();             // 月份的天数：31
        boolean leapYear = localDate.isLeapYear();          // 是否为闰年：false
        LocalDate now = LocalDate.now();

        System.out.println(now);


        LocalTime localTime = LocalTime.of(17, 23, 52);     // 初始化一个时间：17:23:52
        LocalTime now1 = LocalTime.now();
        int hour = localTime.getHour();                     // 时：17
        int minute = localTime.getMinute();                 // 分：23
        int second = localTime.getSecond();                 // 秒：52
    }

    /**
     * LocalDateTime
     */
    @Test
    public void test2() {

        LocalDateTime ldt1 = LocalDateTime.of(2021, Month.JUNE, 4, 17, 23, 52);
        LocalDate localDate = LocalDate.of(2021, Month.JUNE, 4);
        LocalTime localTime = LocalTime.of(17, 23, 52);
        LocalDateTime ldt2 = localDate.atTime(localTime);


        ldt1.toLocalDate();
        ldt1.toLocalTime();

        LocalDate localDate1 = ldt1.toLocalDate();
        LocalTime localTime1 = ldt1.toLocalTime();
    }


    /**
     * Instance
     */
    @Test
    public void test3() {
        Instant instant = Instant.ofEpochSecond(120, 1000);  // 1970-01-01T00:02:00.000001Z
        Instant now = Instant.now();   // 2021-07-07T07:43:57.155Z
        System.out.println(instant);
        System.out.println(now);
    }

    /**
     * Duration
     */
    @Test
    public void test4() {


        LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7, 0);    // 2017-01-05 10:07:00
        LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7, 0);     // 2017-02-05 10:07:00
        Duration duration = Duration.between(from, to);     // 表示从 2017-01-05 10:07:00 到 2017-02-05 10:07:00 这段时间
        long days = duration.toDays();              // 这段时间的总天数
        long hours = duration.toHours();            // 这段时间的小时数
        long minutes = duration.toMinutes();        // 这段时间的分钟数
        long seconds = duration.getSeconds();       // 这段时间的秒数
        long milliSeconds = duration.toMillis();    // 这段时间的毫秒数
        long nanoSeconds = duration.toNanos();      // 这段时间的纳秒数



        System.out.println(days);
        System.out.println(hours);
        System.out.println(minutes);
        System.out.println(seconds);
        System.out.println(milliSeconds);
        System.out.println(nanoSeconds);


        Duration duration1 = Duration.of(5, ChronoUnit.DAYS);       // 5天
        Duration duration2 = Duration.of(1000, ChronoUnit.MILLIS);  // 1000毫秒
    }


    /**
     * Period
     */
    @Test
    public void test5() {
        Period period = Period.of(2, 3, 6);  // P2Y3M6D
        System.out.println(period);

        Period period1 = Period.between(
                LocalDate.of(2017, 1, 10),
                LocalDate.of(2017, 2, 5));  // P26D

        System.out.println(period1);
    }

    @Test
    public void test6() {
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        System.out.println(System.currentTimeMillis());
        System.out.println(milliSecond);
    }

    @Test
    public void test7() {
        String mobile = "  18270347287     ";
        String substring1 = mobile.trim().substring(5);
        boolean b = substring1.equalsIgnoreCase("347287");
        System.out.println(b);


    }
}
