package thread.thread3Implement;

/**
 * @author Administrator
 */
public class A_extends_RunningMan extends Thread {
    private String threadTaskName;

    public A_extends_RunningMan() {
    }

    public A_extends_RunningMan(String name) {
        this.threadTaskName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("线程ID: ")
                    .append(Thread.currentThread().getId())
                    .append(" ")
                    .append("线程Name: ")
                    .append(Thread.currentThread().getName())
                    .append(" ")
                    .append(threadTaskName)
                    .append(" 跑到第")
                    .append(i)
                    .append("米啦");
            System.out.println(sb);
        }
    }
}