package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"src/test/java/features"}, 
                glue = {"steps"}, 
                tags = "@InvalidLogin",
                snippets = SnippetType.CAMELCASE,
                plugin= {"pretty", 
                        "html:target/cucumber-reports/cucumber.html",
                        "json:target/cucumber-reports/cucumber.json"})
public class InvalidLoginTestsRunner extends AbstractTestNGCucumberTests{ 
    
}
