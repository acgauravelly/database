
@All
Feature: Standard user
  As a standard user
  I should not have any admin previleages

  @standardUser
  Scenario: Standard user previleages
    Given Iam logged in to the Hub as "standard" user
    Then I should only see the search option
