@All
Feature: Scrape LG website for urls

  @commercial
  Scenario:LG Scraping

    Given I visit the "commercial" url
    And I get the product details
    Then I should be able to write to a csv

  @digital
  Scenario:LG Scraping

    Given I visit the "digital-signage" url
    And I get the product details
    Then I should be able to write to a csv

  @videowalls
  Scenario:LG Scraping

    Given I visit the "video-walls" url
    And I get the product details
    Then I should be able to write to a csv

  @outdoor
  Scenario:LG Scraping

    Given I visit the "outdoor" url
    And I get the product details
    Then I should be able to write to a csv

  @accessories
  Scenario:LG Scraping

    Given I visit the "accessories" url
    And I get the product details
    Then I should be able to write to a csv

  @desktop
  Scenario:LG Scraping

    Given I visit the "desktop-monitors" url
    And I get the product details
    Then I should be able to write to a csv

  @digitalStorage
  Scenario:LG Scraping

    Given I visit the "digital-storage" url
    And I get the product details
    Then I should be able to write to a csv