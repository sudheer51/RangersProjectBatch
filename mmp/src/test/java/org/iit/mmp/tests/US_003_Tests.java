package org.iit.mmp.tests;

import org.iit.util.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class US_003_Tests extends BaseClass{
	
	@Test
	public void a()
	{

		 
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("Title is ::" + title);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}

}
