package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	
	
	@DataProvider(name="userData")
	public static Object[][] getUserData()
	{
		Object arr[][]=ExcelReader.getData("Users");	
		
		return arr;
	}
	
	@DataProvider(name="userData1")
	public static Object[][] getUserData1()
	{
		
		Object arr[][]=ExcelReader.getData("Users1");
		
		return arr;
	}

}
