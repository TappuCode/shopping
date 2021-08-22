package com.seleniumdemo.automation.shopping.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumdemo.automation.shopping.base.TestSeleniumBase;

public class CheckoutAction extends TestSeleniumBase {

	public CheckoutAction() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
	public WebElement proceedToAddress;

	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
	public WebElement proceedToShipping;

	@FindBy(xpath = "//*[@id=\"cgv\"]")
	public WebElement tAndCBox;

	@FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
	public WebElement proceedToPayment;

	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	public WebElement payByWire;

	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
	public WebElement payByCheck;

	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
	public WebElement confirmMyOrder;

	@FindBy(xpath = "//*[@id=\"center_column\"]/form/div/h3")
	public WebElement confirmPaymentWireText;

	@FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
	public WebElement orderCompletedText;

}
