package com.seleniumdemo.automation.shopping.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumdemo.automation.shopping.base.TestSeleniumBase;

public class CartPage extends TestSeleniumBase {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cart_summary")
	public WebElement cartSummary;
	
	@FindBy (xpath="//table[@id=\"cart_summary\"]/tbody/tr")
	public List<WebElement> cartItems;
	
	
	public int countIteamInCart() {
		return cartItems.size();
	}

}
