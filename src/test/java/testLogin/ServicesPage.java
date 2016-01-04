package testLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ServicesPage {
String Actualtext;
	public WebDriver driver;
	
	public void ServicesTab(){
		driver.findElement(By.xpath(".//*[@id='page-top']/nav/div/div/div[4]/ul/li[4]/a")).click();
		Actualtext = driver.findElement(By.xpath(".//*[@id='services']/div/div/div/h1")).getText();
     	Assert.assertEquals(Actualtext,"services");
	}
}

