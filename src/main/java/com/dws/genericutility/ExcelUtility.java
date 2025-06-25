package com.dws.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getStringDataFromExcel(String sheetName, int rowNum, int columnNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
	}

}
