package commonscenarios;

import commonscenarios.model.Person;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonScenarios {
    @Test
    public void sum() {
        int[] ints = new int[]{1, 2, 3};
        int sum = Arrays.stream(ints).sum(); // 1+2+3=6

        int sum1 = Stream.of(1, 2, 2, 4, 4).mapToInt(Integer::intValue).limit(3).sum(); // 1+2+2=5

        int sum2 = Stream.of(1, 2, 2, 4, 4).mapToInt(Integer::intValue).skip(2).limit(3).sum(); // 2+4+4=10

        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);
    }

    @Test
    public void count() {
        long count = Arrays.stream("a,b,c,a".split(",")).filter("a"::equals).count(); // 2

        System.out.println(count);
    }

    @Test
    public void max() {
        int[] ints = new int[]{1, 2, 3};

        int max = Arrays.stream(ints).max().getAsInt(); // 3

        int min = Arrays.stream(ints).min().getAsInt(); // 1

        double average = Arrays.stream(ints).average().getAsDouble(); // 2.0

        System.out.println(max);
        System.out.println(min);
        System.out.println(average);
    }

    @Test
    public void getFirst() {
        List<String> list = new ArrayList<>();
        String str = list.stream().findFirst().orElse(null);

        System.out.println(str);
    }

    @Test
    public void getkth() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(111);
        list.add(1111);

        Integer integer = list.stream().sorted(Comparator.reverseOrder()).skip(3).limit(1).findFirst().orElse(0); // 1
        System.out.println(integer);

        list.stream().sorted(Comparator.reverseOrder()).skip(3).limit(1).forEach(System.out::println); // 1
    }

    @Test
    public void filter() {
        List<Integer> list22 = new ArrayList<>();
        Arrays.stream("1,2,3,4,5".split(",")).mapToInt(Integer::parseInt).max().ifPresent(list22::add); // [5]

        List<String> list33 = new ArrayList<>();
        Arrays.stream("a,b,c,a,a,a".split(",")).filter("a"::equals).findAny().ifPresent(list33::add); // [a]

        List<String> list44 = new ArrayList<>();
        Arrays.stream("a,b,c,a".split(",")).filter("a"::equals).findFirst().ifPresent(list44::add); // [a]

        List<Person> list = new ArrayList<>();
        list.add(new Person("John", 18, "1234567"));
        List<String> list55 = list.stream().map(Person::getName).collect(Collectors.toList()); // [John]

        System.out.println(list22);
        System.out.println(list33);
        System.out.println(list44);
        System.out.println(list55);
    }

    @Test
    public void safety() {
        List<Person> list = new ArrayList<>();
        List<String> collect = Optional.ofNullable(list).orElse(new ArrayList<>()).stream().map(Person::getName).collect(Collectors.toList());
    }

    @Test
    public void allMatch() {
        // 任意满足
        List<Person> list = new ArrayList<>();
        boolean present1 = list.stream().filter(a -> a.getAge() > 10).findAny().isPresent();

        boolean present2 = list.stream().anyMatch(a -> a.getAge() > 10);

        // 全部满足
        boolean present3 = list.stream().allMatch(a -> a.getAge() > 10);

        Boolean high = true;
        Boolean rich = true;
        Boolean cool = true;
        boolean b = Stream.of(high, rich, cool).allMatch(BooleanUtils::isTrue);

        // 全不满足
        boolean present4 = list.stream().noneMatch(a -> a.getAge() > 10);
    }

    @Test
    public void unionCollection() {
        // Map
        Map<String, List<Person>> map = new HashMap<>();
        List<Person> collect1 = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());

        // List
        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        List<Person> collect2 = Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList());

        List<Person> collect3 = Stream.of(list1.stream(), list2.stream()).flatMap(Function.identity()).collect(Collectors.toList());
    }

    @Test
    public void buildModel() {
        // 素材
        Map<String, List<Person>> map = new HashMap<>();
        // 结果
        List<Person> res = new ArrayList<>();

        // 构造Model
        map.forEach((name, persons) -> {
            if (persons != null && persons.size() > 0) {
                persons.forEach(person -> {
                    Person per = new Person();
                    per.setName(name);
                    per.setAge(person.getAge());
                    per.setNumber(person.getNumber());
                    res.add(per);
                });
            }
        });
    }

    public static void flatten(String[] args) {
        Object[] arr = {1, 2, new Object[]{1, 2, 44}, 4};
        Object[] arr1 = java8Flatten(arr).toArray();                                                // [1, 2, 1, 2, 44, 4]
        Object[] arr2 = java8Flatten(arr).map(String::valueOf).toArray();                           // [1, 2, 1, 2, 44, 4]
        String[] arr3 = java8Flatten(arr).map(String::valueOf).toArray(String[]::new);              // [1, 2, 1, 2, 44, 4]
        List<String> arr4 = java8Flatten(arr).map(String::valueOf).collect(Collectors.toList());    // [1, 2, 1, 2, 44, 4]
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr4);
    }

    /**
     * 展平嵌套数组
     */
    public static Stream<Object> java8Flatten(Object[] arr) {
        return Arrays.stream(arr).flatMap(obj -> obj instanceof Object[] ? java8Flatten((Object[]) obj) : Stream.of(obj));
    }

    /**
     * Bean列表根据Bean的某个属性去重
     */
    public static List<Person> distinctByName(List<Person> list) {
        return list.stream().filter(distinctByKey(Person::getName)).toList();
    }

    /**
     * Bean列表根据Bean的某个属性去重
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> function) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        // map.putIfAbsent,先判断指定的key是否存在
        // 如果所指定的key已经在HashMap中存在,则返回和这个key值对应的value,
        // 如果所指定的key在HashMap中不存在,则返回null,然后将键/值对插入到HashMap中
        // 注意：如果指定key之前已经和一个null值相关联了,则该方法也返回null,此时无法确认是不存在这个key,还是存在这个key只是value为null.
        return item -> map.putIfAbsent(function.apply(item), Boolean.TRUE) == null;
    }

    @Test
    public void testDistinctByKey() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("John", 11, "boy"));
        persons.add(new Person("John1", 11, "boy"));
        persons.add(new Person("John1", 11, "boy"));
        persons.add(new Person("John1", 11, "boy"));
        persons.add(new Person("John1", 11, "boy"));
        persons.add(new Person("John1", 11, "boy"));
        persons.add(new Person("John1", 11, "boy"));
        persons.add(new Person("John1", 11, "boy "));
        List<Person> people = distinctByName(persons);
        System.out.println(people);
    }

    @Test
    public void testPutIfAbsent() {
        Map<Object, Boolean> map = new HashMap<>();
        System.out.println(map); // {}

        Boolean value1 = map.putIfAbsent("key1", true);
        System.out.println(value1); // null, map不存在key1故返回null
        System.out.println(map); // {value=true}

        Boolean value2 = map.put("key2", true); // null key2上个值为null，故返回null
        System.out.println(value2);
        System.out.println(map); // {key1=true, key2=true}

        Boolean value3 = map.put("key2", null); // true key2上个值为true，故返回true
        System.out.println(value3);
        System.out.println(map); // {key1=true, key2=null}


        Boolean value4 = map.putIfAbsent("key2", null); // map存在key2=null，故返回null
        System.out.println(value4); // null
        System.out.println(map); // {key1=true, key2=null}

        Boolean value5 = map.putIfAbsent("key3", true); // map存在key3，故返回null
        System.out.println(value5); // null
        System.out.println(map); // {key1=true, key2=null, key3=true}
        // 注意：如果指定key之前已经和一个null值相关联了,则该方法也返回null,此时无法确认是不存在这个key,还是存在这个key只是value为null.如value4和value5
    }
}
