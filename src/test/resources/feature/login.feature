Feature: Login
 
	Scenario: Login with registered user
    Given user is on the login page
    When user enter valid login credentials
    And user submit the login form
    Then user should be logged in successfully
    
    
  Scenario: User tries to login with incorrect email and password
    Given user is on the initial login page
    When user enters invalid login credentials
    And user submits the login form
    Then user should see an error message for invalid login
    
    
  Scenario Outline: Unsuccessfull login with invalid or empty credentails
		Given I have entered invalid "<username>" and "<password>"
		When I click on the login button
		Then I should see an error message indicating "<error_message>"
		
		Examples:
			|username         |password       |error_message                                                                            |
			|invalid@email.com|invalidPassword|Login was unsuccessful. Please correct the errors and try again. No customer account found|                                                            
			|abcc             |validPassword  |Login was unsuccessful. Please correct the errors and try again. No customer account found|
			|valid@email.com  |abcc						|Login was unsuccessful. Please correct the errors and try again. No customer account found|
			
			
			
	Scenario: forget password
			When I Click on forget Password button
			Then it should redirect to password Recovery page
