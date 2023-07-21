package date;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class MyDateUtil {

    /**
     * 当前时区时间 → 目标时区时间
     */
    public static Date dateFromCurrentToTargetZone(Date date, ZoneId targetZoneId) {
        // 获取对应时区的ZonedDateTime
        ZonedDateTime zonedDateTime = date.toInstant().atZone(targetZoneId);

        // 这一步就是式转换: ZonedDateTime → Date
        return Date.from(zonedDateTime.toLocalDateTime().toInstant(ZonedDateTime.now().getOffset()));
    }

    /**
     * 当前时区时间 → 目标时区时间
     */
    public static Date dateFromCurrentToTargetZone2(Date date, ZoneId targetZoneId) {
        LocalDateTime localDateTime = date.toInstant().atZone(targetZoneId).toLocalDateTime();
        return new Date(Timestamp.valueOf(localDateTime).getTime());
    }

    /**
     * 目标时区时间 → 当前时区时间
     */
    public static Date dateFromTargetToCurrentZone(Date date, ZoneId targetZoneId) {
        // 这一步就是式转换: Date → ZonedDateTime
        ZonedDateTime targetZonedDateTime = date.toInstant().atZone(ZonedDateTime.now().getZone());

        // 目标时区ZonedDateTime → 当前时区ZonedDateTime
        ZonedDateTime currentZonedDateTime = ZonedDateTime.ofInstant(targetZonedDateTime.toLocalDateTime().toInstant((ZoneOffset) targetZoneId), ZoneId.systemDefault());

        // 这一步就是式转换: ZonedDateTime → Date
        return Date.from(currentZonedDateTime.toLocalDateTime().toInstant(ZonedDateTime.now().getOffset()));
    }

    /**
     * 目标时区时间 → 当前时区时间
     */
    public static Date dateFromTargetToCurrentZone2(Date date, ZoneId targetZoneId) {
        // 为了获取没有时区的时间
        LocalDateTime localDateTime = date.toInstant().atZone(ZonedDateTime.now().getZone()).toLocalDateTime();
        // localDateTime视为targetZone的localDateTime → 前时区时间
        return Date.from(localDateTime.toInstant((ZoneOffset) targetZoneId));
    }

    /**
     * source时区时间 → target时区时间
     */
    public static Date dateFromSourceToTargetZone(Date date, ZoneId sourceZoneId, ZoneId targetZoneId) {
        // 为了获取没有时区的时间
        LocalDateTime localDateTime = date.toInstant().atZone(ZonedDateTime.now().getZone()).toLocalDateTime();

        // source时区ZonedDateTime → target时区ZonedDateTime
        ZonedDateTime targetZonedDateTime = ZonedDateTime.ofInstant(localDateTime.toInstant((ZoneOffset) sourceZoneId), targetZoneId);

        // 这一步就是式转换: ZonedDateTime → Date
        return Date.from(targetZonedDateTime.toLocalDateTime().toInstant(ZonedDateTime.now().getOffset()));
    }
}
