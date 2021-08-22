package com.seleniumdemo.automation.shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumdemo.automation.shopping.base.TestSeleniumBase;
import com.seleniumdemo.automation.shopping.utils.TestUtils;

public class CartActions extends TestSeleniumBase {

	public CartActions() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	public WebElement moveToContShopping;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	public WebElement moveToProceedToCheckout;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	public WebElement successMsgItemAdded;

	public WebElement addToCartProductCursorMove(int itemNum) {
		return TestUtils.waitForVisibility(driver, driver.findElement(
				By.xpath("//*[@id=\"center_column\"]/ul/li[" + itemNum + "]/div/div[1]/div/a[1]/img")), 30);
	}

	public WebElement addToCartProductClick(int itemNum) {
		return TestUtils.waitToBeClickable(driver, driver.findElement(
				By.xpath("//*[@id=\"center_column\"]/ul/li[" + itemNum + "]/div/div[2]/div[2]/a[1]/span")), 30);
	}

	public WebElement clickContShopping() {
		return TestUtils.waitToBeClickable(driver, moveToContShopping, 30);
	}

	public WebElement clickProceedToCheckout() {
		return TestUtils.waitToBeClickable(driver, moveToProceedToCheckout, 30);
	}

	public String verifySuccessMsg() {
		return TestUtils.waitForVisibility(driver, successMsgItemAdded, 30).getText();
	}

}
