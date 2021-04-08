package com.travel.adminPage;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class AddPostPage extends BasePage{
	final static Logger logger = Logger.getLogger(AddPage.class);

	public AddPostPage wait_UntilAddPostPageComplete() throws Exception {
		logger.info("Step:>Waiting for Add Post Pageload Complete");
		try {
			Thread.sleep(2000);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement submit = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".btn.btn-primary"));
				}

			});
			assertNotNull(submit);
		} catch (Exception e) {
			logger.error("Error!! Waiting Element Is Failed");
		}
		return this;

	}
	public AddPostPage enter_PageTitle() {
		try {
			logger.info("Step>Enter Page Title");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".form-control.posttitle")).sendKeys("My Travel Memory");
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Page Title");
		}
		return this;
		
	}
	public  AddPostPage enter_Prelink() {
		try {
			logger.info("Step>Enter Prelink");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".form-control.pull-right.permalink")).clear();
			driver.findElement(By.cssSelector(".form-control.pull-right.permalink")).sendKeys("http//www.mytravel.com/");
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Prelink");
		}
		return this;
		
	}
	public  AddPostPage enter_Text() {
		try {
			logger.info("Step>Enter Text");
			Thread.sleep(1000);
			WebElement iframe=driver.findElement(By.id("cke_1_contents")).findElement(By.cssSelector(".cke_wysiwyg_frame.cke_reset"));
			driver.switchTo().frame(iframe);
			Thread.sleep(1000);
			driver.findElement(By.tagName("body")).sendKeys("I had a really pleasnt journey!!");
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
		}catch(Exception e) {
			logger.error("Error! It Did Not Enter Text");
		}
		return this;
		
	}
	
	public AddPostPage insert_Images() {
		try {
			logger.info("Step> Insert Image from Computer");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("image_default")).sendKeys("C:\\Users\\nayila\\Desktop\\cloudView.jpg");
			Thread.sleep(3000);
			
		}catch(Exception e) {
			logger.error("Error!It Did Not Insert Images");
		}
		
		
		
		return this;
		
	}
	
	public  AddPostPage select_Catagory() {
		try {
			logger.info("Step>Select Catagory");
			Thread.sleep(1000);
		WebElement catagory=driver.findElement(By.name("category"));
			Select sel=new Select(catagory);
			sel.selectByValue("15");
			
		}catch(Exception e) {
			logger.error("Error! It Did Not Select Catagory");
		}
		return this;
		
	}
	
	
	
	
	
	
	
	
	public  AddPostPage click_OnSubmit() {
		try {
			logger.info("Step>Click Submit");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,750)", "");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		}catch(Exception e) {
			logger.error("Error! It Did Not Click Submit");
		}
		return this;
		
	}
	
	
	
	
	

}
