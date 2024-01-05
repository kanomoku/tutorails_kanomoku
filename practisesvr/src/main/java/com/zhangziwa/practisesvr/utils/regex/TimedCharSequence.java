package com.zhangziwa.practisesvr.utils.regex;

import java.util.regex.Pattern;

public final class TimedCharSequence implements CharSequence {
    private final CharSequence sequence;
    private final long timestamp;

    public TimedCharSequence(CharSequence sequence, long nanoseconds) {
        this.sequence = sequence;
        this.timestamp = System.nanoTime() + nanoseconds;
    }

    @Override
    public String toString() {
        return sequence.toString();
    }

    @Override
    public int length() {
        return sequence.length();
    }

    @Override
    public char charAt(int index) {
        if (timestamp < System.nanoTime()) {
            throw new IllegalStateException("Regex match timeout");
        }
        return sequence.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return sequence.subSequence(start, end);
    }

    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        long start = System.nanoTime();
        Pattern.compile("^(a+)+$").matcher(str).matches();
        System.out.println(((System.nanoTime() - start)) + " nano seconds");

        long start1 = System.nanoTime();
        try {
            Pattern.compile("^(a+)+$").matcher(new TimedCharSequence(str, 10_000)).matches();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(((System.nanoTime() - start1)) + " nano seconds");
    }
}
