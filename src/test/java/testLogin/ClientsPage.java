package testLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Login1;
import pageObjects.Logout1;
public class ClientsPage {
	public WebDriverWait wait;
	public WebDriver driver;
	@Test
	public void LaunchURL(){
		driver =  new FirefoxDriver();
  		driver.manage().window().maximize();
  		wait = new WebDriverWait(driver, 5);
		driver.get("http://www.ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login into the account");

	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,2000)", "");
	WebElement image1 = driver.findElement(By.xpath(".//*[@id='owl-demo']/div/div/div[4]/div/img"));    
	System.out.println("Entering the loop");
	Boolean imageLoaded1 = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0", "image1"); 
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
	 
	

