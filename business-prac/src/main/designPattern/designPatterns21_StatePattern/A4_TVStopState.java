package designPattern.designPatterns21_StatePattern;

public class A4_TVStopState implements A2_State {

	@Override
	public void doAction() {
		System.out.println("TV is turned OFF");
	}
}