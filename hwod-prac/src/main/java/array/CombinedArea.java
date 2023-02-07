package array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinedArea {
    public static void main(String[] args) throws IOException {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(10, 30));
        list.add(new Interval(20, 60));
        list.add(new Interval(80, 100));
        list.add(new Interval(150, 180));
        CombinedArea combinedArea = new CombinedArea();
        ArrayList<Interval> merge = combinedArea.merge(list);
        merge.stream().forEach(System.out::println);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // 要处理边界值
        if (intervals.size() <= 1) {
            return intervals;
        }

        // 排序
        List<Interval> orderedIntervals = intervals.stream().sorted((a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        }).collect(Collectors.toList());

        // 结果收集容器
        ArrayList<Interval> res = new ArrayList<>();

        // 基底
        Interval base = orderedIntervals.get(0);

        for (int i = 1; i < orderedIntervals.size(); ) {

            if (isNotUnit(base, orderedIntervals.get(i))) {
                res.add(base); // 不相交，收集基底
                base = orderedIntervals.get(i); // 变基

                if (i == orderedIntervals.size() - 1) { // 当前项为最后一项的话、直接收集起来
                    res.add(base);
                }

                i = i + 1; // 指针跳一下，指向下一个目标
            } else {
                base = getNew(base, orderedIntervals.get(i)); // 当前区间和Base区间取最大区间

                if (i == orderedIntervals.size() - 1) { // 当前项为最后一项的话、直接收集起来
                    res.add(base);
                }

                i = i + 1; // 指针跳一下，指向下一个目标
            }
        }
        return res;
    }

    /**
     * 判断两个区间不想交
     */
    public static boolean isNotUnit(Interval left, Interval right) {
        return left.end < right.start;
    }

    /**
     * 获取最大区间
     */
    public static Interval getNew(Interval left, Interval right) {
        int min = Math.min(left.start, right.start);
        int max = Math.max(left.end, right.end);
        return new Interval(min, max);
    }

}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + ']';
    }
}