package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Utility;

public class SignupPage {
	

    WebDriver driver;
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
	}
		
	
		
	private By name=By.xpath("//input[@id='name']");
	
	private By email=By.xpath("//input[@id='email']");
	
	private By pwd=By.xpath("//input[@id='password']");
	
  private By interests=By.xpath("//input[@id='659df493900d50bf6e62a673']");
  
private By gender=By.xpath("//input[@id='gender2']");

private By state=By.xpath("//select[@id='state']");

private By hobbies=By.xpath("//select[@id='hobbies']");

   
private By signup=By.cssSelector("button[type='submit']");


//after successful:
private By successful=By.xpath("//h2[text()='Sign In']");

	
public void signupenterdetails(String NAme, String EMail) throws InterruptedException
{	
		
	Utility.waitForWebElement(driver, name).sendKeys(NAme);

	Utility.waitForWebElement(driver, email).sendKeys(EMail);
	
	Utility.waitForWebElement(driver, pwd).sendKeys("Jerry@3333");
	
	Utility.waitForWebElement(driver, interests).click();
	
	Utility.waitForWebElement(driver, gender).click();
	
	
	//state
	Select sel=new Select(driver.findElement(state));
	sel.selectByVisibleText("Bihar");
	
	
	
	//Hobbies
	Select sel1=new Select(driver.findElement(hobbies));
	sel1.selectByVisibleText("Singing");
	
			
	
//alternatives:
//	
//	WebElement myelement = driver.findElement(By.id("navigationPageButton"));
//	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//	jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
//	
	
	Actions act=new Actions(driver);
	act.click(driver.findElement(signup)).build().perform();
	
	
	
}
	
	

/*
 * 
 * public boolean isUserLoggedIn() throws InterruptedException { boolean
 * status=false;
 * 
 * try { //driver.findElement(manageOption).isDisplayed();
 * 
 * 
 * Utility.waitForWebElement(driver, successful).isDisplayed(); status=true; }
 * catch(NoSuchElementException e) {
 * 
 * }
 * 
 * return status;
 * 
 * }
 */

 
	

/*
 * public HomePage navigateToHomePage() throws InterruptedException {
 * Thread.sleep(12000); return new HomePage(driver); }
 */

public LoginPage navigateToLoginPage() throws InterruptedException {	
	Thread.sleep(12000);
	return new LoginPage(driver);
}



	
	
}
