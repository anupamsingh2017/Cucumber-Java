package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.DriverHelper;

public class ProductListPage extends DriverHelper{
	
	@FindBy(xpath ="//h1[contains(text(),'Search')]")
	public WebElement productSearchHeader;
	
	@FindBy(css = ".product-container .product-name")
	public WebElement productName;
	
	@FindBy(xpath ="//span[text()='More']")
	public WebElement moreBtn;
	
	@FindBy(id ="quantity_wanted")
	public WebElement quanityTxtBox;
	
	@FindBy(id ="group_1")
	public WebElement sizeSelector;
	
	@FindBy(xpath ="//span[contains(text(),'Add to cart')]")
	public WebElement addToCartBtn;
	
	@FindBy(xpath ="//div[@id='layer_cart']//h2/i[@class='icon-ok']")
	public WebElement productAddtionSuccessHeader;
	
	@FindBy(xpath ="//span[contains(text(),'Proceed to checkout')]")
	public WebElement proceedToCheckoutBtn;
	
	public ProductListPage(WebDriver driver){
		super(driver);
	}
	
	public void verifyProductListPage() {
		Assert.assertTrue(isElementVisible(productSearchHeader));
	}
	
	public void verifySearchedProduct(String product) {
		Assert.assertTrue(productName.getText().trim().equals(product));
	}
	
	public void changeView(String viewType) {
		String viewLocator = "css=#" + viewType + " i";
		WebElement viewWebElement = getWebElement(viewLocator);
		click(viewWebElement);
	}
	
	public void verifyProductIsInStock(String product) {
		String availibilityLocator = "//h5/a[contains(text(),'" + product + "')]/following::span/span[@class='available-now']";
		WebElement availibilityLocatorWebElement = getWebElement(availibilityLocator);
		Assert.assertTrue(isElementVisible(availibilityLocatorWebElement));
	}
	
	public ProductSummaryPage addProductToCart(List<Map<String,String>> specs) {
		click(moreBtn);
		enterText(quanityTxtBox, specs.get(0).get("quantity"));
		selectTextFromDropdownList(sizeSelector, specs.get(0).get("size"));
		String colorLocator = "//a[@name='" + specs.get(0).get("color") + "']";
		WebElement colorWebElement = getWebElement(colorLocator);
		click(colorWebElement);
		click(addToCartBtn);
		click(proceedToCheckoutBtn);
		return PageFactory.initElements(driver, ProductSummaryPage.class);
	}
}
