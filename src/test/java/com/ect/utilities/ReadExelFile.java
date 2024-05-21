package com.ect.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExelFile {
    public static Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] data = null;

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist");
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            if (rowCount <= 1) {
                throw new IllegalArgumentException("Sheet does not have enough rows to extract data");
            }

            data = new Object[rowCount - 1][colCount];

            DataFormatter formatter = new DataFormatter();
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return data;
    }

    public static String getSingleCellValue(String filePath, String sheetName, int rowIndex, String columnName) {
        String cellValue = null;

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist");
            }

            Row headerRow = sheet.getRow(0);
            int colIndex = -1;
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                    colIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (colIndex == -1) {
                throw new IllegalArgumentException("Column with name " + columnName + " does not exist");
            }

            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cell = row.getCell(colIndex);
                DataFormatter formatter = new DataFormatter();
                cellValue = formatter.formatCellValue(cell);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return cellValue;
    }
}
