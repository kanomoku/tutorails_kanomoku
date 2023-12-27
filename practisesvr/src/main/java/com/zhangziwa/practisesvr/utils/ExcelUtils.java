package com.zhangziwa.practisesvr.utils;

import com.zhangziwa.practisesvr.model.Person;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.List;

public class ExcelUtils {
    public static final String OUT_PATH = "D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\test\\java\\com\\zhangziwa\\practisesvr\\utils\\output\\";

    public static Workbook getWorkbook1(String filePath) throws Exception {
        File file = new File(filePath);
        String fileName = file.getName();

        Workbook workbook = null;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            if (".xls".equals(fileType)) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (".xlsx".equals(fileType)) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                System.out.println("非Excel文件");;
            }
        }
        return workbook;
    }

    public static Workbook getWorkbook2(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        return WorkbookFactory.create(inputStream);
    }

    public static Workbook getWorkbook3(String filePath) throws IOException {
        FileInputStream inputStream = FileUtils.openInputStream(new File(filePath));
        return WorkbookFactory.create(inputStream);
    }

    public static void getCell(Workbook workbook) throws Exception {
        Sheet sheet;
        Row row;
        Cell cell;

        // 2sheet页时则NumberOfSheets=2，下标索引取值0-1
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            // 6行数据时,FirstRowNum=0,LastRowNum=5
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                // 4列时,FirstCellNum=0,LastCellNum=4
                for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                    cell = row.getCell(k);
                    System.out.print(workbook.getNumberOfSheets() + "-" + sheet.getFirstRowNum() + "-" + sheet.getLastRowNum() + "-" + row.getFirstCellNum() + "-" + row.getLastCellNum() + ":" + cell + "  ");
                }
                System.out.println();
            }
            System.out.println();
        }
        workbook.close();
    }

    public static void writeExcel(Workbook workbook) throws Exception {
        FileIUtils.deleteDirAndFiles(OUT_PATH);
        FileIUtils.makeSureDirExist(OUT_PATH);

        String exportPath = FileIUtils.genFileName(OUT_PATH, "文件名", ".xlsx");
        try (FileOutputStream fos = new FileOutputStream(exportPath, false)) {
            workbook.write(fos);
        }
        System.out.println("Exported Successful: " + exportPath);
    }

    public static void writeExcel2(Workbook workbook) throws Exception {
        FileIUtils.deleteDirAndFiles(OUT_PATH);
        FileIUtils.makeSureDirExist(OUT_PATH);

        String exportPath = FileIUtils.genFileName(OUT_PATH, "文件名", ".xlsx");
        try (OutputStream outputStream = new FileOutputStream(exportPath)) {
            workbook.write(outputStream);
        }
        System.out.println("Exported Successful: " + exportPath);
    }

    public static void buildData(Workbook wb, List<Person> list) {
        Sheet sheetName = wb.createSheet("sheetName");
        Row row = sheetName.createRow(0);
        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Age");
        row.createCell(3).setCellValue("NickName");

        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            row = sheetName.createRow(i + 1);
            row.createCell(0).setCellValue(person.getId());
            row.createCell(1).setCellValue(person.getName());
            row.createCell(2).setCellValue(person.getAge());
            row.createCell(3).setCellValue(person.getNickName());
        }

        wb.setSheetName(0, "sheet");
    }

    public static void buildStyle(Workbook wb) {
        Sheet sheet;
        Row row;
        for (int s = 0; s < wb.getNumberOfSheets(); s++) {
            sheet = wb.getSheetAt(s);
            for (int r = sheet.getFirstRowNum(); r <= sheet.getLastRowNum(); r++) {
                row = sheet.getRow(r);
                for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
                    if (r == 0) { // 表头
                        row.getCell(c).setCellStyle(ExcelStyleUtils.headerStyle(wb));
                        sheet.autoSizeColumn(c);
                    } else { // 数据
                        row.getCell(c).setCellStyle(ExcelStyleUtils.cellsStyle(wb));
                        if (sheet.getColumnWidth(c) > 50 * 256) {
                            sheet.setColumnWidth(c, 50 * 256);
                        }
                    }
                }
            }
        }
    }


    // 将单元格内容转化为字符串
    private static String convertCellValueToString(Cell cell) {
        if (null == cell) {
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
            case STRING:  //字符串
                returnValue = cell.getStringCellValue();
                break;
            case NUMERIC: //数字
                double numericCellValue = cell.getNumericCellValue();
                boolean isInteger = isInteger(numericCellValue);
                if (isInteger) {
                    DecimalFormat df = new DecimalFormat("0");
                    returnValue = df.format(numericCellValue);
                } else {
                    returnValue = Double.toString(numericCellValue);
                }
                break;
            case BOOLEAN: //布尔
                boolean booleanCellValue = cell.getBooleanCellValue();
                returnValue = Boolean.toString(booleanCellValue);
                break;
            case BLANK: //空值
                break;
            case FORMULA: //公式
                // returnValue = cell.getCellFormula();
                try {
                    returnValue = String.valueOf(cell.getNumericCellValue());
                } catch (IllegalStateException e) {
                    returnValue = String.valueOf(cell.getRichStringCellValue());
                }
                break;
            case ERROR: //故障
                break;
            default:
                break;
        }
        return returnValue;
    }

    // 判断是否为整数，是返回true，否则返回false.
    public static boolean isInteger(Double num) {
        double eqs = 1e-10; //精度范围
        return num - Math.floor(num) < eqs;
    }
}