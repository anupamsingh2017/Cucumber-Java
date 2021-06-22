package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CreateAccountPage;
import pageObjects.MyAccountPage;
import pageObjects.POAddressPage;
import pageObjects.POShippingPage;
import pageObjects.PaymentsPage;
import pageObjects.ProductListPage;
import pageObjects.ProductSummaryPage;
import pageObjects.SignInPage;
import utils.ReusableMethods;

public class PlaceOrderSteps extends BaseTest {
	private static final Logger log = LogManager.getLogger(PlaceOrderSteps.class);

	private ReusableMethods reusableMethods = new ReusableMethods();
	private SignInPage signInPage;
	private CreateAccountPage createAccountPage;
	private MyAccountPage myAccountPage;
	private ProductListPage productListPage;
	private ProductSummaryPage productSummaryPage;
	private POAddressPage poAddressPage;
	private POShippingPage poShippingPage;
	private PaymentsPage paymentsPage;

	String emailID = null;
	String url = propertyReader.readTestData("appURL");
	
	@Given("^I go to Sign In page$")
	public void i_go_to_sign_in_page() throws Throwable {
		signInPage = launchGivenApplication(url);
		signInPage.verifySignInPage();
		log.debug("I go to Sign In page");
	}
	
	@When("^I click on Sign In button and wait for Authentication page to load$")
	public void i_click_on_sign_in_button_and_wait_for_authentication_page_to_load() throws Throwable {
		signInPage.clickSignInLinkOnHomePage();
		log.debug("I click on Sign In button and wait for Authentication page to load");
	}
	
	@Then("^I should see Authentication Page$")
	public void i_should_see_authentication_page() throws Throwable {
		signInPage.verifyAuthenticationPage();
		log.debug("I should see Authentication Page");
	}
	
	@Then("^I should see Create an Account segment$")
	public void i_should_see_create_an_account_segment() throws Throwable {
		signInPage.verifyCreateAnAccountSegment();
		log.debug("I should see Create an Account segment");
	}
	
	@When("^I enter my email address$")
	public void i_enter_my_email_address() throws Throwable {
		emailID = "testEmail_" + reusableMethods.getRandomString(5) + "@test.com";
		signInPage.enterEmailAddressForAccountCreation(emailID);
		log.debug("I enter my email address");
	}
	
	@When("^I click on Create an Account button$")
	public void i_click_on_create_an_account_button() throws Throwable {
		createAccountPage = signInPage.clickCreateAccountButton();
		log.debug("I click on Create an Account button");
	}
	
	@Then("^I should see Create an Account form page$")
	public void i_should_see_create_an_account_form_page() throws Throwable {
		createAccountPage.verifyCreateAnAccountPage();
		propertyReader.updateTestData("username", emailID);
		log.debug("I should see Create an Account form page");
	}
	
	@When("^I fill all the required details and submit it$")
	public void i_fill_all_the_required_details_and_submit_it(DataTable detailsTable) throws Throwable {
		List<Map<String, String>> detailsList = detailsTable.asMaps();
		createAccountPage.fillPersonalInformation(detailsList);
		myAccountPage = createAccountPage.submitUserDetails();
		log.debug("I fill all the required details and submit it");
	}
	
	@Then("^I should see My Account page$")
	public void i_should_see_my_account_page() throws Throwable {
		myAccountPage.verifyMyAccountPage();
		log.debug("I should see My Account page");
	}
	
	@Then("^I should see that my correct name is displayed as \"(.*)\"$")
	public void i_should_see_that_my_correct_name_is_displayed(String name) throws Throwable {
		myAccountPage.verifyCorrectNameOfUserIsDisplayed(name);
		log.debug("I should see that my correct name is displayed as " + name);
	}
	
	@Then("^I should see Already Registered segment$")
	public void i_should_see_already_registered_segment() throws Throwable {
		signInPage.verifyAlreadyRegisteredSegment();
		log.debug("I should see Already Registered segment");
	}
	
	@When("^I enter my registered email address and password$")
	public void i_enter_my_registered_email_address_and_password() throws Throwable {
		String username = propertyReader.readTestData("username");
		String password = propertyReader.readTestData("password");
		signInPage.enterCredentialsToSignIn(username, password);
		log.debug("I enter my registered email address and password");
	}
	
	@When("^I click on Sign In button$")
	public void i_click_on_sign_in_button() throws Throwable {
		myAccountPage = signInPage.clickSignInButton();
		log.debug("I click on Sign In button");
	}
	
	@Given("^I am on My Account Page$")
	public void i_am_on_my_account_page() throws Throwable {
		myAccountPage.verifyMyAccountPage();
		log.debug("I am on My Account Page");
	}

	@When("^I search the product \"(.*)\" in search bar$")
	public void i_search_the_product_in_search_bar(String product) throws Throwable {
		productListPage = myAccountPage.searchProduct(product);
		log.debug("I search the product" + product + " in search bar");
	}

	@Then("^I should see the Product Listing page$")
	public void i_should_see_the_product_listing_page() throws Throwable {
		productListPage.verifyProductListPage();
		log.debug("I should see the Product Listing page");
	}

	@Then("^I should see the searched product \"(.*)\"$")
	public void i_should_see_the_searched_product(String product) throws Throwable {
		productListPage.verifySearchedProduct(product);
		log.debug("I should see the searched product " + product);
	}

	@Then("^I should change the view to \"(.*)\" view$")
	public void i_should_change_the_view(String viewType) throws Throwable {
		productListPage.changeView(viewType);
		log.debug("I should change the view to " + viewType + " view");
	}

	@Given("^I verify that the product \"(.*)\" is in stock$")
	public void verify_product_is_in_stock(String product) throws Throwable {
		productListPage.verifyProductIsInStock(product);
		log.debug("I verify that the product " + product + " is in stock");
	}

	@When("^I add the product to cart with given specifications and Proceed to checkout$")
	public void i_add_product_to_cart_with_given_specifications_and_proceed_to_checkout(DataTable prodDetailsTable)
			throws Throwable {
		List<Map<String, String>> prodDetailsList = prodDetailsTable.asMaps();
		productSummaryPage = productListPage.addProductToCart(prodDetailsList);
		log.debug("I add the product to cart with given specifications and Proceed to checkout");
	}

	@Then("^I should see the Product Summary page$")
	public void i_should_see_product_summary_page() throws Throwable {
		productSummaryPage.verifyProductSummaryPage();
		log.debug("I should see the Product Summary page");
	}
	
	@Then("^I verify all the product details and Proceed to checkout$")
	public void verify_all_the_product_details_and_proceed_to_checkout(DataTable prodDetailsTable)
			throws Throwable {
		List<Map<String, String>> prodDetailsList = prodDetailsTable.asMaps();
		productSummaryPage.verifyProductDetailsOnSummaryPage(prodDetailsList);
		poAddressPage = productSummaryPage.proceedToCheckout();
		log.debug("I verify all the product details and Proceed to checkout");
	}
	
	@Then("^I should see PO Address page$")
	public void i_should_see_po_address_page() throws Throwable {
		poAddressPage.verifyPOAddressPage();
		log.debug("I should see PO Address page");
	}
	
	@Then("^I verify my address details and Proceed to checkout$")
	public void verify_my_address_details_and_proceed_to_checkout(DataTable addressTable)
			throws Throwable {
		List<Map<String, String>> addressDetailsList = addressTable.asMaps();
		poAddressPage.verifyProductDetailsOnSummaryPage(addressDetailsList);
		poShippingPage = poAddressPage.proceedToCheckout();
		log.debug("I verify my address details and Proceed to checkout");
	}
	
	@Then("^I should see PO Shipping page$")
	public void i_should_see_po_shipping_page() throws Throwable {
		poShippingPage.verifyPOShippingPage();
		log.debug("I should see PO Shipping page");
	}
	
	@Then("^I agree to Terms and Conditions and Proceed to checkout$")
	public void i_agree_to_terms_and_conditions_and_proceed_to_checkout() throws Throwable {
		poShippingPage.selectTermsAndConditions();
		paymentsPage = poShippingPage.proceedToCheckout();
		log.debug("I agree to Terms and Conditions and Proceed to checkout");
	}
	
	@Then("^I should see Payments page$")
	public void i_should_see_payments_page() throws Throwable {
		paymentsPage.verifyPaymentsPage();
		log.debug("I should see Payments page");
	}
	
	@Then("^I verify various payment methods$")
	public void i_verify_various_payment_methods() throws Throwable {
		paymentsPage.verifyVariousPaymentMethods();
		log.debug("I verify various payment methods");
	}
	
	@Then("^I choose \"(.*)\" payment method$")
	public void i_choose_payment_method(String paymentOption) throws Throwable {
		paymentsPage.selectPaymentOption(paymentOption);
		log.debug("I choose " + paymentOption + " payment method");
	}
	
	@Then("^I confirm my order after verifying total amount as \"(.*)\"$")
	public void i_confirm_my_order_after_verifying_total_amount(String amount) throws Throwable {
		paymentsPage.verifyTotalAmountOfTheOrder(amount);
		paymentsPage.confirmOrder();
		log.debug("I confirm my order after verifying total amount as " + amount );
	}
	
	@Then("^I should see that my order is complete$")
	public void i_should_see_that_my_order_is_complete() throws Throwable {
		paymentsPage.verifyOrderIsComplete();
		log.debug("I should see that my order is complete");
	}
	
	@When("^I click on Sign out button$")
	public void i_click_on_sign_out_button() throws Throwable {
		signInPage = myAccountPage.logOut();
		log.debug("I click on Sign out button");
	}
	
	@Then("^I sign out from Payments page$")
	public void i_sign_out_from_payments_page() throws Throwable {
		signInPage = paymentsPage.logOutFromPaymentsPage();
		log.debug("I sign out from Payments page");
	}
}
