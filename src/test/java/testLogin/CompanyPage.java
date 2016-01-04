package testLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Login1;

public class CompanyPage {
WebDriver driver;
public WebDriverWait wait;
	
	@BeforeTest
	public void LaunchTheBeaseURL() {
		Login1.Browser(driver);
	}
	@Test	
	public void ToolTip(){
	    
//	    Actions actions = new Actions();
//	    WebElement mainMenu = driver.findElement(By.linkText("menulink"));
//	    actions.moveToElement(mainMenu);
//
//	    WebElement subMenu = driver.findElement(By.cssSelector("subLinklocator"));
//	    actions.moveToElement(subMenu);
//	    actions.click().build().perform();

		WebElement element = driver.findElement(By.cssSelector(".active>ul>li>a"));
		// Get tooltip text
		String toolTipText = element.getAttribute("title");
		System.out.println("Tool tip text present :- " + toolTipText);

		// Compare toll tip text
		Assert.assertEquals("Why ISHIR QA?", toolTipText);
}
}
