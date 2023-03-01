package odexam;

import java.util.Deque;
import java.util.LinkedList;

public class face1 {
    public static void main(String[] args) {

        String str = "";
        char[] chars = str.toCharArray();

        Deque<Character> stack = new LinkedList<>();
        boolean extracted = extracted(chars, stack);
        if (extracted) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean extracted(char[] chars, Deque<Character> stack) {
        if (chars.length ==0){
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[' || chars[i] == '<') {
                stack.push(chars[i]);
            } else {
                Character pop = stack.pop();
                if (!isPair(chars[i], pop)) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean isPair(Character c1, Character c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '{' && c2 == '}') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        if (c1 == '<' && c2 == '>') {
            return true;
        }
        return false;
    }

}
