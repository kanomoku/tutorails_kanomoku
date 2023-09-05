package set;

import org.springframework.util.StopWatch;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetLoop {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        int n = 50000000;
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        StopWatch stopWatch = new StopWatch("每种循环各遍历" + n + "次");

        // Set 没有fori 的遍历方式

        stopWatch.start("iterator for 循环");
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            iterator.next();
        }
        stopWatch.stop();

        stopWatch.start("iterator while 循环");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        stopWatch.stop();

        stopWatch.start("for Boost 循环");
        for (int item : set) {
        }
        stopWatch.stop();


        stopWatch.start("list.forEach 循环");
        set.forEach(item -> {
        });
        stopWatch.stop();


        stopWatch.start("list.stream().forEach 循环");
        set.stream().forEach(item -> {
        });
        stopWatch.stop();


        stopWatch.start("list.parallelStream().forEach 循环");
        set.parallelStream().forEach(item -> {
        });
        stopWatch.stop();

        logStopWatch(stopWatch);
    }


    public static void logStopWatch(StopWatch stopWatch) {
        String format = String.format("%s total cost time = %s ms", stopWatch.getId(), stopWatch.getTotalTimeMillis());
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
