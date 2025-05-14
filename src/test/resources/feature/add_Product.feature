Feature: Add Product to Cart

  #Background: 
    #Given User navigate to "https://demo.nopcommerce.com"
    #And User log in with email "ajaygaikwad@gmail.com" and password "Bookmyshow@123"
#	

	@addproduct
  Scenario: Logged-in user adds a configurable product to the cart
    Given user logs in and selects a product
    When user customizes and adds the product to the cart
    Then user verifies the product in the cart
    
  @nonexistproduct
  Scenario: Search for a non-existing product
    Given user is on the homepage
    When user searches for a non-existing product
    Then a message should be displayed indicating no products were found
  
