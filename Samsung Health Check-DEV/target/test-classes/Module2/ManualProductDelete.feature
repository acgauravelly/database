@All
Feature:manual product and assets Deletion


  @ManualProduct
  Scenario:Delete assets and manually created product

    Given Iam on Landing Page as an Admin user
    And  I add a new Product
    Then I should be able to delete a asset manually uploaded
    And  I should be able to delete the product
