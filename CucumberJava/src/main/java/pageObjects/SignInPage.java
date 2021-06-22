package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.DriverHelper;

public class SignInPage extends DriverHelper{
	
	@FindBy(partialLinkText ="Sign in")
	public WebElement signInLink;
	
	@FindBy(xpath ="//h1[text()='Automation Practice Website']")
	public WebElement automationPracticeHeader;
	
	@FindBy(xpath ="//h1[text()='Authentication']")
	public WebElement authenticationPageHeader;
	
	@FindBy(xpath ="//h3[text()='Create an account']")
	public WebElement createAccountHeader;
	
	@FindBy(xpath ="//h3[text()='Already registered?']")
	public WebElement alreadyRegisteredHeader;
	
	@FindBy(id ="email_create")
	public WebElement createEmailTxtBox;
	
	@FindBy(id ="SubmitCreate")
	public WebElement createAccountBtn;
	
	@FindBy(id ="email")
	public WebElement emailAddressTxtBox;
	
	@FindBy(id ="passwd")
	public WebElement passwordTxtBox;
	
	@FindBy(css ="#SubmitLogin>span")
	public WebElement signInBtn;
	
	public SignInPage(WebDriver driver){
		super(driver);
	}
	
	public void verifySignInPage() {
		Assert.assertTrue(isElementVisible(automationPracticeHeader));
	}
	
	public void clickSignInLinkOnHomePage() {
		click(signInLink);
	}
	
	public void verifyAuthenticationPage() {
		Assert.assertTrue(isElementVisible(authenticationPageHeader));
	}
	
	public void verifyCreateAnAccountSegment() {
		Assert.assertTrue(isElementVisible(createAccountHeader));
	}
	
	public void verifyAlreadyRegisteredSegment() {
		Assert.assertTrue(isElementVisible(alreadyRegisteredHeader));
	}
	
	public void enterEmailAddressForAccountCreation(String emailAddress) {
		enterText(createEmailTxtBox, emailAddress);
	}
	
	public CreateAccountPage clickCreateAccountButton() {
		submitDetails(createAccountBtn);
		return PageFactory.initElements(driver, CreateAccountPage.class);
	}
	
	public void enterCredentialsToSignIn(String emailAddress, String password) {
		enterText(emailAddressTxtBox, emailAddress);
		enterText(passwordTxtBox, password);
	}
	
	public MyAccountPage clickSignInButton() {
		click(signInBtn);
		return PageFactory.initElements(driver, MyAccountPage.class);
	}
}
