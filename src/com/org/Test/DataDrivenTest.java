package com.org.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.util.testUtil;

public class DataDrivenTest {
	
	static WebDriver driver;
	
	@BeforeMethod
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rahulsingh/Desktop/MyComputer/Automation/Drivers/chromedriver_latest");
		driver = new ChromeDriver();
		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror%3Fstatuscode%3D500");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	@DataProvider(name="excel-data")
	public Object[][] getTestData()
	{
		Object[][] data = testUtil.getDataFromExcel();
		return data;
	}
	
	// ---retryAnalyzer = RetryAnalyzer.class--- If want to provide retry logic on every @Test manually
	
	@Test(dataProvider="excel-data")
	public void testRegisteration(String fname, String lname, String email, String password)
	{
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(fname);
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lname);
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(email);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
