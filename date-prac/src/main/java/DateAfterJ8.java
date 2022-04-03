import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Administrator
 */
public class DateAfterJ8 {

    @Test
    public void dateCalculate() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);

        System.out.println(localDateTime);
        System.out.println(localDateTime.plusDays(3));
        System.out.println(localDateTime.plusHours(-3));
        System.out.println(localDateTime.minusMinutes(3));

        LocalDateTime after = localDateTime.plusDays(3);
        after = after.plusHours(-3);
        // 计算时间差
        Period period = Period.between(localDateTime.toLocalDate(), after.toLocalDate());
        System.out.println("相差天数：" + period.getDays());
        Duration duration = Duration.between(localDateTime.toLocalTime(), after.toLocalTime());
        System.out.println("相差小时数：" + duration.toHours());
    }

    @Test
    public void dateTimeToDateString() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));

        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]", zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00", offsetDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        Assert.assertEquals("2019-07-07T20:18:18.000000888", localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));

        Assert.assertEquals("2019-07-07+09:00", zonedDateTime.format(DateTimeFormatter.ISO_DATE));
        Assert.assertEquals("2019-07-07+09:00", offsetDateTime.format(DateTimeFormatter.ISO_DATE));
        Assert.assertEquals("2019-07-07", localDateTime.format(DateTimeFormatter.ISO_DATE));

        Assert.assertEquals("20:18:18.000000888+09:00", zonedDateTime.format(DateTimeFormatter.ISO_TIME));
        Assert.assertEquals("20:18:18.000000888+09:00", offsetDateTime.format(DateTimeFormatter.ISO_TIME));
        Assert.assertEquals("20:18:18.000000888", localDateTime.format(DateTimeFormatter.ISO_TIME));
    }

    @Test
    public void dateTimeToLocalString() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));

        Assert.assertEquals("2019-07-07T20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));
        Assert.assertEquals("2019-07-07", DateTimeFormatter.ISO_LOCAL_DATE.format(localDateTime));
        Assert.assertEquals("20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_TIME.format(localDateTime));

        Assert.assertEquals("2019-07-07T20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(zonedDateTime));
        Assert.assertEquals("2019-07-07", DateTimeFormatter.ISO_LOCAL_DATE.format(zonedDateTime));
        Assert.assertEquals("20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_TIME.format(zonedDateTime));

        Assert.assertEquals("2019-07-07T20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(offsetDateTime));
        Assert.assertEquals("2019-07-07", DateTimeFormatter.ISO_LOCAL_DATE.format(offsetDateTime));
        Assert.assertEquals("20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_TIME.format(offsetDateTime));
    }

    @Test
    public void dateToOffsetString() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));

        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00",DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime));
        Assert.assertEquals("2019-07-07+09:00",DateTimeFormatter.ISO_OFFSET_DATE.format(zonedDateTime));
        Assert.assertEquals("20:18:18.000000888+09:00",DateTimeFormatter.ISO_OFFSET_TIME.format(zonedDateTime));

        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00",DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime));
        Assert.assertEquals("2019-07-07+09:00",DateTimeFormatter.ISO_OFFSET_DATE.format(offsetDateTime));
        Assert.assertEquals("20:18:18.000000888+09:00",DateTimeFormatter.ISO_OFFSET_TIME.format(offsetDateTime));

        //System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(localDateTime));//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:
        //System.out.println(DateTimeFormatter.ISO_OFFSET_DATE.format(localDateTime));//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:
        //System.out.println(DateTimeFormatter.ISO_OFFSET_TIME.format(localDateTime));//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:
    }

    @Test
    public void dateTimeToLocalZoneDateTimeString() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));

        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]", DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDateTime));
        //System.out.println(DateTimeFormatter.ISO_ZONED_DATE.format(ZonedDateTime.now()));// 不存在ISO_ZONED_DATE
        //System.out.println(DateTimeFormatter.ISO_ZONED_TIME.format(ZonedDateTime.now()));// 不存在ISO_ZONED_TIME

        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00", DateTimeFormatter.ISO_ZONED_DATE_TIME.format(offsetDateTime));

        //System.out.println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(localDateTime));//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:
    }

    @Test
    public void dateTimeToLocalString1() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));

        Assert.assertEquals("2019-07-07T11:18:18.000000888Z",zonedDateTime.format(DateTimeFormatter.ISO_INSTANT));
        Assert.assertEquals("2019-07-07T11:18:18.000000888Z",offsetDateTime.format(DateTimeFormatter.ISO_INSTANT));
        //Assert.assertEquals("2019-07-07",localDateTime.format(DateTimeFormatter.ISO_INSTANT));//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:

        Assert.assertEquals("2019-188+09:00",zonedDateTime.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        Assert.assertEquals("2019-188+09:00",offsetDateTime.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        Assert.assertEquals("2019-188",localDateTime.format(DateTimeFormatter.ISO_ORDINAL_DATE));

        Assert.assertEquals("2019-W27-7+09:00",zonedDateTime.format(DateTimeFormatter.ISO_WEEK_DATE));
        Assert.assertEquals("2019-W27-7+09:00",offsetDateTime.format(DateTimeFormatter.ISO_WEEK_DATE));
        Assert.assertEquals("2019-W27-7",localDateTime.format(DateTimeFormatter.ISO_WEEK_DATE));
    }

    @Test
    public void dateToString() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));

        Assert.assertEquals("2019年7月7日星期日 日本标准时间 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.of("Asia/Tokyo")).format(localDateTime));
        Assert.assertEquals("2019年7月7日 JST 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of("Asia/Tokyo")).format(localDateTime));
        Assert.assertEquals("2019年7月7日 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withZone(ZoneId.of("Asia/Tokyo")).format(localDateTime));
        Assert.assertEquals("2019/7/7 下午8:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.of("Asia/Tokyo")).format(localDateTime));
        Assert.assertEquals("2019年7月7日星期日",DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(localDateTime));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(localDateTime));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(localDateTime));
        Assert.assertEquals("2019/7/7",DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(localDateTime));

        Assert.assertEquals("2019年7月7日星期日 日本标准时间 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.of("Asia/Tokyo")).format(localDateTime));
        Assert.assertEquals("2019年7月7日 JST 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of("Asia/Tokyo")).format(zonedDateTime));
        Assert.assertEquals("2019年7月7日 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withZone(ZoneId.of("Asia/Tokyo")).format(zonedDateTime));
        Assert.assertEquals("2019/7/7 下午8:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.of("Asia/Tokyo")).format(zonedDateTime));
        Assert.assertEquals("2019年7月7日星期日",DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(zonedDateTime));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(zonedDateTime));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(zonedDateTime));
        Assert.assertEquals("2019/7/7",DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(zonedDateTime));

        Assert.assertEquals("2019年7月7日星期日 日本标准时间 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.of("Asia/Tokyo")).format(offsetDateTime));
        Assert.assertEquals("2019年7月7日 JST 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of("Asia/Tokyo")).format(offsetDateTime));
        Assert.assertEquals("2019年7月7日 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withZone(ZoneId.of("Asia/Tokyo")).format(offsetDateTime));
        Assert.assertEquals("2019/7/7 下午8:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.of("Asia/Tokyo")).format(offsetDateTime));
        Assert.assertEquals("2019年7月7日星期日",DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(offsetDateTime));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(offsetDateTime));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(offsetDateTime));
        Assert.assertEquals("2019/7/7",DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(offsetDateTime));
    }

    @Test
    public void dateToCustomString() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));

        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 7, 7, 20, 18, 18);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("第Q季度 yyyy-MM-dd HH:mm:ss", Locale.JAPAN);
        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter.format(localDateTime));
        Assert.assertEquals(localDateTime1,LocalDateTime.parse("第3季度 2019-07-07 20:18:18", formatter));

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("第Q季度 yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter1.format(localDateTime));
        Assert.assertEquals(localDateTime1,LocalDateTime.parse("第3季度 2019-07-07 20:18:18", formatter1));

        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter.format(zonedDateTime));
        //Assert.assertEquals(localDateTime1,ZonedDateTime.parse("第3季度 2019-07-07 20:18:18", formatter));java.time.format.DateTimeParseException

        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter1.format(zonedDateTime));
        //Assert.assertEquals(localDateTime1,ZonedDateTime.parse("第3季度 2019-07-07 20:18:18", formatter1));java.time.format.DateTimeParseException

        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter.format(offsetDateTime));
        //Assert.assertEquals(localDateTime1,OffsetDateTime.parse("第3季度 2019-07-07 20:18:18", formatter));java.time.format.DateTimeParseException

        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter1.format(offsetDateTime));
        //Assert.assertEquals(localDateTime1,OffsetDateTime.parse("第3季度 2019-07-07 20:18:18", formatter1));java.time.format.DateTimeParseException
    }

    @Test
    public void stringToDateTime() {
        /*1、不带时区/偏移量的字符串：要么不理它说转换不了，要么就约定一个时区（一般用系统默认时区），使用LocalDateTime来解析*/
        System.out.println("解析后：" + LocalDateTime.parse("2022-04-03T18:00"));//2022-04-03T18:00

        /*2、带时区字/偏移量的符串：*/
        // 带偏移量 使用OffsetDateTime
        System.out.println("带偏移量解析后：" + OffsetDateTime.parse("2021-04-03T18:00+09:00"));//2021-04-03T18:00+09:00

        // 带时区 使用ZonedDateTime
        System.out.println("带时区解析后：" + ZonedDateTime.parse("2021-04-03T18:00-05:00[Asia/Tokyo]"));//2021-04-04T08:00+09:00[Asia/Tokyo]
    }

    @Test
    public void dateYearMonthDay() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));

        Assert.assertEquals(2019,localDateTime.getYear());
        Assert.assertEquals(Month.JULY,localDateTime.getMonth());
        Assert.assertEquals(7,localDateTime.getMonthValue());
        Assert.assertEquals(DayOfWeek.SUNDAY,localDateTime.getDayOfWeek());
        Assert.assertEquals(7,localDateTime.getDayOfMonth());
        Assert.assertEquals(188,localDateTime.getDayOfYear());
        Assert.assertEquals(20,localDateTime.getHour());
        Assert.assertEquals(18,localDateTime.getMinute());
        Assert.assertEquals(18,localDateTime.getSecond());
        Assert.assertEquals(888,localDateTime.getNano());

        Assert.assertEquals(2019,zonedDateTime.getYear());
        Assert.assertEquals(Month.JULY,zonedDateTime.getMonth());
        Assert.assertEquals(7,zonedDateTime.getMonthValue());
        Assert.assertEquals(DayOfWeek.SUNDAY,zonedDateTime.getDayOfWeek());
        Assert.assertEquals(7,zonedDateTime.getDayOfMonth());
        Assert.assertEquals(188,zonedDateTime.getDayOfYear());
        Assert.assertEquals(20,zonedDateTime.getHour());
        Assert.assertEquals(18,zonedDateTime.getMinute());
        Assert.assertEquals(18,zonedDateTime.getSecond());
        Assert.assertEquals(888,zonedDateTime.getNano());

        Assert.assertEquals(2019,offsetDateTime.getYear());
        Assert.assertEquals(Month.JULY,offsetDateTime.getMonth());
        Assert.assertEquals(7,offsetDateTime.getMonthValue());
        Assert.assertEquals(DayOfWeek.SUNDAY,offsetDateTime.getDayOfWeek());
        Assert.assertEquals(7,offsetDateTime.getDayOfMonth());
        Assert.assertEquals(188,offsetDateTime.getDayOfYear());
        Assert.assertEquals(20,offsetDateTime.getHour());
        Assert.assertEquals(18,offsetDateTime.getMinute());
        Assert.assertEquals(18,offsetDateTime.getSecond());
        Assert.assertEquals(888,offsetDateTime.getNano());
    }

    /**
     * ZonedDateTime -> OffsetDateTime
     */
    @Test
    public void zonedDateTimeToOffsetDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);

        System.out.println(zonedDateTime.toOffsetDateTime());
    }

    /**
     * OffsetDateTime -> ZonedDateTime
     */
    @Test
    public void offsetDateTimeToZonedDateTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));
        System.out.println(offsetDateTime);

        System.out.println(offsetDateTime.toZonedDateTime());
        System.out.println(offsetDateTime.atZoneSameInstant(ZoneId.of("Asia/Tokyo")));
        System.out.println(offsetDateTime.atZoneSimilarLocal(ZoneId.of("Asia/Tokyo")));
    }

    /**
     * ZonedDateTime -> LocalDateTime
     */
    @Test
    public void zonedDateTimeToLocalDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.toLocalDateTime());
    }

    /**
     * LocalDateTime -> ZonedDateTime
     */
    @Test
    public void localDateTimeToZonedDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        System.out.println(localDateTime);

        System.out.println( ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Tokyo")));
        System.out.println(localDateTime.atZone(ZoneId.of("Asia/Tokyo")));
        System.out.println(ZonedDateTime.ofInstant(localDateTime.toInstant(ZoneOffset.ofHours(9)), ZoneOffset.ofHours(9)));
        System.out.println(ZonedDateTime.ofInstant(localDateTime, ZoneOffset.ofHours(9), ZoneOffset.ofHours(9)));
    }

    /**
     * OffsetDateTime -> LocalDateTime
     */
    @Test
    public void offsetDateTimeToLocalDateTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime .toLocalDateTime());
    }

    /**
     * LocalDateTime -> OffsetDateTime
     */
    @Test
    public void localDateTimeToOffsetDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
        System.out.println(localDateTime);

        System.out.println(OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(9)));
        System.out.println(localDateTime.atOffset(ZoneOffset.ofHours(9)));

        System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(8)));
        System.out.println(OffsetDateTime.ofInstant(localDateTime.toInstant(ZoneOffset.ofHours(9)), ZoneOffset.ofHours(9)));
    }

    @Test
    public void dateNow() {
        // 本地日期/时间
        System.out.println("================本地时间================");
        System.out.println(LocalDate.now());//2022-04-03
        System.out.println(LocalTime.now());//17:30:32.193733700
        System.out.println(LocalDateTime.now());//2022-04-03T17:30:32.193733700

        // 时区时间
        System.out.println("================带时区的时间ZonedDateTime================");
        System.out.println(ZonedDateTime.now()); // 使用系统时区  2022-04-03T17:30:32.193733700+08:00[Asia/Shanghai]
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo"))); // 自己指定时区  2022-04-03T18:30:32.193733700+09:00[Asia/Tokyo]
        System.out.println(ZonedDateTime.now(Clock.systemUTC())); // 自己指定时区  2022-04-03T09:30:32.193733700Z

        System.out.println("================带时区的时间OffsetDateTime================");
        System.out.println(OffsetDateTime.now()); // 使用系统时区  2022-04-03T17:30:32.209357700+08:00
        System.out.println(OffsetDateTime.now(ZoneId.of("Asia/Tokyo"))); // 自己指定时区  2022-04-03T18:30:32.209357700+09:00
        System.out.println(OffsetDateTime.now(Clock.systemUTC())); // 自己指定时区  2022-04-03T09:30:32.209357700Z

        System.out.println(LocalDateTime.MIN);
        System.out.println(LocalDateTime.MAX);
        //System.out.println(ZonedDateTime.MIN);不存在
        //System.out.println(ZonedDateTime.MAX);不存在
        System.out.println(OffsetDateTime.MIN);
        System.out.println(OffsetDateTime.MAX);
    }

    @Test
    public void zonedDateTime() {
        System.out.println(ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo")));
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888),ZoneId.of("Asia/Tokyo")));
        System.out.println(ZonedDateTime.of(LocalDate.of(2019, 7, 7),LocalTime.of(20, 18, 18, 888),ZoneId.of("Asia/Tokyo")));
    }

    @Test
    public void offsetDateTime() {
        System.out.println(OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9)));
        System.out.println(OffsetDateTime.of(LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888),ZoneOffset.ofHours(9)));
        System.out.println(OffsetDateTime.of(LocalDate.of(2019, 7, 7),LocalTime.of(20, 18, 18, 888),ZoneOffset.ofHours(9)));
    }

    @Test
    public void localDateTime() {
        System.out.println(LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888));
        System.out.println(LocalDateTime.of(2019, 7, 7, 20, 18, 18));
        System.out.println(LocalDateTime.of(2019, 7, 7, 20, 18));
        System.out.println(LocalDateTime.of(2019, Month.JULY, 7, 20, 18, 18, 888));
        System.out.println(LocalDateTime.of(2019, Month.JULY, 7, 20, 18, 18));
        System.out.println(LocalDateTime.of(2019, Month.JULY, 7, 20, 18));
        System.out.println(LocalDateTime.of(LocalDate.of(2019, 7, 7),LocalTime.of(20,18)));

        System.out.println(LocalDate.of(2019, 7, 7));
        System.out.println(LocalDate.of(2019, Month.JULY, 7));

        System.out.println(LocalTime.of(20,18));
        System.out.println(LocalTime.of(20,18,18));
        System.out.println(LocalTime.of(20, 18, 18, 888));
    }

    @Test
    public void zoneOffset() {
        /*1、最小/最大偏移量：因为偏移量传入的是数字，这个是有限制*/
        System.out.println("最小偏移量：" + ZoneOffset.MIN);//-18:00
        System.out.println("最小偏移量：" + ZoneOffset.MAX);//+18:00
        System.out.println("中心偏移量：" + ZoneOffset.UTC);//Z

        /*2、通过时分秒构造偏移量（使用很方便，推荐）：*/
        System.out.println(ZoneOffset.ofHours(8));//+08:00
        System.out.println(ZoneOffset.ofHoursMinutes(8, 8));//+08:08
        System.out.println(ZoneOffset.ofHoursMinutesSeconds(8, 8, 8));//+08:08:08
        System.out.println(ZoneOffset.ofHours(-5));//-05:00
        System.out.println(ZoneOffset.ofTotalSeconds(8 * 60 * 60));//+08:00 // 指定一个精确的秒数  获取实例（有时候也很有用处）
    }

    /**
     * 时区相关
     */
    @Test
    public void zoneId() {
        /*1、获取系统默认的ZoneId：*/
        // JDK 1.8之前做法
        System.out.println(TimeZone.getDefault());//sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=31,lastRule=null]
        // JDK 1.8之后做法
        System.out.println(ZoneId.systemDefault());//Asia/Shanghai

        /*2、指定字符串得到一个ZoneId：*/
        System.out.println(ZoneId.of("Asia/Shanghai"));//Asia/Shanghai
        System.out.println(ZoneId.of("+09:00"));//+09:00
        System.out.println(ZoneId.of("+8"));//+08:00
        System.out.println(ZoneId.of("+0"));//Z
        System.out.println(ZoneId.of("Z"));//Z
        System.out.println(ZoneId.of("UTC"));//UTC

        /*3、根据偏移量得到一个ZoneId：*/
        /*根据偏移量得到的ZoneId内部并无现成时区规则可用，因此对于有夏令营的国家转换可能出问题，一般不建议这么去做*/
        System.out.println(ZoneId.ofOffset("UTC", ZoneOffset.of("+8")));//UTC+08:00
        // 必须是大写的Z
        System.out.println(ZoneId.ofOffset("UTC", ZoneOffset.of("Z")));//UTC

        /*4、从日期里面获得时区：*/
        System.out.println(ZoneId.from(ZonedDateTime.now()));//Asia/Shanghai
        System.out.println(ZoneId.from(ZoneOffset.of("+8")));//+08:00

        //System.out.println(ZoneId.from(LocalDateTime.now()));//报错：java.time.DateTimeException: Unable to obtain ZoneId from TemporalAccessor:
        //System.out.println(ZoneId.from(LocalDate.now()));//报错：java.time.DateTimeException: Unable to obtain ZoneId from TemporalAccessor:
    }
}
