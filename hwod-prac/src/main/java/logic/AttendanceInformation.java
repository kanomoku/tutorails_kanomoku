package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 华为od题 56题 考勤问题
 * absent:    缺勤
 * late:      迟到
 * leaveearly:早退
 * present:   正常上班
 * <p>
 * 2
 * present
 * present absent present present leaveearly present absent
 */
public class AttendanceInformation {
    public static void main(String[] args) throws IOException {
        // 收集源数据
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int counts = Integer.parseInt(bf.readLine()); // 几个人的考勤
        List<List<String>> persons = new ArrayList<>(); // 收集具体的考勤信息
        for (int i = 0; i < counts; i++) {
            List<String> onePerson = Arrays.stream(bf.readLine().split(" ")).toList();
            persons.add(onePerson);
        }
        bf.close();

        // 结果收集容器
        List<Boolean> res = new ArrayList<>();

        for (List<String> person : persons) { // 挨个判断每个人的考勤

            // 1.缺勤不超过1次
            long count = person.stream().filter("absent"::equals).count();
            if (count > 0) {
                res.add(false);
                continue;
            }

            // 2.没有连续的迟到/早退
            boolean isBad = isBad(person);
            if (isBad) {
                res.add(false);
                continue;
            }

            // 3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
            boolean isBad2 = isBad2(person);
            if (isBad2) {
                res.add(false);
                continue;
            }
            res.add(true);
        }

        String collect = res.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    /**
     * 判断是否任意连续7次考勤 缺勤/迟到/早退 超过3次
     */
    private static boolean isBad2(List<String> attendances) {
        if (attendances.isEmpty()) {
            return false;
        }

        int[] arr = new int[attendances.size()];
        for (int i = 0; i < attendances.size(); i++) {
            arr[i] = "present".equals(attendances.get(i)) ? 0 : 1;
        }

        if (arr.length <= 7) {
            return Arrays.stream(arr).sum() > 3;
        } else {
            for (int i = 0; i <= arr.length - 7; i++) {
                int[] ints = Arrays.copyOfRange(arr, i, i + 7); // 任意7天
                int sum = Arrays.stream(ints).sum();
                if (sum > 3) {
                    return true; // 存在有问题数据就直接终止判断并返回
                }
            }
        }
        return false;
    }

    /**
     * 判断是否连续的迟到/早退
     */
    private static boolean isBad(List<String> attendances) {
        if (attendances.size() <= 1) {
            return false;
        }

        List<String> absent = Arrays.asList("late", "leaveearly");
        for (int i = 1; i < attendances.size(); i++) {
            String current = attendances.get(i);
            String previous = attendances.get(i - 1);
            if (absent.contains(current) && absent.contains(previous)) {
                // 存在有问题数据就直接终止判断并返回
                return true;
            }
        }
        return false;
    }
}
