package testLogin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;

public class ClientsPage {
	public WebDriverWait wait;
	public WebDriver driver;
	String Actualtext;
	
	public static Logger Log = Logger.getLogger(ClientsPage.class.getName());
	@Test
	public void LaunchURL() throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		
		BasicConfigurator.configure();
		ConsoleAppender appender = new ConsoleAppender();
		appender.activateOptions();
		
		driver =  new FirefoxDriver();
  		driver.manage().window().maximize();
  		wait = new WebDriverWait(driver, 5);
		driver.get("http://www.ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Login into the account");

	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,3000)", "");
	Thread.sleep(1000);

	WebElement image1 = driver.findElement(By.xpath(".//*[@id='owl-demo']/div/div/div[4]/div/img"));  
	Log.info("Entering the Loop");
	Boolean imageLoaded1 = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0", image1); 
	if (!imageLoaded1) 
	{ 
	System.out.println("1. Image is not present"); 
	} 
	else 
	{ 
	System.out.println("1. Got it"); 
	}
	Actualtext = driver.findElement(By.xpath("//div[@class='row']/div[@class='col-lg-12']/h1[text()='Clients Who Trust Us']")).getText();
 	Assert.assertEquals(Actualtext,"CLIENTS WHO TRUST US");
 	Reporter.log("User has succesfully verified the broken image");
	driver.quit();}
	
	}
	 
	

