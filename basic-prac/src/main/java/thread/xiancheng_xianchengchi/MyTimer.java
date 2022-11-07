package thread.xiancheng_xianchengchi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

public class MyTimer {
    private int count = 1;
    //属性 集合
    private ArrayList<String> userBox = new ArrayList<>();

    {
        userBox.add("a");
        userBox.add("b");
        userBox.add("c");
        userBox.add("d");
    }

    //设计一个方法   做点坏事   垃圾短信
    //每隔一段时间 发送一些数据
    public void test() throws ParseException {
        System.out.println("预备开始");
        java.util.Timer timer = new java.util.Timer();//启动了一个小线程 做记录 每隔时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2019-04-14 23:51:00");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("第" + count++ + "次执行" + new Date());
                for (int i = 0; i < userBox.size(); i++) {
                    System.out.println(Thread.currentThread().getName() + "  给" + userBox.get(i) + "发送一条消息:" + "恭喜发财"+ new Date());
                }
                System.out.println("做点坏事真开心" + new Date());
            }
        }, firstTime, 3000);
    }

    public static void main(String[] args) {
        try {
            MyTimer tt = new MyTimer();
            tt.test();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
