/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;

/**
 * @author Petar
 *
 */
public class HomePage extends Base {

	// Locators
	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;
	
	/**
	   * Constructor
	   */
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
		/**
		   * Method for validating MyWishlists
		   * @return
		   */
	public boolean validateMyWishList() {
		return Action.isDisplayed(getDriver(), myWishList);
	}
	
	/**
	   * Method for validating OrderHistory
	   * @return
	   */
	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), orderHistory);
	}
	
	/**
	   * Method for getting url of Home Page - current url
	   * @return 
	   */
	public String getCurrURL() {
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}
}
