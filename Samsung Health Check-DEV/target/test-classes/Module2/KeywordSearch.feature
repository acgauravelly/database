@All
Feature:Keyword search
  As a Samsung MC user
  I should be able to search for products by keyword

  @KeywordAdvSearch
  Scenario:Keyword search
    Given Iam on Landing Page as an Admin user
    And  I search for products using keyword
    Then I should be able to see only products associated with that keyword
