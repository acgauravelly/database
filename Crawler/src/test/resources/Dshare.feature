Feature: Scrape content of DigiShare

  @digi
  Scenario: Scrape all products available
    Given I navigate to "http://www.digishare.net/RBECOMMDAM/"
    When I login
    And I am on the brands page
    Then I should be able to scrape all the products by brand
