package designPattern.patterns15_ChainOfResponsibilityDesignPattern.bean;

public class Currency {

    private final int amount;

    public Currency(int amt) {
        amount = amt;
    }

    public int getAmount() {
        return amount;
    }
}

