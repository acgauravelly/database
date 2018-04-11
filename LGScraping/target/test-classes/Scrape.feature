Feature: Scrape MPNS from Lg

  @ips
  Scenario: Scrapping mpns from LG

    Given I visit the "ipsMonitors" page
    And I get the categories
    Then I retrieve mpns from each category

  @zero
  Scenario: zero client page
    Given I visit the "zeroClientPage" page
    And I get the categories
    Then I retrieve mpns from each category

  @med
  Scenario: Medical  Monitors page
    Given I visit the "medicalMonPage" page
    And I get the categories
    Then I retrieve mpns from each category

  @4k
  Scenario: 4 K page
    Given I visit the "fourKmonitorPage" page
    And I get the categories
    Then I retrieve mpns from each category

  @led
  Scenario:led Monitor page
    Given I visit the "ledMonitorPage" page
    And I get the categories
    Then I retrieve mpns from each category