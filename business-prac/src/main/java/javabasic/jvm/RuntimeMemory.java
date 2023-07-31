package jvm;

public class RuntimeMemory {
    public static void main(String[] args) {
        printRuntime();

        byte[] b1 = new byte[3 * 1024 * 1024];
        printRuntime();

        byte[] b2 = new byte[4 * 1024 * 1024];
        printRuntime();

    }

    private static void printRuntime() {
        System.out.println("java虚拟机从操纵系统那里挖到的最大的内存   maxMemory " + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("java虚拟机已经从操作系统那里挖过来的内存   totalMemory : " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        System.out.println("java虚拟机从操纵系统挖过来还没用上的内存   freeMemory : " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
