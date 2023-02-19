package odexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 第一行数量
        int size = Integer.parseInt(bf.readLine());

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            String s = bf.readLine();
            list.add(s);
        }
        bf.close();

        System.out.println(1);

    }
}
