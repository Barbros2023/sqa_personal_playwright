Feature: Checkout flow on saucedemo

  Scenario: Successful checkout of an item
    Given I am on the login page
    When I login with username "standard_user" and password "secret_sauce"
    And I add an item to the cart
    And I proceed to checkout
    And I fill in checkout information with "John", "Doe", "12345"
    And I finish the checkout
    Then I should see a confirmation message
