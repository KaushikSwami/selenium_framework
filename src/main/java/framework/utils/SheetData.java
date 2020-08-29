package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SheetData {
	
	@DataProvider
	public static Object[][] readExcelData() throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int total_rows = sheet.getLastRowNum();
		System.out.println("the total rows is : " + total_rows);
		int total_columns = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[total_rows][total_columns];
		for (int i = 1; i <= total_rows; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < total_columns; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				data[i-1][j] = stringCellValue;
			} 
		}
		workbook.close();
		return data;
	}

}
