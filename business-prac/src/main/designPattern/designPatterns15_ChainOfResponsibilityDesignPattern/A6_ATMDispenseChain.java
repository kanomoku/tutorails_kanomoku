package designPattern.designPatterns15_ChainOfResponsibilityDesignPattern;

import java.util.Scanner;

public class A6_ATMDispenseChain {

	private A2_DispenseChain c1;

	public A6_ATMDispenseChain() {
		// initialize the chain
		this.c1 = new A3_Dollar50Dispenser();
		A2_DispenseChain c2 = new A4_Dollar20Dispenser();
		A2_DispenseChain c3 = new A5_Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}
	public static void main(String[] args) {
		A6_ATMDispenseChain atmDispenser = new A6_ATMDispenseChain();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			atmDispenser.c1.dispense(new A1_Currency(amount));
		}
	}
}

