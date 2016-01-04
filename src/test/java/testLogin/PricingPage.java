package testLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.Login1;

public class PricingPage {
WebDriver driver;
	String Actualtext;
	
	public void launchURL(){
		Login1.Browser(driver);
	}
	
	public void btn_pricing(){
		driver.findElement(By.xpath(".//*[@id='page-top']/nav/div/div/div[4]/ul/li[3]/a")).click();
		
		Actualtext = driver.findElement(By.xpath("//div[@class='static-banner']//h3[1]")).getText();
     	Assert.assertEquals(Actualtext,"Software Testing");
}
}
