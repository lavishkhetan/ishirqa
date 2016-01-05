package testLogin;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {

	public WebDriverWait wait;
	public WebDriver driver;
	int i;
	@Test
		 public void changeWindow() throws Exception {
			 
			 	driver=new FirefoxDriver();
				driver.manage().window().maximize();
				wait = new WebDriverWait(driver, 5);
				driver.get("http://ishirqa.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Login into the account");
				
			  Set<String> windows = driver.getWindowHandles();
			  if (i > 0) {
			   for (int j = 0; j < 5; j++) 
			   {
			    if (windows.size() < 2) 
			    {
			     try 
			     {
			      Thread.sleep(2000);		      
			     }
			     catch (Exception ex) {
			      ex.printStackTrace();
			     }
			    } else {
			     break;
			    }
			   }
			   windows = driver.getWindowHandles();
			  }
			  String wins[] = windows.toArray(new String[windows.size()]);
			  driver.switchTo().window(wins[i]);

			  while (driver.getTitle().equalsIgnoreCase("about:blank")
			    || driver.getTitle().equalsIgnoreCase("")) {
			   Thread.sleep(2000);
			  }		  
			 }
}