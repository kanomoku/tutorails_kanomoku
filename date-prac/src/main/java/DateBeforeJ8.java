import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 确切的说：Date对象里存的是自格林威治时间（ GMT）1970年1月1日0点至Date所表示时刻所经过的毫秒数，是个数值
 */
public class DateBeforeJ8 {

    @Test public void stringToDate() throws ParseException {
        // 模拟服务端对此服务换转换为Date类型
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("格式化器用的时区是：" + dateFormat.getTimeZone().getID());
        System.out.println(dateFormat.parse("2020-01-15 18:00:00"));

        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.println(dateFormat.parse("2020-01-15 18:00:00"));
    }

    @Test public void dateToStr() {
        // 北京时间(new出来就是默认时区的时间)
        Date bjDate = new Date();

        DateFormat newYorkDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        newYorkDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.println("这是东京时间：" + newYorkDateFormat.format(bjDate));

        System.out.println("这是北京时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bjDate));
    }

    @Test public void getTimeZone() {
        System.out.println(TimeZone.getDefault().getID());
        System.out.println(TimeZone.getTimeZone("GMT+08:00").getID());

        // 纽约时间
        System.out.println(TimeZone.getTimeZone("GMT-05:00").getID());
        System.out.println(TimeZone.getTimeZone("America/New_York").getID());
    }

    @Test public void test1() {
        Date currDate = new Date();
        System.out.println(currDate);//Sun Apr 03 16:18:21 CST 2022
        // 已经@Deprecated
        System.out.println(currDate.toLocaleString());//2022年4月3日 下午4:18:21
        // 已经@Deprecated
        System.out.println(currDate.toGMTString());//3 Apr 2022 08:18:21 GMT
    }
}
