package method;

import org.junit.Test;

import java.util.Objects;

public class Position {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = Integer.MAX_VALUE;
    public static final int START_POSITION = MAX_POSITION / 2;
    public static final int IDEAL_INTERVAL = 50;

    @Test public void instantBuild() {
        System.out.println(MIN_POSITION);
        System.out.println(MAX_POSITION);
        System.out.println(START_POSITION);
    }

    /**
     * 在两个Position中间取一个合理的Position
     */
    private Integer getPositionBetween(Integer begin, Integer end) {
        if (Objects.isNull(begin)) {
            begin = MIN_POSITION;
        }
        if (Objects.isNull(end)) {
            begin = MAX_POSITION;
        }

        // 智能调序
        if (end < begin) {
            Integer temp = begin;
            begin = end;
            end = temp;
        }

        // 两个Integer的平均值肯定是Integer、所以不会溢出
        long averageLong = (Long.valueOf(begin) + Long.valueOf(end)) / 2;
        Integer average = Math.toIntExact(averageLong);

        int diatance = end - average;

        if (diatance < IDEAL_INTERVAL) {
            // 如果两个位置中间不够200、使用平均值作为新的Position
            return average;
        } else if (MIN_POSITION == begin) {
            // 有MIN_POSITION、表示前面没值、这是从后往前取位置、直接减去100即可
            return end - IDEAL_INTERVAL;
        } else if (MAX_POSITION == end) {
            // 有MAX_POSITION、表示后面没值、这是从前往后取位置、直接加上100即可
            return begin + IDEAL_INTERVAL;
        } else {
            // 此时表示传递进来两个合理的位置、新位置为他们的平均值
            return average;
        }
    }

    /**
     * 往后取一个新的Position
     */
    public Integer moveToEnd(Integer position) {
        if (Objects.isNull(position)) {
            position = START_POSITION;
        }
        return this.getPositionBetween(position, MAX_POSITION);
    }

    /**
     * 往前取一个新的Position
     */
    public Integer moveToStart(Integer position) {
        if (Objects.isNull(position)) {
            position = START_POSITION;
        }
        return this.getPositionBetween(MAX_POSITION, position);
    }
}
