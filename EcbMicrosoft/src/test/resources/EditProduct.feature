Feature: Edit Product
  As a flix user
  I should be able to edit the product on crafter and publish it

  @edit
  Scenario: Edit Product
    Given Iam logged in
    And Iam on the "productpage"
    When I click the "Build product content"
    And Iam taken to the crafter
    Then I should be able to edit the product and confirm changes
