package designPattern.patterns13_InterpreterDesignPattern.IExpression;

import designPattern.patterns13_InterpreterDesignPattern.Context.InterpreterContext;

public interface IExpression {

	String interpret(InterpreterContext interpreterContext);
}
