package list;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListLoop {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        int n = 10000_0000;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        StopWatch stopWatch = new StopWatch("测试各循环遍历");

        stopWatch.start("for i 循环");
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        stopWatch.stop();

        stopWatch.start("增强for循环");
        for (int item : list) {
        }
        stopWatch.stop();

        stopWatch.start("iterator for 循环");
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            iterator.next();
        }
        stopWatch.stop();

        stopWatch.start("iterator while 循环");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        stopWatch.stop();

        stopWatch.start("list.forEach 循环");
        list.forEach(item -> {
        });
        stopWatch.stop();


        stopWatch.start("list.stream().forEach 循环");
        list.stream().forEach(item -> {
        });
        stopWatch.stop();


        stopWatch.start("list.parallelStream().forEach 循环");
        list.parallelStream().forEach(item -> {
        });
        stopWatch.stop();

        logStopWatch(stopWatch);
    }


    public static void logStopWatch(StopWatch stopWatch) {
        String format = String.format("%s cost time = %s ms", stopWatch.getId(), stopWatch.getTotalTimeMillis());
        System.out.println(format);
        for (StopWatch.TaskInfo taskInfo : stopWatch.getTaskInfo()) {
            String format2 = String.format("%.2f", (float) taskInfo.getTimeMillis() / stopWatch.getTotalTimeMillis() * 100);
            String format1 = String.format("%s : %s ms, %s%%", postFillSpace(taskInfo.getTaskName()), taskInfo.getTimeMillis(), format2);
            System.out.println(format1);
        }
    }

    public static String postFillSpace(String str) {
        if (str.length() >= 40) {
            return str;
        }
        return postFillSpace(str + " ");
    }
}
