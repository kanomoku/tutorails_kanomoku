package array;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 数组拼接
//  3
//  2,5,6,7,9,5,7
//  1,7,4,3,4
//  4,5,7,1,3,8
public class ArraySplicing {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 读取截取长度
        int len = Integer.parseInt(bf.readLine());

        // 收集多组数组
        List<List<Integer>> list = new ArrayList<>();
        String str = "";
        while (StringUtils.isNotBlank(str = bf.readLine())) {
            List<Integer> collect = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            list.add(collect);
        }
        bf.close();

        List<Integer> res = getIntegers(list, len);

        String collect = res.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    /**
     * 数组按照固定长度拼接
     *
     * @param list      数组
     * @param targetLen 长度
     */
    private static List<Integer> getIntegers(List<List<Integer>> list, int targetLen) {
        List<Integer> res = new ArrayList<>();


        int index = 0; // 每一轮截取的初始下标
        boolean allFinished = false; // 动态标记→初始条件→判断是否所有数据均截取完毕
        List<Integer> temp; // 临时变量纯为了提升性能→取名为篮子

        while (!allFinished) {
            // 所有数组均遍历一次
            for (int i = 0; i < list.size(); i++) {

                allFinished = true; // 动态标记→终止条件→每一轮都默认为所有数组处理完毕
                temp = new ArrayList<>(); // 每次循环清空篮子

                List<Integer> subList = list.get(i);
                if (index + targetLen <= subList.size()) { // 右边界在范围内
                    temp = subList.subList(index, index + targetLen);
                    allFinished = false; // 动态标记→动态打flag→存在正常截取则表示还有未处理完毕的数组
                } else if (index < subList.size()) { // 右边界不在范围内，起始索引还在数组范围内
                    temp = subList.subList(index, subList.size());
                } else {
                    // 左边界不在数组范围内
                }

                res.addAll(temp); // 收集元素
            }

            index = index + targetLen; // 初始下标右移
        }
        return res;
    }
}
