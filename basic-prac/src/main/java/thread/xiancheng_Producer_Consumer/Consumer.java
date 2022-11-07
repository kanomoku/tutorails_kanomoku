package thread.xiancheng_Producer_Consumer;

// 消费者
class Consumer extends Thread {
    // 消费者的方法 一直从仓库里拿
    private Warehouse warehouse;


    public Consumer(Warehouse warehouse,String name) {
        this.warehouse = warehouse;
        super.setName(name);
    }

    public void run() {
        while (true) {
            warehouse.get();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}