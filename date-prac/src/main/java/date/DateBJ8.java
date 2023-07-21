package date;

import org.junit.Test;

import java.util.Date;

/**
 * 确切的说：Date对象里存的是自格林威治时间（ GMT）1970年1月1日0点至Date所表示时刻所经过的毫秒数，是个数值
 */
public class DateBJ8 {

    @Test public void test1() {
        Date currDate = new Date();
        System.out.println(currDate);//Sun Apr 03 16:18:21 CST 2022

        // 已经@Deprecated
        System.out.println(currDate.toLocaleString());//2022年4月3日 下午4:18:21
        // 已经@Deprecated
        System.out.println(currDate.toGMTString());//3 Apr 2022 08:18:21 GMT
    }
}
