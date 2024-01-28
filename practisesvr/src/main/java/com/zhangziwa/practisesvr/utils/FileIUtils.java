package com.zhangziwa.practisesvr.utils;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Slf4j
public class FileIUtils {
    // ----------------------判断----------------------

    /**
     * 判断给定的路径是否指向一个存在的文件。
     *
     * @param path 文件或目录的路径
     * @return 如果路径指向一个文件，则返回true；否则返回false
     */
    public static boolean isFile(String path) {
        if (isBlank(path)) {
            return false;
        }
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    /**
     * 判断给定路径是否指向一个存在的目录。
     *
     * @param path 需要检查的文件或目录路径，以字符串形式表示
     * @return 如果路径指向一个存在的目录，则返回true；否则返回false
     */
    public static boolean isDir(String path) {
        // 检查传入的路径是否是存在的目录
        File file = new File(path);
        return file.isDirectory();
    }

    /**
     * 检查给定文件路径所指的文件是否存在，并确保它是常规文件，而非目录或其他类型的文件系统对象。
     * 如果文件不存在或不是常规文件，则通过日志记录器输出警告信息。
     *
     * @param filePath 需要检查的文件的绝对或相对路径
     */
    public static void doesFileExist(String filePath) {
        // String normalize = FileUtil.normalize(filePath);
        // String fileAbsolutePath = new File(normalize).getAbsoluteFile().toString();
        // File file = new File(fileAbsolutePath);
        // 不需要两次将文件路径转换为字符串；File构造函数在创建对象时就已经进行了路径标准化和转换。
        File file = new File(FileUtil.normalize(filePath)); // 直接使用标准化后的路径创建File对象
        if (!file.exists() || !file.isFile()) {
            System.out.println("Not Found: " + filePath);
        }
    }

    /**
     * 检查给定文件路径所对应的文件是否存在且为普通文件。
     * 如果文件不存在或不是普通文件（即非目录、链接等），则记录一条警告日志信息。
     *
     * @param filePath 要检查的文件的绝对或相对路径
     */
    public static void checkFileExistAndIsRegular(String filePath) {
        // 获取文件的路径对象
        java.nio.file.Path path = Paths.get(filePath);

        // 检查文件是否存在且是普通文件
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            log.warn("文件不存在或不是普通文件: {}", filePath); // 确保log对象在当前类中已经定义
        }
    }

    /**
     * 判断给定的文件名是否为YAML文件。
     *
     * @param fileName 文件名，包括完整路径和文件名
     * @return 如果文件名以".yml"或".yaml"结尾，则返回true；否则返回false
     */
    public static boolean isYaml(String fileName) {
        return fileName.endsWith(".yml") || fileName.endsWith(".yaml");
    }

    /**
     * 检查给定的文件名是否是Excel文件。
     *
     * @param fileName 文件名，包括完整路径和文件名
     * @return 如果文件名以".xlsx"或".xls"结尾，则返回true；否则返回false
     */
    public static boolean isExcel(String fileName) {
        return fileName.endsWith(".xlsx") || fileName.endsWith(".xls");
    }

    // ----------------------创建----------------------

    /**
     * 生成一个带有当前时间戳的文件名。
     *
     * @param basePath 基础路径，不应以斜杠结尾，用于确定文件存放的位置。
     * @param name     文件的基本名称，不包括后缀部分。
     * @param suffix   文件的后缀名，例如 "txt"、"jpg" 等。
     * @return 完整的文件名（包括路径、基础名称、时间戳和后缀）。
     * @throws IllegalArgumentException 当提供的basePath、name或suffix为null时抛出异常。
     */
    public static String genFileName(String basePath, String name, String suffix) {
        // 检查提供的路径、名称和后缀是否有效
        if (isBlank(basePath) || isBlank(name) || isBlank(suffix)) {
            throw new IllegalArgumentException("路径、名称和后缀均不能为空");
        }

        // 确保路径不以斜杠开头
        if (basePath.startsWith("/")) {
            basePath = basePath.substring(1);
        }

        // 使用标准化的分隔符
        String fileName = Paths.get(basePath, name).toString();

        // 获取当前时间戳
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHMMSS"));

        // 生成最终的文件名
        return fileName + "_" + time + "." + suffix;
    }

    /**
     * 确保指定路径的目录存在。如果目录不存在，则尝试创建它。
     *
     * @param path 要检查或创建的目录路径
     * @throws IOException 如果目录无法创建（例如由于权限问题或其他I/O错误）
     */
    public static void makeSureDirExist(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                throw new IOException("Failed to create directory at path: " + path);
            } else {
                System.out.println("Make Directory: " + path);
            }
        }
    }

    // 写文件 传统close

    /**
     * 使用FileOutputStream和OutputStreamWriter将指定内容写入到文件中，并在finally块中关闭流。
     * 如果文件已存在，则追加内容至文件末尾（参数true决定是否追加）。
     * 编码格式为GBK。
     *
     * @param fileName 要写入的文件名
     * @param content  需要写入文件的字符串内容
     */
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

    // 写文件 try-with-resources

    /**
     * 将内容写入文件
     *
     * @param fileName 文件名
     * @param content  内容
     */
    public static void writeFile(String fileName, String content) {
        try (FileOutputStream fos = new FileOutputStream(fileName, true); OutputStreamWriter writer = new OutputStreamWriter(fos, "GBK")) {
            writer.write(content);
            writer.flush();
        } catch (Exception e) {
            System.out.println("写文件异常" + e);
        }
    }

    /**
     * 将给定内容追加写入指定文件中。使用try-with-resources语句确保文件资源的正确关闭。
     * 若文件不存在，则创建新文件并写入内容。
     *
     * @param fileName 要写入的文件路径
     * @param content  需要写入文件的字符串内容
     */
    public static void writeFile3(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // 使用FileWriter自动关闭
            writer.write(content);
            writer.flush();
        } catch (FileNotFoundException e) { // 更具体的异常捕获
            System.out.println("文件找不到: " + e.getMessage());
        } catch (IOException e) { // 用于其他I/O异常
            System.out.println("写文件异常: " + e.getMessage());
        }
    }

    // ----------------------删除----------------------

    /**
     * 删除指定路径下的文件夹及其包含的所有文件和子目录。
     *
     * @param path 要删除的文件夹路径
     * @throws Exception 如果路径为空，或者在尝试删除文件夹及其内容时发生IOException，则抛出异常
     */
    public static void deleteDirAndFiles(String path) throws Exception {
        if (isBlank(path)) {
            log.warn("The path parameter cannot be null or empty");
        }

        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            try {
                FileUtils.deleteDirectory(directory);
                log.info("Delete Folder and Contents: {}", path);
            } catch (IOException e) {
                log.error("Failed to delete folder and contents at path: {}", path, e);
                throw new RuntimeException("Failed to delete folder and contents", e);
            }
        } else {
            log.warn("Path {} does not point to a valid directory", path);
        }
    }

    /**
     * 删除指定的目录及其内容。
     *
     * @param path 要删除的目录的绝对或相对路径。如果路径为null、空或者指向无效的目录，
     *             将会记录适当的警告信息。
     * @throws IOException 如果目录或其包含的内容无法被删除，则抛出此异常。
     */
    public static void deleteDirAndFiles2(String path) {
        if (path == null || path.trim().isEmpty()) {
            log.warn("The path parameter cannot be null or empty");
            return;
        }

        Path directoryPath = Path.of(path);
        try {
            // 使用 Files.deleteIfExists 会抛出 IllegalArgumentException 如果路径不是文件
            // 因此，我们先检查路径是否存在，然后尝试删除
            if (Files.exists(directoryPath)) {
                Files.deleteIfExists(directoryPath);
                log.info("Delete Folder and Contents: {}", path);
            } else {
                log.warn("Path {} does not point to a valid directory", path);
            }
        } catch (IOException e) {
            log.error("Failed to delete folder and contents at path: {}", directoryPath, e);
            throw new RuntimeException("Failed to delete folder and contents at path: " + directoryPath, e);
        }
    }

    // ----------------------查询----------------------

    /**
     * 查询并返回指定文件路径下的所有文件。如果路径指向一个目录，将返回该目录下所有文件的数组；若路径指向一个文件，则返回包含该文件的数组；
     * 若路径既不是文件也不是目录，则抛出异常或打印错误信息。
     *
     * @param fileName 要查询的文件或目录路径字符串
     * @return 包含指定路径下文件的File数组
     * @throws IllegalArgumentException 如果提供的文件名为空或者为null，抛出此异常
     * @throws IllegalStateException    当指定路径既非文件也非目录时，抛出此异常，并附带错误信息
     */
    public static File[] getFilesInDir(String fileName) {
        if (isBlank(fileName)) {
            throw new IllegalArgumentException("文件名不能为空");
        }

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

    // 读取文件长度(字节)
    // 参考:https://blog.51cto.com/u_16175487/8461341
    private static void getFileBytes(String pathname) {
        File file = new File(pathname);

        try (FileInputStream fis = new FileInputStream(file)) {
            int length = fis.available();
            System.out.println("File length: " + length + " bytes");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    // 读取Java文件字符流时,一次读取特定长度字符流
    // 参考:https://blog.51cto.com/u_16175500/7197677
    private static void readSpecificLength(String fileName) {
        // 1. 打开文件
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            char[] buffer = new char[10]; // 2. 定义字符数组
            int length;

            // 3. 读取字符到字符数组
            while ((length = reader.read(buffer)) != -1) {
                // 4. 处理读取到的字符
                for (int i = 0; i < length; i++) {
                    System.out.print(buffer[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        // 6. 关闭文件
    }

    /**
     * 检查给定目录是否对当前用户具有读权限。
     *
     * @param directory 要检查的 {@link File} 类型目录对象
     * @return 如果目录可读，则返回 `true`，否则返回 `false`
     */
    private static boolean isDirectoryReadable(File directory) {
        return Files.isReadable(directory.toPath());
    }

    /**
     * 判断指定目录是否可写。
     * 通过尝试在该目录下创建并删除一个临时文件来测试其可写性。
     *
     * @param directory 需要测试的目录对象
     * @return 如果目录可写则返回true，否则（包括发生I/O异常时）返回false
     * @throws Exception 在尝试创建和删除临时文件过程中可能抛出的异常
     */
    private static boolean isDirectoryWritable(File directory) throws Exception {
        String fileName = "testfile.txt";
        File testFile = new File(directory, fileName);
        try {
            boolean created = testFile.createNewFile();
            if (created) {
                // 删除临时文件
                testFile.delete();
            }
            return created;
        } catch (IOException e) {
            // 捕获并处理I/O异常
            System.err.println("An I/O error occurred while testing directory writable: " + e.getMessage());
            return false;
        }
    }
}
