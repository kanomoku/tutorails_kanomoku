package designPattern.patterns13_InterpreterDesignPattern.IExpression;

import designPattern.patterns13_InterpreterDesignPattern.Context.InterpreterContext;

public class IntToHexExpression implements IExpression {

    private final int intNum;

    public IntToHexExpression(int intNum) {
        this.intNum = intNum;
    }

    @Override
    public String interpret(InterpreterContext interpreterContext) {
        return interpreterContext.getHexadecimalFormat(intNum);
    }
}

