package org.iit.mmp.tests;

import java.util.Random;

import org.iit.mmp.pages.RegisterationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MMPTests {
	
	WebDriver driver;
	@Parameters({"url"})
	@Test
	public void registerPatientTest(String url) throws Exception{

		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		Random rnd = new Random();
		String username = "test"+rnd.nextInt(90);
		String password = "test";
		String email = "test"+rnd.nextInt(90)+"@gmail.com";
		RegisterationPage regPage = new RegisterationPage(driver);
		regPage.register(email,username,password);

	}
	
	@Test(enabled=false)
	public void verifyLogin()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	
		SoftAssert sa = new SoftAssert();
		
		//First Verification point
		String actualTitle = login("ria1","Ria12345");
		String expectedTitle = "home";
		sa.assertEquals(actualTitle, expectedTitle);
	
		//Second Verification point
		boolean result = validateUserNameinHomePage("ria1");
		sa.assertTrue(result);
		
		sa.assertAll();
		
	}

	public String login(String username,String password) 
	{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		return driver.getTitle();	
	}
	public boolean validateUserNameinHomePage(String expected)
	{
	   
	   String actual =driver.findElement(By.tagName("h3")).getText();
	   System.out.println("Actual username value" + actual);
	   boolean result = actual.equals(expected);
	   return result;
	}
	public boolean verifyTableHeader(String expected)
	{

	String actual = driver.findElement(By.xpath("//table[@class='table']/thead/tr/th[contains(text(),'"+expected+"')]")).getText();	

	return actual.equals(expected);


	}
}
