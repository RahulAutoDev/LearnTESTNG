package com.org.Test;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@Test
	public void loginPage()
	{
		System.out.println("Login Page");
	}
	
	@Test(dependsOnMethods="loginPage")
	public void HomePage()
	{
		System.out.println("Home Page");
	}
	
}
