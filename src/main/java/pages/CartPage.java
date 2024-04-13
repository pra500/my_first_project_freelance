package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import helper.Utility;

public class CartPage {
	
	
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	private By addtocartblue= By.xpath("//div[@class='container-child']//div[2]//div[2]//button[1]");
	
	private By abovecart=By.xpath("//button[@class='cartBtn']");
	
	
	private By totalpriceheading=By.xpath("//div[@class='container-child']//h3[1]");
	
	private By selenium=By.xpath("//h2[@class='name']");	
		
	private By enrollnowbtn=By.xpath("//button[text()='Enroll Now']");
	
	
	
	
	
	public void cartdata() throws InterruptedException
	{
			
		Utility.waitForWebElement(driver, addtocartblue).click();		

		Utility.waitForWebElement(driver, abovecart).click();
		
		Utility.waitForWebElement(driver, totalpriceheading).isDisplayed();
		
		Utility.waitForWebElement(driver, selenium).isDisplayed();
		
		Utility.waitForWebElement(driver, enrollnowbtn).click();	 
		
		
	}
			


			/*
			 * public boolean isUserLoggedIn() { boolean status=false;
			 * 
			 * try { //driver.findElement(manageOption).isDisplayed();
			 * Utility.waitForWebElement(driver, successful).isDisplayed(); status=true; }
			 * catch(NoSuchElementException e) {
			 * 
			 * } return status;
			 * 
			 * }
			 */
				


	

//	
//	public CartPage navigateToHomePage() {		
//		return new CartPage(driver);
//	}
//	
	
	
	

}
