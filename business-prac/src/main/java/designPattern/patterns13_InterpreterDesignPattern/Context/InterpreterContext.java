package designPattern.patterns13_InterpreterDesignPattern.Context;

public class InterpreterContext {

    public String getBinaryFormat(int intNum) {
        return Integer.toBinaryString(intNum);
    }

    public String getHexadecimalFormat(int intNum) {
        return Integer.toHexString(intNum);
    }
}

