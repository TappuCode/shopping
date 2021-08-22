package com.seleniumdemo.automation.shopping.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static String PROJECT_PATH = System.getProperty("user.dir");

	// Wait for element to be Clickable
	public static WebElement waitToBeClickable(WebDriver driver, WebElement element, int waitInterval) {
		WebElement returnElement = (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.elementToBeClickable(element));
		return returnElement;
	}

	// Wait for element to be visible
	public static WebElement waitForVisibility(WebDriver driver, WebElement element, int waitInterval) throws Error {
		WebElement returnElement = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.visibilityOf(element));
		return returnElement;
	}
}
