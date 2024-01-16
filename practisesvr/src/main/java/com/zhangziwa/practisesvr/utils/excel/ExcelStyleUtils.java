package com.zhangziwa.practisesvr.utils.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelStyleUtils {

    public static Font fontLib(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("等线"); // 字体
        font.setFontHeightInPoints((short) 14);// 字号
        font.setBold(true);// 加粗
        font.setColor(IndexedColors.BLACK.getIndex());// 颜色
        font.setItalic(true);// 斜体
        font.setStrikeout(true);// 使用划线
        return font;
    }

    public static CellStyle styleLib(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(fontLib(workbook)); // 字体
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 居中
        cellStyle.setWrapText(true); // 自动换行
        cellStyle.setBorderTop(BorderStyle.THIN); // 单元格边框
        cellStyle.setBorderBottom(BorderStyle.THIN); // 单元格边框
        cellStyle.setBorderLeft(BorderStyle.THIN); // 单元格边框
        cellStyle.setBorderRight(BorderStyle.THIN); // 单元格边框
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//高度居中
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 实心填充
        // poi poi-ooxml 5.2.3
        // cellStyle.setFillForegroundColor(new XSSFColor(new Color(181, 230, 181),new DefaultIndexedColorMap()));
        // poi poi-ooxml 4.1.2
        cellStyle.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
        return cellStyle;
    }

    public static Font headerFont(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("等线");
        font.setFontHeightInPoints((short) 14);
        font.setBold(true);
        font.setColor(IndexedColors.BLACK.getIndex());
        return font;
    }

    public static CellStyle headerStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(headerFont(workbook));
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // cellStyle.setFillForegroundColor(new XSSFColor(new Color(100, 210, 181),new DefaultIndexedColorMap()));
        cellStyle.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
        return cellStyle;
    }

    public static Font cellFont(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("等线");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        font.setColor(IndexedColors.BLACK.getIndex());
        return font;
    }

    public static CellStyle cellsStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(cellFont(workbook));
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // cellStyle.setFillForegroundColor(new XSSFColor(new Color(181, 230, 181),new DefaultIndexedColorMap()));
        cellStyle.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
        return cellStyle;
    }

    // exportExcelColorExample专用，为了输出颜色目录
    private static CellStyle getCellStyle(Workbook workbook, IndexedColors clolor) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(clolor.getIndex());
        return cellStyle;
    }

    // 输出颜色目录
    public static void exportExcelColorExample() throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheetName = wb.createSheet("ColorExample");
        Row row = sheetName.createRow(0);

        row.createCell(0).setCellValue("AQUA");
        row.getCell(0).setCellStyle(getCellStyle(wb, IndexedColors.AQUA));
        row.createCell(1).setCellValue("AUTOMATIC");
        row.getCell(1).setCellStyle(getCellStyle(wb, IndexedColors.AUTOMATIC));
        row.createCell(2).setCellValue("BLUE");
        row.getCell(2).setCellStyle(getCellStyle(wb, IndexedColors.BLUE));
        row.createCell(3).setCellValue("BLUE_GREY");
        row.getCell(3).setCellStyle(getCellStyle(wb, IndexedColors.BLUE_GREY));
        row.createCell(4).setCellValue("BRIGHT_GREEN");
        row.getCell(4).setCellStyle(getCellStyle(wb, IndexedColors.BRIGHT_GREEN));
        row.createCell(5).setCellValue("BROWN");
        row.getCell(5).setCellStyle(getCellStyle(wb, IndexedColors.BROWN));
        row.createCell(6).setCellValue("CORAL");
        row.getCell(6).setCellStyle(getCellStyle(wb, IndexedColors.CORAL));
        row.createCell(7).setCellValue("CORNFLOWER_BLUE");
        row.getCell(7).setCellStyle(getCellStyle(wb, IndexedColors.CORNFLOWER_BLUE));
        row.createCell(8).setCellValue("DARK_BLUE");
        row.getCell(8).setCellStyle(getCellStyle(wb, IndexedColors.DARK_BLUE));
        row.createCell(9).setCellValue("DARK_GREEN");
        row.getCell(9).setCellStyle(getCellStyle(wb, IndexedColors.DARK_GREEN));
        row.createCell(10).setCellValue("DARK_RED");
        row.getCell(10).setCellStyle(getCellStyle(wb, IndexedColors.DARK_RED));
        row.createCell(11).setCellValue("DARK_TEAL");
        row.getCell(11).setCellStyle(getCellStyle(wb, IndexedColors.DARK_TEAL));
        row.createCell(12).setCellValue("DARK_YELLOW");
        row.getCell(12).setCellStyle(getCellStyle(wb, IndexedColors.DARK_YELLOW));
        row.createCell(13).setCellValue("GOLD");
        row.getCell(13).setCellStyle(getCellStyle(wb, IndexedColors.GOLD));
        row.createCell(14).setCellValue("GREEN");
        row.getCell(14).setCellStyle(getCellStyle(wb, IndexedColors.GREEN));
        row.createCell(15).setCellValue("GREY_25_PERCENT");
        row.getCell(15).setCellStyle(getCellStyle(wb, IndexedColors.GREY_25_PERCENT));
        row.createCell(16).setCellValue("GREY_40_PERCENT");
        row.getCell(16).setCellStyle(getCellStyle(wb, IndexedColors.GREY_40_PERCENT));
        row.createCell(17).setCellValue("GREY_50_PERCENT");
        row.getCell(17).setCellStyle(getCellStyle(wb, IndexedColors.GREY_50_PERCENT));
        row.createCell(18).setCellValue("GREY_80_PERCENT");
        row.getCell(18).setCellStyle(getCellStyle(wb, IndexedColors.GREY_80_PERCENT));
        row.createCell(19).setCellValue("INDIGO");
        row.getCell(19).setCellStyle(getCellStyle(wb, IndexedColors.INDIGO));
        row.createCell(20).setCellValue("LAVENDER");
        row.getCell(20).setCellStyle(getCellStyle(wb, IndexedColors.LAVENDER));
        row.createCell(21).setCellValue("LIGHT_BLUE");
        row.getCell(21).setCellStyle(getCellStyle(wb, IndexedColors.LIGHT_BLUE));
        row.createCell(22).setCellValue("LEMON_CHIFFON");
        row.getCell(22).setCellStyle(getCellStyle(wb, IndexedColors.LEMON_CHIFFON));
        row.createCell(23).setCellValue("LIGHT_BLUE");
        row.getCell(23).setCellStyle(getCellStyle(wb, IndexedColors.LIGHT_BLUE));
        row.createCell(24).setCellValue("LIGHT_CORNFLOWER_BLUE");
        row.getCell(24).setCellStyle(getCellStyle(wb, IndexedColors.LIGHT_CORNFLOWER_BLUE));
        row.createCell(25).setCellValue("LIGHT_GREEN");
        row.getCell(25).setCellStyle(getCellStyle(wb, IndexedColors.LIGHT_GREEN));
        row.createCell(26).setCellValue("LIGHT_ORANGE");
        row.getCell(26).setCellStyle(getCellStyle(wb, IndexedColors.LIGHT_ORANGE));
        row.createCell(27).setCellValue("LIGHT_TURQUOISE");
        row.getCell(27).setCellStyle(getCellStyle(wb, IndexedColors.LIGHT_TURQUOISE));
        row.createCell(28).setCellValue("LIGHT_YELLOW");
        row.getCell(28).setCellStyle(getCellStyle(wb, IndexedColors.LIGHT_YELLOW));
        row.createCell(29).setCellValue("LIME");
        row.getCell(29).setCellStyle(getCellStyle(wb, IndexedColors.LIME));
        row.createCell(30).setCellValue("MAROON");
        row.getCell(30).setCellStyle(getCellStyle(wb, IndexedColors.MAROON));
        row.createCell(31).setCellValue("OLIVE_GREEN");
        row.getCell(31).setCellStyle(getCellStyle(wb, IndexedColors.OLIVE_GREEN));
        row.createCell(32).setCellValue("ORANGE");
        row.getCell(32).setCellStyle(getCellStyle(wb, IndexedColors.ORANGE));
        row.createCell(33).setCellValue("ORCHID");
        row.getCell(33).setCellStyle(getCellStyle(wb, IndexedColors.ORCHID));
        row.createCell(34).setCellValue("PALE_BLUE");
        row.getCell(34).setCellStyle(getCellStyle(wb, IndexedColors.PALE_BLUE));
        row.createCell(35).setCellValue("PINK");
        row.getCell(35).setCellStyle(getCellStyle(wb, IndexedColors.PINK));
        row.createCell(36).setCellValue("PLUM");
        row.getCell(36).setCellStyle(getCellStyle(wb, IndexedColors.PLUM));
        row.createCell(37).setCellValue("RED");
        row.getCell(37).setCellStyle(getCellStyle(wb, IndexedColors.RED));
        row.createCell(38).setCellValue("ROSE");
        row.getCell(38).setCellStyle(getCellStyle(wb, IndexedColors.GREY_25_PERCENT));
        row.createCell(39).setCellValue("ROYAL_BLUE");
        row.getCell(39).setCellStyle(getCellStyle(wb, IndexedColors.ROYAL_BLUE));
        row.createCell(40).setCellValue("SEA_GREEN");
        row.getCell(40).setCellStyle(getCellStyle(wb, IndexedColors.SEA_GREEN));
        row.createCell(41).setCellValue("SKY_BLUE");
        row.getCell(41).setCellStyle(getCellStyle(wb, IndexedColors.SKY_BLUE));
        row.createCell(42).setCellValue("TAN");
        row.getCell(42).setCellStyle(getCellStyle(wb, IndexedColors.TAN));
        row.createCell(43).setCellValue("TEAL");
        row.getCell(43).setCellStyle(getCellStyle(wb, IndexedColors.TEAL));
        row.createCell(44).setCellValue("TURQUOISE");
        row.getCell(44).setCellStyle(getCellStyle(wb, IndexedColors.TURQUOISE));
        row.createCell(45).setCellValue("VIOLET");
        row.getCell(45).setCellStyle(getCellStyle(wb, IndexedColors.VIOLET));
        row.createCell(46).setCellValue("WHITE");
        row.getCell(46).setCellStyle(getCellStyle(wb, IndexedColors.WHITE));
        row.createCell(47).setCellValue("YELLOW");
        row.getCell(47).setCellStyle(getCellStyle(wb, IndexedColors.YELLOW));

        ExcelUtils.writeExcel(wb);
    }
}
