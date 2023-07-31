package designPattern.designPatterns15_ChainOfResponsibilityDesignPattern;

public class A3_Dollar50Dispenser implements A2_DispenseChain {
	private A2_DispenseChain chain;

	@Override
	public void setNextChain(A2_DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(A1_Currency cur) {
		if (cur.getAmount() >= 50) {
			int num = cur.getAmount() / 50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing " + num + " 50$ note");
			if (remainder != 0)
				this.chain.dispense(new A1_Currency(remainder));
		} else {
			this.chain.dispense(cur);
		}
	}
}
