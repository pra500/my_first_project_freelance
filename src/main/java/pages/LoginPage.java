package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import helper.Utility;

public class LoginPage {
	
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
		
	private By  email=By.id("email1");	
	private By  pwd= By.id("password1");	
	private By signinbtn= By.xpath("//button[@type='submit']");	
	private By newusersignuplnk= By.xpath("//a[@class='subLink']");
	
			 
	
	
	public void logindata(String eemail, String pass) throws InterruptedException
	{
			
		Utility.waitForWebElement(driver, email).sendKeys(eemail);	

		Utility.waitForWebElement(driver, pwd).sendKeys(pass);
		
		
		Utility.waitForWebElement(driver, signinbtn).click();
		
		Thread.sleep(2000);
		
		//Utility.waitForWebElement(driver, newusersignuplnk).isDisplayed();		
		
		
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
				


	

	
	  public HomePage navigateToHomePage() throws InterruptedException	  
	  {
	  Thread.sleep(12000);
	  return new HomePage(driver);
	  
	  }
	 
	
	
	

}
