@All
Feature:Batch Upload
  As a user of the Hub
  I should be able to assign an asset by sku or category

  Background:
    Given Iam on Landing Page as an Admin user
    Given Iam on Batch Upload menu

  @Sku
  Scenario:Batch Upload of Assets
    Then I should be able to assign an asset by sku and category


