package commonscenarios;

import commonscenarios.model.Dog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {
    @Test
    public void groupingBy1() {
        List<Dog> list = null;
        Map<String, List<Dog>> collect1 = list.stream().collect(Collectors.groupingBy(Dog::getName));
    }

    @Test
    public void groupingBy2() {
        List<Dog> list = new ArrayList<>();
        Map<String, List<Dog>> collect1 = list.stream().collect(Collectors.groupingBy(Dog::getName));
        System.out.println(collect1);
    }

    @Test
    public void groupingBy3() {
        List<Dog> list = new ArrayList<>();
        list.add(null);
        Map<String, List<Dog>> collect1 = list.stream().collect(Collectors.groupingBy(Dog::getName));
        System.out.println(collect1);
    }

    @Test
    public void groupingBy4() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(null, 18));
        Map<String, List<Dog>> collect1 = list.stream().collect(Collectors.groupingBy(Dog::getName));
        System.out.println(collect1);
    }

    @Test
    public void groupingBy5() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
        Map<String, List<Dog>> collect1 = list.stream().collect(Collectors.groupingBy(Dog::getName));
        System.out.println(collect1);
    }

    @Test
    public void groupingBy6() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
        list.add(new Dog(null, 19));
        Map<String, List<Dog>> collect1 = list.stream().filter(a -> a != null && a.getName() != null).collect(Collectors.groupingBy(Dog::getName));
        System.out.println(collect1);
    }

    public void groupingBy0() {
        // List<Dog>  →  Map<name, List<Dog>>
        List<Dog> list = new ArrayList<>();
        Map<String, List<Dog>> collect1 = list.stream().collect(Collectors.groupingBy(Dog::getName));
        // list为null     →  NPE
        // list为empty    →  {}
        // model存在null  →  NPE
        // key存在null    →  NPE
        // {Tom=[Dog(name=Tom, age=18), Dog(name=Tom, age=19)], John=[Dog(name=John, age=18)]}
    }

    @Test
    public void groupingBy21() {
        List<Dog> list = null;
        Map<String, List<Dog>> collect2 = list.stream().collect(Collectors.groupingBy(Dog::getName, HashMap::new, Collectors.toList()));
        System.out.println(collect2);
    }

    @Test
    public void groupingBy22() {
        List<Dog> list = new ArrayList<>();
        Map<String, List<Dog>> collect2 = list.stream().collect(Collectors.groupingBy(Dog::getName, HashMap::new, Collectors.toList()));
        System.out.println(collect2);
    }

    @Test
    public void groupingBy23() {
        List<Dog> list = new ArrayList<>();
        list.add(null);
        Map<String, List<Dog>> collect2 = list.stream().collect(Collectors.groupingBy(Dog::getName, HashMap::new, Collectors.toList()));
        System.out.println(collect2);
    }

    @Test
    public void groupingBy24() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(null, 18));
        Map<String, List<Dog>> collect2 = list.stream().collect(Collectors.groupingBy(Dog::getName, HashMap::new, Collectors.toList()));
        System.out.println(collect2);
    }

    @Test
    public void groupingBy25() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
        Map<String, List<Dog>> collect2 = list.stream().collect(Collectors.groupingBy(Dog::getName, HashMap::new, Collectors.toList()));
        System.out.println(collect2);
    }

    @Test
    public void groupingBy26() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
        list.add(new Dog(null, 19));
        Map<String, List<Dog>> collect2 = list.stream().filter(a -> a != null && a.getName() != null).collect(Collectors.groupingBy(Dog::getName, HashMap::new, Collectors.toList()));
        System.out.println(collect2);
    }

    @Test
    public void groupingBy20() {
        // List<Dog>  →  Map<name, List<Dog>>
        List<Dog> list = new ArrayList<>();
        Map<String, List<Dog>> collect2 = list.stream().collect(Collectors.groupingBy(Dog::getName, HashMap::new, Collectors.toList()));
        // list为null     →  NPE
        // list为empty    →  {}
        // model存在null  →  NPE
        // key存在null    →  NPE
        // {Tom=[Dog(name=Tom, age=18), Dog(name=Tom, age=19)], John=[Dog(name=John, age=18)]}
    }

    @Test
    public void groupingBy31() {
        List<Dog> list = null;
        Map<String, List<Dog>> collect3 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(collect3);
    }

    @Test
    public void groupingBy32() {
        List<Dog> list = new ArrayList<>();
        Map<String, List<Dog>> collect3 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(collect3);
    }

    @Test
    public void groupingBy33() {
        List<Dog> list = new ArrayList<>();
        list.add(null);
        Map<String, List<Dog>> collect3 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(collect3);
    }

    @Test
    public void groupingBy34() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(null, 18));
        Map<String, List<Dog>> collect3 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(collect3);
    }

    @Test
    public void groupingBy35() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
        Map<String, List<Dog>> collect3 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(collect3);
    }

    @Test
    public void groupingBy36() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
        list.add(new Dog(null, 19));
        Map<String, List<Dog>> collect3 = list.stream().filter(a -> a != null && a.getName() != null).collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(collect3);
    }

    @Test
    public void groupingBy30() {
        // List<Dog>  →  Map<name, List<Dog>>
        List<Dog> list = new ArrayList<>();
        Map<String, List<Dog>> collect3 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        // list为null     →  NPE
        // list为empty    →  {}
        // model存在null  →  NPE
        // key存在null    →  NPE
        // {Tom=[Dog(name=Tom, age=18), Dog(name=Tom, age=19)], John=[Dog(name=John, age=18)]}
    }

    @Test
    public void groupingBy_valueList1() {
        List<Dog> list = null;
        Map<String, List<Integer>> collect4 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));
        System.out.println(collect4);
    }

    @Test
    public void groupingBy_valueList2() {
        List<Dog> list = new ArrayList<>();
        Map<String, List<Integer>> collect4 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));
        System.out.println(collect4);
    }

    @Test
    public void groupingBy_valueList3() {
        List<Dog> list = new ArrayList<>();
        list.add(null);
        Map<String, List<Integer>> collect4 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));
        System.out.println(collect4);
    }

    @Test
    public void groupingBy_valueList4() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(null, 18));
        Map<String, List<Integer>> collect4 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));
        System.out.println(collect4);
    }

    @Test
    public void groupingBy_valueList5() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("John", null));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 18));
        Map<String, List<Integer>> collect4 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));
        System.out.println(collect4);
    }

    @Test
    public void groupingBy_valueList6() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("John", null));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 18));
        Map<String, List<Integer>> collect4 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));
        System.out.println(collect4);
    }

    @Test
    public void groupingBy_valueList7() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("John", null));
        list.add(new Dog("Tom", 18));
        list.add(new Dog(null, 18));
        list.add(new Dog("Tom", 18));
        Map<String, List<Integer>> collect4 = list.stream().filter(a -> a != null && a.getName() != null).collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));
        System.out.println(collect4);
    }

    @Test
    public void groupingBy_valueList0() {
        // List<Dog>  →  Map<name, List<Age>>
        List<Dog> list = new ArrayList<>();
        Map<String, List<Integer>> collect4 = list.stream().collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));
        System.out.println(collect4);
        // list为null          →  NPE
        // list为empty         →  {}
        // model存在null       →  NPE
        // key存在null         →  NPE
        // value为null依旧收集  →  {Tom=[18, 18], John=[18, null]}
        // value重复收集不去重   →  {Tom=[18, 18], John=[18, null]}
    }

    @Test
    public void beanToMap1() {
        List<Dog> list = null;
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
    }

    @Test
    public void beanToMap2() {
        List<Dog> list = new ArrayList<>();
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
    }

    @Test
    public void beanToMap3() {
        List<Dog> list = new ArrayList<>();
        list.add(null);
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
    }

    @Test
    public void beanToMap4() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog(null, 18));
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
    }

    @Test
    public void beanToMap5() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", null));
        list.add(new Dog(null, 18));
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
    }

    @Test
    public void beanToMap6() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("John", 18));
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
    }

    @Test
    public void beanToMap7() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(null, 18));
        list.add(new Dog(null, 18));
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
    }

    @Test
    public void beanToMap8() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
    }

    @Test
    public void beanToMap0() {
        List<Dog> list = new ArrayList<>();
        Map<String, Dog> collect6 = list.stream().collect(Collectors.toMap(Dog::getName, Function.identity()));
        System.out.println(collect6);
        // list为null             →  NPE
        // list为empty            →  {}
        // model存在null          →  NPE
        // key为null则null作为key  →  {null=Dog(name=null, age=20), Tom=Dog(name=Tom, age=18)}
        // value为null依旧收集     →  {Tom=Dog(name=Tom, age=18), John=Dog(name=John, age=null)}
        // Key重复报错(包括null)   →  IllegalStateException: Duplicate key
        // value重复收集不去重      →  {Tom=Dog(name=Tom, age=18), John=Dog(name=John, age=18)}

        // Key重复时采用定制化规则(e1, e2) -> e2      →  {null=Dog(name=null, age=21), Tom=Dog(name=Tom, age=22), John=Dog(name=John, age=18)}

    }

    @Test
    public void toMap_name_age_1() {
        List<Dog> list = null;
        Map<String, Integer> collect7 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));
        System.out.println(collect7);
    }

    @Test
    public void toMap_name_age_2() {
        List<Dog> list = new ArrayList<>();
        Map<String, Integer> collect7 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));
        System.out.println(collect7);
    }

    @Test
    public void toMap_name_age_3() {
        List<Dog> list = new ArrayList<>();
        list.add(null);
        Map<String, Integer> collect7 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));
        System.out.println(collect7);
    }

    @Test
    public void toMap_name_age_4() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog(null, 20));
        Map<String, Integer> collect7 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));
        System.out.println(collect7);
    }

    @Test
    public void toMap_name_age_5() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("John", null));
        Map<String, Integer> collect7 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));
        System.out.println(collect7);
    }

    @Test
    public void toMap_name_age_6() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("Tom", 23));
        Map<String, Integer> collect7 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));
        System.out.println(collect7);
    }

    @Test
    public void toMap_name_age_7() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("John", 22));
        Map<String, Integer> collect7 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));
        System.out.println(collect7);
    }

    @Test
    public void toMap_name_age_8() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("Tom", 23));
        list.add(new Dog("John", 22));
        Map<String, Integer> collect9 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge, (existing, replacement) -> replacement));
        System.out.println(collect9);
    }

    @Test
    public void toMap_name_age_9() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("Tom", 23));
        list.add(new Dog("John", 22));
        Map<String, Integer> collect9 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge, (existing, replacement) -> existing));
        System.out.println(collect9);
    }

    @Test
    public void toMap_name_age_10() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("Tom", 23));
        list.add(new Dog("John", 22));
        list.add(new Dog(null, 22));
        list.add(new Dog("John", null));
        Map<String, Integer> collect9 = list.stream().filter(a -> a != null && a.getAge() != null).collect(Collectors.toMap(Dog::getName, Dog::getAge, (existing, replacement) -> replacement));
        System.out.println(collect9);
    }

    @Test
    public void toMap_name_age_0() {
        List<Dog> list = new ArrayList<>();
        Map<String, Integer> collect7 = list.stream().collect(Collectors.toMap(Dog::getName, Dog::getAge));
        System.out.println(collect7);
        // list为null             →  NPE
        // list为empty            →  {}
        // model存在null          →  NPE
        // key为null则null作为key  →  {null=20, John=18}
        // value为null            →  NPE
        // Key重复报错             →  IllegalStateException: Duplicate key
        // value重复收集不去重      →  {Tom=18, John=18}

        // key重复时采用定制化规则(e1, e2) -> e1      →  {Tom=22}
    }

    @Test
    public void collect_reduce1() {
        List<Dog> list = null;
        Map<String, Integer> collect10 = list.stream().collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);
        System.out.println(collect10);
    }

    @Test
    public void collect_reduce2() {
        List<Dog> list = new ArrayList<>();
        Map<String, Integer> collect10 = list.stream().collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);
        System.out.println(collect10);
    }

    @Test
    public void collect_reduce3() {
        List<Dog> list = new ArrayList<>();
        list.add(null);
        Map<String, Integer> collect10 = list.stream().collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);
        System.out.println(collect10);
    }
    @Test
    public void collect_reduce4() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog(null, 20));
        Map<String, Integer> collect10 = list.stream().collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);
        System.out.println(collect10);
    }

    @Test
    public void collect_reduce5() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("John", null));
        Map<String, Integer> collect10 = list.stream().collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);
        System.out.println(collect10);
    }

    @Test
    public void collect_reduce6() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("Tom", 23));
        list.add(new Dog("John", 22));
        list.add(new Dog(null, 22));
        list.add(new Dog("John", null));
        Map<String, Integer> collect10 = list.stream().collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);
        System.out.println(collect10);
    }

    @Test
    public void collect_reduce7() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Tom", 22));
        list.add(new Dog("John", 22));
        Map<String, Integer> collect10 = list.stream().collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);
        System.out.println(collect10);
    }

    @Test
    public void collect_reduce0() {
        List<Dog> list = new ArrayList<>();
        Map<String, Integer> collect10 = list.stream().collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);
        System.out.println(collect10);
        // list为null                      →  NPE
        // list为empty                     →  {}
        // model存在null                   →  NPE
        // key为null则null作为key           →  {null=20, John=18}
        // Key重复时value被后面的值替换      →  {Tom=22}
        // Key重复时value被后面的值替换       →  {Tom=22}
        // value重复收集不去重               →  {Tom=18, John=18}
    }
}
