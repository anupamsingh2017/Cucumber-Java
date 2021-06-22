package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.DriverHelper;

public class PaymentsPage extends DriverHelper{
	@FindBy(xpath = "//h1[contains(text(),'Please choose your payment method')]")
	public WebElement paymentsPagegHeader;
	
	@FindBy(css = "a[title='Pay by bank wire']")
	public WebElement payByBankWireOption;
	
	@FindBy(css = "a[title^='Pay by check']")
	public WebElement payByCheckOption;
	
	@FindBy(id = "amount")
	public WebElement totalAmount;
	
	@FindBy(xpath = "//span[text()='I confirm my order']")
	public WebElement confirmOrderBtn;
	
	@FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
	public WebElement orderCompletionNote;
	
	@FindBy(partialLinkText = "Sign out")
	public WebElement signOutLink;
	
	public PaymentsPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPaymentsPage() {
		Assert.assertTrue(isElementVisible(paymentsPagegHeader));
	}
	
	public void verifyVariousPaymentMethods() {
		Assert.assertTrue(isElementVisible(payByBankWireOption));
		Assert.assertTrue(isElementVisible(payByCheckOption));
	}
	
	public void selectPaymentOption(String option) {
		if(option.equalsIgnoreCase("Pay by bank wire")) {
			click(payByBankWireOption);
		
		} else if(option.equalsIgnoreCase("Pay by check")) {
			click(payByCheckOption);
		}
	}
	
	public void verifyTotalAmountOfTheOrder(String amount) {
		Assert.assertTrue(totalAmount.getText().equals(amount));
	}
	
	public void confirmOrder() {
		click(confirmOrderBtn);
	}
	
	public void verifyOrderIsComplete() {
		Assert.assertTrue(isElementVisible(orderCompletionNote));
	}
	
	public SignInPage logOutFromPaymentsPage () {
		click(signOutLink);
		return PageFactory.initElements(driver, SignInPage.class);
	}
}
