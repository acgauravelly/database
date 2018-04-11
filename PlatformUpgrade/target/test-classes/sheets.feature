Feature: Testing brand consistency over migration across all templates

  @sheet
  Scenario: Reading the correct data

    Given I load the "lg" excel
    When I load the "dev" url
    And I read the "dev" pagesource
    When I load the "prod" url
    And I read the "prod" pagesource
    Then there should be no differences

