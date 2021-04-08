package com.travel.mainpage;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class CheckOutPage extends BasePage {
	final static Logger logger = Logger.getLogger(CheckOutPage.class);

	public CheckOutPage wait_forCompleteOrderVisibility() {
		logger.info("Step>Waiting for Complete Order Btn Visibility");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCompleteOrder")));
		} catch (Exception e) {
			logger.error("Error!!Waiting for Complete Order Btn Is Failed");
			assertTrue(false);
		}
		return this;
	}

	public CheckOutPage enter_UserInformation() {
		try {
			
			logger.info("Step>Entering Personal Information");
			String firstName="Mary";
			String lastName="William";
			String companyName="Apple";
			String email="Mwilliam12345678914@gmail.com";
			String phone="2124568968";
			String address="1212 Market St";
			String city="Chicago";
			String state="Illinois";
			String zipCode="12756";
			String coun="United States";
			
			driver.findElement(By.id("inputFirstName")).sendKeys(firstName);
			driver.findElement(By.id("inputLastName")).sendKeys(lastName);
			driver.findElement(By.id("inputCompanyName")).sendKeys(companyName);
			driver.findElement(By.id("inputEmail")).sendKeys(email);
			driver.findElement(By.id("inputPhone")).sendKeys(phone);
			driver.findElement(By.id("inputAddress1")).sendKeys(address);
			driver.findElement(By.id("inputCity")).sendKeys(city);
			driver.findElement(By.id("stateinput")).sendKeys(state);
			driver.findElement(By.id("inputPostcode")).sendKeys(zipCode);
			WebElement country = driver.findElement(By.id("inputCountry"));
			Select unitedS = new Select(country);
			unitedS.selectByVisibleText(coun);
			WebElement howDidYouFind = driver.findElement(By.id("customfield1"));
			Select bing = new Select(howDidYouFind);
			bing.selectByVisibleText("Bing");
			driver.findElement(By.id("customfield2")).sendKeys("2124568968");
			driver.findElement(By.id("inputNewPassword1")).sendKeys("Mary121@Ww");
			driver.findElement(By.id("inputNewPassword2")).sendKeys("Mary121@Ww");
		} catch (Exception e) {
			logger.error("Error!Entering Information Is Failed");
		}
		return this;

	}

	public CheckOutPage select_PaymentMethod() {
		try {
		logger.info("Step>Selecting Payment Mothod");
		Thread.sleep(3000);
		List<WebElement> paymentMothods = driver.findElements(By.cssSelector(".radio-inline"));
		for (WebElement temp : paymentMothods) {
			//System.out.println(temp.getText());
			if (temp.getText().contains("Western Union")) {
				WebElement westernUniton=temp.findElement(By.name("paymentmethod"));
				boolean checkBoxState = westernUniton.isSelected();
				boolean isCheck = true;
				if (isCheck == true) {
					if (checkBoxState == true) {
					} else {
						westernUniton.click();
					}
				} else {
					if (checkBoxState == true) {
						westernUniton.click();
					} else {

					}
				}
			break;}
			}}catch(Exception e) {
				logger.error("Error!Selecting Payment Mothod Failed");
			}
		return this;

	}
	public CheckOutPage click_OnCompleteOrder() {
		try {
			Thread.sleep(2000);
			logger.info("Step>Clicking On Complete Order Button");
			driver.findElement(By.cssSelector("#btnCompleteOrder")).click();
			Thread.sleep(5000);
		}catch(Exception e) {
			logger.error("Error!!It Did not Click on Complete Order Button");
		}
		return this;
		
	}
	
	
	
	
	
	

}
