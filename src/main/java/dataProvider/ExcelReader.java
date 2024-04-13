package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	static XSSFWorkbook wb;

	public static Object [][] getData(String sheetName)
	{
		
		try 
		{
			String path="C:\\Users\\Admin\\eclipse-workspace\\Mukeshagain\\src\\main\\java\\TestData\\UserData.xlsx";
			//String path="C:\\Users\\Admin\\eclipse-workspace\\Mukeshagain\\src\\main\\java\\TestData\\mydata.xlsx";
			FileInputStream fip=new FileInputStream(path);
			
			wb=new XSSFWorkbook(fip);
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
		
		}
		
		int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
		
		int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		
		Object arr[][]=new Object[row-1][column];
		
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
					arr[i-1][j]=getData(wb,sheetName, i, j);
			}
		}
	
		return arr;
	}
	
	
	public static String getData(XSSFWorkbook wb,String sheetName,int row,int column)
	{
		
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		
		String data="";
		
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			data=String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BOOLEAN)
		{
			data=String.valueOf(cell.getBooleanCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
	
		return data;
	}
	
		
	

}
