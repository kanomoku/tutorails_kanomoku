import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Build {
    public static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
    public static final ZonedDateTime ZONED_DATE_TIME = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
    public static final OffsetDateTime OFFSET_DATE_TIME = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));
    protected static final Date DATE = new Date(1562501898000L);

    @Test
    public void instantBuild() {
        System.out.println(Instant.now());
        System.out.println("----------");

        System.out.println(Instant.ofEpochMilli(1562501898000L));//2019-07-07T12:18:18Z
        System.out.println(Instant.ofEpochMilli(1562501898888L));//2019-07-07T12:18:18.888Z
        System.out.println(Instant.ofEpochSecond(1562501898));//2019-07-07T12:18:18Z
        System.out.println(Instant.ofEpochSecond(1562501898,888));//2019-07-07T12:18:18.000000888Z
        System.out.println("----------");
        System.out.println(ZONED_DATE_TIME.toInstant());//2019-07-07T11:18:18.000000888Z
        System.out.println(OFFSET_DATE_TIME.toInstant());//2019-07-07T11:18:18.000000888Z
        System.out.println(LOCAL_DATE_TIME.toInstant(ZoneOffset.ofHours(8)));//2019-07-07T12:18:18.000000888Z
        System.out.println(LOCAL_DATE_TIME.toInstant(ZoneOffset.UTC));//2019-07-07T20:18:18.000000888Z
        System.out.println("----------");
        System.out.println(DATE.toInstant());//2019-07-07T12:18:18Z
        System.out.println("----------");

        System.out.println(Instant.parse("2019-07-07T20:18:18.000000888Z"));//2019-07-07T20:18:18.000000888Z
        System.out.println(Instant.parse("2019-07-07T20:18:18Z"));//2019-07-07T20:18:18Z
        System.out.println("----------");
    }

    @Test
    public void dateBuild() throws ParseException {
        System.out.println(new Date(1562501898000L));//Sun Jul 07 20:18:18 CST 2019
        System.out.println(new Date());

        Date date1 = new Timestamp(1562501898000L);//2019-07-07 20:18:18.0
        System.out.println(date1);
        System.out.println(new Date(new Timestamp(1562501898000L).getTime()));//Sun Jul 07 20:18:18 CST 2019

        System.out.println(Calendar.getInstance().getTime());
        System.out.println("----------");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("格式化器用的时区是：" + dateFormat.getTimeZone().getID() + ":" + dateFormat.parse("2019-07-07 20:18:18"));
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.println("格式化器用的时区是：" + dateFormat.getTimeZone().getID() + ":" + dateFormat.parse("2019-07-07 20:18:18"));

        System.out.println(DateUtils.parseDate("2019-07-07 20:18:18 +0800","yyyy-MM-dd HH:mm:ss Z"));
        System.out.println(DateUtils.parseDate("2019-07-07 20:18:18.888","yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println(DateUtils.parseDate("2019-07-07 20:18:18","yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateUtils.parseDate("2019-07-07 20:18","yyyy-MM-dd HH:mm"));
        System.out.println(DateUtils.parseDate("2019/07/07 20:18:18 +0800","yyyy/MM/dd HH:mm:ss Z"));
        System.out.println(DateUtils.parseDate("2019/07/07 20:18:18.888","yyyy/MM/dd HH:mm:ss.SSS"));
        System.out.println(DateUtils.parseDate("2019/07/07 20:18:18","yyyy/MM/dd HH:mm:ss"));
        System.out.println(DateUtils.parseDate("2019/07/07 20:18","yyyy/MM/dd HH:mm"));
        System.out.println(DateUtils.parseDate("20190707201818 +0800","yyyyMMddHHmmss Z"));
        System.out.println(DateUtils.parseDate("20190707201818888","yyyyMMddHHmmsSSS"));
        System.out.println(DateUtils.parseDate("20190707201818","yyyyMMddHHmmss"));
        System.out.println(DateUtils.parseDate("201907072018","yyyyMMddHHmm"));
        System.out.println("----------");

        System.out.println(DateUtils.parseDate("2019-07-32 20:18:18 +0800","yyyy-MM-dd HH:mm:ss Z"));//Thu Aug 01 20:18:18 CST 2019
        System.out.println(DateUtils.parseDateStrictly("2019-07-07 20:18:18 +0800","yyyy-MM-dd HH:mm:ss Z"));
        System.out.println("----------");

        System.out.println(Date.from(Instant.ofEpochMilli(1562501898888L)));//Sun Jul 07 20:18:18 CST 2019
        System.out.println(Date.from(Instant.ofEpochSecond(1562501898,888)));//Sun Jul 07 20:18:18 CST 2019
        System.out.println(Date.from(Instant.ofEpochSecond(1562501898)));//Sun Jul 07 20:18:18 CST 2019
        System.out.println(Date.from(Instant.parse("2019-07-07T20:18:18.000000888Z")));//Mon Jul 08 04:18:18 CST 2019
        System.out.println(Date.from(Instant.parse("2019-07-07T20:18:18Z")));//Mon Jul 08 04:18:18 CST 2019
        System.out.println(Date.from(ZONED_DATE_TIME.toInstant()));//Sun Jul 07 19:18:18 CST 2019
        System.out.println(Date.from(OFFSET_DATE_TIME.toInstant()));//Sun Jul 07 19:18:18 CST 2019
        System.out.println(Date.from(LOCAL_DATE_TIME.toInstant(ZoneOffset.UTC)));//Mon Jul 08 04:18:18 CST 2019
        System.out.println(Date.from(LOCAL_DATE_TIME.toInstant(ZoneOffset.ofHours(8))));//Sun Jul 07 20:18:18 CST 2019
    }

    @Test
    public void timestampBuild() {
        System.out.println(new Timestamp(1562501898000L));//2019-07-07 20:18:18.0
        System.out.println(new Timestamp(new Date(1562501898000L).getTime()));//2019-07-07 20:18:18.0
        System.out.println("----------");

        System.out.println(Timestamp.from(Instant.ofEpochMilli(1562501898888L)));//2019-07-07 20:18:18.888
        System.out.println(Timestamp.from(Instant.ofEpochSecond(1562501898,888)));//2019-07-07 20:18:18.000000888
        System.out.println(Timestamp.from(Instant.ofEpochSecond(1562501898)));//2019-07-07 20:18:18.0
        System.out.println(Timestamp.from(Instant.parse("2019-07-07T20:18:18.000000888Z")));//2019-07-08 04:18:18.000000888
        System.out.println(Timestamp.from(Instant.parse("2019-07-07T20:18:18Z")));//2019-07-08 04:18:18.0
        System.out.println("----------");

        System.out.println(Timestamp.from(ZONED_DATE_TIME.toInstant()));//2019-07-07 19:18:18.000000888
        System.out.println(Timestamp.from(OFFSET_DATE_TIME.toInstant()));//2019-07-07 19:18:18.000000888
        System.out.println(Timestamp.from(LOCAL_DATE_TIME.toInstant(ZoneOffset.ofHours(8))));//2019-07-07 20:18:18.000000888
        System.out.println(Timestamp.from(LOCAL_DATE_TIME.toInstant(ZoneOffset.UTC)));//2019-07-08 04:18:18.000000888
        System.out.println("----------");

        System.out.println(Timestamp.valueOf(LOCAL_DATE_TIME));//2019-07-07 20:18:18.000000888
        System.out.println(ZONED_DATE_TIME);//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println(ZONED_DATE_TIME.toLocalDateTime());//2019-07-07T20:18:18.000000888
        System.out.println(Timestamp.valueOf(ZONED_DATE_TIME.toLocalDateTime()));//2019-07-07 20:18:18.000000888
    }

    @Test
    public void localDateBuild() {
        System.out.println(LocalDate.now());//2022-04-03

        System.out.println(LocalDate.of(2019, 7, 7));//2019-07-07
        System.out.println(LocalDate.of(2019, Month.JULY, 7));//2019-07-07

        System.out.println(LOCAL_DATE_TIME.toLocalDate());//2019-07-07
        System.out.println(OFFSET_DATE_TIME.toLocalDate());//2019-07-07
        System.out.println(ZONED_DATE_TIME.toLocalDate());//2019-07-07
    }

    @Test
    public void localTimeBuild() {
        System.out.println(LocalTime.now());//17:30:32.193733700

        System.out.println(LocalTime.of(20, 18));//20:18
        System.out.println(LocalTime.of(20, 18, 18));//20:18:18
        System.out.println(LocalTime.of(20, 18, 18, 888));//20:18:18.000000888

        System.out.println(LOCAL_DATE_TIME.toLocalTime());//20:18:18.000000888
        System.out.println(OFFSET_DATE_TIME.toLocalTime());//20:18:18.000000888
        System.out.println(ZONED_DATE_TIME.toLocalTime());//20:18:18.000000888
    }

    @Test
    public void localDateTimeBuild() {
        System.out.println(LocalDateTime.now());//2022-04-03T17:30:32.193733700
        System.out.println("----------1");

        System.out.println(LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888));//2019-07-07T20:18:18.000000888
        System.out.println(LocalDateTime.of(2019, 7, 7, 20, 18, 18));//2019-07-07T20:18:18
        System.out.println(LocalDateTime.of(2019, 7, 7, 20, 18));//2019-07-07T20:18
        System.out.println(LocalDateTime.of(2019, Month.JULY, 7, 20, 18, 18, 888));//2019-07-07T20:18:18.000000888
        System.out.println(LocalDateTime.of(2019, Month.JULY, 7, 20, 18, 18));//2019-07-07T20:18:18
        System.out.println(LocalDateTime.of(2019, Month.JULY, 7, 20, 18));//2019-07-07T20:18
        System.out.println(LocalDateTime.of(LocalDate.of(2019, 7, 7), LocalTime.of(20, 18,18,888)));//2019-07-07T20:18:18.000000888
        System.out.println(LocalDateTime.of(LocalDate.of(2019, 7, 7), LocalTime.of(20, 18,18)));//2019-07-07T20:18:18
        System.out.println(LocalDateTime.of(LocalDate.of(2019, 7, 7), LocalTime.of(20, 18)));//2019-07-07T20:18
        System.out.println("----------2");

        System.out.println(LocalDateTime.ofEpochSecond(1562501898,888888888, ZoneOffset.UTC));//2019-07-07T12:18:18.888888888
        System.out.println(LocalDateTime.ofEpochSecond(1562501898,888888888, ZoneOffset.ofHours(8)));//2019-07-07T20:18:18.888888888
        System.out.println(LocalDateTime.ofInstant(Instant.parse("2019-07-07T20:18:18.000000888Z"), ZoneId.of("UTC")));//2019-07-07T20:18:18.000000888
        System.out.println(LocalDateTime.ofInstant(Instant.parse("2019-07-07T20:18:18.000000888Z"), ZoneId.of("+08:00")));//2019-07-08T04:18:18.000000888

        System.out.println(DATE.toInstant().atZone(ZoneId.of("+09:00")).toLocalDateTime());//2019-07-07T21:18:18
        System.out.println(OFFSET_DATE_TIME.toLocalDateTime());//2019-07-07T20:18:18.000000888
        System.out.println(ZONED_DATE_TIME.toLocalDateTime());//2019-07-07T20:18:18.000000888
        System.out.println("----------3");

        System.out.println(LocalDateTime.parse("2022-04-03T18:00"));//2022-04-03T18:00

        DateTimeFormatter df = DateTimeFormatter.ofPattern("第Q季度 yyyy-MM-dd HH:mm:ss", Locale.JAPAN);
        System.out.println(LocalDateTime.parse("第3季度 2019-07-07 20:18:18",df));//2019-07-07T20:18:18
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("第Q季度 yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        System.out.println(LocalDateTime.parse("第3季度 2019-07-07 20:18:18",df1));//2019-07-07T20:18:18

        System.out.println(LocalDateTime.parse("2019-07-07T20:18:18.000000888"));//2019-07-07T20:18:18.000000888
        System.out.println(LocalDateTime.parse("2019-07-07T20:18:18"));//2019-07-07T20:18:18
        System.out.println(LocalDateTime.parse("2019-07-07T20:18"));//2019-07-07T20:18
    }

    @Test
    public void offsetDateTimeBuild() {
        System.out.println(OffsetDateTime.now());// 使用系统时区 2022-04-03T17:30:32.209357700+08:00
        System.out.println(OffsetDateTime.now(ZoneId.of("Asia/Tokyo")));//自己指定时区 2022-04-03T18:30:32.209357700+09:00
        System.out.println(OffsetDateTime.now(Clock.systemUTC()));//自己指定时区 2022-04-03T09:30:32.209357700Z
        System.out.println("----------1");

        System.out.println(OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9)));//2019-07-07T20:18:18.000000888+09:00
        System.out.println(OffsetDateTime.of(LocalDate.of(2019, 7, 7),LocalTime.of(20, 18, 18, 888),ZoneOffset.ofHours(9)));//2019-07-07T20:18:18.000000888+09:00
        System.out.println(OffsetDateTime.of(LOCAL_DATE_TIME,ZoneOffset.ofHours(9)));//2019-07-07T20:18:18.000000888+09:00
        System.out.println(OffsetDateTime.ofInstant(LOCAL_DATE_TIME.toInstant(ZoneOffset.ofHours(9)), ZoneOffset.ofHours(9)));//2019-07-07T20:18:18.000000888+09:00
        System.out.println("----------2");

        System.out.println(LOCAL_DATE_TIME.atOffset(ZoneOffset.ofHours(9)));//2019-07-07T20:18:18.000000888+09:00
        System.out.println(ZONED_DATE_TIME.toOffsetDateTime());//2019-07-07T20:18:18.000000888+09:00

        System.out.println(OffsetDateTime.parse("2019-07-07T20:18:18.000000888+09:00"));//2019-07-07T20:18:18.000000888+09:00
        System.out.println(OffsetDateTime.parse("2019-07-07T20:18:18+09:00"));//2019-07-07T20:18:18+09:00
        System.out.println(OffsetDateTime.parse("2019-07-07T20:18+09:00"));//2019-07-07T20:18+09:00
    }

    @Test
    public void zonedDateTimeBuild() {
        System.out.println(ZonedDateTime.now());//使用系统时区 2022-04-03T17:30:32.193733700+08:00[Asia/Shanghai]
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));//自己指定时区 2022-04-03T18:30:32.193733700+09:00[Asia/Tokyo]
        System.out.println(ZonedDateTime.now(Clock.systemUTC()));//自己指定时区 2022-04-03T09:30:32.193733700Z
        System.out.println("----------2");

        System.out.println(ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo")));//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println(ZonedDateTime.of(LocalDate.of(2019, 7, 7),LocalTime.of(20, 18, 18, 888),ZoneId.of("Asia/Tokyo")));//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println(ZonedDateTime.of(LOCAL_DATE_TIME, ZoneId.of("Asia/Tokyo")));//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println("--------3");

        System.out.println(ZonedDateTime.ofInstant(LOCAL_DATE_TIME.toInstant(ZoneOffset.ofHours(9)), ZoneOffset.ofHours(9)));//2019-07-07T20:18:18.000000888+09:00
        System.out.println(ZonedDateTime.ofInstant(LOCAL_DATE_TIME.toInstant(ZoneOffset.ofHours(9)), ZoneId.of("Asia/Tokyo")));//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println(ZonedDateTime.ofInstant(LOCAL_DATE_TIME.toInstant(ZoneOffset.ofHours(9)), ZoneId.of("Asia/Shanghai")));//2019-07-07T19:18:18.000000888+08:00[Asia/Shanghai]
        System.out.println(ZonedDateTime.ofInstant(LOCAL_DATE_TIME, ZoneOffset.ofHours(9), ZoneOffset.ofHours(9)));//2019-07-07T20:18:18.000000888+09:00
        System.out.println(ZonedDateTime.ofInstant(LOCAL_DATE_TIME, ZoneOffset.UTC, ZoneOffset.ofHours(9)));//2019-07-08T05:18:18.000000888+09:00
        System.out.println("--------4");

        System.out.println(OFFSET_DATE_TIME.toZonedDateTime());//2019-07-07T20:18:18.000000888+09:00
        System.out.println(OFFSET_DATE_TIME.atZoneSameInstant(ZoneId.of("Asia/Tokyo")));//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println(OFFSET_DATE_TIME.atZoneSameInstant(ZoneId.of("Asia/Shanghai")));//以确保结果具有相同的Instant 2019-07-07T19:18:18.000000888+08:00[Asia/Shanghai]
        System.out.println(OFFSET_DATE_TIME.atZoneSimilarLocal(ZoneId.of("Asia/Tokyo")));//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println(OFFSET_DATE_TIME.atZoneSimilarLocal(ZoneId.of("Asia/Shanghai")));//以确保结果具有相同的本地时间 2019-07-07T20:18:18.000000888+08:00[Asia/Shanghai]
        System.out.println("--------5");

        System.out.println(LOCAL_DATE_TIME.atZone(ZoneId.of("Asia/Tokyo")));//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println(DATE.toInstant().atZone(ZonedDateTime.now().getZone()));//2019-07-07T20:18:18+08:00[Asia/Shanghai]
        System.out.println(DATE.toInstant().atZone(ZonedDateTime.now().getOffset()));//2019-07-07T20:18:18+08:00
        System.out.println("----------6");

        System.out.println(ZonedDateTime.parse("2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]"));//2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]
        System.out.println(ZonedDateTime.parse("2019-07-07T20:18:18+09:00[Asia/Tokyo]"));//2019-07-07T20:18:18+09:00[Asia/Tokyo]
        System.out.println(ZonedDateTime.parse("2019-07-07T20:18+09:00[Asia/Tokyo]"));//2019-07-07T20:18+09:00[Asia/Tokyo]

        System.out.println(ZonedDateTime.parse("Sun Oct 01 00:00:00 EDT 2017",DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy").withLocale(Locale.US)));
        System.out.println(ZonedDateTime.parse("Sun Oct 01 00:00:00 EDT 2017 GMT+0800",DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy 'GMT'Z").withLocale(Locale.US)));
    }
}
