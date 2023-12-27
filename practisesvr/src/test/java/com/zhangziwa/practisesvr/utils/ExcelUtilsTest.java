package com.zhangziwa.practisesvr.utils;

import com.zhangziwa.practisesvr.model.Person;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class ExcelUtilsTest {

    @Test
    public void getWorkbook1_xlsx() throws Exception {
        String xlsx = "D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\test\\java\\com\\zhangziwa\\practisesvr\\utils\\input\\input.xlsx";
        Workbook workbook = ExcelUtils.getWorkbook1(xlsx);
        ExcelUtils.getCellForI(workbook);
        ExcelUtils.getCell2ForEach(workbook);
        Workbook workbook2 = ExcelUtils.getStreamWorkbook(xlsx);
        ExcelUtils.getCell2ForEach(workbook2);
    }

    @Test
    public void getWorkbook1_xls() throws Exception {
        String xls = "D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\test\\java\\com\\zhangziwa\\practisesvr\\utils\\input\\input2.xls";
        Workbook workbook2 = ExcelUtils.getWorkbook1(xls);
        ExcelUtils.getCellForI(workbook2);
    }

    @Test
    public void getWorkbook2_xlsx() throws Exception {
        String xlsx = "D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\test\\java\\com\\zhangziwa\\practisesvr\\utils\\input\\input.xlsx";
        Workbook workbook2 = ExcelUtils.getWorkbook2(xlsx);
        ExcelUtils.getCellForI(workbook2);
        ExcelUtils.getCell2ForEach(workbook2);
    }

    @Test
    public void getWorkbook2_xls() throws Exception {
        String xls = "D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\test\\java\\com\\zhangziwa\\practisesvr\\utils\\input\\input2.xls";
        Workbook workbook2 = ExcelUtils.getWorkbook2(xls);
        ExcelUtils.getCellForI(workbook2);
        ExcelUtils.getCell2ForEach(workbook2);
    }

    @Test
    public void getWorkbook3_xlsx() throws Exception {
        String xlsx = "D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\test\\java\\com\\zhangziwa\\practisesvr\\utils\\input\\input.xlsx";
        Workbook workbook2 = ExcelUtils.getWorkbook3(xlsx);
        ExcelUtils.getCellForI(workbook2);
        ExcelUtils.getCell2ForEach(workbook2);
    }

    @Test
    public void getWorkbook3_xls() throws Exception {
        String xls = "D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\test\\java\\com\\zhangziwa\\practisesvr\\utils\\input\\input2.xls";
        Workbook workbook2 = ExcelUtils.getWorkbook3(xls);
        ExcelUtils.getCellForI(workbook2);
        ExcelUtils.getCell2ForEach(workbook2);
    }

    @Test
    public void testWriteExcel() throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "John", 11, "nickName"));
        persons.add(new Person(11, "John1", 11, "nickName1"));
        persons.add(new Person(12, "John2", 11, "nickName2"));
        persons.add(new Person(13, "John3", 11, "nickName3"));
        persons.add(new Person(14, "John4", 11, "nickName4"));

        XSSFWorkbook wb = new XSSFWorkbook();
        ExcelUtils.buildData(wb, persons);
        ExcelUtils.buildStyle(wb);
        ExcelUtils.writeExcel(wb);
    }

    @Test
    public void testWriteExcel2() throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "John", 11, "nickName"));
        persons.add(new Person(11, "John1", 11, "nickName1"));
        persons.add(new Person(12, "John2", 11, "nickName2"));
        persons.add(new Person(13, "John3", 11, "nickName3"));
        persons.add(new Person(14, "John4", 11, "nickName4"));

        XSSFWorkbook wb = new XSSFWorkbook();
        ExcelUtils.buildData(wb, persons);
        ExcelUtils.buildStyle(wb);
        ExcelUtils.writeExcel2(wb);
    }
}