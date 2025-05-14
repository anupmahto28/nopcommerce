package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature/login.feature",
    glue = {"stepdefinition"},
    dryRun=false,
    monochrome=true,
    plugin = {
    	    "pretty",
    	    "html:target/cucumber-reports.html",
//    	    "json:target/register-reports.json"
    	}

//    tags = "@search"
)

public class Run2 {
}
