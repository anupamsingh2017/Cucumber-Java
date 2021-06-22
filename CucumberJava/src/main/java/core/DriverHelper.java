package core;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.PropertyReader;

public class DriverHelper {
	protected WebDriver driver;
	protected PropertyReader propertyReader;
	public WebDriverWait wait = null;
	private int TIME_OUT = 10;
	public static final String CURRENT_DIR = System.getProperty("user.dir");

	public DriverHelper(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, TIME_OUT);
		propertyReader = new PropertyReader();
	}

	// Click a web element
	public void click(WebElement element) {

		try {
			waitForElementToBeClickable(element);
			element.click();
			// mouseOverAndClick(element);

		} catch (StaleElementReferenceException sere) {

			// simply retry finding the element in the refreshed DOM

			wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
	}

	// Enter text in a Text box
	public void enterText(WebElement element, String text) {
		waitForElementToBePresent(element);
		element.clear();
		element.sendKeys(text);
	}
	
	// Enter text in a Text box
	public void submitDetails(WebElement element) {
		waitForElementToBePresent(element);
		element.submit();
	}

	public void clearText(WebElement element) {
		waitForElementToBePresent(element);
		element.clear();
	}

	// Wait for the element to be present
	public void waitForElementToBePresent(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Select value from drop down
	public void selectValueFromDropdownList(WebElement element, final String optionValue) {
		//waitForElementToBePresent(element);
		Select objSelect = new Select(element);
		objSelect.selectByValue(optionValue);
	}
	
	public void selectTextFromDropdownList(WebElement element, final String optionText) {
		//waitForElementToBePresent(element);
		Select objSelect = new Select(element);
		objSelect.selectByVisibleText(optionText);
	}

	// Get value of any given attribute of the Web element
	public String getAttributeValue(WebElement element, String attribute) {
		String value = null;
		value = element.getAttribute(attribute);

		return value;
	}

	public void waitForPageToLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver ldriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(3000);
			wait.until(expectation);
		} catch (Throwable error) {
			error.printStackTrace();
		}
	}

	private Object _executeJavaScript(String jsCode) {
		return ((JavascriptExecutor) driver).executeScript(jsCode);
	}

	public String getText(final String locator) {
		final String text = driver.findElement(By.xpath(locator)).getText();
		return text;
	}

	public Boolean isElementVisible(WebElement element) {

		Boolean result = false;
		try {
			result = element.isDisplayed();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public WebElement getWebElement(String locator) {

		WebElement element = driver.findElement(DriverHelper.byLocator(locator));

		return element;
	}

	public boolean isAttributePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	public void verifySpanText(final String text) {
		final String locator = "//span[contains(text(),\"" + text + "\")]";
		WebElement element = getWebElement(locator);
		waitForElementToBePresent(element);
		Assert.assertTrue(isElementVisible(element), text + "is displyed");
	}

	// Handle locator type
	public static By byLocator(final String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else if (locator.startsWith("linkText=")) {
			result = By.linkText(locator.replace("linkText=", ""));
		} else if (locator.startsWith("xpath=")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("(//")) {
			result = By.xpath(locator);
		} else {
			result = By.id(locator);
		}
		return result;
	}

	public void attachFile(WebElement element, String fileName) {
		String filePath = CURRENT_DIR + "\\files\\" + fileName;

		try {
			File f = new File(filePath);

			if (f.exists()) {
				element.sendKeys(filePath);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Handle mouse over action
	public void mouseOverAndClick(final WebElement element) {

		// build and perform the mouseOver with Advanced User Interactions API
		final Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
		builder.moveToElement(element).click().build();
	}

	// Click Web element using Javascript
	public void clickJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// Scroll the page vertically to the bottom
	public void scrollPageTillBottom() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollPageTillElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Get Web Element's text
	public String getElementText(WebElement element) {
		String text = null;
		text = element.getText().trim();
		return text;
	}

	public void clickMidOfElement(WebElement element) {
		int width = element.getSize().getWidth();
		Actions act = new Actions(driver);
		act.moveToElement(element).moveByOffset((width / 2) - 2, 0).click().perform();
	}

	public void waitForElementToBeVisibleOnScreen() {
		try {
			Thread.sleep(2000);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public void setText(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].innerText='" + text + "';", element);
	}

	public Date convertStringToDate(String date, String format) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void scrollWindowToBottomOfPage() {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public String switchToChildWindow() {
		final Set<String> str = driver.getWindowHandles();
		final Iterator<String> itr = str.iterator();
		final String parentWindow = itr.next();
		final String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		return parentWindow;
	}

	public String getWindowTitle() {
		final String winTitle = driver.getTitle();
		return winTitle;
	}

	public void closeChildWindows(final String parentWindow) {
		for (final String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(winHandle);
				driver.close();
			}
		}
	}
	
	// Get random string
	public String getRandomString(final int len) {
		final String abc = "abcdefghijklmnopqrstuvwxyz";
		final Random rnd = new Random();
		final StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(abc.charAt(rnd.nextInt(abc.length())));
		}
		return sb.toString();
	}
}
