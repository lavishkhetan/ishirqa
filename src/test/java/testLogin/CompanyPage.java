package testLogin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompanyPage {
public WebDriver driver;
public WebDriverWait wait;
String Actualtext;
	@Test	
	public void ToolTip() throws Exception{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login into the account");
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='page-top']/nav/div/div/div[5]/ul/li[2]/a"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath(".//*[@id='page-top']/nav/div/div/div[5]/ul/li[2]/ul/li/a"))).click().build().perform();
		System.out.println("Clicked on Why ISHIR QA?");

		Actualtext = driver.findElement(By.xpath("//h1[text()='Why ISHIR QA?']")).getText();
     	Assert.assertEquals(Actualtext,"WHY ISHIR QA?");
     	System.out.println("Why ISHIR QA? mouse hover functionality is working");
	}
	
}
