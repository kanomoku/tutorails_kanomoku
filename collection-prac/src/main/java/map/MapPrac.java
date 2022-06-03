package map;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapPrac {
    @Test void test() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[] arr = list.toArray(new String[0]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        Map map = new HashMap();
    }
}
