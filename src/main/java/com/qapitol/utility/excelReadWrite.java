package com.qapitol.utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelReadWrite {
    static String filePath="";
    public static void readExcel(String sheetname, int row1, int column1) throws IOException {
        File file=new File(filePath);
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet(sheetname);
        for(int i =0; i<sheet.getLastRowNum();i++) {
            XSSFRow row = sheet.getRow(i);
            for(int j=0; j<row.getLastCellNum();j++ ) {
                System.out.println(row.getCell(j));
            }
        }
        workbook.close();
    }
    public static void writeExcel(String sheetname, int row1, int column1) throws IOException {
        File file=new File(filePath);
        FileOutputStream fos=new FileOutputStream(file);
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet= workbook.createSheet(sheetname);
        for(int i=0;i<10;i++){
            Row row = sheet.createRow(i);
            for(int j=0;j<4;j++){
                row.createCell(j).setCellValue(" ");
            }
        }
        workbook.write(fos);
        workbook.close();
    }
}
