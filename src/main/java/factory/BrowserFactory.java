package factory;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import dataProvider.ConfigReader;

public class BrowserFactory {
	
	
    public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriver startBrowser(String browserName,String appURL)
	{
		
		if(browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("GC") || browserName.equalsIgnoreCase("Google Chrome"))
		{
			
			System.out.println("Browser Captured "+browserName);
			
ChromeOptions opt=new ChromeOptions();
			
			opt.addArguments("--no-sandbox");
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			capabilities.setCapability("browserName", "chrome");
			
			//capabilities.setCapability("browserVersion", "117.0");
			
			//capabilities.setCapability("platformName", "linux");
			
			opt.merge(capabilities);
			
			
			//*************my code***********
			driver=new ChromeDriver();
			//*************my code***********
			
			
		} else if(browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF") || browserName.equalsIgnoreCase("Mozila"))
		{
		
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge") || browserName.equalsIgnoreCase("Microsoft Edge") || browserName.equalsIgnoreCase("MSEdge"))
		{
			
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
			
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTimeOut"))));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
		
		driver.get(appURL);
		
		return driver;
	}
	}
