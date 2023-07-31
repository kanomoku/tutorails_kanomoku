package atomicitybusiness.excel;

import model.Person;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class ExcelUtilsTest {

    @Test
    public void getWorkbook2_1() throws Exception {
        String xlsx = "D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\resources\\input.xlsx";
        Workbook workbook2 = ExcelUtils.getWorkbook2(xlsx);
        ExcelUtils.getCell(workbook2);
    }

    @Test
    public void getWorkbook2_2() throws Exception {
        String xls = "D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\resources\\input2.xls";
        Workbook workbook2 = ExcelUtils.getWorkbook2(xls);
        ExcelUtils.getCell(workbook2);
    }

    @Test
    public void getWorkbook3_1() throws Exception {
        String xlsx = "D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\resources\\input.xlsx";
        Workbook workbook2 = ExcelUtils.getWorkbook3(xlsx);
        ExcelUtils.getCell(workbook2);
    }

    @Test
    public void getWorkbook3_2() throws Exception {
        String xls = "D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\resources\\input2.xls";
        Workbook workbook2 = ExcelUtils.getWorkbook3(xls);
        ExcelUtils.getCell(workbook2);
    }

    @Test
    public void getWorkbook4_1() throws Exception {
        String xlsx = "D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\resources\\input.xlsx";
        Workbook workbook2 = ExcelUtils.getWorkbook1(xlsx);
        ExcelUtils.getCell(workbook2);
    }

    @Test
    public void getWorkbook4_2() throws Exception {
        String xls = "D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\resources\\input2.xls";
        Workbook workbook2 = ExcelUtils.getWorkbook1(xls);
        ExcelUtils.getCell(workbook2);
    }

    @Test
    public void getWorkbook111() throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "John", 11, "nickName"));
        persons.add(new Person(11, "John1", 11, "nickName1"));
        persons.add(new Person(12, "John2", 11, "nickName2"));
        persons.add(new Person(13, "John3", 11, "nickName3"));
        persons.add(new Person(14, "John4", 11, "nickName4"));

        String OUT_PATH = "D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\resources\\output\\";
        ExcelUtils.deleteOldExcelFile(OUT_PATH);
        XSSFWorkbook wb = new XSSFWorkbook();
        ExcelUtils.buildData(wb, persons);
        ExcelUtils.buildStyle(wb);
        ExcelUtils.output2(wb);
    }
}