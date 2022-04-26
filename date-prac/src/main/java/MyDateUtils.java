import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(localDateTime.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(localDateTime.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
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
}
