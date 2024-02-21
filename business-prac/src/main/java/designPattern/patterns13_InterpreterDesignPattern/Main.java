package designPattern.patterns13_InterpreterDesignPattern;

import designPattern.patterns13_InterpreterDesignPattern.Client.Client;
import designPattern.patterns13_InterpreterDesignPattern.Context.InterpreterContext;

public class Main {

    public static void main(String args[]) {
        String str1 = "28 in Binary";
        String str2 = "28 in Hexadecimal";

        Client client = new Client(new InterpreterContext());
        System.out.println(str1 + "= " + client.interpret(str1));
        System.out.println(str2 + "= " + client.interpret(str2));
    }
}

