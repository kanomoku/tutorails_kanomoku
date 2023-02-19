package odexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Second1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        if (s1 == null || s1.length() == 0) {
            System.out.println(-1);
        }

        long[] s = Arrays.stream(s1.split(" ")).mapToLong(Long::parseLong).toArray();
        long fieldCnt = s[0]; // 果园数量
        long targetDays = s[1]; // 几天之内完成

        // 果园的数量
        String s2 = bf.readLine();
        if (s2 == null || s2.length() <= 2) {
            System.out.println(-1);
        }

        String[] s3 = s2.split(" ");
        long[] areas = Arrays.stream(s3).mapToLong(Long::parseLong).toArray();
        bf.close();

        Arrays.sort(areas);

        if (fieldCnt > targetDays) { // 果园数>天数,不可能完成的目标
            System.out.println(-1);
        }

        if (fieldCnt == targetDays) { // 果园数=天数,一片果园只能干一天,故必须采纳最大功率的机器
            System.out.println(areas[areas.length - 1]);
        }
        // 果园数<天数,存在一个果园做多天的场景

        boolean isBad = true;
        long power = areas.length + 1; // 初始功率
        while (isBad) {
            isBad = false;
            // 当前功率最快需要几天
            long tempDays = 0;
            for (int i = 0; i < areas.length; i++) {
                tempDays += getNeedDay(areas[i], power);
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
