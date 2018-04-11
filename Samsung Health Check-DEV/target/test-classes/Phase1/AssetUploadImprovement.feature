@All
Feature:upload higher size assets to a product
  As a Admin user
  I should be able to add bigger assets to product

  @AssetUpload
  Scenario: Upload bigger assets
    Given Iam on Landing Page as an Admin user
    And I navigate to the test product
    And I should be able to upload assets of 1Gb
