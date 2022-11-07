package thread.threadMethod;

/**
 * one启动
 * two启动
 * three启动
 * two就join到one里了
 * 2000之后one想把two从自己的线程内删除
 * two对象不在自己手里--发现对象被three线程锁定啦--而且锁定了10000
 * one只能等待--等着three将two对象释放后--才能踢掉
 */
public class Join_Lock4_TestMain {
    public static void main(String[] args) {
        Join_Lock1_ThreadOne one = new Join_Lock1_ThreadOne();
        one.start();
    }
}
//可以得到：
//        synchronized锁---非常的厉害
//        一旦对象被锁定--不释放的情况下---其他的对象都需要等待