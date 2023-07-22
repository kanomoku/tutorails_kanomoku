package date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;

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

    /**
     * 更新开始日截止日时，输入日期合理性校验
     * @param requestParams 输入参数
     * @param existingStart 系统既存开始时间
     * @param existingEnd   系统既存结束时间
     */
    public static String checkDateOrder(Map<String, String> requestParams, Date existingStart, Date existingEnd) throws ParseException {
        // 更新日期有3种场景
        // 第一种：两个都不更新
        // 第二种：两个都要更新
        // 第三种：仅更新一个

        String INPUT_START = "inputStart";
        String INPUT_END = "inputEnd";

        // 第一种：两个都不更新
        if (!requestParams.containsKey(INPUT_START) && !requestParams.containsKey(INPUT_END)) {
            // 如果开始日、终了日都不更新、无需校验
            return "输入为空无需校验";
        }

        String inputStart = requestParams.getOrDefault(INPUT_START, EMPTY);
        String inputEnd = requestParams.getOrDefault(INPUT_END, EMPTY);

        // 第二种：两个都要更新
        if (requestParams.containsKey(INPUT_START) && requestParams.containsKey(INPUT_END)) {
            // 都更新包括如下四种
            // inputStart:具体日期 、inputEnd:具体日期
            // inputStart:""   、inputEnd:具体日期
            // inputStart:具体日期 、inputEnd:""
            // inputStart:""   、inputEnd:""
            if (StringUtils.isNotBlank(inputStart) && StringUtils.isNotBlank(inputEnd)) {
                Date beginDateNew = DateUtils.parseDateStrictly(inputStart, "yyyy-MM-dd");
                Date endDateNew = DateUtils.parseDateStrictly(inputEnd, "yyyy-MM-dd");
                if (!beginDateNew.before(endDateNew)) {
                    return "输入开始日需要小于输入终了日";
                }
            }
            return "校验成功";
        }

        // 第三种：仅更新一个
        // 如果只更新开始日、如果有值进入判断、如果为空不需要进入判断
        if (requestParams.containsKey(INPUT_START) && StringUtils.isNotBlank(inputStart)) {
            Date beginDateNew = DateUtils.parseDateStrictly(inputStart, "yyyy-MM-dd");
            // 如果系统有终了日、要保证开始日小于终了日
            if (Objects.nonNull(existingEnd) && !beginDateNew.before(existingEnd)) {
                return "输入开始日需要小于既存终了日";
            }
        }

        // 如果只更新终了日、如果有值进入判断、如果为空不需要进入判断
        if (requestParams.containsKey(INPUT_END) && StringUtils.isNotBlank(INPUT_END)) {
            Date endDateNew = DateUtils.parseDateStrictly(inputEnd, "yyyy-MM-dd");
            // 如果系统有开始日、要保证开始日小于终了日
            if (Objects.nonNull(existingStart) && !existingStart.before(endDateNew)) {
                return "输入终了日需要大于既存开始日";
            }
        }
        return "校验成功";
    }
}
