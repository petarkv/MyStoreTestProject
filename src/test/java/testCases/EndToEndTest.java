/**
 * 
 */
package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.AddToCartPage;
import pageObjects.AddressPage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;
import pageObjects.OrderConfirmationPage;
import pageObjects.OrderPage;
import pageObjects.OrderSummary;
import pageObjects.PaymentPage;
import pageObjects.SearchResultPage;
import pageObjects.ShippingPage;

/**
 * @author Petar
 *
 */
public class EndToEndTest extends Base {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void endToEndTest() throws Exception {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterProductQuantity("2");
		addToCartPage.selectProductSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedToCheckout();
		loginPage = orderPage.clickOnProceedToCheckout();
		addressPage = loginPage.loginOrder(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickToProceedCheckout();
		shippingPage.clickOnTermsBox();
		paymentPage = shippingPage.clickProceedToCheckout();
		orderSummary = paymentPage.clickOnBankWireMethod();
		orderConfirmationPage = orderSummary.clickOnConfirmOrder();
		String actualMessage = orderConfirmationPage.OrderConfirmationMessage();
		String expectegMessage = "Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectegMessage);
	}
}
