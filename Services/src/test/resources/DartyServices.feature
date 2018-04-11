@All
Feature: As a  user
  I navigate to the url and check if Comparision Table service is available

  Background:
    Given I navigate to "darty" Url


  @AF360
  Scenario: Comparision  Table interface is available
    Then I should be able to check the "comparision table"  is displayed
