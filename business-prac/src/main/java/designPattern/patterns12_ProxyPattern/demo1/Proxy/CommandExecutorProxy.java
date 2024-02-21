package designPattern.patterns12_ProxyPattern.demo1.Proxy;

import designPattern.patterns12_ProxyPattern.demo1.ISubject.ICommandExecutor;
import designPattern.patterns12_ProxyPattern.demo1.RealSubject.CommandExecutorImpl;

public class CommandExecutorProxy implements ICommandExecutor {

    private boolean isAdmin;
    private ICommandExecutor executor;

    public CommandExecutorProxy(String user, String pwd) {
        if ("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) {
            isAdmin = true;
        }
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        //权限管理
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }
}
