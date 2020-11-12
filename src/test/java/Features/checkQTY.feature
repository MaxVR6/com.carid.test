Feature: xxxxxxxxxxxxxxxx

  Scenario: Check QTY of add's item in cart
    Given I navigate to <item> and push to the add btn
    And I select MMY
    And I check correct MMY in pop-up
    And I go to cart by push to Checkout btn
    And I check item in cart
    And I check present MMY in description
    And I check QTY main item in cart
    And I check QTY second item in cart
    And I change QTY main item in cart
    And I check QTY second item in cart after change QTY main item
    And I delete main item from cart
    Then I check cart is empty