package io.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileIUtils {
    public static void deleteDirAndFiles(String path) throws Exception {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            FileUtils.deleteDirectory(file);
            System.out.println("Delete Dir and Files: " + path);
        }
    }

    public static void makeSureDirExist(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                throw new IOException("mkdirs failed");
            } else {
                System.out.println("Make Directory: " + path);
            }
        }
    }

    public static String genFileName(String path, String name, String suffix) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHMMSS"));
        return path + name + time + suffix;
    }
}
