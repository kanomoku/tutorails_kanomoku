package javabasic.thread.threadfactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExecuterThreadFactoryBuilder {
    public static ThreadFactory build() {
        return new ThreadFactoryBuilder().setDaemon(true).setNameFormat("thread-%d").build();
    }

    public static ThreadFactory build(String nameFormat) {
        return new ThreadFactoryBuilder().setDaemon(true).setNameFormat(nameFormat).build();
    }
}
