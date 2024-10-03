package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    protected String loginPageURL;
	protected By usernameField;
	protected By pwdField;
	protected By loginButton;
	protected By errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
        loginPageURL = "https://www.saucedemo.com/v1/";
        usernameField = By.id("user-name");
	    pwdField = By.id("password");
	    loginButton = By.id("login-button");
	    errorMessage = By.xpath("//h3[@data-test='error']");
    }

    public boolean userIsInLoginPage(){
        assertUrl(loginPageURL);
        return true;
    }

    public void enterUsername(String username){
        type(usernameField, username);
    }

    public void enterPassword(String password){
        type(pwdField, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean assertErrorMessageIsDisplayed(){
        assertElementIsDisplayed(errorMessage);
        return true;
    }

    public void assertErrorMessageText(String text){
        assertText(errorMessage, text);
    }
}
