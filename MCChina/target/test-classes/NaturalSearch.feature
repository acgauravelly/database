@All
Feature: Natural Search by MPN

  @natural
  Scenario:Natural Search by mpn

    Given Iam logged in to MC
    And Iam on landing page
    Then I should be able to search by "Natural search"