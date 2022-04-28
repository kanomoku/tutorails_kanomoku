import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class MyDateUtils {

    @Test public void convertDateFromZeroTimeZoneToCurrentTimeZone() {
        Date date = new Date();
        System.out.println(date);

        // Date -> LocalDateTime、OffsetDateTime、ZonedDateTime
        LocalDateTime localDateTime = date.toInstant().atZone(ZonedDateTime.now().getZone()).toLocalDateTime();
        // LocalDateTime localDateTime2 = date.toInstant().atOffset(ZoneOffset.ofHours(8)).toLocalDateTime();
        LocalDateTime localDateTime2 = date.toInstant().atOffset(ZonedDateTime.now().getOffset()).toLocalDateTime();
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println("------------------------------");

        // localDateTime -> ZonedDateTime/OffsetDateTime 来随意切换时区
        ZonedDateTime zonedDateTime =
            ZonedDateTime.ofInstant(localDateTime.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        OffsetDateTime offsetDateTime =
            OffsetDateTime.ofInstant(localDateTime.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        System.out.println(zonedDateTime);
        System.out.println(offsetDateTime);
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime));
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime));
        System.out.println("------------------------------");

        System.out.println(Date.from(zonedDateTime.toLocalDateTime().toInstant(ZoneOffset.ofHours(8))));
        System.out.println(Date.from(offsetDateTime.toLocalDateTime().toInstant(ZoneOffset.ofHours(8))));
    }

    @Test public void convertDateFromCurrentTimeZoneToZeroTimeZone() {
        Date date = new Date();
        System.out.println(date);

        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println(new Date(timestamp.getTime()));

        // LocalDateTime、OffsetDateTime、ZonedDateTime -> Date
        System.out.println(Date.from(localDateTime.toInstant(ZonedDateTime.now().getOffset())));
        System.out.println(Date.from(localDateTime.toInstant(ZoneOffset.UTC)));
    }

    public void checkDateOrder(String beginDateStr, String endDateStr, Date beginDateExist, Date endDateExist,
        Map<String, Object> updateParam) throws ParseException {
        // 如果开始日、终了日都不更新、还校验个屁
        if (!updateParam.containsKey("beginDateStr") && !updateParam.containsKey("endDateStr")) {
            return;
        }
        // 如果开始日、终了日都更新
        if (updateParam.containsKey("beginDateStr") && updateParam.containsKey("endDateStr")) {
            // 都更新包括如下四种、此时为第一种
            // beginDateStr:具体日期 、endDateStr:具体日期
            // beginDateStr:null   、endDateStr:具体日期
            // beginDateStr:具体日期 、endDateStr:null
            // beginDateStr:null   、endDateStr:null
            if (StringUtils.isNotBlank("beginDateStr") && StringUtils.isNotBlank("beginDateStr")) {
                Date beginDateNew = DateUtils.parseDateStrictly(beginDateStr, "YYYY-MM-DD");
                Date endDateNew = DateUtils.parseDateStrictly(endDateStr, "YYYY-MM-DD");
                if (!beginDateNew.before(endDateNew)) {
                    new Exception("開始日必須小於終了日、等於也不可以");
                }
            }
        }
        // 更新日期有3种场景
        // 两个都不更新
        // 两个都要更新
        // 一个更新、另一个不更新

        // 如上已经分析两种场景、此处为第三种场景
        // 如果只更新开始日、如果有值进入判断、如果为null不需要进入判断
        if (updateParam.containsKey("beginDateStr") && StringUtils.isNotBlank("beginDateStr")) {
            Date beginDateNew = DateUtils.parseDateStrictly(beginDateStr, "YYYY-MM-DD");
            // 如果系统有终了日、要保证开始日小于终了日
            if (Objects.nonNull(endDateExist) && !beginDateNew.before(endDateExist)) {
                new Exception("開始日必須小於終了日、等於也不可以");
            }
        }
        // 如果只更新终了日、如果有值进入判断、如果为null不需要进入判断
        if (updateParam.containsKey("endDateStr") && StringUtils.isNotBlank("endDateStr")) {
            Date endDateNew = DateUtils.parseDateStrictly(endDateStr, "YYYY-MM-DD");
            // 如果系统有开始日、要保证开始日小于终了日
            if (Objects.nonNull(beginDateExist) && !beginDateExist.before(endDateNew)) {
                new Exception("開始日必須小於終了日、等於也不可以");
            }
        }
    }
}
