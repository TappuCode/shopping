package com.seleniumdemo.automation.shopping.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumdemo.automation.shopping.base.TestSeleniumBase;

public class LoginPage extends TestSeleniumBase {

	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "passwd")
	public WebElement password;

	@FindBy(id = "SubmitLogin")
	public WebElement loginButtoin;

	@FindBy(className = "login")
	public WebElement signIn;


	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void goToLoginPage() {
		signIn.click();
	}

	public boolean validateLoginButton() {
		return signIn.isDisplayed();
	}

	public ProductCatalogue login(String un, String pwd) {
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginButtoin.click();
		return new ProductCatalogue();
	}

}
