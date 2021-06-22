package com.org.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {
	
	static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"url"})
	public static void openBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rahulsingh/Desktop/MyComputer/Automation/Drivers/chromedriver_latest");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	@Test(priority=1,groups="Title")
	public void getBrowserTitle()
	{
		String name = driver.getTitle();
		System.out.println("Browser Title: " + name);
		Assert.assertEquals(name, "Google", "Title did not match");
	}
	
	@Test(priority=3,groups="Image")
	public void testBrowserImage()
	{
		boolean result  = driver.findElement(By.xpath("//*[contains(@class,'lnXdpd')]")).isDisplayed();
		System.out.println("Image Test: " + result);
	}
	
	@Test(priority=2,groups="Link")
	public void testGmailLink()
	{
		boolean gmailLink = driver.findElement(By.xpath("//*[contains(text(),'Gmail')]")).isDisplayed();
		System.out.println("Gmail Link Test: "+ gmailLink);
	}
	
	@Test
	public void test1()
	{
		System.out.println("Default Test: ");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
