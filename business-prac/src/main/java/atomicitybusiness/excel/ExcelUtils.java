package atomicitybusiness.excel;

import model.Person;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelUtils {

    public static final String INPUT_PATH = "C:\\Users\\zhang\\Desktop\\input.xlsx";
    public static final String OUT_PATH = "D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\resources\\output\\";

    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpServletRequest.getFile("fileName");
        InputStream inputStream = file.getInputStream();
        String fileName = file.getName();
        return null;
    }

    public static Workbook getWorkbook1(String path) throws Exception {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        String fileName = file.getName();

        Workbook workbook;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            throw new Exception("请上传Excel");
        }
        inputStream.close();
        return workbook;
    }

    public static Workbook getWorkbook2(String path) throws IOException, InvalidFormatException {
        InputStream inputStream = new FileInputStream(path);
        return WorkbookFactory.create(inputStream);
    }

    public static Workbook getWorkbook3(String path) throws IOException, InvalidFormatException {
        FileInputStream inputStream = FileUtils.openInputStream(new File(path));
        return WorkbookFactory.create(inputStream);
    }

    public static void getCell(Workbook workbook) throws Exception {
        Sheet sheet;
        Row row;
        Cell cell;
        // sheet页3页时则NumberOfSheets=3，下标索引取值0-2
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            // 3行数据时,FirstRowNum=0,LastRowNum=2
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                // 2列时,FirstCellNum=0,LastCellNum=2
                for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                    cell = row.getCell(k);
                    System.out.print(cell + "  ");
                }
                System.out.println();
            }
        }
        workbook.close();
    }

    public static void deleteOldExcelFile(String path) throws Exception {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            FileUtils.deleteDirectory(file);
        }
    }

    public static void makeExcelFile(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs){
                throw new IOException("mkdirs failed");
            }
        }
    }

    public static void output(Workbook workbook) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(genExcelName(OUT_PATH), false);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    public static void output2(Workbook workbook) throws Exception {
        makeExcelFile(OUT_PATH);
        OutputStream outputStream = new FileOutputStream(genExcelName(OUT_PATH));
        workbook.write(outputStream);
        outputStream.close();
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
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            sheet = wb.getSheetAt(i);
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (j == 0) {
                    for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                        row.getCell(k).setCellStyle(ExcelStyleUtils.headerStyle(wb));
                    }
                } else {
                    for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                        row.getCell(k).setCellStyle(ExcelStyleUtils.cellsStyle(wb));
                    }
                }
            }
        }
    }


    private static String genExcelName(String path) {
        String postName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHMMSS"));
        return path + "/输出" + postName + ".xlsx";
    }
}