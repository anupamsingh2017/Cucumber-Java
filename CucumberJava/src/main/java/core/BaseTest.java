package core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import enums.Browsers;
import pageObjects.SignInPage;
import utils.PropertyReader;

public class BaseTest {

	public static WebDriver driver;
	protected PropertyReader propertyReader = new PropertyReader();
	
	public WebDriver selectBrowser(String browser) {
		if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.setAcceptInsecureCerts(true);
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(Browsers.IE.name())) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public SignInPage launchGivenApplication(String url) {
		driver.get(url);
		return PageFactory.initElements(driver, SignInPage.class);
	}
}