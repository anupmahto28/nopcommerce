Feature: Product Search
	
	Background: 
    Given User navigate to "https://demo.nopcommerce.com"
    And User log in with email "ajaygaikwad@gmail.com" and password "Bookmyshow@123"

  Scenario: Search for a non-existing product
    Given user is on the homepage
    When user searches for a non-existing product
    Then a message should be displayed indicating no products were found
