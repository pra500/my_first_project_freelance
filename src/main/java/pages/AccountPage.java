package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	
	

	WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
 By myaccountlink = By.xpath("//span[normalize-space()='My Account']");
 By registerlink = By.xpath("//a[normalize-space()='Register']");
By firstname = By.id("input-firstname");
By lastname = By.id("");
By EMail = By.id("");

//span[normalize-space()='My Account']
//a[normalize-space()='Register']



//input-firstname
}
