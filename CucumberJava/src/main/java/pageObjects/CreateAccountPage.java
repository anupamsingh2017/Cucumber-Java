package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.DriverHelper;

public class CreateAccountPage extends DriverHelper{
	
	@FindBy(xpath ="//h1[text()='Create an account']")
	public WebElement createAccountHeader;
	
	@FindBy(id ="id_gender1")
	public WebElement mrTitleRadBtn;
	
	@FindBy(id ="id_gender2")
	public WebElement mrsTitleRadBtn;
	
	@FindBy(id ="customer_firstname")
	public WebElement firstNameTxtBox;
	
	@FindBy(id ="customer_lastname")
	public WebElement lastNameTxtBox;
	
	@FindBy(id ="passwd")
	public WebElement passwordTxtBox;
	
	@FindBy(id ="days")
	public WebElement dateSelector;
	
	@FindBy(id ="months")
	public WebElement monthSelector;
	
	@FindBy(id ="years")
	public WebElement yearSelector;
	
	@FindBy(id ="address1")
	public WebElement addressTxtBox;
	
	@FindBy(id ="city")
	public WebElement cityTxtBox;
	
	@FindBy(id ="id_state")
	public WebElement stateSelector;
	
	@FindBy(id ="postcode")
	public WebElement postcodeTxtBox;
	
	@FindBy(id ="phone_mobile")
	public WebElement phoneMobileTxtBox;
	
	@FindBy(css ="#submitAccount>span")
	public WebElement registerUserBtn;
	
	public CreateAccountPage(WebDriver driver){
		super(driver);
	}
	
	public void verifyCreateAnAccountPage() {
		Assert.assertTrue(isElementVisible(createAccountHeader));
	}
	
	public void fillPersonalInformation(List<Map<String,String>> details) {
		
		// Select title
		if (details.get(0).get("title").equals("Mr.")) {
			click(mrTitleRadBtn);
		
		} else if (details.get(0).get("title").equals("Mrs.")) {
			click(mrsTitleRadBtn);
		
		} else {
			Assert.fail("Wrong title input");
		}
		
		// Enter first name
		enterText(firstNameTxtBox, details.get(0).get("fname"));
		
		// Enter last name
		enterText(lastNameTxtBox, details.get(0).get("lname"));
		
		// Enter password
		enterText(passwordTxtBox, details.get(0).get("password"));
		
		// Save password in test data properties file
		propertyReader.updateTestData("password", details.get(0).get("password"));
		
		// Enter date of birth
		String[] dobArr = details.get(0).get("dob").split("-");
		selectValueFromDropdownList(dateSelector, dobArr[0]);
		selectValueFromDropdownList(monthSelector, dobArr[1]);
		selectValueFromDropdownList(yearSelector, dobArr[2]);
		
		// Enter Address
		enterText(addressTxtBox, details.get(0).get("address").split(",")[0]);
		
		// Enter City
		enterText(cityTxtBox, details.get(0).get("address").split(",")[1]);
		
		// Enter State
		selectTextFromDropdownList(stateSelector, details.get(0).get("address").split(",")[2]);
		
		// Enter Postal code
		enterText(postcodeTxtBox, details.get(0).get("address").split(",")[3]);
		
		// Enter Mobile phone number
		enterText(phoneMobileTxtBox, details.get(0).get("mobile"));
	}
	
	public MyAccountPage submitUserDetails() {
		click(registerUserBtn);
		return PageFactory.initElements(driver, MyAccountPage.class);
	}
}
