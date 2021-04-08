package com.travel.travelPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.Nayilalibrary.BasePage;

import jxl.common.Logger;

public class FlightSearchResultPage extends BasePage {
	final static Logger logger = Logger.getLogger(FlightSearchResultPage.class);

	public FlightSearchResultPage wait_ForFlightSearchLoading() {

		try {
			logger.info("Step>Waiting for Flight Search");
			WebDriverWait waitOne = new WebDriverWait(driver, 60);
			waitOne.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".countdown-title__text")));

		} catch (Exception e) {
			logger.error("Error! Waiting for Flight Search Failed");
		}
		return this;

	}

	public FlightSearchResultPage select_BestTicket() {
		try {
			logger.info("Step>Selecting Best Ticket");
			Thread.sleep(3000);
			List<WebElement> names = driver.findElements(By.cssSelector(".name"));
			for (WebElement temp : names) {
				if (temp.getText().contains("Best tickets")) {
					temp.click();
					break;
				}
			}
			Thread.sleep(1000);
			WebElement bestPriceTag = driver.findElements(By.cssSelector(".ticket-label.ticket-label--cheap")).get(0);
			assertNotNull(bestPriceTag);

		} catch (Exception e) {
			logger.error("Error!It Did Not Select Best Ticket");
		}
		return this;

	}

	public FlightSearchResultPage click_OnOneStop() {
		try {
			logger.info("Step>Click on One Stop Box");
			JavascriptExecutor ja = (JavascriptExecutor) driver;
			ja.executeScript("window.scrollBy(0,500)", "");

			Thread.sleep(2000);
			driver.findElements(By.cssSelector(".filter.stops-filter")).get(0)
					.findElement(By.cssSelector(".list.stops-list")).findElements(By.tagName("li")).get(0)
					.findElement(By.cssSelector(".label-block.name.stops-label")).click();

			Thread.sleep(1000);
			driver.findElements(By.cssSelector(".filter.stops-filter")).get(0)
					.findElement(By.cssSelector(".list.stops-list")).findElements(By.tagName("li")).get(1)
					.findElement(By.cssSelector(".label-block.name.airlines-label.g-text-overflow")).click();

			Thread.sleep(1000);

		} catch (Exception e) {
			logger.error("Error!It Did Not Click On One Stop");
		}
		return this;

	}

	public FlightSearchResultPage verify_OneStopResult() {
		try {
			logger.info("Step>Verifying One Stop Selection Result");
			List<WebElement> stopList = driver.findElements(By.cssSelector(".flight-brief-layovers__list-wrapper"));
			if (stopList.size() > 3 && stopList.size() < 3) {
				assertFalse(true);
				logger.error("Error!It Is Not a One Stop Result");
			} else {
				assertTrue(true);
				logger.info("Good!It Is an One Stop Result");
			}
		} catch (Exception e) {
			logger.error("Error!Verifying One Stop Result Failed");
		}

		return this;

	}

	public FlightSearchResultPage slide_DurationOfStop() {
		int x = 10;
		try {
			logger.info("Step>Sliding Duration Of Stop");
			Thread.sleep(1000);
			WebElement slider = driver.findElement(By.cssSelector(".filter.stops-duration-filter"))
					.findElement(By.className("js-stops-duration")).findElement(By.className("slider_field"))
					.findElement(By.cssSelector(".slider_arrow.slider_arrow--right"));
			WebElement to = driver.findElement(By.cssSelector(".filter.stops-duration-filter"))
					.findElement(By.className("to"));
			Actions act = new Actions(driver);
			int width = slider.getSize().getWidth();

			do {
				act.moveToElement(slider, ((width * x) / 100), 0).click();
				act.build().perform();
				Thread.sleep(2000);
				System.out.println(to.getText());
			} while (!to.getText().contains("3h?30m"));
			System.out.println(to.getText());
		} catch (Exception e) {
			logger.error("Error!It Did Not Slide Through");
		}

		return this;

	}

	public FlightSearchResultPage select_CheapestTicket() {

		try {
			logger.info("Step> Select Cheapest Ticket");
			List<WebElement> prices = driver
					.findElements(By.cssSelector(".ticket-action-button-deeplink.ticket-action-button-deeplink--"));
			WebElement priceTax = prices.get(0)
					.findElement(By.className("ticket-action-button-deeplink-text__price--not-mobile"))
					.findElement(By.cssSelector(".currency_font.currency_font--usd"));
			String text = priceTax.getText();
			String removeSpaceText = text.replaceAll("\\s+", "");
			int textNum = Integer.parseInt(removeSpaceText);

			for (int i = 1; i < prices.size(); i++) {
				WebElement priceTaxOne = prices.get(i)
						.findElement(By.className("ticket-action-button-deeplink-text__price--not-mobile"))
						.findElement(By.cssSelector(".currency_font.currency_font--usd"));
				String textOne = priceTaxOne.getText();
				String removeSpaceTextOne = textOne.replaceAll("\\s+", "");
				int textNumOne = Integer.parseInt(removeSpaceTextOne);
				if (textNum > textNumOne) {
					textNum = textNumOne;

				}

			}
			System.out.println(textNum);

		} catch (Exception e) {
			logger.error("Error!It Did Not Select Cheapest Ticket");
		}

		return this;

	}

}
