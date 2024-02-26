package designPattern.patterns15_ChainOfResponsibilityDesignPattern;

import designPattern.patterns15_ChainOfResponsibilityDesignPattern.Handler.Dollar10Dispenser;
import designPattern.patterns15_ChainOfResponsibilityDesignPattern.Handler.Dollar20Dispenser;
import designPattern.patterns15_ChainOfResponsibilityDesignPattern.Handler.Dollar50Dispenser;
import designPattern.patterns15_ChainOfResponsibilityDesignPattern.Handler.IDispenseChain;
import designPattern.patterns15_ChainOfResponsibilityDesignPattern.bean.Currency;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // initialize the chain
        IDispenseChain c1 = new Dollar50Dispenser();
        IDispenseChain c2 = new Dollar20Dispenser();
        IDispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);

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
            c1.dispense(new Currency(amount));
        }
    }
}

