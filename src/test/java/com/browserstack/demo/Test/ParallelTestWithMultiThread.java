package com.browserstack.demo.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;

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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ParallelTestWithMultiThread  {
	
	By home_close_btn = By.xpath("//*[text()='✕']");
	By home_search_field = By.name("q");
	By category_mobiles = By.xpath("//*[text()='CATEGORIES']/parent::div/following-sibling::div//a[text()='Mobiles']");
	By mobile_brand = By.xpath("//*[text()='SAMSUNG']");
	By icon_fpKartAssured = By.xpath("(//*[contains(@src,'62673a.png')])[1]");
	By price_high_to_low = By.xpath("//*[text()='Price -- High to Low']");
	By product_name = By.xpath("//*[contains(text(),'SAMSUNG Galaxy')]");
	By product_link = By.xpath("//*[contains(text(),'SAMSUNG Galaxy')]/ancestor::a");
	
	@Test()
	public void testOnChromeWithFlipKartUrl() {
		WebDriver driver;
		WebDriverManager.chromedriver().driverVersion("89.0.4389.23").setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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
	public void testOnFirefoxWithFlipKartUrl() {
		WebDriver driver;
		WebDriverManager.firefoxdriver().driverVersion("0.29.1").setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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
	
}