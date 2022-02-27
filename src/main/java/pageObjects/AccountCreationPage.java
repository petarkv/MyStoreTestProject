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
public class AccountCreationPage extends Base {
	
	// Locators
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement formTitle;
	
	/**
	   * Constructor
	   */
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);		
	}
	
	// Methods
	
	/**
	   * Method for validating is Form Title is displayed
	   * @return
	   */
	public boolean validateAccountCreatePage() {
		return Action.isDisplayed(getDriver(), formTitle);
	}

}
