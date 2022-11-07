package thread.xiancheng_Producer_Consumer;

// 生产者
class Producer extends Thread {
    private Warehouse warehouse;
    private int count;

    public Producer(Warehouse warehouse,String name) {
        this.warehouse = warehouse;
        super.setName(name);
    }

    // 一直向仓库添加元素
    public void run() {
        while (true) {
            warehouse.add();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}