package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.DriverHelper;

public class POShippingPage extends DriverHelper {
	@FindBy(xpath = "//h1[contains(text(),'Shipping')]")
	public WebElement poShippingHeader;
	
	@FindBy(xpath ="(//span[contains(text(),'Proceed to checkout')])[2]")
	public WebElement proceedToCheckoutBtn;
	
	@FindBy(id = "cgv")
	public WebElement termsNConditionCheckbox;
	
	public POShippingPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPOShippingPage() {
		Assert.assertTrue(isElementVisible(poShippingHeader));
	}
	
	public void selectTermsAndConditions() {
		clickJS(termsNConditionCheckbox);
	}
	
	public PaymentsPage proceedToCheckout() {
		click(proceedToCheckoutBtn);
		return PageFactory.initElements(driver, PaymentsPage.class);
	}
}
