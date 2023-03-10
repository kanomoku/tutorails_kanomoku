package designPattern.designPatterns21_StatePattern;

public class A3_TVStartState implements A2_State {

	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}
}
