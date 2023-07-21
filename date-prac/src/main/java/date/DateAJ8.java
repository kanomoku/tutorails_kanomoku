package date;

import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Administrator
 */
public class DateAJ8 {
    public static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);
    public static final ZonedDateTime ZONED_DATE_TIME = ZonedDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneId.of("Asia/Tokyo"));
    public static final OffsetDateTime OFFSET_DATE_TIME = OffsetDateTime.of(2019, 7, 7, 20, 18, 18, 888, ZoneOffset.ofHours(9));
    protected static final Date DATE = new Date(1562501898000L);

    @Test
    public void dateYearMonthDay() {
        System.out.println("-------LocalDateTime-------");
        Assert.assertEquals(2019, LOCAL_DATE_TIME.getYear());
        Assert.assertEquals(Month.JULY, LOCAL_DATE_TIME.getMonth());
        Assert.assertEquals(7, LOCAL_DATE_TIME.getMonthValue());
        Assert.assertEquals(DayOfWeek.SUNDAY, LOCAL_DATE_TIME.getDayOfWeek());
        Assert.assertEquals(7, LOCAL_DATE_TIME.getDayOfMonth());
        Assert.assertEquals(188, LOCAL_DATE_TIME.getDayOfYear());
        Assert.assertEquals(20, LOCAL_DATE_TIME.getHour());
        Assert.assertEquals(18, LOCAL_DATE_TIME.getMinute());
        Assert.assertEquals(18, LOCAL_DATE_TIME.getSecond());
        Assert.assertEquals(888, LOCAL_DATE_TIME.getNano());
        // 当前localDateTime视为东8区的时间、去获取时间戳
        Assert.assertEquals(1562501898L, LOCAL_DATE_TIME.toEpochSecond(ZoneOffset.ofHours(8)));
        // 当前localDateTime视为0时区的时间、去获取时间戳
        Assert.assertEquals(1562530698L, LOCAL_DATE_TIME.toEpochSecond(ZoneOffset.ofHours(0)));
        Assert.assertEquals(1562501898000L, LOCAL_DATE_TIME.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());

        System.out.println("-------ZonedDateTime-------");
        Assert.assertEquals(2019, ZONED_DATE_TIME.getYear());
        Assert.assertEquals(Month.JULY, ZONED_DATE_TIME.getMonth());
        Assert.assertEquals(7, ZONED_DATE_TIME.getMonthValue());
        Assert.assertEquals(DayOfWeek.SUNDAY, ZONED_DATE_TIME.getDayOfWeek());
        Assert.assertEquals(7, ZONED_DATE_TIME.getDayOfMonth());
        Assert.assertEquals(188, ZONED_DATE_TIME.getDayOfYear());
        Assert.assertEquals(20, ZONED_DATE_TIME.getHour());
        Assert.assertEquals(18, ZONED_DATE_TIME.getMinute());
        Assert.assertEquals(18, ZONED_DATE_TIME.getSecond());
        Assert.assertEquals(888, ZONED_DATE_TIME.getNano());
        Assert.assertEquals(1562498298L, ZONED_DATE_TIME.toEpochSecond());
        Assert.assertEquals(1562498298000L, ZONED_DATE_TIME.toInstant().toEpochMilli());

        System.out.println("-------OffsetDateTime-------");
        Assert.assertEquals(2019, OFFSET_DATE_TIME.getYear());
        Assert.assertEquals(Month.JULY, OFFSET_DATE_TIME.getMonth());
        Assert.assertEquals(7, OFFSET_DATE_TIME.getMonthValue());
        Assert.assertEquals(DayOfWeek.SUNDAY, OFFSET_DATE_TIME.getDayOfWeek());
        Assert.assertEquals(7, OFFSET_DATE_TIME.getDayOfMonth());
        Assert.assertEquals(188, OFFSET_DATE_TIME.getDayOfYear());
        Assert.assertEquals(20, OFFSET_DATE_TIME.getHour());
        Assert.assertEquals(18, OFFSET_DATE_TIME.getMinute());
        Assert.assertEquals(18, OFFSET_DATE_TIME.getSecond());
        Assert.assertEquals(888, OFFSET_DATE_TIME.getNano());
        Assert.assertEquals(1562498298, OFFSET_DATE_TIME.toEpochSecond());
        Assert.assertEquals(1562498298000L, OFFSET_DATE_TIME.toInstant().toEpochMilli());
    }

    @Test
    public void dateNow() {
        System.out.println(LocalDateTime.MIN);
        System.out.println(LocalDateTime.MAX);
        //System.out.println(ZonedDateTime.MIN);不存在
        //System.out.println(ZonedDateTime.MAX);不存在
        System.out.println(OffsetDateTime.MIN);
        System.out.println(OffsetDateTime.MAX);
    }

    @Test
    public void zoneOffset() {
        /*1、最小/最大偏移量：因为偏移量传入的是数字，这个是有限制*/
        System.out.println("最小偏移量：" + ZoneOffset.MIN);//-18:00
        System.out.println("最小偏移量：" + ZoneOffset.MAX);//+18:00
        System.out.println("中心偏移量：" + ZoneOffset.UTC);//Z

        System.out.println(OffsetDateTime.now().getOffset());
        System.out.println(ZonedDateTime.now().getOffset());

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
        Assert.assertEquals("Asia/Shanghai",TimeZone.getDefault().getID());
        Assert.assertEquals("GMT+08:00",TimeZone.getTimeZone("GMT+08:00").getID());
        Assert.assertEquals("GMT-05:00",TimeZone.getTimeZone("GMT-05:00").getID());

        // JDK 1.8之后做法
        Assert.assertEquals("Asia/Shanghai",ZoneId.systemDefault().getId());
        Assert.assertEquals("Asia/Shanghai",ZonedDateTime.now().getZone().getId());

        /*2、指定字符串得到一个ZoneId：*/
        Assert.assertEquals("Asia/Shanghai",ZoneId.of("Asia/Shanghai").getId());
        Assert.assertEquals("+09:00",ZoneId.of("+09:00").getId());
        Assert.assertEquals("+08:00",ZoneId.of("+8").getId());
        Assert.assertEquals("Z",ZoneId.of("+0").getId());
        Assert.assertEquals("Z",ZoneId.of("Z").getId());
        Assert.assertEquals("UTC",ZoneId.of("UTC").getId());

        /*3、根据偏移量得到一个ZoneId：*/
        /*根据偏移量得到的ZoneId内部并无现成时区规则可用，因此对于有夏令营的国家转换可能出问题，一般不建议这么去做*/
        Assert.assertEquals("UTC+08:00",ZoneId.ofOffset("UTC", ZoneOffset.of("+8")).getId());
        // 必须是大写的Z
        Assert.assertEquals("UTC",ZoneId.ofOffset("UTC", ZoneOffset.of("Z")).getId());

        /*4、从日期里面获得时区：*/
        Assert.assertEquals("Asia/Shanghai",ZoneId.from(ZonedDateTime.now()).getId());
        Assert.assertEquals("+08:00",ZoneId.from(ZoneOffset.of("+8")).getId());

        //System.out.println(ZoneId.from(LocalDateTime.now()));//报错：java.time.DateTimeException: Unable to obtain ZoneId from TemporalAccessor:
        //System.out.println(ZoneId.from(LocalDate.now()));//报错：java.time.DateTimeException: Unable to obtain ZoneId from TemporalAccessor:
    }

    @Test
    public void dateCalculate() {
        LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2019, 7, 7, 20, 18, 18, 888);

        System.out.println(LOCAL_DATE_TIME);
        System.out.println(LOCAL_DATE_TIME.plusDays(3));
        System.out.println(LOCAL_DATE_TIME.plusHours(-3));
        System.out.println(LOCAL_DATE_TIME.minusMinutes(3));
        System.out.println(LOCAL_DATE_TIME.plus(1, ChronoUnit.WEEKS));
        System.out.println(LOCAL_DATE_TIME.minus(1, ChronoUnit.YEARS));

        LocalDateTime after = LOCAL_DATE_TIME.plusDays(3);
        after = after.plusHours(-3);
        // 计算时间差
        Period period = Period.between(LOCAL_DATE_TIME.toLocalDate(), after.toLocalDate());
        System.out.println("相差天数：" + period.getDays());
        Duration duration = Duration.between(LOCAL_DATE_TIME.toLocalTime(), after.toLocalTime());
        System.out.println("相差小时数：" + duration.toHours());
    }

    @Test
    public void instantMethod() {
        System.out.println(Instant.MIN);//-1000000000-01-01T00:00:00Z
        System.out.println(Instant.MAX);//+1000000000-12-31T23:59:59.999999999Z
        System.out.println(Instant.EPOCH);//1970-01-01T00:00:00Z
        System.out.println(Instant.parse("2019-07-07T20:18:18.000000888Z").toString());//2019-07-07T20:18:18.000000888Z
        System.out.println(Instant.parse("2019-07-07T20:18:18.000000888Z").getEpochSecond());//1562530698
        System.out.println(Instant.parse("2019-07-07T20:18:18.000000888Z").toEpochMilli());//1562530698000
        System.out.println(Instant.parse("2019-07-07T20:18:18.000000888Z").getNano());//888
    }
}
