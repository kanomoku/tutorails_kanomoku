package designPattern.designPatterns12_ProxyPattern;

public class A3_CommandExecutorProxy implements A1_CommandExecutor {

	private boolean isAdmin;
	private A1_CommandExecutor executor;

	public A3_CommandExecutorProxy(String user, String pwd) {
		if ("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) {
			isAdmin = true;
		}
		executor = new A2_CommandExecutorImpl();
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
