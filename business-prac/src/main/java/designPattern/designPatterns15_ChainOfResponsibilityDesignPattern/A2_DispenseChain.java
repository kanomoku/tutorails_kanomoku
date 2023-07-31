package designPattern.designPatterns15_ChainOfResponsibilityDesignPattern;

public interface A2_DispenseChain {

	void setNextChain(A2_DispenseChain nextChain);
	
	void dispense(A1_Currency cur);
}
