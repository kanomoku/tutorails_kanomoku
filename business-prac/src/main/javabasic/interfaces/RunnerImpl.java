package interfaces;

interface Runner1 {
    default void run() {
        System.out.println("default Runner1::run");
    }
}

interface Runner2 {
    default void run() {
        System.out.println("default Runner2::run");
    }
}

class RunnerImpl implements Runner1, Runner2 {
    public void run() {
        Runner1.super.run(); // which one???
    }

    public static void main(String[] args) {
        RunnerImpl runner = new RunnerImpl();
        runner.run();
    }
}
