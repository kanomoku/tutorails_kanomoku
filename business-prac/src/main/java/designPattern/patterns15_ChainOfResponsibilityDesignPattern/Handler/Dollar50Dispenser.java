package designPattern.patterns15_ChainOfResponsibilityDesignPattern.Handler;

import designPattern.patterns15_ChainOfResponsibilityDesignPattern.bean.Currency;

public class Dollar50Dispenser implements IDispenseChain {
    private IDispenseChain chain;

    @Override
    public void setNextChain(IDispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 50) {
            int num = cur.getAmount() / 50;
            int remainder = cur.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50$ note");

            if (remainder != 0) {
                chain.dispense(new Currency(remainder));
            }
        } else {
            chain.dispense(cur);
        }
    }
}
