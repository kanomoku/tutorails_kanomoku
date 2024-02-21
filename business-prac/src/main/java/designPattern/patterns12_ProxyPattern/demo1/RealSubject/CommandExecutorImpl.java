package designPattern.patterns12_ProxyPattern.demo1.RealSubject;

import designPattern.patterns12_ProxyPattern.demo1.ISubject.ICommandExecutor;

import java.io.IOException;

public class CommandExecutorImpl implements ICommandExecutor {

    @Override
    public void runCommand(String cmd) throws IOException {
        // some heavy implementation
        // Runtime.getRuntime().exec(cmd);
        System.out.println(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }
}
