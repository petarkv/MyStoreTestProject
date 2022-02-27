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
import pageObjects.IndexPage;
import pageObjects.SearchResultPage;

/**
 * @author Petar
 *
 */
public class AddToCartPageTest extends Base {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression", "Sanity"})
	public void addToCartTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterProductQuantity("2");
		addToCartPage.selectProductSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
	}
}
