package com.zhangziwa.practisesvr.excuter.wordcount;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCount {

    public static final String SENTENCE = " Nel   mezzo  mi  ritrovai in una  selva oscura che la  dritta via era   smarrita ";

    public static void main(String[] args) {
//        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
//        System.out.println("Found " + countWords(SENTENCE) + " words");

        //  串行流执行
//        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
//        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
//        int count = wordCounter.getCount();
//        System.out.println(count);

        //  并行流执行
        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        WordCounter wordCounter = stream.parallel().reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        int count = wordCounter.getCount();
        System.out.println(count);
    }

    // 统计String中的单词数
    // 一个迭代式字数统计方法
    public static int countWordsIteratively(String str) {
        int counter = 0;

        boolean lastSpace = true; // 前面是否为空格

        for (char c : str.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {  // 前面是否为空格,当前为字符则表示一个新的单词
                    counter++;
                }
                lastSpace = Character.isWhitespace(c);
            }
        }

        return counter;
    }

    public static int countWords(String s) {
        //Stream<Character> stream = IntStream.range(0, s.length())
        //                                    .mapToObj(SENTENCE::charAt).parallel();
        Spliterator<Character> spliterator = new WordCounterSpliterator(s);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        return countWords(stream);
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCount();
    }

    // 用来在遍历Character流时计数的类
    private static class WordCounter {
        private final int count;
        private final boolean lastSpace;

        public WordCounter(int count, boolean lastIsSpace) {
            this.count = count;
            this.lastSpace = lastIsSpace;
        }

        public WordCounter accumulate(Character c) {
            if (Character.isWhitespace(c)) {
                return lastSpace ? this : new WordCounter(count, true);
            } else {
                return lastSpace ? new WordCounter(count + 1, false) : this;
            }
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(count + wordCounter.count, wordCounter.lastSpace);
        }

        public int getCount() {
            return count;
        }
    }

    private static class WordCounterSpliterator implements Spliterator<Character> {

        private final String string;
        private int currentChar = 0;

        private WordCounterSpliterator(String string) {
            this.string = string;
        }

        // tryAdvance方法的行为类似于普通的Iterator，因为它会按顺序一个一个使用Spliterator中的元素，并且如果还有其他元素要遍历就返回true。
        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {
            action.accept(string.charAt(currentChar++));
            return currentChar < string.length();
        }

        // trySplit是专为Spliterator接口设计的，因为它可以把一些元素划出去分给第二个Spliterator（由该方法返回），让它们两个并行处理。
        @Override
        public Spliterator<Character> trySplit() {
            int currentSize = string.length() - currentChar;
            if (currentSize < 10) {
                return null;
            }
            for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
                if (Character.isWhitespace(string.charAt(splitPos))) {
                    Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                    currentChar = splitPos;
                    return spliterator;
                }
            }
            return null;
        }

        // Spliterator还可通过estimateSize方法估计还剩下多少元素要遍历，因为即使不那么确切，能快速算出来是一个值也有助于让拆分均匀一点。
        @Override
        public long estimateSize() {
            return string.length() - currentChar;
        }

        // 此方法返回此分隔符及其元素的一组特征。它可以是以下8个值中的任何一个。以下所有值都是静态最终整数值：
        // ORDERED：此值用于表示为分隔符元素定义了遇到顺序。
        // DISTINCT：此值表示元素遇到的每对元素是否相等。如果我们从集合创建分离器，它将始终是DISTINCT。
        // IMMUTABLE：此值表示是否无法修改元素的来源，即我们不能添加，替换或删除任何元素。
        // NONNULL：此值表示遇到的元素不会为空。
        // SIZED：表示estimateSize()方法返回的值表示有限大小。
        // SORTED：表示该元素总是有序。
        // SUBSIZED：表示由返回的所有分隔符trySplit()将为 SIZED和SUBSIZED。
        // CONCURRENT：表示可以同时修改源，即，我们可以使用多个线程并发地添加，删除或删除元素，而无需同步。
        @Override
        public int characteristics() {
            return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
        }
    }
}
