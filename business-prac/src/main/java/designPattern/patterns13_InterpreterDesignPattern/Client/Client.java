package designPattern.patterns13_InterpreterDesignPattern.Client;

import designPattern.patterns13_InterpreterDesignPattern.Context.InterpreterContext;
import designPattern.patterns13_InterpreterDesignPattern.IExpression.IExpression;
import designPattern.patterns13_InterpreterDesignPattern.IExpression.IntToBinaryExpression;
import designPattern.patterns13_InterpreterDesignPattern.IExpression.IntToHexExpression;

public class Client {

    private final InterpreterContext interpreterContext;

    public Client(InterpreterContext interpreterContext) {
        this.interpreterContext = interpreterContext;
    }

    public String interpret(String str) {
        IExpression exp;
        int intNum = Integer.parseInt(str.substring(0, str.indexOf(" ")));

        if (str.contains("Hexadecimal")) {
            exp = new IntToHexExpression(intNum);
        } else if (str.contains("Binary")) {
            exp = new IntToBinaryExpression(intNum);
        } else {
            return str;
        }
        return exp.interpret(interpreterContext);
    }
}

