package testLogin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DownloadBtn {
	
	public WebDriverWait wait;
	public WebDriver driver=null;
	
	@Test(priority = 1)
	public void testSetup() throws Exception {
		WebDriver driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://www.ishirqa.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    System.out.println("Login into the account");

		System.out.println("Entering into DownloadFunctionality method");		
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[5]")).click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	    driver.findElement(By.xpath("//div[@class='row']//div[contains(@class,'col-lg-8')]//a")).click();
	    System.out.println("Download button working");
	    
	    String parentHandle = driver.getWindowHandle(); // get the current window handle
	    for (String winHandle : driver.getWindowHandles())
	    {
	    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    driver.close(); // close newly opened window when done with it
	    driver.switchTo().window(parentHandle);
	 }

	}
