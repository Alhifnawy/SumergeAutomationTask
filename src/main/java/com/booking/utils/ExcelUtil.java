package com.booking.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;


public class ExcelUtil {

    private static final String FILE_PATH = "src/main/resources/BookingData.xlsx";

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        Workbook workbook = null;
        DataFormatter formatter = new DataFormatter(Locale.US);
        try {
            file = new FileInputStream(FILE_PATH);
            workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                }
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[][]{};
        } finally {
            try {
                if (workbook != null) workbook.close();
                if (file != null) file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
