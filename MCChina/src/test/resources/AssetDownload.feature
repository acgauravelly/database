@All
Feature:Asset Download

  As a mc user
  I should be able to download the Asset

  @Assetdownload
  Scenario: Asset Download
    Given Iam logged in to MC
    And  I am on the product page
    When I click the "images menu"
    Then Asset should be downloadable