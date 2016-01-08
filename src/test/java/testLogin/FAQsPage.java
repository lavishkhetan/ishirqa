package testLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FAQsPage {

	public WebDriver driver;
	String Actualtext;
	public WebDriverWait wait;
	@Test
	public void FaqTab(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login into the account");

		driver.findElement(By.xpath("//a[@class='page-scroll' and text()='FAQ']")).click();
		System.out.println("Entered FAQ");
		
//		Actualtext = driver.findElement(By.xpath("//div[@class='static-banner']//h3[text()='Usability and functionality ']")).getText();
//     	Assert.assertEquals(Actualtext,"USABILITY AND FUNCTIONALITY TESTING IN ONE!");
     	System.out.println("Assertion Working for FAQ tab");
     	JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		
		Actualtext = driver.findElement(By.xpath("//div[@class='row']//h1[text()='Frequently Asked Questions ']")).getText();
     	Assert.assertEquals(Actualtext,"FREQUENTLY ASKED QUESTIONS (FAQs)");
     	driver.quit();
	}
}
