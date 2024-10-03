package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods {

    protected WebDriver driver;
    
	public void initDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://www.saucedemo.com/v1/";
		driver.get(url);
	}
	
	public void closeDriver() {
		driver.quit();
	}
}
