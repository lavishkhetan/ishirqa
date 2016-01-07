package testLogin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPageHandle {

	public WebDriver driver;
	public WebDriverWait wait;
	String Actualtext;
	WebElement element;
	
	@Test
	public void dynamicPage() throws Exception{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login into the account");
	}
	@Test
	public void dynamicPanel() throws Exception{
		
	 	element = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[1]/ol"));
     	element.click();
     	for(int i=1;i<4;i++);{
     	        Thread.sleep(1000);
     	        element.click();
     	    }
		
		driver.findElement(By.xpath("//ol[@class='carousel-indicators']/li[1]")).click();
		Thread.sleep(1000);
		Actualtext = driver.findElement(By.xpath("//div[@class='container']/h1")).getText();
     	Assert.assertEquals(Actualtext,"IT IS ALREADY TOO LATE.");
     	System.out.println("1st btn of homepageslider is working");
     	
		driver.findElement(By.xpath("//ol[@class='carousel-indicators']/li[2]")).click();
		Thread.sleep(1000);
		Actualtext = driver.findElement(By.xpath("//div[@class='homepageslider']/h4/span[2]")).getText();
     	Assert.assertEquals(Actualtext,"ENGAGEMENTS");
     	System.out.println("2nd btn of homepageslider is working");
    	
		driver.findElement(By.xpath("//ol[@class='carousel-indicators']/li[3]")).click();
		Thread.sleep(1000);
		Actualtext = driver.findElement(By.xpath("//div[@class='homepageslider']/h5[1]/span[1]")).getText();
     	Assert.assertEquals(Actualtext,"SOFTWARE TESTING TEAM");
     	System.out.println("3rd btn of homepageslider is working");
     	
		driver.findElement(By.xpath("//ol[@class='carousel-indicators']/li[4]")).click();
		Thread.sleep(1000);
		Actualtext = driver.findElement(By.xpath("(//div[@class='homepageslider']//h5/span[1])[2]")).getText();
     	Assert.assertEquals(Actualtext,"SOFTWARE TESTING TEAM");
     	System.out.println("4th button of homepageslider is working");
     	  
	}
}
