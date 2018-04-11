@All
Feature: Inpage,Minisite,Reviews

  Background:
    Given I visit the "clamp url"
    And I export the harfile

  @inpage
  Scenario: Inpage impression
    Then I should be able to verify the impressions for "inpage"

  @minisite
  Scenario: Minisite impression
    Then I should be able to verify the impressions for "minisite"



