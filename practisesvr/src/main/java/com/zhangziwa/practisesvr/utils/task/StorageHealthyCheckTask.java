package com.zhangziwa.practisesvr.utils.task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Component
public class StorageHealthyCheckTask {
    private static volatile AtomicBoolean isActive = new AtomicBoolean(true);

    @Value("${storage.path}")
    private String storagePath;
    @Value("${storage.needCheck}")
    private boolean needCheck;

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            3, 3,
            5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1),
            new ThreadFactoryBuilder().setNameFormat("探活检查-%d").setDaemon(true).build(),
            new ThreadPoolExecutor.DiscardPolicy());

    @Scheduled(cron = "0/5 * * * * ?") // 每分钟执行一次
    private void storageHealthyCheck() {
        log.info("{}线程 调用:storageHealthyCheck start", Thread.currentThread().getName());
        if (!needCheck) {
            log.info("no need check");
            return;
        }

        // true表示正常状态,则已知探活
        if (BooleanUtils.isTrue(isActive.get())) {
            check(Paths.get(storagePath), isActive);
        } else {
            // false表示失败,则报错
            log.error("isActive:{}", false);
        }

        log.info("{}线程 调用:storageHealthyCheck end \n", Thread.currentThread().getName());
    }

    private void check(Path path, AtomicBoolean flag) {
        try {
            Future<Boolean> future = executor.submit(() -> {
                try {
                    log.info("{}线程 测试isReadable", Thread.currentThread().getName());

                    // true表示有读权限,false表没读权限,超时中断就会异常退出
                    return Files.isReadable(path);
                } finally {
                    // 只要路径存在且可读, 就可以认为存储服务是健康的
                    flag.set(true);
                }
            });

            Boolean res = future.get(2, TimeUnit.SECONDS);
            log.info("{}线程 isReadable结果: {}", Thread.currentThread().getName(), res);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 重新设置中断状态
            log.error("Thread was interrupted while waiting for the check task to complete.", e);
            flag.set(false);
        } catch (TimeoutException e) {
            log.error("Check task did not complete within the timeout of 2 seconds.", e);
            flag.set(false);
        } catch (CancellationException e) {
            log.error("Check task was cancelled before it could complete.", e);
            flag.set(false);
        } catch (ExecutionException e) {
            log.error("An error occurred while executing the check task", e);
            flag.set(false);
        }
    }
}
