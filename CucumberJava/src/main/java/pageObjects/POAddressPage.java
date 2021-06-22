package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.DriverHelper;

public class POAddressPage extends DriverHelper {

	@FindBy(xpath = "//h1[text()='Addresses']")
	public WebElement poAddressHeader;
	
	@FindBy(xpath ="//span[text()='Proceed to checkout']")
	public WebElement proceedToCheckoutBtn;
	
	public POAddressPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPOAddressPage() {
		Assert.assertTrue(isElementVisible(poAddressHeader));
	}
	
	public void verifyProductDetailsOnSummaryPage(List<Map<String, String>> details) {
		String deliveryNameLoc = "//ul[@id='address_delivery']//li[text()='" + details.get(0).get("name") + "']";
		WebElement deliveryNameElement = getWebElement(deliveryNameLoc);
		Assert.assertTrue(isElementVisible(deliveryNameElement));
		
		String deliveryAddLoc = "//ul[@id='address_delivery']//li[contains(text(),'" + details.get(0).get("deliveryAddress").split(",")[0] + "')]";
		WebElement deliveryAddElement = getWebElement(deliveryAddLoc);
		Assert.assertTrue(isElementVisible(deliveryAddElement));
		
		String deliveryCityLoc = "//ul[@id='address_delivery']//li[contains(text(),'" + details.get(0).get("deliveryAddress").split(",")[1] + "')]";
		WebElement deliveryCityElement = getWebElement(deliveryCityLoc);
		Assert.assertTrue(isElementVisible(deliveryCityElement));
		
		String deliveryStateLoc = "//ul[@id='address_delivery']//li[contains(text(),'" + details.get(0).get("deliveryAddress").split(",")[2] + "')]";
		WebElement deliveryStateElement = getWebElement(deliveryStateLoc);
		Assert.assertTrue(isElementVisible(deliveryStateElement));
		
		String deliveryPostLoc = "//ul[@id='address_delivery']//li[contains(text(),'" + details.get(0).get("deliveryAddress").split(",")[3] + "')]";
		WebElement deliveryPostElement = getWebElement(deliveryPostLoc);
		Assert.assertTrue(isElementVisible(deliveryPostElement));
		
		String deliveryPhoneLoc = "//ul[@id='address_delivery']//li[text()='" + details.get(0).get("deliveryContact") + "']";
		WebElement deliveryPhoneElement = getWebElement(deliveryPhoneLoc);
		Assert.assertTrue(isElementVisible(deliveryPhoneElement));
		
		String billingNameLoc = "//ul[@id='address_invoice']//li[text()='" + details.get(0).get("name") + "']";
		WebElement billingNameElement = getWebElement(billingNameLoc);
		Assert.assertTrue(isElementVisible(billingNameElement));
		
		String billingAddLoc = "//ul[@id='address_invoice']//li[contains(text(),'" + details.get(0).get("billingAddress").split(",")[0] + "')]";
		WebElement billingAddElement = getWebElement(billingAddLoc);
		Assert.assertTrue(isElementVisible(billingAddElement));
		
		String billingCityLoc = "//ul[@id='address_invoice']//li[contains(text(),'" + details.get(0).get("billingAddress").split(",")[1] + "')]";
		WebElement billingCityElement = getWebElement(billingCityLoc);
		Assert.assertTrue(isElementVisible(billingCityElement));
		
		String billingStateLoc = "//ul[@id='address_invoice']//li[contains(text(),'" + details.get(0).get("billingAddress").split(",")[2] + "')]";
		WebElement billingStateElement = getWebElement(billingStateLoc);
		Assert.assertTrue(isElementVisible(billingStateElement));
		
		String billingPostLoc = "//ul[@id='address_invoice']//li[contains(text(),'" + details.get(0).get("billingAddress").split(",")[3] + "')]";
		WebElement billingPostElement = getWebElement(billingPostLoc);
		Assert.assertTrue(isElementVisible(billingPostElement));
		
		String billingPhoneLoc = "//ul[@id='address_invoice']//li[text()='" + details.get(0).get("billingContact") + "']";
		WebElement billingPhoneElement = getWebElement(billingPhoneLoc);
		Assert.assertTrue(isElementVisible(billingPhoneElement));
	}
	
	public POShippingPage proceedToCheckout() {
		click(proceedToCheckoutBtn);
		return PageFactory.initElements(driver, POShippingPage.class);
	}
}
