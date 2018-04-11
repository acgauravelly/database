@All
Feature: Advanced Search By MPN

  @mpn
  Scenario: Search by using MPN in advanced search

    Given Iam logged in to MC
    And Iam on landing page
    And I click on "Advanced" Search
    Then I should be able to search by "MPN"

