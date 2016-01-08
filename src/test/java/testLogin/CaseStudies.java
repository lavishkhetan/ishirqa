package testLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObjects.Pageobj_model;

public class CaseStudies {

	public WebDriver driver;
	public WebDriverWait wait;
	String appURL = "http://ishirqa.com/";
	String Actualtext;

	@BeforeClass
	public void testSetup() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://ishirqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login into the account");
	}
	
	@Test(priority = 1)
	public void caseStudies() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000)", "");
		driver.findElement(By.id("learnmore")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("applynow")).click();
	}
	
	@Test(priority = 2, dataProvider="UserLogin")
	public void VerifyDataEntry(String userName,String emailAdd, String phoneNo, String zipCode, String businessName, String noOfEmp, String product, String websiteBlk, String describe) {

	Pageobj_model page = new Pageobj_model(driver);
	
	page.cs_name.sendKeys(userName);
	page.cs_email.sendKeys(emailAdd);
	page.cs_phone.sendKeys(phoneNo);
	page.cs_zipcode.sendKeys(zipCode);
	page.cs_business.sendKeys(businessName);
	page.cs_emp.sendKeys(noOfEmp);
	page.cs_product.sendKeys(product);
	page.cs_website.sendKeys(websiteBlk);
	page.cs_description.sendKeys(describe);
	}
	
	@DataProvider(name="UserLogin")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData("C:\\Users\\lkhetan\\workspace\\myMaven\\DataSets\\DataFile.xls","Data");
		return arrayObject;
	}

	public String[][] getExcelData(String DataFile, String Data) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(DataFile);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(Data);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {
				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	@Test(priority = 3)
	public void submitForm() throws InterruptedException{
		driver.findElement(By.id("submitapplyForm")).click();
		Thread.sleep(1000);
		Actualtext = driver.findElement(By.xpath("//section[@id='about']/div/div/div[1]/p")).getText();
     	Assert.assertEquals(Actualtext,"Our representative will contact you soon.");
     	System.out.println("Assertion Working for Submit page");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

