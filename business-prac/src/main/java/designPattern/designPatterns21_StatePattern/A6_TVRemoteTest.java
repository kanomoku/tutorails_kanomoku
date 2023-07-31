package designPattern.designPatterns21_StatePattern;

public class A6_TVRemoteTest {

	public static void main(String[] args) {
		A5_TVContext context = new A5_TVContext();
		A2_State tvStartState = new A3_TVStartState();
		A2_State tvStopState = new A4_TVStopState();
		
		context.setState(tvStartState);
		context.doAction();
		
		
		context.setState(tvStopState);
		context.doAction();
	}
}
