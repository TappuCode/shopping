package com.seleniumdemo.automation.shopping.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.seleniumdemo.automation.shopping.base.TestSeleniumBase;
import com.seleniumdemo.automation.shopping.pages.CartActions;
import com.seleniumdemo.automation.shopping.pages.CartPage;
import com.seleniumdemo.automation.shopping.pages.CheckoutAction;
import com.seleniumdemo.automation.shopping.pages.LoginPage;
import com.seleniumdemo.automation.shopping.pages.ProductCatalogue;

public class CheckoutProcessTest extends TestSeleniumBase {
	private Actions action;

	ProductCatalogue catalogue;
	LoginPage loginPage;
	ProductCatalogue productCatalogue;
	CartActions addToCart;
	CartPage cartpage;
	CheckoutAction checkout;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage.goToLoginPage();
		productCatalogue = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		action = new Actions(driver);
		catalogue = new ProductCatalogue();
		addToCart = new CartActions();
		cartpage = new CartPage();
		checkout = new CheckoutAction();

	}

	@Test(priority = 1)
	public void checkoutProcessVerification() {

		// Following action will click on Women link and load all items
		action.moveToElement(catalogue.showWomenMenu()).perform();
		catalogue.showWomenMenu().click();

		// Verify Total number of items on page
		softAssert.assertEquals(catalogue.getTotalDresses().size(), 7,
				"Total dress count for Women's menu doesn't match with expected 7");

		// Following block will move cursor to N(parameter value) dress and Add it.
		// Add First item to Cart
		action.moveToElement(addToCart.addToCartProductCursorMove(1)).perform();
		addToCart.addToCartProductClick(1).click();

		// Verify Success Message
		softAssert.assertEquals(addToCart.verifySuccessMsg(), "Product successfully added to your shopping cart",
				"Product added to shopping cart message doesn't match");

		// Click on Continue button
		addToCart.clickContShopping().click();

		// Add Second item to Cart
		action.moveToElement(addToCart.addToCartProductCursorMove(2)).perform();
		addToCart.addToCartProductClick(2).click();

		// Verify Success Message
		softAssert.assertEquals(addToCart.verifySuccessMsg(), "Product successfully added to your shopping cart",
				"Product added to shopping cart message doesn't match");

		// Click on Proceed To Checkout button
		addToCart.clickProceedToCheckout().click();

		// Check items in cart
		softAssert.assertTrue(cartpage.cartSummary.isDisplayed());
		softAssert.assertEquals(cartpage.countIteamInCart(), 2, "Cart Items don't match with 2");

		// Move to Address tab
		checkout.proceedToAddress.click();

		// Move to Shipping tab
		checkout.proceedToShipping.click();

		// Select T & C and move to Payment
		softAssert.assertTrue(checkout.tAndCBox.isEnabled(), "T & C Enabled assertion failing");
		softAssert.assertFalse(checkout.tAndCBox.isSelected(), "T & C selected false assertion failing");
		checkout.tAndCBox.click();
		checkout.proceedToPayment.click();

		// Select Pay by wiretransfer
		softAssert.assertTrue(checkout.payByWire.isDisplayed(), "PayByWire assertion failing");
		checkout.payByWire.click();

		// I confirm my order
		checkout.confirmMyOrder.click();
		softAssert.assertEquals(checkout.orderCompletedText.getText().trim(), "Your order on My Store is complete.",
				"Final Order confirmation message doesn't match or missing");

	}

	@AfterMethod
	public void closeAll() {
		driver.quit();
		softAssert.assertAll();

	}

}
