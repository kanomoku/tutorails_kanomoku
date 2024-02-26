package designPattern.patterns15_ChainOfResponsibilityDesignPattern.Handler;

import designPattern.patterns15_ChainOfResponsibilityDesignPattern.bean.Currency;

public interface IDispenseChain {

    //给自己指定一个背锅的
    void setNextChain(IDispenseChain nextChain);

    //自己处理
    void dispense(Currency cur);
}
