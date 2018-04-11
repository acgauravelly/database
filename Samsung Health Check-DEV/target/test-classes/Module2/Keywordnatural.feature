@All
Feature:Keyword search Natural
  As a Samsung MC user
  I should be able to search for products by keyword

  @KeywordNaturalSearch
  Scenario:Keyword search
    Given Iam on Landing Page as an Admin user
    And  I search for products using keyword using natural search