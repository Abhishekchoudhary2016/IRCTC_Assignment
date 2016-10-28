package com.selenium.project.test;

//public class ExcelDataRead {
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

import junit.framework.TestListener;

	//@Listeners({com.selenium.project.testExcelDataRead.class})
	@Listeners({com.selenium.project.test.TestListener.class})
	public class ExcelDataRead {

	 private  XSSFSheet ExcelWSheet;
	 private  XSSFWorkbook ExcelWBook;
	 private  XSSFCell Cell;

	 @Test(dataProvider="dp")
	 public void testm(String a,String b){
	  System.out.println(a);
	  System.out.println(b);
	  Assert.assertFalse(true);
	 }

	 @DataProvider
	 public Object[][] dp(){
	  Object[][] tabArray = null;
	  try {
	   FileInputStream ExcelFile = new FileInputStream("E:/Flight_source_latest.xlsx");
	   // Access the required test data sheet
	   ExcelWBook = new XSSFWorkbook(ExcelFile);
	   ExcelWSheet = ExcelWBook.getSheetAt(0);
	   int startRow = 1;
	   int startCol = 0;
	   int ci, cj;
	   int totalRows = ExcelWSheet.getLastRowNum();
	   System.out.println("TR = "+totalRows);
	   
	   int totalCols = ExcelWSheet.getRow(1).getLastCellNum();
	   System.out.println("TC = "+totalCols);
	   tabArray = new String[totalRows][totalCols];
	   ci = 0;
	   for (int i = startRow; i <= totalRows; i++, ci++) {
	    cj = 0;
	    for (int j = startCol; j < totalCols; j++, cj++) {
	     try {
	      tabArray[ci][cj] = getCellData(i, j);
	     } catch (Exception e) {
	      break;
	     }
	    }
	   }

	  }

	  catch (FileNotFoundException e) {
	   e.printStackTrace();
	  }

	  catch (IOException e) {
	   e.printStackTrace();
	  }
	  return (tabArray);
	 }

	 public Object getCellData(int RowNum, int ColNum) throws Exception {

	  try {

	   Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

	   int dataType = Cell.getCellType();

	   if (dataType == 3) {

	    return "";

	   } else if (dataType == 0) {
	    Object CellData = Cell.getRawValue();
	    return CellData;

	   } else {
	    Object CellData = Cell.getStringCellValue();
	    return CellData;
	   }

	  } catch (Exception e) {

	   System.out.println(e.getMessage());

	   throw (e);

	  }
	 }
	

}
