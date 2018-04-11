@All
@Addproduct
Feature:Add a new product


@AddNewProduct
Scenario:Adding a new product
Given I am logged in
And I add a new Product
Then I should be able to see the new product added with the details
