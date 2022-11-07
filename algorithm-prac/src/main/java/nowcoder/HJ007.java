package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ7 取近似值
 */
public class HJ007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // double val = Double.parseDouble(bf.readLine());
        float val = Float.parseFloat(bf.readLine());
        bf.close();

        // System.out.println((int)(val + 0.5));
        System.out.println((int)(val + 0.5));
    }
}
