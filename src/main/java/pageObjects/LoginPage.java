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
public class LoginPage extends Base {

	// Locators
	
	@FindBy(id = "email")
	WebElement userEmail;
	
	@FindBy(id = "passwd")
	WebElement userPassword;
	
	@FindBy(name = "SubmitLogin")
	WebElement loginButton;
	
	@FindBy(id = "email_create")
	WebElement createAccountEmail;
	
	@FindBy(name = "SubmitCreate")
	WebElement createAccountBtn;
	
	/**
	   * Constructor
	   */
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Methods
	
	/**
	   * Method for User login
	   * @param uname
	   * @param pswd
	   * @return
	   */
	public HomePage login(String uname, String pswd) {
		Action.type(userEmail, uname);
		Action.type(userPassword, pswd);
		Action.click(getDriver(), loginButton);
		return new HomePage();
	}
	
	/**
	   * Method for User login when Order Product
	   * @param uname
	   * @param pswd
	   * @return
	   */
	public AddressPage loginOrder(String uname, String pswd) {
		Action.type(userEmail, uname);
		Action.type(userPassword, pswd);
		Action.click(getDriver(), loginButton);
		return new AddressPage();
	}
	
	/**
	   * Method for create new Account
	   * @param newEmail
	   * @return
	   */
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(createAccountEmail, newEmail);
		Action.click(getDriver(), createAccountBtn);
		return new AccountCreationPage();
	}
}
