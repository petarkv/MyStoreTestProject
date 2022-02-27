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
public class ShippingPage extends Base {
	
	// Locators
	
	@FindBy(id = "cgv")
	WebElement terms;
	
	@FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBtn;
	
	/**
	   * Constructor
	   */
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for clicking on CheckBox
	   * Terms and Services od Shipping Page
	   */
	public void clickOnTermsBox() {
		Action.click(getDriver(), terms);
	}
	
	/**
	   * Method for clicking on Proceed to Checkout Btn
	   * on Shipping Page
	   * @return 
	   */
	public PaymentPage clickProceedToCheckout() {
		Action.click(getDriver(), proceedToCheckoutBtn);
		return new PaymentPage();
	}

}
