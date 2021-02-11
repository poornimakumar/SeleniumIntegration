package com.qa.assessment.PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class Login extends BasePage {
	@FindBy(xpath = "//*[@id=\"user-name\"]")
	public WebElement username;
	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElement password;
	@FindBy(xpath ="//*[@id=\"login-button\"]")
	public WebElement loginbutton;
	public Login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void setUsername(String  Username) {	
		 username.sendKeys(Username);
		}
	public void setPassword(String Password) {	
		password.sendKeys(Password);
		}
	public Products clickLoginbutton(WebDriver driver)
	{
		loginbutton.click();	
		return new Products(driver);//open login page
	}
	
	public void takeScreenshot(String fileName) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File ("./Screenshots/" + fileName +".png"));
	}
//	public void takeScreenshot(String fileName) throws IOException {​​​​
//       // Take screenshot and store as a file format
//       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        // now copy the screenshot to desired location using copyFile //method
//        FileUtils.copyFile(src, 
//                new File("./Screenshots/" + fileName +".png"));
// 
//}
		
	}
