Feature: Register 

	@test
  Scenario: Register a new user
    Given user is on the registration page
    When user enter valid registration details
    And user submit the registration form
    Then user should see a registration success message
	
	
	Scenario: User tries to register without filling required fields
    Given user is on the initial page
    When user leaves required registration fields blank
    And user attempts to submit the incomplete registration form
    Then user should see validation error messages for required fields
	
