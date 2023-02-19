package odexam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Second2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        long fieldCnt = in.nextInt(); // 果园数量
        long targetDays = in.nextInt(); // 几天之内完成
        List<Long> areas = new ArrayList<>();
        while (areas.size() < fieldCnt && in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            areas.add(in.nextLong());
        }

        if (fieldCnt > targetDays) { // 果园数>天数,不可能完成的目标
            System.out.println(-1);
        }

        if (fieldCnt == targetDays) { // 果园数=天数,一片果园只能干一天,故必须采纳最大功率的机器
            long asLong = areas.stream().mapToLong(Long::longValue).max().getAsLong();
            System.out.println(asLong);
        }
        // 果园数<天数,存在一个果园做多天的场景

        boolean isBad = true;
        long power = areas.size() + 1; // 初始功率
        while (isBad) {
            isBad = false;
            // 当前功率最快需要几天
            long tempDays = 0;
            for (int i = 0; i < areas.size(); i++) {
                tempDays += getNeedDay(areas.get(i), power);
                if (tempDays > targetDays) { // 当前功率会超期
                    isBad = true;
                    power++; // 提升功率
                    break; // 终止计算
                }
            }
        }
        System.out.println(power);
    }

    /**
     * 基于当前的效能，当前果林施肥需要的天数
     */
    private static long getNeedDay(long size, long power) {
        // 亩数/功率=天数
        long ceil = (long) Math.ceil((double) size / power);
//        System.out.println(size + " " + power + " " + ceil);
        return ceil;
    }
}
