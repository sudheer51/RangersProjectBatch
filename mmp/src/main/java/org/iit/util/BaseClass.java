package org.iit.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	protected WebDriver driver;
	 
	@Parameters({"browserType"})
	@BeforeClass
	public void setUpDriverInstance(String browserType)
	{
		System.out.println("in Setup Driver Instance");
		if(driver==null)
		{
			if(browserType.equals("FF"))
			{
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				System.out.println("in Firefox browser");
				driver = new FirefoxDriver();
			}
			else if(browserType.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else
			{
				System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
				driver= new ChromeDriver();
			}
		}

	}
}