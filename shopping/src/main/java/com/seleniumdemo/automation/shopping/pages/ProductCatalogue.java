package com.seleniumdemo.automation.shopping.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumdemo.automation.shopping.base.TestSeleniumBase;
import com.seleniumdemo.automation.shopping.utils.TestUtils;


public class ProductCatalogue extends TestSeleniumBase{
	
	
	public ProductCatalogue() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]")
	public WebElement moveToWomenButton;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]")
	public WebElement moveToDressButton;

	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]")
	public WebElement moveToTShirtBtn;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li")
	public List<WebElement> list;
	
	public WebElement showWomenMenu() {
		return TestUtils.waitToBeClickable(driver, moveToWomenButton, 30);
	}
	
	public WebElement showDressesMenu() {
		return TestUtils.waitToBeClickable(driver, moveToDressButton, 30);
	}
	
	public WebElement showTShirtMenu() {
		return TestUtils.waitToBeClickable(driver, moveToTShirtBtn, 30);
	}
	
	public List<WebElement> getTotalDresses(){
		return list;
	}
	
}
