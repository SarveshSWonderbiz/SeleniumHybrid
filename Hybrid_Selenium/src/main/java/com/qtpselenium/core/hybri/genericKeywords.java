package com.qtpselenium.core.hybri;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class genericKeywords {
	public WebDriver driver;
	public Properties prop;
	ExtentTest test;
	
	
genericKeywords()
	{
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources/project.properties");
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public genericKeywords(ExtentTest test) {
	this.test = test;
}

	public void openBrowser(String browserType){
		if(browserType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarvesh Sawant\\Desktop\\Hybrid_Framework\\chromedriver.exe");
			driver = new ChromeDriver();
			WebDriverWait wait=new WebDriverWait(driver, 20);
		}else if(browserType.equals("Mozila")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarvesh Sawant\\Desktop\\Hybrid_Framework\\chromedriver.exe");
			driver = new ChromeDriver();
			WebDriverWait wait=new WebDriverWait(driver, 20);
		}
	}

	public void navigate(String urlkey){
		//System.out.println("Navigating to " +prop.getProperty(urlkey));
		test.log(LogStatus.INFO, "Navigating to " +prop.getProperty(urlkey));
		driver.get(prop.getProperty(urlkey));
	}
	
	public void click(String locatorkey){
		WebElement e = getElement(locatorkey);
		test.log(LogStatus.INFO, "Clicking on "+ getElement(locatorkey));
		e.click();
	}
	
	public void input(String locatorkey, String data){
		WebElement e = getElement(locatorkey);
		test.log(LogStatus.INFO, "Clicking on "+ getElement(locatorkey));
		e.sendKeys(data);	
	}
	
	public void verifyText(String xpath, String expectedText){
		
	}
	
	public void close()
	{
		test.log(LogStatus.INFO, "Closing Browser");
		driver.quit();
	}
	
	
	public WebElement getElement(String locatorkey)
	{
		WebElement e = null;
		
		System.out.println("Clicking on " +prop.getProperty(locatorkey));
		try {
			if(locatorkey.endsWith("_xpath")){
				e= driver.findElement(By.xpath(prop.getProperty(locatorkey)));
			}else if (locatorkey.endsWith("_id")){
				e= driver.findElement(By.xpath(prop.getProperty(locatorkey)));
			}else if (locatorkey.endsWith("_name")){
				e= driver.findElement(By.xpath(prop.getProperty(locatorkey)));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			reportFailure("Failure in Element Extraction-"+locatorkey);
		}
		return e;
	}
	/*******************************Reporting Functions***************/
	
	
	public void reportFailure(String FailureMessage){
		takeScreenshot();
		test.log(LogStatus.FAIL,FailureMessage);
		
	}
	
	public void takeScreenshot(){
		
	}
	
	
}
