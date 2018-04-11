@all
Feature: Add a new product
  As a ecb user
  I should be able to add a new product inorder to add content

  Scenario: Add new product
    Given Iam logged in
    And Iam on the "addproductpage"
    When I add a product with todays date
      | Fields            | Data             |
      | Name              | AutoTest Product |
      | Description       | TestProduct      |
      | Short Description | TestProduct      |
      | Language          | English          |
      | Vendor            | Microsoft        |
      | MPN               | AutoTest        |
    Then I should be able to verify the added product