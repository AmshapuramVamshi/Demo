package Pages;

import Base.BaseClass;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class HandlingExcels extends BaseClass {
    public void excelHandling() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Eshwar\\Java Training\\Test.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowSize = sheet.getLastRowNum();
        System.out.println("No.of Rows : " + rowSize);

        int cellSize = sheet.getRow(0).getLastCellNum();
        System.out.println("No.of Cells : " + cellSize);

        for (int i = 1; i <= rowSize; i++) {
            System.out.println(i + " " + sheet.getRow(i).getCell(0) + "");
            XSSFRow row = sheet.getRow(i);
        }
    }
}
