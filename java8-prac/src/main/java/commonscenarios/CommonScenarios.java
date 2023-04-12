package commonscenarios;

import commonscenarios.model.Person;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonScenarios {
    @Test
    public void sum() {
        int[] ints = new int[]{1, 2, 3};
        int sum = Arrays.stream(ints)
                .sum(); // 1+2+3=6

        int sum1 = Stream.of(1, 2, 2, 4, 4).mapToInt(Integer::intValue)
                .limit(3)
                .sum(); // 1+2+2=5

        int sum2 = Stream.of(1, 2, 2, 4, 4).mapToInt(Integer::intValue)
                .skip(2)
                .limit(3)
                .sum(); // 2+4+4=10

        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);
    }

    @Test
    public void count() {
        long count = Arrays.stream("a,b,c,a".split(","))
                .filter("a"::equals)
                .count(); // 2

        System.out.println(count);
    }

    @Test
    public void max() {
        int[] ints = new int[]{1, 2, 3};

        int max = Arrays.stream(ints)
                .max().getAsInt(); // 3

        int min = Arrays.stream(ints)
                .min().getAsInt(); // 1

        double average = Arrays.stream(ints)
                .average().getAsDouble(); // 2.0

        System.out.println(max);
        System.out.println(min);
        System.out.println(average);
    }

    @Test
    public void getFirst() {
        List<String> list = new ArrayList<>();
        String str = list.stream()
                .findFirst()
                .orElse(null);

        System.out.println(str);
    }

    @Test
    public void getkth() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(111);
        list.add(1111);

        Integer integer = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(3)
                .limit(1)
                .findFirst()
                .orElse(0); // 1

        list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(3)
                .limit(1)
                .forEach(System.out::println); // 1

        System.out.println(integer);
    }

    @Test
    public void filter() {
        List<Integer> list22 = new ArrayList<>();
        Arrays.stream("1,2,3,4,5".split(",")).mapToInt(Integer::parseInt)
                .max()
                .ifPresent(list22::add); // [5]

        List<String> list33 = new ArrayList<>();
        Arrays.stream("a,b,c,a,a,a".split(","))
                .filter("a"::equals)
                .findAny()
                .ifPresent(list33::add); // [a]

        List<String> list44 = new ArrayList<>();
        Arrays.stream("a,b,c,a".split(","))
                .filter("a"::equals)
                .findFirst()
                .ifPresent(list44::add); // [a]

        List<Person> list = new ArrayList<>();
        list.add(new Person("John", 18, "1234567"));
        List<String> list55 = list.stream()
                .map(Person::getName)
                .collect(Collectors.toList()); // [John]

        System.out.println(list22);
        System.out.println(list33);
        System.out.println(list44);
        System.out.println(list55);
    }

    @Test
    public void safety() {
        List<Person> list = new ArrayList<>();
        List<String> collect = Optional.ofNullable(list)
                .orElse(new ArrayList<>())
                .stream().map(Person::getName).collect(Collectors.toList());
    }

    @Test
    public void allMatch() {
        // 任意满足
        List<Person> list = new ArrayList<>();
        boolean present1 = list.stream().filter(a -> a.getAge() > 10)
                .findAny().isPresent();

        boolean present2 = list.stream()
                .anyMatch(a -> a.getAge() > 10);

        // 全部满足
        boolean present3 = list.stream()
                .allMatch(a -> a.getAge() > 10);

        Boolean high = true;
        Boolean rich = true;
        Boolean cool = true;
        boolean b = Stream.of(high, rich, cool).allMatch(BooleanUtils::isTrue);

        // 全不满足
        boolean present4 = list.stream()
                .noneMatch(a -> a.getAge() > 10);
    }

    @Test
    public void unionCollection() {
        // Map
        Map<String, List<Person>> map = new HashMap<>();
        List<Person> collect1 = map.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // List
        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        List<Person> collect2 = Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<Person> collect3 = Stream.of(list1.stream(), list2.stream())
                .flatMap(Function.identity())
                .collect(Collectors.toList());
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

}
