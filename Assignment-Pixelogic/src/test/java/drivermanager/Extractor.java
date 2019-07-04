package drivermanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Extractor {

	public String getExcelData(String sheetName , int rowNum , int colNum) {

    	String filepath = "src\\test\\resources\\Test_data.xlsx";
    	String data = null;
    	try {
    		
          FileInputStream fis = new FileInputStream(filepath);
          
          Workbook workobook = WorkbookFactory.create(fis);
          
          Sheet sheet = workobook.getSheet(sheetName);    
          Row row = sheet.getRow(rowNum);
          data = row.getCell(colNum).getStringCellValue();
      
    	} catch (Exception e) {
			// TODO Auto-generated catch block
    		System.out.println("ERROR");
			e.printStackTrace();
		}
    	
          return data;
    }
}
