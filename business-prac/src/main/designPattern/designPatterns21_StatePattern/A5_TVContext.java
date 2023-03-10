package designPattern.designPatterns21_StatePattern;

public class A5_TVContext implements A2_State {

	private A2_State tvState;

	public void setState(A2_State state) {
		this.tvState=state;
	}

	public A2_State getState() {
		return this.tvState;
	}

	@Override
	public void doAction() {
		this.tvState.doAction();
	}
}

