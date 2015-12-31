package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageobj_model{
	
	public Pageobj_model(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyname']")
			public WebElement cs_name;
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyemail']")
			public WebElement cs_email; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyphone']")
			public WebElement cs_phone; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyzcode']")
			public WebElement cs_zipcode; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applybname']")
			public WebElement cs_business; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyemp']")
			public WebElement cs_emp; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyproname']") 
			public WebElement cs_product;
	@FindBy(xpath="//form[@id='applyForm']//input[@name='website']")
			public WebElement cs_website;
	@FindBy(xpath="//form[@id='applyForm']/div[12]/textarea")
			public WebElement cs_description;

}