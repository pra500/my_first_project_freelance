package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigReader;

public class Utility {
	
	
	

	/*
	 * Find the element until its clickable and It will highlight as well
	 */
	
	
	public static WebElement waitForWebElement(WebDriver driver,By locator)
	{
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		if(ConfigReader.getProperty("highlightElement").contains("true"))
		{
			return highlightWebElement(driver, element);
		}
		else
		{
			return element;
		}
	
	}
	
	public static WebElement waitForElement(WebDriver driver,By locator)
	{
		WebElement element=null;
		
		for(int i=0;i<30;i++)
		{
			
			try 
			{
				element=driver.findElement(locator);
				
				if(element.isDisplayed() && element.isEnabled())
				{
					if(ConfigReader.getProperty("highlightElement").contains("true"))
					{
						return highlightWebElement(driver, element);
					}
					else
					{
						return element;
					}
					//break;
				}
			} catch (Exception e) 
			{	
				System.out.println("Waiting for element conditions to be checked");
				wait(1);
			}
			
		}
			
		return element;
			
	}
	public static WebElement waitForElement(WebDriver driver,By locator,int time)
	{
		WebElement element=null;
		
		for(int i=0;i<time;i++)
		{
			
			try 
			{
				element=driver.findElement(locator);
				
				if(element.isDisplayed() && element.isEnabled())
				{
					if(ConfigReader.getProperty("highlightElement").contains("true"))
					{
						return highlightWebElement(driver, element);			
					}
					else
					{
						return element;
					}
					
				}
			} catch (Exception e) 
			{	
				System.out.println("Waiting for element conditions to be checked");
				wait(1);
			}
			
		}
			
		return element;
			
	}
	
	public static void wait(int second)
	{
		
		try 
		{
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			
			System.out.println("Something Went Wrong");
		}
	
	}
	
	public static WebElement highlightWebElement(WebDriver driver,WebElement ele)
	{	
		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px red')",ele);

		Utility.wait(1);
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black')",ele);

		return ele;
	}

	
	public static WebElement highlightWebElement(WebDriver driver,By locator)
	{
		
		WebElement ele=driver.findElement(locator);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px red')",ele);

		Utility.wait(1);
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black')",ele);

		
		return ele;
	}
	
	public static String getCurrentDate()
	{
		SimpleDateFormat myformat=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		
		String newFormat=myformat.format(new Date());
		
		return newFormat;
	}
	
	public static void captureScreenshot(WebDriver driver)
	{
		
		try 
		{
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\Admin\\eclipse-workspace\\Mukeshagain\\Screenshots\\screenshot"+getCurrentDate()+".png"));
			
		} catch (IOException e) {
			
			System.out.println("Exception "+e.getMessage());
		}
		
		
	}	
}
