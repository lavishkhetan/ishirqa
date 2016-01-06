package testLogin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicPageHandle {

	public WebDriver driver;
	public WebDriverWait wait;
	@Test
	public void dynamicPage(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
			try{
		      driver.get("http://ishirqa.com/");
		      (new WebDriverWait(driver, 10/*sec*/)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='myCarousel']/div[1]/ol/li[1]")));
		      System.out.println("Login into the account");
		      List<WebElement> dailyList = driver.findElements(By.xpath(".//*[@id='myCarousel']/div[1]/ol/li[1]"));
		      if (dailyList.size()!=0) {
		                dailyList.get(0).click();
		            }
		}
		catch (Exception e) {
		       e.printStackTrace();  
		}   
		finally{
		       driver.close();
		} 
		
	}
}
