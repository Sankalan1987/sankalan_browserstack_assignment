package com.browserstack.demo.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ParallelTestWithMultiThreadBrowserStack  {
	
	RemoteWebDriver driver = null;
	
	By home_close_btn = By.xpath("//*[text()='✕']");
	By home_search_field = By.name("q");
	By category_mobiles = By.xpath("//*[text()='CATEGORIES']/parent::div/following-sibling::div//a[text()='Mobiles']");
	By mobile_brand = By.xpath("//*[text()='SAMSUNG']");
	By icon_fpKartAssured = By.xpath("(//*[contains(@src,'62673a.png')])[1]");
	By price_high_to_low = By.xpath("//*[text()='Price -- High to Low']");
	By product_name = By.xpath("//*[contains(text(),'SAMSUNG Galaxy')]");
	By product_link = By.xpath("//*[contains(text(),'SAMSUNG Galaxy')]/ancestor::a");
	
	@Test()
	public void testOnChromeWithFlipKartUrl() throws MalformedURLException {
		
		DesiredCapabilities caps_chrome = new DesiredCapabilities();
        caps_chrome.setCapability("os", "Windows");
        caps_chrome.setCapability("os_version", "10");
        caps_chrome.setCapability("browser", "Chrome");
        caps_chrome.setCapability("browser_version", "latest");
        caps_chrome.setCapability("browserstack.local", "false");
        caps_chrome.setCapability("browserstack.selenium_version", "3.14.0");
        caps_chrome.setCapability("project", "Sample Test Automation");
        caps_chrome.setCapability("build","Demo_Build");
        caps_chrome.setCapability("name", "testOnChromeWithFlipKartUrl");
        caps_chrome.setCapability("browserstack.idleTimeout", 300);
        caps_chrome.setCapability("browserstack.networkLogs", "true");
        driver = new RemoteWebDriver(
                new URL("https://" + "sankalanbanerjee2" + ":" + "p4XgzpB4gmoJGvmTRDDQ" + "@hub-cloud.browserstack.com/wd/hub"),caps_chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("Test started in Chrome");
		driver.get("https://www.flipkart.com/");
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(home_close_btn));
			
			System.out.println("Home Page Loaded");
			
			driver.findElement(home_close_btn).click();
			
			System.out.println("Clicked on Close Button");
			
			driver.findElement(home_search_field).sendKeys("Samsung Galaxy S10"+Keys.ENTER);
			
			System.out.println("Samsung Galaxy S10 entered in Search field");
			
			try {
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(category_mobiles));
				
				driver.findElement(category_mobiles).click();
				
				System.out.println("Clicked on Mobiles Category");
				
				WebElement elm = driver.findElement(mobile_brand);
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm);
				
				System.out.println("SAMSUNG Brand selected");
				
				wait.until(ExpectedConditions.elementToBeClickable(icon_fpKartAssured));
				
				WebElement elm1 = driver.findElement(icon_fpKartAssured);
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm1);
				
				System.out.println("Flipkart Assured selected");
				
				wait.until(ExpectedConditions.elementToBeClickable(price_high_to_low));
				
				driver.findElement(price_high_to_low).click();
				
				System.out.println("Price High to Low selected");
				
				Thread.sleep(20000);
				
				wait.until(ExpectedConditions.elementToBeClickable(product_name));
				
				List<WebElement> productList = driver.findElements(product_name);
			//	List<WebElement> productPrice = driver.findElements(product_name);
				List<WebElement> productLink = driver.findElements(product_link);
				
				int iCount = 0;
				for(WebElement product : productList) {
					System.out.println("Product Name = " + product.getText() + " Product Link = " + productLink.get(iCount).getAttribute("href"));
					iCount++;
				}
				
			} catch(Exception ex) {
				System.out.println("Categories Page not loaded");
			}
			
		} catch(Exception ex) {
			System.out.println("Close Button not present");
		}
		driver.quit();
	}
	
	@Test()
	public void testOnFirefoxWithFlipKartUrl() throws MalformedURLException {
		RemoteWebDriver driver = null;
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("os", "Windows");
		firefoxOptions.setCapability("os_version", "10");
		firefoxOptions.setCapability("browser", "Firefox");
		firefoxOptions.setCapability("browser_version", "latest");
		firefoxOptions.setCapability("browserstack.local", "false");
		firefoxOptions.setCapability("browserstack.selenium_version", "3.14.0");
		firefoxOptions.setCapability("project", "Sample Test Automation");
		firefoxOptions.setCapability("build","Demo_Build");
		firefoxOptions.setCapability("name", "testOnFirefoxWithFlipKartUrl");
		firefoxOptions.setCapability("browserstack.idleTimeout", 300);
		firefoxOptions.setCapability("browserstack.networkLogs", "true");
		driver = new RemoteWebDriver(
				new URL("https://" + "sankalanbanerjee2" + ":" + "p4XgzpB4gmoJGvmTRDDQ" + "@hub-cloud.browserstack.com/wd/hub"),firefoxOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("Test started in Firefox");
		
		driver.get("https://www.flipkart.com/");
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(home_close_btn));
			
			System.out.println("Home Page Loaded");
			
			driver.findElement(home_close_btn).click();
			
			System.out.println("Clicked on Close Button");
			
			driver.findElement(home_search_field).sendKeys("Samsung Galaxy S10"+Keys.ENTER);
			
			System.out.println("Samsung Galaxy S10 entered in Search field");
			
			try {
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(category_mobiles));
				
				driver.findElement(category_mobiles).click();
				
				System.out.println("Clicked on Mobiles Category");
				
				WebElement elm = driver.findElement(mobile_brand);
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm);
				
				System.out.println("SAMSUNG Brand selected");
				
				wait.until(ExpectedConditions.elementToBeClickable(icon_fpKartAssured));
				
				WebElement elm1 = driver.findElement(icon_fpKartAssured);
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm1);
				
				System.out.println("Flipkart Assured selected");
				
				wait.until(ExpectedConditions.elementToBeClickable(price_high_to_low));
				
				driver.findElement(price_high_to_low).click();
				
				System.out.println("Price High to Low selected");
				
				Thread.sleep(20000);
				
				wait.until(ExpectedConditions.elementToBeClickable(product_name));
				
				List<WebElement> productList = driver.findElements(product_name);
			//	List<WebElement> productPrice = driver.findElements(product_name);
				List<WebElement> productLink = driver.findElements(product_link);
				
				int iCount = 0;
				for(WebElement product : productList) {
					System.out.println("Product Name = " + product.getText() + " Product Link = " + productLink.get(iCount).getAttribute("href"));
					iCount++;
				}
				
			} catch(Exception ex) {
				System.out.println("Categories Page not loaded");
			}
			
		} catch(Exception ex) {
			System.out.println("Close Button not present");
		}
		driver.quit();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}