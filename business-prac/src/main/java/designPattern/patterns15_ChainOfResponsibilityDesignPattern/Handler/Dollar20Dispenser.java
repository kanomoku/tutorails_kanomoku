package designPattern.patterns15_ChainOfResponsibilityDesignPattern.Handler;

import designPattern.patterns15_ChainOfResponsibilityDesignPattern.bean.Currency;

public class Dollar20Dispenser implements IDispenseChain {

    private IDispenseChain chain;

    @Override
    public void setNextChain(IDispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 20) {
            int num = cur.getAmount() / 20;
            int remainder = cur.getAmount() % 20;
            System.out.println("Dispensing " + num + " 20$ note");

            if (remainder != 0) {
                chain.dispense(new Currency(remainder));
            }
        } else {
            chain.dispense(cur);
        }
    }
}
