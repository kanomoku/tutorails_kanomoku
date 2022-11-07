package thread.threadDemo;

import java.util.ArrayList;

// 仓库
public class A_extends_ProducerConsumer_Warehouse {
	// 仓库里面的集合 存放元素
	private ArrayList<String> list = new ArrayList<>();

//    // 向集合中添加元素
//    public void add() {
//        if (list.size() < 20) {
//            list.add("a");
//        } else {
//            return;// 结束方法
//        }
//    }
//
//    // 从集合中获取元素的方法
//    public void get() {
//        if (list.size() > 0) {
//            list.remove(0);
//        } else {
//            return;// 结束方法
//        }
//    }

//操作的是同一个仓库对象
//    以上代码会有如下问题：
//    两个消费者
//    线程1 判断
//    线程1 拿走
//    线程2 判断
//    线程2 拿走
//    这种情况是理想的好的状态
//
//    线程1 判断
//    线程2 判断
//    线程2 拿走
//    线程1 拿走
//    这种有可能出现数组越界--多线程出问题了
//    Exception in thread "Con2" java.lang.ArrayIndexOutOfBoundsException: -1
//1.通过这个模型--成功的演示了线程安全的问题
//    两个消费者线程同时访问一个仓库对象，而且仓库内只有一个元素的时候
//    两个消费者线程并发时会有可能产生抢夺资源的问题
//2.自己解决一下线程安全的问题
//    让仓库对象被线程访问的时候--->仓库对象被锁定--->也就是说--->仓库对象只能被一个线程访问--->其他的线程处于一种等待的状态
//    特征修饰符--synchronized--同步--一个时间点只有一个线程访问--线程锁
//            有两种形式
//	1.将synchronized关键字 放在方法的结构上
//    public synchronized void get(){}
//    锁定的是调用方法的那个对象--->如：仓库的get方法--->仓库调用这个方法--->仓库对象被锁定--->访问仓库的消费者线程把仓库给锁上了
//	2.将synchronized关键字 放在方法/构造方法的内部
//    public void get(){
//        代码块：走楼梯
//        代码块：进教室
//
//        走楼梯可以并行 进教室不行
//        写成下面的样子
//
//        代码块：走楼梯
//        synchronized(对象){
//            代码块：进教室
//        }
//    }
//============================================================================================================

//    public synchronized void add() {
//        if (list.size() < 20) {
//            list.add("a");
//            System.out.println(Thread.currentThread().getName() + " 增加完1件货物之后仓库有" + list.size() + "件货物");
//        } else {
//            System.out.println(Thread.currentThread().getName() + " 不增加货物了，因为有" + list.size() + "件货物");
//            return;// 结束方法
//        }
//    }
//
//    // 从集合中获取元素的方法
//    public synchronized void get() {
//        if (list.size() > 0) {
//            list.remove(0);
//            System.out.println(Thread.currentThread().getName() + " 拿走完1件货物之后仓库有" + list.size() + "件货物");
//        } else {
//            System.out.println(Thread.currentThread().getName() + " 不取货了，因为有" + list.size() + "件货物");
//            return;// 结束方法
//        }
//    }
//    //以上虽然是线程安全的，但是不是最高效的方式，可以参看对比的excel图
	// ============================================================================================================

//	public synchronized void add() {
//		if (list.size() < 20) {
//			list.add("a");
//			System.out.println(Thread.currentThread().getName() + " 增加完1件货物之后仓库有" + list.size() + "件货物");
//		} else {
//			try {
//				System.out.println(Thread.currentThread().getName() +"生产者线程开始休息了-----------------------------------------------------------------");
//				this.wait(); // 生产者线程
//				System.out.println(Thread.currentThread().getName() +"生产者线程开始休息了==========================================");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public synchronized void get() {
//		if (list.size() > 0) {
//			list.remove(0);
//			System.out.println(Thread.currentThread().getName() + " 拿走完1件货物之后仓库有" + list.size() + "件货物");
//
//		} else {
//			try {
//				System.out.println(Thread.currentThread().getName() +"消费者线程开始休息了-----------------------------------------------------------------");
//				this.wait(); // 消费者线程
//				System.out.println(Thread.currentThread().getName() +"消费者线程开始休息了==========================================");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
////    会出现类似假死的状态--->生产者干够了就休息--->消费者干够了就休息--->当两个人都休息时--->没人叫他们起来干活呀--->这样就假死了
	// ============================================================================================================

    public synchronized void add() {
        if (list.size() < 20) {
            list.add("a");
            System.out.println(Thread.currentThread().getName() + " 增加完1件货物之后仓库有" +
                    list.size() + "件货物");
        } else {
            try {
                System.out.println(Thread.currentThread().getName() + " 不增加货物了，因为有" +
                        list.size() + "件货物");
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void get() {
        if (list.size() > 0) {
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + " 拿走完1件货物之后仓库有" +
                    list.size() + "件货物");
        } else {
            try {
                System.out.println(Thread.currentThread().getName() + " 不取货了，因为有" +
                        list.size() + "件货物");
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//叫起来别人以后再自己睡
//        叫人如果有个优先级--->先叫起来谁的话--谁就优先抢资源
//        producer.setPriority(10);
//    事实结果也是，用wait要比return更加高效，此例子来看，Pro,con1,con2三个线程，
//    如果是return的话，给个分的时间片的概率是三分之一，其中con1和con2,还是等待，浪费时间的概率为三分之二。
//    如果是con1去wait的话，con2和producer获取时间片的概率为二分之一，那么浪费时间的概率为三分之一。

	// ============================================================================================================

//    public void add() {
//        if (list.size() < 20) {
//            list.add("a");
//            System.out.println(Thread.currentThread().getName() + " 增加完1件货物之后仓库有" +
//                    list.size() + "件货物");
//        } else {
//            try {
//                System.out.println(Thread.currentThread().getName() + " 不增加货物了，因为有" +
//                        list.size() + "件货物");
//                this.notifyAll();
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void get() {
//        if (list.size() > 0) {
//            list.remove(0);
//            System.out.println(Thread.currentThread().getName() + " 拿走完1件货物之后仓库有" +
//                    list.size() + "件货物");
//        } else {
//            try {
//                System.out.println(Thread.currentThread().getName() + " 不取货了，因为有" +
//                        list.size() + "件货物");
//                this.notifyAll();
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//如果以上情况的话，没有synchronized的话
//生产者判断如果大于20的话--要告诉生产者的线程等待--但是告诉那一刹那变成了消费者的线程--就会发生IllegalMonitorStateException
}
