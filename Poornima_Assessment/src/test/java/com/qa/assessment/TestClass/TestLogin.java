package com.qa.assessment.TestClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.assessment.FileHandling.PropertyManager;
import com.qa.assessment.PageObjects.Login;
import com.qa.assessment.PageObjects.Products;
import com.qa.assessment.PageObjects.YourCart;

import bsh.ParseException;




public class TestLogin extends BaseTest {
	private static Logger log;
	@Test(priority=1,dataProvider="AddingToCart")
	public void signin(String username,String password) throws IOException, InterruptedException{
		log= LogManager.getLogger(Login.class.getName());
		log.debug("Execution Started");
		//navigate to the food delivery url
		driver.get(PropertyManager.getProperty("url.app"));
		driver.manage().window().maximize();

		//Object of home
		Login h1 = new Login(driver);
		Products p1 = new Products(driver);
		YourCart yc = new YourCart(driver);


		h1.username.sendKeys(username);
		h1.password.sendKeys(password);
		h1.loginbutton.click();
		driver.manage().timeouts().pageLoadTimeout(13000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(13000, TimeUnit.SECONDS);
		p1.addtocart.click();
		driver.manage().timeouts().pageLoadTimeout(13000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(13000, TimeUnit.SECONDS);
		p1.cart.click();
		driver.manage().timeouts().pageLoadTimeout(13000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(13000, TimeUnit.SECONDS);
		h1.takeScreenshot("YourCart"); 
	}
	@DataProvider(name="AddingToCart")
	public Object[][] getValidCredentials()
	{
		return new Object[][]
				{
			{"standard_user","secret_sauce"}
				};

	}
	@Test(priority=2,dataProvider="AddingToCartByJSON")
	public void signin(String data) throws IOException, InterruptedException{
		String users[] = data.split(",");
		driver.get(PropertyManager.getProperty("url.app"));
		driver.manage().window().maximize();
		Login h1 = new Login(driver);
		Products p1 = new Products(driver);
		YourCart yc = new YourCart(driver);
		driver.manage().timeouts().pageLoadTimeout(13000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(13000, TimeUnit.SECONDS);
		h1.setUsername(users[0]);;
		h1.setPassword(users[1]);;
		h1.loginbutton.click();
		driver.manage().timeouts().pageLoadTimeout(13000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(13000, TimeUnit.SECONDS);
		p1.addtocart.click();
		driver.manage().timeouts().pageLoadTimeout(13000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(13000, TimeUnit.SECONDS);
		p1.cart.click();

		//  Assert.assertEquals(false,true);
	}
	@DataProvider(name="AddingToCartByJSON")
	public String[] readJson8() throws IOException, org.json.simple.parser.ParseException    {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("src\\test\\resources\\JSONData\\TestData.json");

		Object obj = jsonParser.parse(reader);

		JSONObject userloginsJsonobj = (JSONObject) obj;
		JSONArray userloginsArray = (JSONArray) userloginsJsonobj.get("AddingToCartByJSON");

		String arr[] = new String[userloginsArray.size()];

		for(int i=0;i<userloginsArray.size();i++) {
			JSONObject users = (JSONObject) userloginsArray.get(i);
			String user = (String) users.get("username");
			String pwd = (String) users.get("password");
			arr[i] = user+","+pwd;
		}
		return arr;
	}


}
