@All
Feature:Specifications Upload
  As an Admin user
  I should be able to upload specifications for a product

  @Specifications
  Scenario:Upload specifications via a csv file to a product.
    Given Iam on Landing Page as an Admin user
    And  Iam on the Test product page
    Then I should be able to batch upload specifications for the product.

