@All
Feature:Category prioritisation
  As an Admin user
  I should be able to prioritise the order of categories

  @Cat-Priority
  Scenario:Priority of categories to reflect in the search

    Given Iam on Landing Page as an Admin user
    And  I set the priorities for categories
    Then the search results should reflect that priority of categories
