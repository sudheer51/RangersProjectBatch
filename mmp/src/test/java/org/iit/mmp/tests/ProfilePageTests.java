package org.iit.mmp.tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProfilePageTests {

	
	WebDriver driver;
	 
	@Test
	public void verifyHistoryElements( ) throws Exception{

		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/profile.php");
		navigateToProfilePage();
		clickOnViewHistory();
		Assert.assertTrue(retreiveButtonText("PAST TRANSACTION"));
		Assert.assertTrue(retreiveButtonText("PAST APPOINTMENTS"));
		Assert.assertTrue(retreiveButtonText("PAST DIAGNOSIS"));
		Assert.assertTrue(retreiveButtonText("PAST PRESCRIPTION"));
		
		
	}
	
	public void navigateToProfilePage()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
	}
	public void clickOnViewHistory()
	{
		driver.findElement(By.xpath("//button[text()='View History']")).click();
	}
	public boolean retreiveButtonText(String expected) throws InterruptedException
	{
		String expectedArr[]=expected.split(" ");
		String str1= expectedArr[0].substring(1, expectedArr[0].length()).toLowerCase();
		String str2=expectedArr[1].substring(1, expectedArr[1].length()).toLowerCase();
		String xpathExp = expectedArr[0].substring(0,1)+str1+" "+expectedArr[1].substring(0,1)+str2;
		Thread.sleep(5000);
		//input[@value="Past Transaction"]
		String actual = driver.findElement(By.xpath("//input[@value='"+xpathExp+"']")).getText();
		System.out.println("Actual " + actual +"" + actual.length());
		System.out.println("expected"+ expected+""+ expected.length());
		return expected.equals(actual);
	}
	
	
}
