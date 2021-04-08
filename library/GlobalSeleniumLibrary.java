package com.selenium.library;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

/***
 * this method starts Chrome browser
 * 
 * @return driver
 * @author nayila
 * 
 */

public class GlobalSeleniumLibrary {
	final static Logger logger = Logger.getLogger(GlobalSeleniumLibrary.class);
	public boolean isDemoMode = false;
	private WebDriver driver;
	//public boolean isRemoteUpload = false;
	public boolean isRemote=false;
	public List<String> errorScreenshots;

	/***
	 * constructor
	 * 
	 * @param _driver
	 */

	// constructor
	public GlobalSeleniumLibrary(WebDriver _driver) {
		driver = _driver;

	}

	private WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();// this line open webbroser
			logger.info("chrome driver is starting");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();// maximize the browser window
			// below setting page load time from 0s up to 30s max
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
		return driver;
	}

	/***
	 * this method enters value to the text field
	 * 
	 * @param by
	 * @param inputValue
	 */
	public void enterText(By by, String inputValue) {
		//
		try {
			WebElement textField = driver.findElement(by);
			highLightElement(textField);
			textField.clear();
			textField.sendKeys(inputValue);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	/***
	 * this method select drop-down element for given drop-down value
	 * 
	 * @param by
	 * @param optionValue
	 */

	public void selectDropdown(By by, String optionValue) {
		try {
			WebElement dropdownElem = driver.findElement(by);
			highLightElement(dropdownElem);
			Select dropdown = new Select(dropdownElem);
			dropdown.selectByVisibleText(optionValue);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}

	}

	/***
	 * this method select drop-down element by index
	 * 
	 * @param by
	 * @param IndexValue
	 */
	public void selectDropdownOne(By by, int IndexValue) {
		try {
			WebElement dropDownElemOne = driver.findElement(by);
			highLightElement(dropDownElemOne);
			Select DropdownOne = new Select(dropDownElemOne);
			DropdownOne.selectByIndex(IndexValue);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	/***
	 * this method select drop-down element by visible text
	 * 
	 * @param by
	 * @param visibleText
	 */
	public void selectDropDownTwo(By by, String visibleText) {
		try {
			WebElement dropDownElemTwo = driver.findElement(by);
			highLightElement(dropDownElemTwo);
			Select DropdownTwo = new Select(dropDownElemTwo);
			DropdownTwo.selectByVisibleText(visibleText);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	/***
	 * this method handle check-box problem.
	 * 
	 * @param checkBoxLocator
	 * @param isCheck
	 */

	public void handleCheckbox(By checkBoxLocator, boolean isCheck) {
		WebElement checkBoxElem = driver.findElement(checkBoxLocator);
		highLightElement(checkBoxElem);
		boolean checkBoxState = checkBoxElem.isSelected();
		try {
			if (isCheck == true) {// user want to check
				if (checkBoxState == true) {
					// doing nothing
				} else {
					checkBoxElem.click();
				}
			} else {// user do not want to check
				if (checkBoxState == true) {// checkbox is selected
					checkBoxElem.click();
				} else {// check box is not selected
						// doing nothing

				}

			}
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	/***
	 * capture screenshots and save it to sepasefic or default path.
	 * 
	 * @param screenshotsFileName
	 * @param filePath
	 * @return
	 */

	public String captureScreenShot(String screenshotsFileName, String filePath) {
		String tempFileName = null;
		try {

			String timestamp = getCurrentTime();
			if (!filePath.isEmpty()) {
				tempFileName = filePath + screenshotsFileName + timestamp + ".png";

			} else {

				tempFileName = "src/test/target/screenshots/" + screenshotsFileName + timestamp + ".png";
			}
             if(isRemote) {
            	 driver=new Augmenter().augment(driver);
             }
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(srcFile, new File(tempFileName));
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
		logger.info("screenshot taken:" + tempFileName);
		return tempFileName;

	}

	/***
	 * gettting current time of file in order to idetify them.
	 * 
	 * @return
	 */
	public String getCurrentTime() {
		String finalTimeStamp = null;
		try {
			Date date = new Date();
			String tempTime = new Timestamp(date.getTime()).toString();
			finalTimeStamp = tempTime.replace(":", "_").replace(".", "_").replace("-", "_").replace(" ", "_");

		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);

		}
		return finalTimeStamp;

	}

	public void customWait(double inSeconds) {
		try {
			logger.info("Current thread is stopping for" + inSeconds + "second(s)");
			Thread.sleep((long) (inSeconds * 1000));
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}

	}

	public void clickOnHiddenElement(By by) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement elem = driver.findElement(by);
			highLightElement(elem);
			js.executeScript("arguments[0].click();", elem);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	public void clickOnhHiddenElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			highLightElement(element);
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	/***
	 * cool thing to highlight element.
	 * 
	 * @param elem
	 */
	public void highLightElement(WebElement elem) {
		try {

			if (isDemoMode == true) {
				for (int i = 0; i < 4; i++) {
					WrapsDriver wrappedElement = (WrapsDriver) elem;
					JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
					Thread.sleep(500);// half a second;
					js.executeScript("arguments[0].setAttribute('style',arguments[1]);", elem,
							"color:red; border:2px solid yellow;");
					Thread.sleep(500);
					js.executeScript("arguments[0].setAttribute('style',arguments[1]);", elem, "");
				}
			}
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	/***
	 * cool thing to flash webelement.
	 * 
	 * @param by
	 */
	public void highLightElement(By by) {
		try {
			if (isDemoMode == true) {
				for (int i = 0; i < 4; i++) {
					WebElement elem = driver.findElement(by);

					WrapsDriver wrappedElement = (WrapsDriver) elem;
					JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
					Thread.sleep(500);// half a second;
					js.executeScript("arguments[0].setAttribute('style',arguments[1]);", elem,
							"color:red; border:2px solid yellow;");
					Thread.sleep(500);
					js.executeScript("arguments[0].setAttribute('style',arguments[1]);", elem, "");
				}
			}
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}

	}

	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					highLightElement(by);
					return driver.findElement(by);
				}

			});
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);

		}
		highLightElement(targetElem);

		return targetElem;

	}

	public WebElement fluentWait(final WebElement element) {
		WebElement targetElem = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					highLightElement(element);
					return element;
				}

			});
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
		highLightElement(targetElem);
		return targetElem;

	}

	/***
	 * this method moves the mouse to the given element.
	 * 
	 * @param element
	 * @author nayila
	 */

	public void moveMouseToElement(WebElement element) {
		try {
			Actions action = new Actions(driver);
			highLightElement(element);
			action.moveToElement(element).build().perform();
			customWait(1);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);

		}
	}

	/***
	 * this method moves the mouse the given element
	 * 
	 * @param by
	 * @author nayila
	 */

	public void moveMouseToElement(By by) {
		try {
			Actions action = new Actions(driver);
			highLightElement(by);
			action.moveToElement(driver.findElement(by)).build().perform();
			customWait(1);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	public WebElement waitForElementPresence(By by) {
		WebElement dynamicElem = null;
		try {
			dynamicElem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(by));
			highLightElement(dynamicElem);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
		return dynamicElem;

	}

	public WebElement waitForElementVisibility(By by) {
		WebElement dynamicElem = null;
		try {
			dynamicElem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(by));
			highLightElement(dynamicElem);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
		return dynamicElem;

	}

	public void switchToIFrame(By by) {
		try {
			WebElement iFrameElem = driver.findElement(by);
			highLightElement(iFrameElem);
			driver.switchTo().frame(iFrameElem);
		} catch (Exception e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	public WebDriver startLocalBrowser(String browser) {
		try {
			if (browser.contains("IE")) {
				driver = startIEBrowser();

			} else if (browser.contains("chrome")) {
				driver = startChromeBrowser();

			} else if (browser.contains("firefox")) {
				driver = startFirefoxBrowser();

			} else {
				throw new Exception(
						"you choose ' " + browser + "', Currently" + "Supporting browser are IE,chrome, firefox"
								+ "for any question, please contact Automation team");
			}
		} catch (Exception e) {
			logger.error(e);
		}

		return driver;
	}

	private WebDriver startFirefoxBrowser() {
		try {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024,
			// 768));
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			logger.error(e);
		}
		return driver;
	}

	private WebDriver startIEBrowser() {
		try {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("Internet explorer");
			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			driver = new InternetExplorerDriver(cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			logger.error(e);
		}
		return driver;

	}

	public WebDriver switchWindows(String browserUrl) {

		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			customWait(2);
			driver.switchTo().window(window);
			String currentURL = driver.getCurrentUrl();
			if (browserUrl.contains(currentURL)) {
				break;
			}

		}
		return driver;
	}

	public void fileUpload(By by, String filePath) {
		try {
			File file = new File(filePath);
			file.getAbsolutePath();
			if (isRemote) {
				((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());

			}
			WebElement fileUploadElem = driver.findElement(by);
			fileUploadElem.sendKeys(filePath);
		} catch (Exception e) {
			logger.error(e);
		}

	}

	public List<String> automaticallyAttachErrorImgToEmail() {

		List<String> fileNames = new ArrayList<>();
		JavaPropertiesManager propertyReader = new JavaPropertiesManager("src/test/resources/dynamicConfig.properties");
		String tempTimeStamp = propertyReader.readProperty("sessionTime");
		String numberTimeStamp = tempTimeStamp.replaceAll("_", "");
		Long testStartTime = Long.parseLong(numberTimeStamp);
		// first check if error screen shot has a file
		File file = new File("target/images");
		if (file.isDirectory()) {
			if (file.list().length > 0) {
				File[] screenshotFile = file.listFiles();
				for (int i = 0; i < screenshotFile.length; i++) {
					// checking if file is a file , not a folder
					if (screenshotFile[i].isFile()) {
						String eachFileName = screenshotFile[i].getName();
						logger.info("testing file names:" + eachFileName);
						int indexOf20 = searchStringInString("20", eachFileName);
						String timeStampfromScreenshotFile = eachFileName.substring(indexOf20,
								eachFileName.length() - 4);
						logger.info("testing file names:" + timeStampfromScreenshotFile);
						String fileNumberStamp = timeStampfromScreenshotFile.replaceAll("_", "");
						long screenshotFileTime = Long.parseLong(fileNumberStamp);
						testStartTime = Long.parseLong(numberTimeStamp.substring(0, 14));
						screenshotFileTime = Long.parseLong(fileNumberStamp.substring(0, 14));
						if (screenshotFileTime > testStartTime) {
							fileNames.add("target/images/" + eachFileName);

						}

						// hold untill we get the screen shot
					}
				}
			}
		}
		errorScreenshots = fileNames;
		return fileNames;
	}

	public int searchStringInString(String target, String message) {
		int targetIndex = 0;
		for (int i = -1; (i = message.indexOf(target, i + 1)) != -1;) {
			targetIndex = i;
			break;
		}
		return targetIndex;

	}

	public WebDriver startRemoteBrowser(String hubURL, String browserName) {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			if (browserName.contains("IE")) {
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				browserName = "internet_explorer";

			}
			cap.setBrowserName(browserName);
			driver = new RemoteWebDriver(new URL(hubURL), cap);
             isRemote=true;
		} catch (Exception e) {
			logger.error("Starting remote browser fails for'"+browserName+"'",e);
			assertTrue(false);
		}

		return driver;

	}

	/*
	 * public static void main(String[] args) { GlobalSeleniumLibrary myLib = new
	 * GlobalSeleniumLibrary(null); myLib.automaticallyAttachErrorImgToEmail();
	 * 
	 * }
	 */
}
