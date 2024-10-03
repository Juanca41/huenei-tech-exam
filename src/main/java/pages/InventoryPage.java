package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

	protected By productsTitle = By.xpath("//div[@class='product_label']");
	protected By pwdField = By.id("password");
	protected By loginButton = By.id("login-button");
	protected By errorMessage = By.xpath("//h3[@data-test='error']");

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public boolean userIsInInventoryPage(){
        assertElementIsDisplayed(productsTitle);
        return true;
    }

}
