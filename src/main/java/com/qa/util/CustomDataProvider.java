package com.qa.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	
	@DataProvider(name="credentials")
	public static Object[][] testData() throws FileNotFoundException, IOException
	{
		Object[][]arr= ExcelReader.getDataFromSheet("Login");
	
		return arr;
		
	}
}
