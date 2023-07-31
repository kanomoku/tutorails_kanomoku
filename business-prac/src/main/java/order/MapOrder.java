package order;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapOrder {
    @Test
    public void order() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 11);
        map.put(3, 33);
        map.put(2, 22);
        map.put(5, 55);
        map.put(4, 44);

        HashMap<Integer, Integer> res = map.entrySet().stream()

                //----------------------------------------------------------------
                // 按照Key升序
                .sorted((e1, e2) -> e1.getKey() - e2.getKey())
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .sorted(Map.Entry.comparingByKey())

                // 按照Key降序
                .sorted((e1, e2) -> e2.getKey() - e1.getKey())
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .sorted((Map.Entry.<Integer, Integer>comparingByKey().reversed()))

                // 按照Value升序
                .sorted((e1, e2) -> e1.getValue() - e2.getValue())
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .sorted(Map.Entry.comparingByValue())

                // 按照Value降序
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))

                //----------------------------------------------------------------
                // 收集数据
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println(res);
    }
}
