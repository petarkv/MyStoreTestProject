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
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;
import resources.Log;

/**
 * @author Petar
 *
 */
public class LoginPageTest extends Base {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke", "Sanity"})
	public void loginTest(String uname, String pswd) {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on SignIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter username and password");
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// Get username and password from excell sheet Credentials - TestData.xlsx
		homePage = loginPage.login(uname,pswd);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verify if User is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("User is logged in");
		Log.endTestCase("loginTest");
	}
	
	
}
