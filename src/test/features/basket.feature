Feature: Basket
  As a user
  I should add and update item into the Basket

  Scenario: User on selecting item expecting to get added into the basket

    Given I am on the Home Page "https://www.next.co.uk"
    When I enter item into the search bar "Black Cap Sleeve Sports T-Shirt"
    When I click on Search Item button
    Then I should be redirected to Item Listing Page with Title contains "Buy Black Cap Sleeve Sports T-Shirt from the Next UK"
    When I click on selected item
    Then I should be redirected to product description Page with Title contains "Buy Black Cap Sleeve Sports T-Shirt from the Next UK"
    When I select Size "Small"
    When I click on Add to Bag button
    When I click on the Basket
    Then I should see that item "Black Cap Sleeve Sports T-Shirt" of size "Small" is added into the basket

