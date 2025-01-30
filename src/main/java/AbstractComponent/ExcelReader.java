package AbstractComponent;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public List<String> getData(String testCaseName)  {
        List<String> data = new ArrayList<>();
        FileInputStream file = null;
        try {
            file = new FileInputStream("D:\\selenium\\Pom\\src\\main\\resources\\TestCaseData (2).xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet= workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        while (rows.hasNext()) {
            Row row = rows.next();
            if(row.getCell(0) != null && row.getCell(0).getStringCellValue().equals(testCaseName)) {
                for(Cell cell : row) {
if(cell.getCellType() == CellType.STRING) {
    data.add(cell.getStringCellValue());
}
else {
    data.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
}
                }
            }
        }
        return data;
    }

}
