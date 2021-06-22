package stepDefinitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import core.BaseTest;
import pageObjects.SignInPage;
import utils.PropertyReader;

public class AppHooks {
	
	private WebDriver driver;
	private PropertyReader propertyReader;
	private BaseTest baseTest;
	public SignInPage signInPage;;
	
	@Before(order = 0)
	public void intialize() {
		propertyReader = new PropertyReader();
		baseTest = new BaseTest();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = propertyReader.readTestData("browser");
		driver = baseTest.selectBrowser(browserName);
	}

	  @AfterStep()
	  public void takeScreenShotOnFailure(Scenario scenario) {
	    if (scenario.getStatus().equals(Status.FAILED)) {
	      takeScreenshot(scenario);
	    }
	  }
	  
	  @After()
	  public void closeBrowser(Scenario scenario) {
	    driver.quit();
	  }

	  private void takeScreenshot(Scenario scenario) {
	    final byte[] screenshot = ((TakesScreenshot) driver)
	        .getScreenshotAs(OutputType.BYTES);
	    String currentDate = new SimpleDateFormat("_yyyy-MM-dd_HH:mm:ss").format(new Date());
	    scenario.embed(screenshot, "image/png", scenario.getName() + "" + currentDate);
	  }
}
