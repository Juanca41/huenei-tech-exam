package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    
    protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement find(By locator) {
		waitForElementToBeVisible(locator);
		return driver.findElement(locator);
	}
	
	protected void click(By locator) {
		waitForElementToBeClickable(locator);
		find(locator).click();
	}
	
	protected String text(By locator) {
		waitForElementToBeVisible(locator);
		String text = find(locator).getText();
		return text;
	}
	
	protected void type(By locator, String text) {
		waitForElementToBeVisible(locator);
		find(locator).sendKeys(text);
	}
	
	protected void assertText(By locator, String text) {
		Assert.assertEquals(text(locator), text, "Text is not equal.\nText found: "+text(locator)+"\nText expected: "+text+"\n");
	}
	
	protected void assertUrl(String text) {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, text, "URL is not equal.\nCurrent url: "+url+"\nText expected: "+text+"\n");
	}
	
	private void explicitWaitFor(ExpectedCondition<WebElement> condition, Duration timeout) {
        
        timeout = timeout != null ? timeout : Duration.ofSeconds(15);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(condition);
	}
	
    protected void assertElementIsDisplayed(By locator) {
        waitForElementToBeVisible(locator);
        WebElement element = find(locator);
        Assert.assertTrue(element.isDisplayed(), "The element is not displayed.");
    }

	protected void waitForElementToBeVisible(By locator, Duration... timeout) {
		
		int attempts = 0;
		while(attempts < 2) {
			try {
				explicitWaitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeout.length > 0 ? timeout[0] : null));
			}catch(StaleElementReferenceException error) {
			}
		
			attempts ++;
		}
	}
		
	protected void waitForElementToBeClickable(By locator, Duration... timeout) {
		
		int attempts = 0;
		while(attempts < 2) {
			try {
				explicitWaitFor(ExpectedConditions.elementToBeClickable(locator), (timeout.length > 0 ? timeout[0] : null));
			}catch(StaleElementReferenceException error) {
			}
		
			attempts ++;
		}
	}

}
