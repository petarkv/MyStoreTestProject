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
public class AddToCartPage extends Base {
	
	// Locators
	
	@FindBy(id = "quantity_wanted")
	WebElement productQuantity;
	
	@FindBy(id = "group_1")
	WebElement productSize;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[contains(@class,'layer_cart_product')]//h2/i")
	WebElement successfullyAddedToCart;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBtn;
	
	/**
	   * Constructor
	   */
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for choose Product Quantity
	   * @param qty
	   */
	public void enterProductQuantity(String qty) {
		Action.type(productQuantity, qty);
	}
	
	/**
	   * Method for choose Product Size
	   * @param size
	   */
	public void selectProductSize(String size) {
		Action.selectByVisibleText(size, productSize);
	}
	
	/**
	   * Method for click on Add To Cart Button
	   */
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
	}
	
	/**
	   * Method for checking if Product is sucessfully added to Cart
	   * @return 
	   */
	public boolean validateAddToCart() {
		Action.fluentWait(getDriver(), successfullyAddedToCart, 10);
		return Action.isDisplayed(getDriver(), successfullyAddedToCart);
	}
	
	/**
	   * Method for clicking on Proceed to Checkout Btn
	   * @return 
	   * @throws Exception 
	   */
	public OrderPage clickOnProceedToCheckout() throws Exception {
		Action.fluentWait(getDriver(), proceedToCheckoutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckoutBtn);		
		return new OrderPage();
	}
	
	

}
