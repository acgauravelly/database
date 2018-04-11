@All
Feature:Batch upload Promotions
  As a hub user
  I should be able to upload promotions and assign to sku and category

  @BUPromo
  Scenario:Batch upload promotions to sku and category
    Given Iam on Landing Page as an Admin user
    And  Iam on Batch promotions menu
    Then I should be able to upload promotions to sku and category
