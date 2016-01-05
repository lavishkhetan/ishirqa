package testLogin;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
public WebDriverWait wait;
public WebDriver driver;
	
//	    String element_xpath = ".//*[@id='ajaxLoadingModalPanelContainer'  and not(contains(@style,'display: none'))]";
//	    WebDriverWait wait = new WebDriverWait(driver, new TimeSpan(0, 2, 0));
//	    wait.Until(ExpectedConditions.ElementIsVisible(By.xpath(element_xpath));
//	    element_xpath = ".//*[@id='ajaxLoadingModalPanelContainer' and contains(@style,'DISPLAY: none')]";
//	    wait.Until(ExpectedConditions.ElementExists(By.xpath(element_xpath)));
//	driver.switchTo(By.)
//	}
//}

		 public void changeWindow(int i) {
			  Set<String> windows = driver.switchTo();
			  if (i > 0) {
			   for (int j = 0; j < 5; j++) {
			    if (windows.size() < 2) {
			     try {
			      Thread.sleep(2000);
			     } catch (Exception ex) {
			      ex.printStackTrace();
			     }
			    } else {
			     break;
			    }
			   }
			   windows = driver.switchTo();
			  }
			  String wins[] = windows.toArray(new String[windows.size()]);
			  driver.switchTo().window(wins[i]);

			  while (driver.getTitle().equalsIgnoreCase("about:blank")
			    || driver.getTitle().equalsIgnoreCase("")) {
			   wait.hardWait(2);
			  }
			 }
}