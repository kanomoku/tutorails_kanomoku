package designPattern.patterns12_ProxyPattern.demo1;

import designPattern.patterns12_ProxyPattern.demo1.ISubject.ICommandExecutor;
import designPattern.patterns12_ProxyPattern.demo1.Proxy.CommandExecutorProxy;
import org.junit.Test;

public class Main {

    @Test
    public void test1() {
        ICommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}
