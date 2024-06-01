package tree;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryHeapPrint {
    public static void main(String[] args) {
        int[] arr3 = {1, 3, 2, 9, 5, 7, 8, 6, 10, 0};

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> start = Arrays.asList(0);
        res.add(start);
        test(arr3, start, res);
        System.out.println(res);

        for (int i = 0; i < res.size(); i++) {
            List<Integer> idx = res.get(i);
            String temp = preFill(idx.get(0).toString(), (int)Math.pow(2, res.size() - 1 - i) - 1);
            for (int j = 1; j < idx.size(); j++) {
                int pow = (int)Math.pow(2, res.size() - i);
                temp += preFill(idx.get(j).toString(), (int)Math.pow(2, res.size() - i));
            }
            System.out.println(temp);
        }
    }

    public static String preFill(String str, int len) {
        if (str.length() > len) {
            return str;
        }
        return preFill(" " + str, len);
    }

    public static void test(int[] arr, List<Integer> idxs, List<List<Integer>> res) {
        if (CollectionUtils.isEmpty(idxs)) {
            return;
        }
        List<Integer> sons = getSons(arr, idxs);
        if (CollectionUtils.isEmpty(sons)) {
            return;
        }

        res.add(sons);
        test(arr, sons, res);
    }

    public static List<Integer> getSons(int[] arr, List<Integer> idxs) {
        return idxs.stream().map(a -> getSon(arr, a)).filter(CollectionUtils::isNotEmpty).flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    public static List<Integer> getSon(int[] arr, int idx) {
        int l = 2 * idx + 1;
        int r = 2 * idx + 2;
        List<Integer> list = new ArrayList<>();
        if (l < arr.length) {
            //            list.add(arr[l]);
            list.add(l);
        }
        if (r < arr.length) {
            //            list.add(arr[r]);
            list.add(r);

        }
        return list;
    }
}
