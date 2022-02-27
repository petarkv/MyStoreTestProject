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
public class OrderPage extends Base {

	// Locators
	
	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	WebElement unitProductPrice;
	
	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckoutBtn;
	
	/**
	   * Constructor
	   */
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for getting a unit Price from Order Form
	   * @return 
	   */
	public double getUnitPrice() {
		String unitPrice=unitProductPrice.getText();
		String unitP=unitPrice.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unitP);
		return finalUnitPrice/100;
	}
	
	/**
	   * Method for getting a Total Price from Order Form
	   * @return 
	   */
	public double getTotalPrice() {
		String totalOrderPrice=totalPrice.getText();
		String totalOrder=totalOrderPrice.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(totalOrder);
		return finalTotalPrice/100;
	}
	
	/**
	   * Method for clicking on Proceed to Checkout Btn
	   * when User is not LoggedIn
	   * @return 
	   */
	public LoginPage clickOnProceedToCheckout() {
		Action.click(getDriver(), proceedToCheckoutBtn);
		return new LoginPage();
	}
	
	/**
	   * Method for clicking on Proceed to Checkout Btn
	   * when User is LoggedIn
	   * @return 
	   */
	public AddressPage clickOnProceedToCheckoutLoggedIn() {
		Action.click(getDriver(), proceedToCheckoutBtn);
		return new AddressPage();
	}
}
