package com.qa.assessment.TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.assessment.FileHandling.PropertyManager;

public class CrossBrowser {
	protected	WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("path.driver.chrome"));//accessing the web driver from property manager
		driver = new ChromeDriver();
		//driver.get(PropertyManager.getProperty("url.app"));// accessing the url for testing
	}
	
	else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", PropertyManager.getProperty("path.driver.gecko"));//accessing the web driver from property manager
		driver = new FirefoxDriver();
	//	driver.get(PropertyManager.getProperty("url.app"));// accessing the url for testing
	}
	
	else {
		throw new Exception("driver not found");
	}
	}
	
	
	@Test
	public void testCheck() throws IOException {
		driver.get(PropertyManager.getProperty("url.app"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
}
}
