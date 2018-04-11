@All
Feature: Advanced Search By EAN

  @ean
  Scenario: Search by using EAN in advanced search

    Given Iam logged in to MC
    And Iam on landing page
    And I click on "Advanced" Search
    Then I should be able to search by "EAN"