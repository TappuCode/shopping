package com.seleniumdemo.automation.shopping.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.seleniumdemo.automation.shopping.base.TestSeleniumBase;
import com.seleniumdemo.automation.shopping.pages.LoginPage;
import com.seleniumdemo.automation.shopping.pages.ProductCatalogue;

public class ProductCatalogueTest extends TestSeleniumBase {

	private Actions action;

	ProductCatalogue catalogue;
	LoginPage loginPage;
	ProductCatalogue productCatalogue;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage.goToLoginPage();
		productCatalogue = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		action = new Actions(driver);
		catalogue = new ProductCatalogue();

	}
	
	// Loading all items under Women menu
	@Test(priority = 1)
	public void listAllItemFromWomenMenu() {
		action.moveToElement(catalogue.showWomenMenu()).perform();
		catalogue.showWomenMenu().click();
		softAssert.assertEquals(catalogue.getTotalDresses().size(), 7,
				"Total dress count for Women's menu doesn't match with expected 7");
	}

	//  Loading all items under Dress menu
	@Test(priority = 2)
	public void listAllItemFromDressesMenu() {
		action.moveToElement(catalogue.showDressesMenu()).perform();
		catalogue.showDressesMenu().click();
		softAssert.assertEquals(catalogue.getTotalDresses().size(), 5,
				"Total dress count for dresses' menu doesn't match with expected 5");
	}

	//  Loading all items under TShirt menu
	@Test(priority = 3)
	public void listAllItemFromTShirtMenu() {
		action.moveToElement(catalogue.showTShirtMenu()).perform();
		catalogue.showTShirtMenu().click();
		softAssert.assertEquals(catalogue.getTotalDresses().size(), 1,
				"Total dress count for TShirt's menu doesn't match with expected 1");
	}

	@AfterMethod
	public void closeAll() {
		driver.quit();
		softAssert.assertAll();

	}

}
