package com.seleniumdemo.automation.shopping.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.seleniumdemo.automation.shopping.base.TestSeleniumBase;
import com.seleniumdemo.automation.shopping.pages.LoginPage;
import com.seleniumdemo.automation.shopping.pages.ProductCatalogue;

public class LoginPageTest extends TestSeleniumBase {

	LoginPage loginPage;
	ProductCatalogue productCatalogue;
	SoftAssert softAssert = new SoftAssert();

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginButtonTest() {
		loginPage.goToLoginPage();
		softAssert.assertTrue(loginPage.signIn.isDisplayed(), "Login button is missing");
	}

	@Test(priority = 2)
	public void loginTest() {
		loginPage.goToLoginPage();
		productCatalogue = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	/*
	 * 
	 * you can add more test here for invalid login and locked account etc
	 * 
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
		softAssert.assertAll();
	}

}
