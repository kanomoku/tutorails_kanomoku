package javabasic.log;

import org.springframework.util.StopWatch;

public class StopWatchUtils {
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
