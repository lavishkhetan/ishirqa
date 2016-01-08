package testLogin;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {

	public WebDriverWait wait;
	public WebDriver driver;
	int i;
	String Actualtext;
	@Test
		 public void changeWindow() throws Exception {
			 
			 	driver=new FirefoxDriver();
				driver.manage().window().maximize();
				wait = new WebDriverWait(driver, 5);
				driver.get("http://ishirqa.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Login into the account");

					driver.findElement(By.xpath("//a[@href='https://web.facebook.com/ishirinc/']")).click();	
				    System.out.println("navigated to fb");						    
				    String parentHandle1 = driver.getWindowHandle(); // get the current window handle
				    for (String winHandle : driver.getWindowHandles())
				    {
				    driver.switchTo().window(winHandle); 
				    }
				    Thread.sleep(1000);			    
				    Assert.assertEquals("Security Check Required",driver.getTitle());
				    driver.close(); // close newly opened window when done with it
				    driver.switchTo().window(parentHandle1);
				    Thread.sleep(1000);
				    
				    driver.findElement(By.xpath("//a[@href='https://twitter.com/ISHIR']")).click();
				    System.out.println("navigated to twitter");		    
				    String parentHandle2 = driver.getWindowHandle(); // get the current window handle
				    for (String winHandle : driver.getWindowHandles())
				    {
				    driver.switchTo().window(winHandle); 
				    }
				    Thread.sleep(1000);
				    Assert.assertEquals("ISHIR (@ISHIR) | Twitter",driver.getTitle());
				    driver.close(); // close newly opened window when done with it
				    driver.switchTo().window(parentHandle2);
				    Thread.sleep(1000);
				    
				    driver.findElement(By.xpath("//a[@href=' https://www.linkedin.com/company/ishir-infotech?trk=top_nav_home']")).click();
				    System.out.println("navigated to Linkedin");		    
				    String parentHandle3 = driver.getWindowHandle(); // get the current window handle
				    for (String winHandle : driver.getWindowHandles())
				    {
				    driver.switchTo().window(winHandle); 
				    }
				    Thread.sleep(1000);
				    Actualtext = driver.findElement(By.xpath("//div[@class='join-linkedin-promo']/h3")).getText();
			     	Assert.assertEquals(Actualtext,"Keep up with ISHIR");
//				    Assert.assertEquals("ISHIR | LinkedIn",driver.getTitle());
				    driver.close(); // close newly opened window when done with it
				    driver.switchTo().window(parentHandle3);
				    Thread.sleep(1000);
				    
				    driver.findElement(By.xpath("//a[@href='https://plus.google.com/+Ishir']")).click();
				    System.out.println("navigated to google+");		    
				    String parentHandle4 = driver.getWindowHandle(); // get the current window handle
				    for (String winHandle : driver.getWindowHandles())
				    {
				    driver.switchTo().window(winHandle); 
				    }
				    Thread.sleep(1000);
				    Assert.assertEquals("ISHIR - Google+",driver.getTitle());
				    driver.close(); // close newly opened window when done with it
				    driver.switchTo().window(parentHandle4);
				    driver.quit();
	}
}
