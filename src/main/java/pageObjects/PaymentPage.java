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
public class PaymentPage extends Base {

	// Locators
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	WebElement payByCheckmethod;
	
	/**
	   * Constructor
	   */
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for clicking on Bank Wire Payment Method
	   * @return 
	   */
	public OrderSummary clickOnBankWireMethod() {
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummary();
	}
	
	/**
	   * Method for clicking on Bank Wire Payment Method
	   * @return 
	   */
	public OrderSummary clickOnCheckMethod() {
		Action.click(getDriver(), payByCheckmethod);
		return new OrderSummary();
	}
}
