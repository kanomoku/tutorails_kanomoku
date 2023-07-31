package designPattern.designPatterns12_ProxyPattern;

import java.io.IOException;

public class A2_CommandExecutorImpl implements A1_CommandExecutor {

	@Override
	public void runCommand(String cmd) throws IOException {
		// some heavy implementation
		// Runtime.getRuntime().exec(cmd);
		System.out.println(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}
}
