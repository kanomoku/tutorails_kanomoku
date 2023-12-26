package com.zhangziwa.practisesvr.utils;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileIUtils {
    // 删除文件夹和其下所有文件
    public static void deleteDirAndFiles(String path) throws Exception {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            FileUtils.deleteDirectory(file);
            System.out.println("Delete Dir and Files: " + path);
        }
    }

    // 确保文件夹存在,不存在就新建个
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

    // 生成文件名字
    public static String genFileName(String path, String name, String suffix) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHMMSS"));
        return path + "/" + name + time + suffix;
    }

    // 校验文件是否存在
    public static void checkFileExist(String filePath) {
        String normalize = FileUtil.normalize(filePath);
        File file = new File(normalize);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Not Found: " + filePath);
        }
    }

    // 判断是否为yaml文件
    public static boolean isYaml(String fileName) {
        return fileName.endsWith(".yml") || fileName.endsWith(".yaml");
    }

    // 获取当前文件或当前目录下所有文件
    public static File[] getFilesInPath(String fileName) {
        File file = new File(fileName);
        File[] files = new File[0];
        if (file.isDirectory()) {
            files = file.listFiles();
        } else if (file.isFile()) {
            files = new File[]{file};
        } else {
            System.out.println("此路径没有文件:" + fileName);
        }
        return files;
    }

    // 判断传入路径为文件
    public static boolean isFile(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    // 判断传入路径为路径
    public static boolean isDir(String path) {
        File file = new File(path);
        return file.exists() && file.isDirectory();
    }

    // 写文件 try=with-resources
    public static void writeFile(String fileName, String content) {
        try (FileOutputStream fos = new FileOutputStream(fileName, true);
             OutputStreamWriter writer = new OutputStreamWriter(fos, "GBK")) {
            writer.write(content);
            writer.flush();
        } catch (Exception e) {
            System.out.println("写文件异常" + e);
        }
    }

    // 写文件 传统close
    public static void writeFile2(String fileName, String content) {
        FileOutputStream fos = null;
        OutputStreamWriter writer = null;
        try {
            fos = new FileOutputStream(fileName, true);
            writer = new OutputStreamWriter(fos, "GBK");
            writer.write(content);
            writer.flush();
        } catch (Exception e) {
            System.out.println("写文件异常" + e);
        } finally {
            if (fos != null) {
                IOUtils.closeQuietly(fos);
            }
            if (writer != null) {
                IOUtils.closeQuietly(writer);
            }
        }
    }
}
