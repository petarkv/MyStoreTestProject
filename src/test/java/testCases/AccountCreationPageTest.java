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
import pageObjects.AccountCreationPage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

/**
 * @author Petar
 *
 */
public class AccountCreationPageTest extends Base {

	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Sanity")
	public void createAccountTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("peca@punk.com");
		boolean result = accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
	}
}
