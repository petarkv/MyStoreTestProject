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
public class SearchResultPage extends Base {

	// Locators
	
	@FindBy(xpath = "//a[@class='product_img_link']//img")
	WebElement productSearchResult;
	
	/**
	   * Constructor
	   */
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for checking is product available
	   * @return
	   */
	public boolean isProductAvailable() {
		return Action.isDisplayed(getDriver(), productSearchResult);
	}
	
	/**
	   * Method for click on product and navigate to Add To Cart Page
	   * @return
	   */
	public AddToCartPage clickOnProduct() {
		Action.click(getDriver(), productSearchResult);
		return new AddToCartPage();
	}
}
