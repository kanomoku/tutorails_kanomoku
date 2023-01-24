package list;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListCaluculate {
    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList();
//        List<Integer> list2 = new ArrayList();
//        List<Integer> list5 = null;
//        List<Integer> list1 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list1 = new ArrayList(Arrays.asList(1, 2, 3, 6, 7, 8, 9));
        List<Integer> list2 = new ArrayList(Arrays.asList(1, 2, 3, 6, 7, 8, 9));
//        boolean existIntersection2 = new ArrayList(list1).retainAll(list2);
//        System.out.println(existIntersection2);

//        Collection intersection = CollectionUtils.intersection(list1, list2);
//        System.out.println("交集结果是: " + intersection);

        System.out.println(list1);
        System.out.println(list2);
        list1.retainAll(list2);
        System.out.println(list1);
        System.out.println(list2);


//        System.out.println(list3);
//        boolean b = list1.retainAll(list2);
//        System.out.println(b);
    }
}
