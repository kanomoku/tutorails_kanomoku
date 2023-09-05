package map;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapLoop {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = 1000_0000;
        for (int i = 1; i <= n; i++) {
            map.put(i, i);
        }

        StopWatch stopWatch = new StopWatch("每种循环各遍历" + n + "次");

        stopWatch.start("map.entrySet()");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        }
        stopWatch.stop();

        stopWatch.start("map.entrySet().iterator()");
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            entries.next();
        }
        stopWatch.stop();

        stopWatch.start("map.forEach");
        map.forEach((key, value) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.entrySet().stream().forEach");
        map.entrySet().stream().forEach((entry) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.entrySet().parallelStream().forEach");
        map.entrySet().parallelStream().forEach((entry) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.keySet()");
        for (Integer key : map.keySet()) {
        }
        stopWatch.stop();

        stopWatch.start("map.keySet().iterator()");
        Iterator<Integer> iteratorKeySet = map.keySet().iterator();
        while (iteratorKeySet.hasNext()) {
            iteratorKeySet.next();
        }
        stopWatch.stop();

        stopWatch.start("map.keySet().forEach");
        map.keySet().forEach((key) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.keySet().stream().forEach");
        map.keySet().stream().forEach((entry) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.keySet().parallelStream().forEach");
        map.keySet().parallelStream().forEach((entry) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.values()");
        for (Integer value : map.values()) {
        }
        stopWatch.stop();

        stopWatch.start("map.values().iterator()");
        Iterator<Integer> iteratorValues = map.values().iterator();
        while (iteratorValues.hasNext()) {
            iteratorValues.next();
        }
        stopWatch.stop();

        stopWatch.start("map.values().forEach");
        map.values().forEach((values) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.values().stream().forEach");
        map.values().stream().forEach((entry) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.values().parallelStream().forEach");
        map.values().parallelStream().forEach((value) -> {
        });
        stopWatch.stop();

        stopWatch.start("map.keySet() → map.get(key)");
        for (Integer key : map.keySet()) {
            map.get(key);
        }
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
