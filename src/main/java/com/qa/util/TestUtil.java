package com.qa.util;

import com.qa.base.Testbase;

public class TestUtil extends Testbase {

	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT=10;
	
	public void switchToframe()
	{
		driver.switchTo().frame("");
		}
}
