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
public class IndexPage extends Base {
	
	// Locators
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(css = "button[name='submit_search']")
	WebElement searchButton;
	
	/**
	   * Constructor
	   */
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for clicking signin button	 
	   * @return
	   */
	public LoginPage clickOnSignIn() {
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	/**
	   * Method for checking is Logo displayed
	   * @return
	   */
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), myStoreLogo);		
	}
	
	/**
	   * Method for getting Title of Home Page
	   * @return
	   */
	public String getMyStoreTitle() {
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}
	
	/**
	   * Method for typing text in Search Box
	   * @param productName
	   * @return
	   */
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}

}
