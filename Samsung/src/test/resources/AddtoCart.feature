@All
Feature:Add to cart

  @Batch-AddtoCart
  Scenario:Ability to do a Download by adding to the downloads cart

    Given Iam logged in to MC
    Given I am on the product page
    Then I should be able to add a product to the cart for download