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
    public void groupingBy() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
//        list.add(new Dog(null, 18));
//        list.add(null);

        // List<Dog>  →  Map<name, List<Dog>>
        Map<String, List<Dog>> collect1 = list.stream()
                .collect(Collectors.groupingBy(Dog::getName));

        System.out.println(collect1);
        // list为null     →  NPE
        // list为empty    →  {}
        // model存在null  →  NPE
        // key存在null    →  NPE
        // {Tom=[Dog(name=Tom, age=18), Dog(name=Tom, age=19)], John=[Dog(name=John, age=18)]}
    }

    @Test
    public void groupingBy2() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
//        list.add(new Dog(null, 20));
//        list.add(null);

        // List<Dog>  →  Map<name, List<Dog>>
        Map<String, List<Dog>> collect2 = list.stream()
                .collect(Collectors.groupingBy(Dog::getName, HashMap::new, Collectors.toList()));


        System.out.println(collect2);
        // list为null     →  NPE
        // list为empty    →  {}
        // model存在null  →  NPE
        // key存在null    →  NPE
        // {Tom=[Dog(name=Tom, age=18), Dog(name=Tom, age=19)], John=[Dog(name=John, age=18)]}
    }

    @Test
    public void groupingBy_mapping() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 19));
//        list.add(new Dog(null, 20));
//        list.add(null);

        // List<Dog>  →  Map<name, List<Dog>>
        Map<String, List<Dog>> collect3 = list.stream()
                .collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(collect3);
        // list为null     →  NPE
        // list为empty    →  {}
        // model存在null  →  NPE
        // key存在null    →  NPE
        // {Tom=[Dog(name=Tom, age=18), Dog(name=Tom, age=19)], John=[Dog(name=John, age=18)]}
    }

    @Test
    public void groupingBy_mapping2() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
        list.add(new Dog("John", null));
        list.add(new Dog("Tom", 18));
        list.add(new Dog("Tom", 18));
//        list.add(new Dog(null, 20));
//        list.add(null);

        // List<Dog>  →  Map<name, List<Age>>
        Map<String, List<Integer>> collect4 = list.stream()
                .collect(Collectors.groupingBy(Dog::getName, Collectors.mapping(Dog::getAge, Collectors.toList())));

        System.out.println(collect4);
        // list为null          →  NPE
        // list为empty         →  {}
        // model存在null       →  NPE
        // key存在null         →  NPE
        // value为null依旧收集  →  {Tom=[18, 18], John=[18, null]}
        // value重复收集不去重   →  {Tom=[18, 18], John=[18, null]}
    }

    @Test
    public void toMap() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
//        list.add(new Dog("John", null));
//        list.add(new Dog("Tom", 18));
//        list.add(new Dog("Tom", 18));
        list.add(new Dog(null, 20));
//        list.add(null);

        Map<String, Dog> collect6 = list.stream()
                .collect(Collectors.toMap(Dog::getName, Function.identity()));

        System.out.println(collect6);
        // list为null             →  NPE
        // list为empty            →  {}
        // model存在null          →  NPE
        // key为null则null作为key  →  {null=Dog(name=null, age=20), Tom=Dog(name=Tom, age=18)}
        // value为null依旧收集     →  {Tom=Dog(name=Tom, age=18), John=Dog(name=John, age=null)}
        // Key重复报错             →  IllegalStateException: Duplicate key
        // value重复收集不去重      →  {Tom=Dog(name=Tom, age=18), John=Dog(name=John, age=18)}
    }

    @Test
    public void toMap2() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
//        list.add(new Dog("John", null));
        list.add(new Dog("Tom", 18));
//        list.add(new Dog("Tom", 22));
//        list.add(new Dog(null, 20));
//        list.add(null);

        Map<String, Integer> collect7 = list.stream()
                .collect(Collectors.toMap(Dog::getName, Dog::getAge));


        System.out.println(collect7);
        // list为null             →  NPE
        // list为empty            →  {}
        // model存在null          →  NPE
        // key为null则null作为key  →  {null=20, John=18}
        // value为null            →  NPE
        // Key重复报错             →  IllegalStateException: Duplicate key
        // value重复收集不去重      →  {Tom=18, John=18}
    }


    @Test
    public void toMap_replacement() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
//        list.add(new Dog("John", null));
        list.add(new Dog("Tom", 18));
//        list.add(new Dog("Tom", 22));
//        list.add(new Dog(null, 20));
//        list.add(null);

        Map<String, Dog> collect8 = list.stream()
                .collect(Collectors.toMap(Dog::getName, Function.identity(), (existing, replacement) -> replacement));

        System.out.println(collect8);
        // list为null                              →  NPE
        // list为empty                             →  {}
        // model存在null                           →  NPE
        // key为null则null作为key                   →  {null=Dog(name=null, age=20), John=Dog(name=John, age=18)}
        // value为null                             →  {Tom=Dog(name=Tom, age=18), John=Dog(name=John, age=null)}
        // Key重复时采用定制化规则(e1, e2) -> e1      →  {Tom=Dog(name=Tom, age=22)}
        // value重复收集不去重                       →  {Tom=Dog(name=Tom, age=18), John=Dog(name=John, age=18)}
    }

    @Test
    public void toMap_replacement2() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
//        list.add(new Dog("John", null));
        list.add(new Dog("Tom", 18));
//        list.add(new Dog("Tom", 22));
//        list.add(new Dog(null, 20));
//        list.add(null);

        Map<String, Integer> collect9 = list.stream()
                .collect(Collectors.toMap(Dog::getName, Dog::getAge, (existing, replacement) -> replacement));


        System.out.println(collect9);
        // list为null                              →  NPE
        // list为empty                             →  {}
        // model存在null                           →  NPE
        // key为null则null作为key                   →  {null=20, John=18}
        // value存在null                           →  NPE
        // key重复时采用定制化规则(e1, e2) -> e1      →  {Tom=22}
        // value重复收集不去重                       →  {Tom=18, John=18}
    }

    @Test
    public void dddd() {
//        List<Dog> list = null;
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("John", 18));
//        list.add(new Dog("John", null));
        list.add(new Dog("Tom", 18));
//        list.add(new Dog("Tom", 22));
//        list.add(new Dog(null, 20));
//        list.add(null);

        Map<String, Integer> collect10 = list.stream()
                .collect(HashMap::new, (map1, per) -> map1.put(per.getName(), per.getAge()), HashMap::putAll);

        System.out.println(collect10);
        // list为null                      →  NPE
        // list为empty                     →  {}
        // model存在null                   →  NPE
        // key为null则null作为key           →  {null=20, John=18}
        // value存在null                   →  {Tom=18, John=null}
        // Key重复时value被后面的值替换       →  {Tom=22}
        // value重复收集不去重               →  {Tom=18, John=18}
    }
}
