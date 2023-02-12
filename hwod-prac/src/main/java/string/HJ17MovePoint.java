package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ17 坐标移动
 */
public class HJ17MovePoint {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        List<String> strs = Arrays.stream(str.split(";")).collect(Collectors.toList());

        List<String> actions = strs.stream()
                .filter(a -> a != null && a.length() > 0)
                .filter(word -> word.matches("[WASD][0-9]{1,2}"))
                .collect(Collectors.toList());

        int[] location = {0, 0};
        for (String action : actions) {
            String act = action.substring(0, 1);
            int actStep = parseInt(action.substring(1));
            if ("A".equals(act)) {
                location[0] = location[0] - actStep;
                location[1] = location[1];
            } else if ("D".equals(act)) {
                location[0] = location[0] + actStep;
                location[1] = location[1];
            } else if ("W".equals(act)) {
                location[0] = location[0];
                location[1] = location[1] + actStep;
            } else if ("S".equals(act)) {
                location[0] = location[0];
                location[1] = location[1] - actStep;
            }
        }
        String res = Arrays.stream(location).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(res);
    }
}
