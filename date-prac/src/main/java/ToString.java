import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ToString {
    public static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
    public static final ZonedDateTime ZONED_DATE_TIME = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
    public static final OffsetDateTime OFFSET_DATE_TIME = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));
    protected static final Date DATE = new Date(1562501898888L);

    @Test public void timestampToString() {
        Timestamp timestamp = new Timestamp(156250189888L);
        System.out.println(timestamp.toString());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(timestamp));
    }

    @Test public void dateToString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("这是北京时间：" + df.format(DATE));
        df.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.println("这是东京时间：" + df.format(DATE));
    }

    @Test
    public void ISO_DATE_TIME() {
        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]", ZONED_DATE_TIME.format(DateTimeFormatter.ISO_DATE_TIME));
        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00", OFFSET_DATE_TIME.format(DateTimeFormatter.ISO_DATE_TIME));
        Assert.assertEquals("2019-07-07T20:18:18.000000888", LOCAL_DATE_TIME.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    @Test
    public void ISO_DATE() {
        Assert.assertEquals("2019-07-07+09:00", ZONED_DATE_TIME.format(DateTimeFormatter.ISO_DATE));
        Assert.assertEquals("2019-07-07+09:00", OFFSET_DATE_TIME.format(DateTimeFormatter.ISO_DATE));
        Assert.assertEquals("2019-07-07", LOCAL_DATE_TIME.format(DateTimeFormatter.ISO_DATE));
    }

    @Test
    public void ISO_TIME() {
        Assert.assertEquals("20:18:18.000000888+09:00", ZONED_DATE_TIME.format(DateTimeFormatter.ISO_TIME));
        Assert.assertEquals("20:18:18.000000888+09:00", OFFSET_DATE_TIME.format(DateTimeFormatter.ISO_TIME));
        Assert.assertEquals("20:18:18.000000888", LOCAL_DATE_TIME.format(DateTimeFormatter.ISO_TIME));
    }

    @Test
    public void ISO_LOCAL_DATE_TIME() {
        Assert.assertEquals("2019-07-07T20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ZONED_DATE_TIME));
        Assert.assertEquals("2019-07-07T20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019-07-07T20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LOCAL_DATE_TIME));
    }

    @Test
    public void ISO_LOCAL_DATE() {
        Assert.assertEquals("2019-07-07", DateTimeFormatter.ISO_LOCAL_DATE.format(ZONED_DATE_TIME));
        Assert.assertEquals("2019-07-07", DateTimeFormatter.ISO_LOCAL_DATE.format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019-07-07", DateTimeFormatter.ISO_LOCAL_DATE.format(LOCAL_DATE_TIME));
    }

    @Test
    public void ISO_LOCAL_TIME() {
        Assert.assertEquals("20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_TIME.format(ZONED_DATE_TIME));
        Assert.assertEquals("20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_TIME.format(OFFSET_DATE_TIME));
        Assert.assertEquals("20:18:18.000000888", DateTimeFormatter.ISO_LOCAL_TIME.format(LOCAL_DATE_TIME));
    }

    @Test
    public void ISO_OFFSET_DATE_TIME() {
        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00",DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZONED_DATE_TIME));
        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00",DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OFFSET_DATE_TIME));
        //DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(LOCAL_DATE_TIME);//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:
    }

    @Test
    public void ISO_OFFSET_DATE() {
        Assert.assertEquals("2019-07-07+09:00",DateTimeFormatter.ISO_OFFSET_DATE.format(ZONED_DATE_TIME));
        Assert.assertEquals("2019-07-07+09:00",DateTimeFormatter.ISO_OFFSET_DATE.format(OFFSET_DATE_TIME));
        //DateTimeFormatter.ISO_OFFSET_DATE.format(LOCAL_DATE_TIME);//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:
    }

    @Test
    public void ISO_OFFSET_TIME() {
        Assert.assertEquals("20:18:18.000000888+09:00",DateTimeFormatter.ISO_OFFSET_TIME.format(ZONED_DATE_TIME));
        Assert.assertEquals("20:18:18.000000888+09:00",DateTimeFormatter.ISO_OFFSET_TIME.format(OFFSET_DATE_TIME));
        //DateTimeFormatter.ISO_OFFSET_TIME.format(LOCAL_DATE_TIME);//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:
    }

    @Test
    public void ISO_ZONED_DATE_TIME() {
        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00[Asia/Tokyo]", DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ZONED_DATE_TIME));
        Assert.assertEquals("2019-07-07T20:18:18.000000888+09:00", DateTimeFormatter.ISO_ZONED_DATE_TIME.format(OFFSET_DATE_TIME));
        //DateTimeFormatter.ISO_ZONED_DATE_TIME.format(LOCAL_DATE_TIME);//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:

        //DateTimeFormatter.ISO_ZONED_DATE.format(ZonedDateTime.now());// 不存在ISO_ZONED_DATE
        //DateTimeFormatter.ISO_ZONED_TIME.format(ZonedDateTime.now());// 不存在ISO_ZONED_TIME
    }

    @Test
    public void ISO_INSTANT() {
        Assert.assertEquals("2019-07-07T11:18:18.000000888Z", ZONED_DATE_TIME.format(DateTimeFormatter.ISO_INSTANT));
        Assert.assertEquals("2019-07-07T11:18:18.000000888Z", OFFSET_DATE_TIME.format(DateTimeFormatter.ISO_INSTANT));
        //LOCAL_DATE_TIME.format(DateTimeFormatter.ISO_INSTANT);//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field:
    }

    @Test
    public void ISO_ORDINAL_DATE() {
        Assert.assertEquals("2019-188+09:00", ZONED_DATE_TIME.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        Assert.assertEquals("2019-188+09:00", OFFSET_DATE_TIME.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        Assert.assertEquals("2019-188", LOCAL_DATE_TIME.format(DateTimeFormatter.ISO_ORDINAL_DATE));
    }

    @Test
    public void ISO_WEEK_DATE() {
        Assert.assertEquals("2019-W27-7+09:00",ZONED_DATE_TIME.format(DateTimeFormatter.ISO_WEEK_DATE));
        Assert.assertEquals("2019-W27-7+09:00",OFFSET_DATE_TIME.format(DateTimeFormatter.ISO_WEEK_DATE));
        Assert.assertEquals("2019-W27-7",LOCAL_DATE_TIME.format(DateTimeFormatter.ISO_WEEK_DATE));
    }

    @Test
    public void ofLocalizedDateTime() {
        Assert.assertEquals("2019年7月7日星期日 日本标准时间 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.of("Asia/Tokyo")).format(LOCAL_DATE_TIME));
        Assert.assertEquals("2019年7月7日 JST 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of("Asia/Tokyo")).format(LOCAL_DATE_TIME));
        Assert.assertEquals("2019年7月7日 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withZone(ZoneId.of("Asia/Tokyo")).format(LOCAL_DATE_TIME));
        Assert.assertEquals("2019/7/7 下午8:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.of("Asia/Tokyo")).format(LOCAL_DATE_TIME));
        Assert.assertEquals("2019年7月7日星期日",DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LOCAL_DATE_TIME));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(LOCAL_DATE_TIME));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(LOCAL_DATE_TIME));
        Assert.assertEquals("2019/7/7",DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(LOCAL_DATE_TIME));

        Assert.assertEquals("2019年7月7日星期日 日本标准时间 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.of("Asia/Tokyo")).format(ZONED_DATE_TIME));
        Assert.assertEquals("2019年7月7日 JST 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of("Asia/Tokyo")).format(ZONED_DATE_TIME));
        Assert.assertEquals("2019年7月7日 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withZone(ZoneId.of("Asia/Tokyo")).format(ZONED_DATE_TIME));
        Assert.assertEquals("2019/7/7 下午8:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.of("Asia/Tokyo")).format(ZONED_DATE_TIME));
        Assert.assertEquals("2019年7月7日星期日",DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(ZONED_DATE_TIME));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(ZONED_DATE_TIME));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(ZONED_DATE_TIME));
        Assert.assertEquals("2019/7/7",DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(ZONED_DATE_TIME));

        Assert.assertEquals("2019年7月7日星期日 日本标准时间 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.of("Asia/Tokyo")).format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019年7月7日 JST 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of("Asia/Tokyo")).format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019年7月7日 下午8:18:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withZone(ZoneId.of("Asia/Tokyo")).format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019/7/7 下午8:18",DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.of("Asia/Tokyo")).format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019年7月7日星期日",DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019年7月7日",DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(OFFSET_DATE_TIME));
        Assert.assertEquals("2019/7/7",DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(OFFSET_DATE_TIME));
    }

    @Test
    public void dateToCustomString() {
        LocalDateTime localDateTimeExcept = LocalDateTime.of(2019, 7, 7, 20, 18, 18);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("第Q季度 yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter1.format(LOCAL_DATE_TIME));
        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter1.format(ZONED_DATE_TIME));
        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter1.format(OFFSET_DATE_TIME));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("第Q季度 yyyy-MM-dd HH:mm:ss", Locale.JAPAN);
        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter.format(LOCAL_DATE_TIME));
        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter.format(ZONED_DATE_TIME));
        Assert.assertEquals("第3季度 2019-07-07 20:18:18",formatter.format(OFFSET_DATE_TIME));


        Assert.assertEquals(localDateTimeExcept,LocalDateTime.parse("第3季度 2019-07-07 20:18:18", formatter));
        Assert.assertEquals(localDateTimeExcept,LocalDateTime.parse("第3季度 2019-07-07 20:18:18", formatter1));
        //Assert.assertEquals(localDateTime1,ZonedDateTime.parse("第3季度 2019-07-07 20:18:18", formatter));java.time.format.DateTimeParseException
        //Assert.assertEquals(localDateTime1,ZonedDateTime.parse("第3季度 2019-07-07 20:18:18", formatter1));java.time.format.DateTimeParseException
        //Assert.assertEquals(localDateTime1,OffsetDateTime.parse("第3季度 2019-07-07 20:18:18", formatter));java.time.format.DateTimeParseException
        //Assert.assertEquals(localDateTime1,OffsetDateTime.parse("第3季度 2019-07-07 20:18:18", formatter1));java.time.format.DateTimeParseException
    }
}
