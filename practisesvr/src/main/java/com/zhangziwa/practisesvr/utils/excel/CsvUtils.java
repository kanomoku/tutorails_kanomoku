package com.zhangziwa.practisesvr.utils.excel;

import com.zhangziwa.practisesvr.model.Person;
import com.zhangziwa.practisesvr.utils.FileIUtils;
import com.zhangziwa.practisesvr.utils.reflect.ReflectUtils;

import java.util.*;

public class CsvUtils {
    public static final String PATH = "D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\main\\java\\com\\zhangziwa\\practisesvr\\out";

    public static void main(String[] args) {
        List<Person> lines = Arrays.asList(new Person());
        String fileName = FileIUtils.genFileName(PATH, lines.get(0).getClass().getSimpleName(), ".csv");
        String str = buildCsvFileTable(lines);
        FileIUtils.writeFile(fileName, str);
    }

    /**
     * 构建excel 标题行名
     */
    public static String buildCsvFileTableTitle(List dataList) {
        Map<String, Object> map = ReflectUtils.beanToMap(dataList.get(0));
        StringBuilder tableNames = new StringBuilder();
        for (String key : map.keySet()) {
            tableNames.append(key).append(",");
        }
        return tableNames.append(System.lineSeparator()).toString();
    }

    /**
     * 构建excel内容
     */
    public static String buildCsvFileTableBody(List dataLists) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Object o : dataLists) {
            mapList.add(ReflectUtils.beanToMap(o));
        }
        StringBuilder lineBuilder = new StringBuilder();
        for (Map<String, Object> rowData : mapList) {
            for (Object value : rowData.values()) {
                if (Objects.nonNull(value)) {
                    lineBuilder.append(value).append(",");
                } else {
                    lineBuilder.append("--").append(",");
                }
            }
            lineBuilder.append(System.lineSeparator());
        }
        return lineBuilder.toString();
    }

    public static String buildCsvFileTable(List dataList) {
        Map<String, Object> map = ReflectUtils.beanToMap(dataList.get(0));

        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Object o : dataList) {
            mapList.add(ReflectUtils.beanToMap(o));
        }

        // 构建excel 标题行名
        StringBuilder lineBuilder = new StringBuilder();
        for (String key : map.keySet()) {
            lineBuilder.append(key).append(",");
        }
        lineBuilder.append(System.lineSeparator());

        // 构建excel内容
        for (Map<String, Object> rowData : mapList) {
            for (Object value : rowData.values()) {
                if (Objects.nonNull(value)) {
                    lineBuilder.append(value).append(",");
                } else {
                    lineBuilder.append("--").append(",");
                }
            }
            lineBuilder.append(System.lineSeparator());
        }
        return lineBuilder.toString();
    }
}
