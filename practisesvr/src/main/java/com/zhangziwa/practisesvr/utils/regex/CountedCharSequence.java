package com.zhangziwa.practisesvr.utils.regex;

import java.util.regex.Pattern;

public class CountedCharSequence implements CharSequence {
    private final CharSequence charSequence;
    private long count;

    public CountedCharSequence(CharSequence charSequence, long count) {
        this.charSequence = charSequence;
        this.count = count;
    }

    @Override
    public String toString() {
        return charSequence.toString();
    }

    @Override
    public int length() {
        return charSequence.length();
    }

    @Override
    public char charAt(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Regex match over max " + count + " times");
        }
        count--;
        return charSequence.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return charSequence.subSequence(start, end);
    }

    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        long start = System.nanoTime();
        boolean matches = Pattern.compile("^(a+)+$").matcher(str).matches();
        System.out.println(((System.nanoTime() - start)) + " nano seconds");

        long start1 = System.nanoTime();
        try {
            Pattern.compile("^(a+)+$").matcher(new CountedCharSequence(str, 100_000_000)).matches();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(((System.nanoTime() - start1)) + " nano seconds");
    }
}
