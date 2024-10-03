package steps;

import org.testng.Assert;

import base.HelperMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTestsSteps extends  HelperMethods{

    LoginPage loginPage;
    InventoryPage inventoryPage;
    
	@Before()
	public void setUp() {

        initDriver();

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
	}
	
	@After
	public void tearDown() {
		closeDriver();
	}

    @Given("User is in Login Page")
    public void userIsInLoginPage(){
         Assert.assertTrue(loginPage.userIsInLoginPage());
    }

    @When("User enters username (.*) and password (.*)$")
    public void enterUsername(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks on Login button")
    public void clickOnLoginButton(){
        loginPage.clickLoginButton();
    }
    
    @Then("User should be able to log in")
    public void userLoggedIn(){
        Assert.assertTrue(inventoryPage.userIsInInventoryPage());
        waitFor(5);
    }
    
    @Then("User should not be able to log in and should see this error message: (.*)$")
    public void userNotLoggedIn(String errorMsg){
        Assert.assertTrue(loginPage.assertErrorMessageIsDisplayed());
        loginPage.assertErrorMessageText("Epic sadface: "+errorMsg);
        waitFor(5);
    }
}
