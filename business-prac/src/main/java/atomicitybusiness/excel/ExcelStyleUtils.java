package atomicitybusiness.excel;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;

import java.awt.Color;

public class ExcelStyleUtils {

    public static Font demoFont(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("等线"); // 字体
        font.setFontHeightInPoints((short) 14);// 字号
        font.setBold(true);// 加粗
        font.setColor(IndexedColors.BLACK.getIndex());// 颜色
        font.setItalic(true);// 斜体
        font.setStrikeout(true);// 使用划线
        return font;
    }

    public static CellStyle demoStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(demoFont(workbook)); // 字体
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 居中
        cellStyle.setWrapText(true); // 自动换行
        cellStyle.setBorderTop(BorderStyle.THIN); // 单元格边框
        cellStyle.setBorderBottom(BorderStyle.THIN); // 单元格边框
        cellStyle.setBorderLeft(BorderStyle.THIN); // 单元格边框
        cellStyle.setBorderRight(BorderStyle.THIN); // 单元格边框
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//高度居中
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 实心填充
        cellStyle.setFillForegroundColor(new XSSFColor(new Color(181, 230, 181),new DefaultIndexedColorMap()));
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
        cellStyle.setFillForegroundColor(new XSSFColor(new Color(100, 210, 181),new DefaultIndexedColorMap()));
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
        cellStyle.setFillForegroundColor(new XSSFColor(new Color(181, 230, 181),new DefaultIndexedColorMap()));
        return cellStyle;
    }
}
