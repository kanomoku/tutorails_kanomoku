package thread.xiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubmitAndExcute_ExcuteWithoutResult_MainTest {
    public static void main(String[] args) {
        // testSubmit();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService.shutdown();
    }
}
