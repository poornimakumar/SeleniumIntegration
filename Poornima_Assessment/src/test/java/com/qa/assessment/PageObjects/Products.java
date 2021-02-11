package com.qa.assessment.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Products extends BasePage {

	public Products(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
	public WebElement addtocart;
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
	public WebElement cart;
	
	public void clickAddtocart(WebDriver driver)
	{
		addtocart.click();	
		//open login page
	}
	public YourCart clickCart(WebDriver driver)
	{
		cart.click();	
		return new YourCart(driver);//open login page
	}
	}

	


