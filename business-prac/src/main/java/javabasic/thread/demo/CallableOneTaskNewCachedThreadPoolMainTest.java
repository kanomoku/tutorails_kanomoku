package thread.demo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableOneTaskNewCachedThreadPoolMainTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            results.add(exec.submit(new CallableOneTask("线程" + i)));
        }

        exec.shutdown();

        for (Future<String> fs : results) {
            while (!fs.isDone()) {
                Thread.sleep(500);
                System.out.println("Future result is not yet complete");
            }
            System.out.println(fs.get());
        }
    }
}
