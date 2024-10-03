package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"src/test/java/features"}, 
                glue = {"steps"}, 
                tags = "@ValidLogin",
                snippets = SnippetType.CAMELCASE,
                plugin= {"pretty", 
                        "html:target/cucumber-reports/cucumber.html",
                        "json:target/cucumber-reports/cucumber.json"})
public class ValidLoginTestsRunner extends AbstractTestNGCucumberTests{ 
    
}
