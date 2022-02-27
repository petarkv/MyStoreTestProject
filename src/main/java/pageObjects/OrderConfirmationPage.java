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
public class OrderConfirmationPage extends Base {

	// Locators
	
	@FindBy(xpath = "//p/strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmMessage;
	
	/**
	   * Constructor
	   */
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for checking is confirm Order Message displayed
	   * @return 
	   */
	public String OrderConfirmationMessage() {
		String confirmMsg = confirmMessage.getText();
		return confirmMsg;
	}
}
