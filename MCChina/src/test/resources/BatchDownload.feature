@All
Feature:Batch Download

  As a mc user
  I should be able to download the whole product

  @batchdownload
    Scenario: Batch Download
  Given Iam logged in to MC
  And  I am on the product page
  When I click the download buttton
  Then the product should be downloaded with in 2 minutes

