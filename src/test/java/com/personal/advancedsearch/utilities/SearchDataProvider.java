package com.personal.advancedsearch.dataproviders;

import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;
import java.util.List;

public class SearchDataProvider {

    @DataProvider(name = "searchData")
    public static Iterator<Object[]> getSearchData() throws IOException {
        List<Object[]> testData = new ArrayList<>();

        FileInputStream fis = new FileInputStream("src/test/resources/testData/Search_Test_Data.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header
            Row row = sheet.getRow(i);

            // Updated below lines to handle mixed cell types (STRING / NUMERIC)
            String keyword = getCellValueAsString(row.getCell(0));
            String category = getCellValueAsString(row.getCell(1));
            boolean subCat = Boolean.parseBoolean(getCellValueAsString(row.getCell(2)));
            String manufacturer = getCellValueAsString(row.getCell(3));
            boolean searchDesc = Boolean.parseBoolean(getCellValueAsString(row.getCell(4)));

            testData.add(new Object[]{keyword, category, subCat, manufacturer, searchDesc});
        }

        workbook.close();
        return testData.iterator();
    }

    // Helper method added to safely read cell values regardless of type
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((int) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }
}