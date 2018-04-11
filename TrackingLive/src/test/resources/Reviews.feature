@Additional
Feature: Reviews Logging


  @inpagereviews
  Scenario: Reviews impresion on Inpage
    Given I visit the "clamp url"
    And I export the harfile
    Then I should be able to verify the impressions for "reviews"

  @minisitereviews
  Scenario: Reviews impression on Minisite
    Given I visit the "Minisite reviews  url"
    And I export the harfile
    Then I should be able to verify the impressions for "reviews"