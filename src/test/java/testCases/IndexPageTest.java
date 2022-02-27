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
import pageObjects.IndexPage;

/**
 * @author Petar
 *
 */
public class IndexPageTest extends Base {
	IndexPage ip;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Regression", "Sanity"})
//	public void setup() {
//		launchApp();
//	}
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Regression", "Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() {
		ip = new IndexPage();
		boolean result = ip.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		String actualTitle = ip.getMyStoreTitle();
		Assert.assertEquals(actualTitle, "My Store 666");
	}
}
