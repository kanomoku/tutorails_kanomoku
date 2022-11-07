package thread.xiancheng_Producer_Consumer;

import java.util.ArrayList;

public class Warehouse {
    // 仓库里面的集合 存放元素
    private ArrayList<String> list = new ArrayList<>();

    // 向集合中添加元素
    public synchronized void add() {
        if (list.size() < 20) {
            list.add("a");
            System.out.println(Thread.currentThread().getName()+"：生产1件货物以后，仓库有 " + list.size()+"件货物");
        } else {
            System.out.println(Thread.currentThread().getName()+ "：仓库有多余20件货物，所以不生产了");
            return;// 结束方法
//            try{
//                this.notifyAll();
//                this.wait(); //生产者线程
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
        }
    }

    // 从集合中获取元素的方法
    public synchronized void get() {
        if (list.size() > 0) {
            list.remove(0);
            System.out.println(Thread.currentThread().getName()+"：取走1件货物以后，仓库有 " + list.size()+"件货物");
        } else {
            System.out.println(Thread.currentThread().getName() + "：仓库有没货物，所以不取了");
            return;// 结束方法
//            try{
//                this.notifyAll();
//                this.wait(); //消费者线程
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
        }
    }
}
