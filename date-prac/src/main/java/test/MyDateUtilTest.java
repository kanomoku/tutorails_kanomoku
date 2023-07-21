package test;

import date.MyDateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.ZoneId;

import java.util.Date;

public class MyDateUtilTest {

    @Test
    public void convertDateFromCurrentToTargetTimeZone_8() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromCurrentToTargetZone(date, ZoneId.of("+08:00"));
        Date targetDate2 = MyDateUtil.dateFromCurrentToTargetZone2(date, ZoneId.of("+08:00"));
        Date expected = DateUtils.parseDate("2019-7-07 20:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
        Assert.assertEquals(expected, targetDate2);
    }

    @Test
    public void convertDateFromCurrentToTargetTimeZone_9() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromCurrentToTargetZone(date, ZoneId.of("+09:00"));
        Date targetDate2 = MyDateUtil.dateFromCurrentToTargetZone2(date, ZoneId.of("+09:00"));
        Date expected = DateUtils.parseDate("2019-7-07 21:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
        Assert.assertEquals(expected, targetDate2);
    }

    @Test
    public void convertDateFromCurrentToTargetTimeZone_0() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromCurrentToTargetZone(date, ZoneId.of("+00:00"));
        Date targetDate2 = MyDateUtil.dateFromCurrentToTargetZone2(date, ZoneId.of("+00:00"));
        Date expected = DateUtils.parseDate("2019-7-07 12:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
        Assert.assertEquals(expected, targetDate2);
    }

    @Test
    public void convertDateFromCurrentToTargetTimeZone_0_1() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromCurrentToTargetZone(date, ZoneId.of("-01:00"));
        Date targetDate2 = MyDateUtil.dateFromCurrentToTargetZone2(date, ZoneId.of("-01:00"));
        Date expected = DateUtils.parseDate("2019-7-07 11:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
        Assert.assertEquals(expected, targetDate2);
    }

    @Test
    public void convertDateFromTargetToCurrentTimeZone_9() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromTargetToCurrentZone(date, ZoneId.of("+09:00"));
        Date targetDate2 = MyDateUtil.dateFromTargetToCurrentZone2(date, ZoneId.of("+09:00"));
        Date expected = DateUtils.parseDate("2019-7-07 19:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
        Assert.assertEquals(expected, targetDate2);
    }

    @Test
    public void convertDateFromTargetToCurrentTimeZone_0() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromTargetToCurrentZone(date, ZoneId.of("+00:00"));
        Date targetDate2 = MyDateUtil.dateFromTargetToCurrentZone2(date, ZoneId.of("+00:00"));
        Date expected = DateUtils.parseDate("2019-7-08 04:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
        Assert.assertEquals(expected, targetDate2);
    }

    @Test
    public void convertDateFromTargetToCurrentTimeZone_0_1() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromTargetToCurrentZone(date, ZoneId.of("-01:00"));
        Date targetDate2 = MyDateUtil.dateFromTargetToCurrentZone2(date, ZoneId.of("-01:00"));
        Date expected = DateUtils.parseDate("2019-7-08 05:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
        Assert.assertEquals(expected, targetDate2);
    }

    @Test
    public void dateFromSourceToTargetZone_8to9() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromSourceToTargetZone(date, ZoneId.of("+08:00"), ZoneId.of("+09:00"));
        Date expected = DateUtils.parseDate("2019-7-07 21:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
    }

    @Test
    public void dateFromSourceToTargetZone_7to9() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromSourceToTargetZone(date, ZoneId.of("+07:00"), ZoneId.of("+09:00"));
        Date expected = DateUtils.parseDate("2019-7-07 22:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
    }

    @Test
    public void dateFromSourceToTargetZone_01to9() throws ParseException {
        Date date = new Date(1562501898000L); // Sun Jul 07 20:18:18 CST 2019
        Date targetDate = MyDateUtil.dateFromSourceToTargetZone(date, ZoneId.of("-01:00"), ZoneId.of("+09:00"));
        Date expected = DateUtils.parseDate("2019-7-08 06:18:18", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected, targetDate);
    }
}