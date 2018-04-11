@All
Feature: Natural search with Keyword
  As a MC user
  I should be able to search with keyword from natural search


  Background:
    Given Iam logged in to the Hub as "admin" user
    And Iam on "landing page"

  @natSearch
  Scenario: Keyword natural search
    And I search by using the keyword "association test"
    Then I should be able to see the "copytest" product

  @advkeysearch
  Scenario: Advanced keyword search
    Then I should be able to use "advanced keyword" search


