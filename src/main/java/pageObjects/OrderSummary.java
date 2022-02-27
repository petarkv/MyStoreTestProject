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
public class OrderSummary extends Base {
	
	// Locators
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	/**
	   * Constructor
	   */
	public OrderSummary() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for clicking on Confirm Order
	   * @return 
	   */
	public OrderConfirmationPage clickOnConfirmOrder() {
		Action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}

}
