package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.DriverHelper;

public class MyAccountPage extends DriverHelper{
	
	@FindBy(xpath = "//h1[text()='My account']")
	public WebElement myAccountHeader;
	
	@FindBy(xpath = "//div[@class='header_user_info']//span")
	public WebElement userFullName;
	
	@FindBy(partialLinkText = "Sign out")
	public WebElement signOutLink;
	
	@FindBy(id = "search_query_top")
	public WebElement searchBox;
	
	@FindBy(name = "submit_search")
	public WebElement searchBtn;
	
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	public void verifyMyAccountPage() {
		Assert.assertTrue(isElementVisible(myAccountHeader));
	}
	
	public void verifyCorrectNameOfUserIsDisplayed (String name) {
		Assert.assertEquals(userFullName.getText(), name);
	}
	
	public SignInPage logOut () {
		click(signOutLink);
		return PageFactory.initElements(driver, SignInPage.class);
	}
	
	public ProductListPage searchProduct (String product) {
		enterText(searchBox, product);
		click(searchBtn);
		return PageFactory.initElements(driver, ProductListPage.class);
	}
}
