Feature: As a new user I should be able to create a new account and place an order	

	  Scenario: As a new user I should be able to create a new account, logout from app then login again
    Given I go to Sign In page
    When I click on Sign In button and wait for Authentication page to load
		Then I should see Authentication Page
		And I should see Create an Account segment
		When I enter my email address
		And I click on Create an Account button
		Then I should see Create an Account form page
		When I fill all the required details and submit it
    | title | fname | lname | password | dob | address | mobile |
    | Mr. | Anupam | Singh | a12345 | 23-1-1993 | Gaur Galaxy,Noida,Connecticut,20101 | 9876543213 |
		
		Then I should see My Account page
		And I should see that my correct name is displayed as "Anupam Singh"
		When I click on Sign out button
		Then I should see Authentication Page
		And I should see Already Registered segment
		When I enter my registered email address and password
		And I click on Sign In button
		Then I should see My Account page
		And I should see that my correct name is displayed as "Anupam Singh"
	
	Scenario: As a user I should be able to add a product to cart and proceed to make payment
    Given I go to Sign In page
    When I click on Sign In button and wait for Authentication page to load
		Then I should see Authentication Page
		And I should see Already Registered segment
		When I enter my registered email address and password
		And I click on Sign In button
		Then I should see My Account page
		And I should see that my correct name is displayed as "Anupam Singh"
		When I search the product "Faded Short Sleeve T-shirts" in search bar
		Then I should see the Product Listing page
		And I should see the searched product "Faded Short Sleeve T-shirs"
		And I should change the view to "list" view
	  Given I verify that the product "Faded Short Sleeve T-shirts" is in stock
	  When I add the product to cart with given specifications and Proceed to checkout
	  | quantity | size | color |
    | 1 | M | Blue |
    
	  Then I should see the Product Summary page
	  And I verify all the product details and Proceed to checkout
    | description | color | size | unitPrice | quantity | shipping | tax |
    | Faded Short Sleeve T-shirts | Blue | M | $16.51 | 1 | $2.00 | $0.00 |
   
    Then I should see PO Address page
    And I verify my address details and Proceed to checkout
    | name | deliveryAddress | deliveryContact | billingAddress | billingContact |
    | Anupam Singh | Gaur Galaxy,Noida,Connecticut,20101 | 9876543213 | Gaur Galaxy,Noida,Connecticut,20101 | 9876543213 |
   
    Then I should see PO Shipping page
    And I agree to Terms and Conditions and Proceed to checkout
    Then I should see Payments page
    And I verify various payment methods
    And I choose "Pay by bank wire" payment method
    And I confirm my order after verifying total amount as "$18.51" 
    Then I should see that my order is complete
    And I sign out from Payments page