package designPattern.patterns13_InterpreterDesignPattern.IExpression;

import designPattern.patterns13_InterpreterDesignPattern.Context.InterpreterContext;

public class IntToBinaryExpression implements IExpression {

    private final int intNum;

    public IntToBinaryExpression(int intNum) {
        this.intNum = intNum;
    }

    @Override
    public String interpret(InterpreterContext interpreterContext) {
        return interpreterContext.getBinaryFormat(this.intNum);
    }
}

