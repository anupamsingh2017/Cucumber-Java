package testRunner;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, glue = { "stepDefinitions", "AppHooks" }, plugin = {
		"pretty", "html:test-output", "json:target/cucumber-report/cucumber.json",
 "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
}, dryRun = false, monochrome = true, tags = "not @ignore"

)

public class TestRunner extends AbstractTestNGCucumberTests{

}
