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
import dataProvider.DataProviders;
import pageObjects.AddToCartPage;
import pageObjects.IndexPage;
import pageObjects.OrderPage;
import pageObjects.SearchResultPage;
import resources.Log;

/**
 * @author Petar
 *
 */
public class OrderPageTest extends Base {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Exception {
		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPage();
//		searchResultPage = indexPage.searchProduct("t-shirt");
		searchResultPage = indexPage.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
//		addToCartPage.enterProductQuantity("2");
		addToCartPage.enterProductQuantity(qty);
//		addToCartPage.selectProductSize("M");
		addToCartPage.selectProductSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedToCheckout();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
	}
}
