Feature: nopCommerce Test Cases

  Background: 
    Given User navigate to "https://demo.nopcommerce.com"
    And User log in with email "ajaygaikwad@gmail.com" and password "Bookmyshow@123"

  @search
  Scenario: Search for an existing product
    Given User is on the homepage
    When User enter "laptop" Usern the search bar
    And User click on the search icon
    Then relevant products should be displayed in search results

 