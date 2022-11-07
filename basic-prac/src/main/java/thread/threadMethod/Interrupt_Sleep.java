package thread.threadMethod;


public class Interrupt_Sleep extends Object{  
    public static void main(String[] args){  
        Thread t = Thread.currentThread();  
        System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());  
        //待决中断，中断自身  
        t.interrupt();  
        System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());  
        System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());  
  
        try{  
            Thread.sleep(2000);  //而一旦调用sleep（）方法 便抛出异常，它将清空中断标志，此时isInterrupted（）方法将返回false。
            System.out.println("was NOT interrupted");  
        }catch( InterruptedException x){  
            x.printStackTrace();
            System.out.println("was interrupted");  
        }  
        //抛出异常后，会清除中断标志，这里会返回false  
        System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());  
    }  
}
