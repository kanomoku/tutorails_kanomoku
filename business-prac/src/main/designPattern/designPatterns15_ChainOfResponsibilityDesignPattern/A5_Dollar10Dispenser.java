package designPattern.designPatterns15_ChainOfResponsibilityDesignPattern;

public class A5_Dollar10Dispenser implements A2_DispenseChain {

	private A2_DispenseChain chain;

	@Override
	public void setNextChain(A2_DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(A1_Currency cur) {
		if (cur.getAmount() >= 10) {
			int num = cur.getAmount() / 10;
			int remainder = cur.getAmount() % 10;
			System.out.println("Dispensing " + num + " 10$ note");
			if (remainder != 0)
				this.chain.dispense(new A1_Currency(remainder));
		} else {
			this.chain.dispense(cur);
		}
	}
}
