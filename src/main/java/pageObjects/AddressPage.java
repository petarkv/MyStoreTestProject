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
public class AddressPage extends Base {

	// Locators
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckoutBtn;
	
	/**
	   * Constructor
	   */
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);		
	}
	
	// Methods
	
	/**
	   * Method for clicking on Proceed to Checkout Btn
	   * on Address Page
	   * @return 
	   */
	public ShippingPage clickToProceedCheckout() {
		Action.click(getDriver(), proceedToCheckoutBtn);
		return new ShippingPage();
	}
}
