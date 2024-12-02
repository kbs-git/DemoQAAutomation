package com.utilities;

import java.io.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelRead {

    public static XSSFSheet readExcel(String filePath) throws IOException {
        FileInputStream fs=new FileInputStream(new File(filePath));
        XSSFWorkbook workbook=new XSSFWorkbook(fs);
        XSSFSheet sh =workbook.getSheetAt(0);
        return sh;
    }


    public String getData(String sheetname, int row, int column) throws EncryptedDocumentException, IOException {
        FileInputStream fis=new FileInputStream(ReadPropFile.getObject("demoQAExcel"));
        Workbook wb=WorkbookFactory.create(new PushbackInputStream(fis));
        Sheet sheet1 =  wb.getSheet(sheetname);
        DataFormatter formatter = new DataFormatter();
        String excelData = formatter.formatCellValue(sheet1.getRow(row).getCell(column));
        return excelData;

    }


    public static void writeResultToExcel(String filePath, String sheetName, int rowIndex, String result) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.createCell(row.getPhysicalNumberOfCells());  // Create new cell for result
        cell.setCellValue(result);
        fis.close();
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        workbook.write(fos);
        fos.close();
        workbook.close();
        }
}
