package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipTheContent {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = Arrays.stream(bf.readLine().split(" ")).toList();
        int start = Integer.parseInt(bf.readLine());
        int end = Integer.parseInt(bf.readLine());
        bf.close();

        // 收集结果
        String resStr = "";

        // 越界直接返回
        if (start < 0 || start >= words.size() || end < 0 || end >= words.size() || start > end) {
            resStr = "EMPTY";
        } else {
            List<String> startList;
            if (start == 0) {
                startList = new ArrayList<>();// 0对应元素给midList所以这里取不到
            } else {
                startList = words.subList(0, start);
            }

            List<String> endList;
            if (end == words.size() - 1) {
                endList = new ArrayList<>();// 最后一个元素给midList所以这里取不到
            } else {
                endList = words.subList(end + 1, words.size());
            }

            List<String> midList = words.subList(start, end + 1);

            List<String> res = new ArrayList<>();
            res.addAll(startList);
            for (int i = midList.size() - 1; i >= 0; i--) {
                res.add(midList.get(i));
            }
            res.addAll(endList);
            resStr = String.join(" ", res);
        }
        System.out.println(resStr);
    }
}
