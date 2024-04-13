package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import helper.Utility;

public class HomePage {
	
	
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//webelement
	
	private By learnautomationcourses= By.xpath("//h1[normalize-space()='Learn Automation Courses']");	
	
	private By cypress= By.xpath("//h2[normalize-space()='Cypress']");
	
	private By selenium= By.xpath("//h2[normalize-space()='Selenium']");
	
	private By addtocart= By.xpath("//button[contains(text(),'Add to Cart')]");
	
	
	
	public void homedata() throws InterruptedException
	{
			
		Utility.waitForWebElement(driver, learnautomationcourses).isDisplayed();		

		Utility.waitForWebElement(driver, cypress).isDisplayed();
		
		Utility.waitForWebElement(driver, selenium).isDisplayed();
		
		Utility.waitForWebElement(driver, addtocart).isDisplayed();		
		
		
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
				


	

	
	public CartPage navigateToCartPage() throws InterruptedException {	
		Thread.sleep(12000);
		return new CartPage(driver);
	}
	
	
	
	

}
