@All
Feature: Advanced Search By Keyword

  @keyword
  Scenario: Search by using keyword in advanced search

    Given Iam logged in to MC
    And Iam on landing page
    And I click on "Advanced" Search
    Then I should be able to search by "keyword"