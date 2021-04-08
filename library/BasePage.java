package com.selenium.library;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasePage {
	final static Logger logger = Logger.getLogger(BasePage.class);
	// it has to be static, child class will have to refer to same browser
	public static WebDriver driver;
	public static GlobalSeleniumLibrary myLib;
	private static JavaPropertiesManager property;
	private static JavaPropertiesManager property2;
	private static String browser;
	private static String isDemoMode;
	private static String isAutoSendEmail;
	private static String isRemote;
	private static String hubURL;

	@BeforeClass    
	// before all test
	public static void beforeAllTests() {
		property = new JavaPropertiesManager("src/test/resources/config.properties");
		browser = property.readProperty("browserType");
		isDemoMode=property.readProperty("isDemoMode");
		isAutoSendEmail=property.readProperty("sendEmail");
		isRemote=property.readProperty("isRemote");
		hubURL=property.readProperty("hubURL");
		
		logger.info("");
		myLib = new GlobalSeleniumLibrary(driver);
		if (property.readProperty("isDemoMode").contains("true")) {
			myLib.isDemoMode = true;
			logger.info("test is running Demo Mode On");
		} else {
			myLib.isDemoMode = false;
			logger.info("test is running Demo Mode Off");
		}
		property2=new JavaPropertiesManager("src/test/resources/dynamicConfig.properties");
		property2.setProterty("sessionTime", myLib.getCurrentTime());
		logger.info("--#########[" + myLib.getCurrentTime() + "]###########--");

	}

	@AfterClass
	public static void afterAllTest() {
		if(driver!=null) {
		driver.quit();// kill the driver object
		}
		// sending all the reports, screeshots, logfiles via email
	List<String> screenshots=new ArrayList<>();
	EmailManager emailSender=new EmailManager();
	emailSender.attchmentFiles.add("target/logs/log4j-selenium.log");
	emailSender.attchmentFiles.add("target/logs/Selenium-Report.html");
	screenshots=myLib.automaticallyAttachErrorImgToEmail();
	if(screenshots.size()!=0) {
		for(String temp:screenshots) {
			emailSender.attchmentFiles.add(temp);
		}
		
	}
	
	if(isAutoSendEmail.contains("true")) {
		emailSender.sendEmail(emailSender.attchmentFiles);
	}
	}
	@BeforeMethod 
	// before each test
	public void setup() {
		if(isRemote.contains("ture")) {
			driver=myLib.startRemoteBrowser(hubURL, browser);
				
			}else {
				driver=myLib.startLocalBrowser(browser);
		}
		logger.info("test is starting...");
		driver = myLib.startLocalBrowser(browser);

	}

	@AfterMethod
	// after each test
	public void tearDown(ITestResult result) throws Exception {
		if(ITestResult.FAILURE==result.getStatus()) {
			myLib.captureScreenShot(result.getName(), "target/images/");
		}
		myLib.customWait(5);
		driver.close();
		logger.info("test is ending...");

	}

}
