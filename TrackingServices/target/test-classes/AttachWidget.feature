@All
Feature:AW Tracking

  @AW
  Scenario:AW Impression
    Given I visit the "aw clamp"
    And I export the harfile
    Then I should be able to verify the impressions for "attach widget"