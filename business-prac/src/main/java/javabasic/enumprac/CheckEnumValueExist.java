package javabasic.enumprac;

import lombok.Data;

import java.util.Arrays;
import java.util.Optional;

public class CheckEnumValueExist {
    public enum Direction {
        EAST, WEST, SOUTH, NORTH;

        public static Direction findByName(String name) {
            Direction result = null;
            for (Direction direction : Direction.values()) {
                if (direction.name().equalsIgnoreCase(name)) {
                    result = direction;
                    break;
                }
            }
            return result;
        }
    }


    public enum Weekday {
        MONDAY("Monday"), TUESDAY("Tuesday"), SUNDAY("Sunday");

        private final String value;

        Weekday(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Weekday findByValue(String value) {
            Weekday result = null;
            for (Weekday day : Weekday.values()) {
                if (day.getValue().equalsIgnoreCase(value)) {
                    result = day;
                    break;
                }
            }
            return result;
        }
    }

    public enum Month {
        JANUARY("January", 1),
        FEBRUARY("February", 2),
        // ...
        DECEMBER("December", 12);

        private final String value;
        private final int code;

        Month(String value, int code) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static Optional<Month> findByCode(int code) {
            return Arrays.stream(values()).filter(month -> month.getCode() == code).findFirst();
        }

        public static Month findByValue(String value) {
            return Arrays.stream(values()).filter(month -> month.getValue().equalsIgnoreCase(value)).findFirst().orElseThrow(IllegalArgumentException::new);
        }
    }

    public static void main(String[] args) {
//        findByName();
//        findByValue();
//        findByCode();
        Month.findByValue("Jan");
    }

    private static void findByCode() {
        Optional<Month> result = Month.findByCode(1);
        System.out.println(Month.JANUARY == result.orElseGet(() -> null)); // true

        Optional<Month> result2 = Month.findByCode(0);
        System.out.println(result2.orElseGet(() -> null)); // null
    }

    private static void findByValue() {
        Weekday result1 = Weekday.findByValue("Monday");
        System.out.println(Weekday.MONDAY == result1); // true

        Weekday result2 = Weekday.findByValue("mon"); // null
        System.out.println(result2);
    }

    private static void findByName() {
        Direction result1 = Direction.findByName("EAST");
        Direction result2 = Direction.findByName("east");
        Direction result3 = Direction.findByName("East");
        System.out.println(Direction.EAST == result1); // true
        System.out.println(Direction.EAST == result2); // true
        System.out.println(Direction.EAST == result3); // true
    }
}
