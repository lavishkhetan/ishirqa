package testLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Login1;
import pageObjects.Logout1;
public class ClientsPage {
	
	public WebDriver driver;
	@BeforeTest
	public void LaunchURL(){
		Login1.Browser(driver);
	}
	@Test
	public void checkImage(){
	WebElement image1 = driver.findElement(By.xpath(".//*[@id='owl-demo']/div/div/div[4]/div/img"));    

	Boolean imageLoaded1 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != "undefined" && arguments[0].naturalWidth > 0", image1); 
	if (!imageLoaded1) 
	{ 
	System.out.println("1. Image is not present"); 
	} 
	else 
	{ 
	System.out.println("1. Got it"); 
	}}

	@AfterTest
		public void logout(){
			Logout1.loggoff(driver);}
	
	}
	 
	

