package testLogin;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	@Test(priority=1)
	public void dynamicPage(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login into the account");
	}
	@Test(priority=2)
		public void clickLinkByHref(String data, int position) {
		    List<WebElement> anchors = driver.findElements(By.partialLinkText("data-slide-to"));
		    Iterator<WebElement> i = anchors.iterator();
//		    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		    int j = 0;
		    while(i.hasNext()) {
		        WebElement anchor = i.next();
		 
		     if(anchor.getAttribute("data-target").contains(data)) {
		         j++;
		     }
		 
		     if(anchor.getAttribute("data-target").contains(data)
		                && j == position) {
		         anchor.click();
		         break;
		     }
		 	
		    }
		}

//			try{
//		      driver.get("http://ishirqa.com/");
//		      (new WebDriverWait(driver, 10/*sec*/)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='myCarousel']/div[1]/ol/li[1]")));
//		      System.out.println("Login into the account");
//		      List<WebElement> dailyList = driver.findElements(By.xpath(".//*[@id='myCarousel']/div[1]/ol/li[1]"));
//		      if (dailyList.size()!=0) {
//		                dailyList.get(0).click();
//		            }
//		}
//		catch (Exception e) {
//		       e.printStackTrace();  
//		}   
//		finally{
//		       driver.close();
//		} 
		
	}

