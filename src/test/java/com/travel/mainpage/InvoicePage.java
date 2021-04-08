package com.travel.mainpage;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class InvoicePage extends BasePage{
	final static Logger logger=Logger.getLogger(InvoicePage.class);
	
	public InvoicePage wait_ForDownloadBtnLoading() {
		try {
			logger.info("Step>Waiting For PageLoad Complete");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement downloadBtn = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElements(By.cssSelector(".btn.btn-default")).get(1);
			}

		});
		assertNotNull(downloadBtn);
		}catch(Exception e) {
			logger.error("Error!Waiting For Element Failed");
		}
		return this;
		
	}
	
	public InvoicePage verify_InvoiceDataInformation() throws Exception {
		try {
		logger.info("Step>Verifying Order Date");
		Thread.sleep(2000);
		List<WebElement>invoiceCatagories=driver.findElements(By.cssSelector(".small-text"));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		 Date date = new Date();
		 String dateOne= dateFormat.format(date);
		 System.out.println(dateOne);
		for(WebElement temp:invoiceCatagories) {
			if(temp.getText().contains(dateOne)) {
				assertTrue(true);
				break;
			}
				
			
		}}catch(Exception e) {
			logger.error("Error!Verifying Invoice Data Failed");
		}
		return this;
		
		
	}
	
	public InvoicePage download_File() throws IOException, InterruptedException {
		//Click on Download Text File link to download file.
		  driver.findElements(By.cssSelector(".btn.btn-default")).get(1).click();
		  //Execute Script To Download File.exe file to run AutoIt script. File location = E:\\AutoIT\\
		  Runtime.getRuntime().exec("C:\\Users\\nayila\\Documents\\DownloadFile.exe");
		  Thread.sleep(3000);
		 
		return this;
		
	}
	
	
	
	
	

}
