package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.DriverHelper;

public class ProductSummaryPage extends DriverHelper {

	@FindBy(xpath = "//h1[contains(text(),'Shopping-cart summary')]")
	public WebElement productSummaryHeader;
	
	@FindBy(id = "total_product")
	public WebElement totalProductPrice;
	
	@FindBy(id = "total_shipping")
	public WebElement totalShippingPrice;
	
	@FindBy(id = "total_tax")
	public WebElement totalTaxPrice;
	
	@FindBy(id = "total_price")
	public WebElement totalPrice;
	
	@FindBy(xpath ="//span[text()='Proceed to checkout']")
	public WebElement proceedToCheckoutBtn;
	
	public ProductSummaryPage(WebDriver driver) {
		super(driver);
	}

	public void verifyProductSummaryPage() {
		Assert.assertTrue(isElementVisible(productSummaryHeader));
	}

	public void verifyProductDetailsOnSummaryPage(List<Map<String, String>> details) {
		String descLocator = "//td[@class='cart_description']//a[text()='" + details.get(0).get("description") + "']";
		WebElement descWebElement = getWebElement(descLocator);
		Assert.assertTrue(isElementVisible(descWebElement));

		String sizeColorLocator = "//td[@class='cart_description']//a[text()='" + "Color : " + details.get(0).get("color") + ", Size : "
				+ details.get(0).get("size") + "']";
		WebElement sizeColorWebElement = getWebElement(sizeColorLocator);
		Assert.assertTrue(isElementVisible(sizeColorWebElement));
		
		String unitPriceLocator = "//td[@class='cart_unit']//span[text()='" + details.get(0).get("unitPrice") + "']";
		WebElement unitPriceWebElement = getWebElement(unitPriceLocator);
		Assert.assertTrue(isElementVisible(unitPriceWebElement));
		
		String quantityLocator = "(//td[contains(@class,'cart_quantity')]/input)[1]";
		WebElement quantityWebElement = getWebElement(quantityLocator);
		Assert.assertTrue(quantityWebElement.getAttribute("value").equals(details.get(0).get("quantity")));
		
		float unitPrice = Float.parseFloat(details.get(0).get("unitPrice").replace("$", ""));
		int quantity = Integer.parseInt(details.get(0).get("quantity"));
		float totalProductPrice = quantity*unitPrice;
		String totalProdPrice = "$" + String.valueOf(totalProductPrice);
		System.out.println(totalProdPrice+".......................................");
		
		Assert.assertTrue(this.totalProductPrice.getText().equals(totalProdPrice));
		
		Assert.assertTrue(totalShippingPrice.getText().equals(details.get(0).get("shipping")));
		
		Assert.assertTrue(totalTaxPrice.getText().equals(details.get(0).get("tax")));
		
		float shippingPrice = Float.parseFloat(details.get(0).get("shipping").replace("$", ""));
		float taxPrice = Float.parseFloat(details.get(0).get("tax").replace("$", ""));
		
		String totalOrderAmount = "$" + String.valueOf(totalProductPrice + shippingPrice + taxPrice);
		Assert.assertTrue(totalPrice.getText().equals(totalOrderAmount));
	}
	
	public POAddressPage proceedToCheckout() {
		click(proceedToCheckoutBtn);
		return PageFactory.initElements(driver, POAddressPage.class);
	}
}
