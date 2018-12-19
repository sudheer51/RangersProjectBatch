package org.iit.mmp.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTests {

	@Test
	public void verifyTitleTest()
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		String actual = driver.getTitle(); 
		String expected="Google";
		Assert.assertEquals(actual,expected);
	}
}
