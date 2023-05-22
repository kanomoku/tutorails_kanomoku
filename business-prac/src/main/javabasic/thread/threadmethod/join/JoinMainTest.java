package thread.threadmethod.join;

public class JoinMainTest {
    public static void main(String[] args){
//        normal();

//        TwoInOne();

//        TwoJoinOne();

        synchronizedJoin();
    }

    private static void synchronizedJoin() {
        JoinLockThreadOne one = new JoinLockThreadOne();
        one.start();
    }

    /**
     * 两个线程合并成一个线程
     */
    private static void TwoJoinOne() {
        TaskTwoJoinOne one = new TaskTwoJoinOne();
        one.start();
    }

    /**
     * 保证two在one后面执行
     */
    private static void TwoInOne() {
        TaskTwoInOne one = new TaskTwoInOne();
        one.start();
    }

    /**
     * 线程one和线程two是交替执行的,但是不一定谁先启动
     */
    private static void normal() {
        TaskOne one = new TaskOne();
        TaskTwo two = new TaskTwo();
        one.start();
        two.start();
    }
}
