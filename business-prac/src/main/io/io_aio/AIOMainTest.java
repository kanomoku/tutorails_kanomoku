package io.io_aio;

import java.util.Scanner;

public class AIOMainTest {
    public static void main(String[] args) {
        AIOClient client = new AIOClient("localhost", 9999);
        try {
            System.out.print("enter message send to server > ");
            Scanner s = new Scanner(System.in);
            String line = s.nextLine();
            client.write(line);

            client.read();
        } finally {
            client.doDestroy();
        }
    }
}
